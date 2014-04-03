package name.benjaminAbbitt.akkaSupport

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.pattern.Patterns
import akka.util.Timeout
import groovy.transform.Memoized
import scala.concurrent.Await
import scala.concurrent.Future

import java.util.concurrent.TimeUnit

abstract class AkkaProxy implements GroovyInterceptable {
    private final ActorSelection sender
    private final ActorSelection target
    private final Timeout timeout

    protected AkkaProxy(sender, target, timeout) {
        this.sender = sender
        this.target = target
        this.timeout = timeout
    }

    def invokeMethod(String name, args) {
        //noinspection GroovyAssignabilityCheck
        def metaMethod = metaClass.getMetaMethod(name, args)
        def returnType = metaMethod.getReturnType()
        if (returnType.name == "void") {
            def message = new AkkaProxiedMethodCallVoid(methodName: name, arguments: Arrays.asList(args))
            target.tell(message, resolve(sender))
        } else {
            def message = new AkkaProxiedMethodCall(methodName: name, arguments: Arrays.asList(args))
            return ask(message)
        }
    }

    @Memoized
    public static ActorRef resolve(ActorSelection selection) {
        return selection.resolveOne(new Timeout(10, TimeUnit.SECONDS)) as ActorRef
    }

    public Object ask(Object msg) throws Exception {
        Future<Object> future;
        future = Patterns.ask(target, msg, timeout);
        return Await.result(future, timeout.duration());
    }
}
