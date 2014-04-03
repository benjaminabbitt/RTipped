package name.benjaminAbbitt.akkaSupport

import akka.actor.UntypedActor

class DelegatingActor<T> extends UntypedActor {
    private final T delegate

    public DelegatingActor(T delegate) {
        this.delegate = delegate
    }

    @Override
    void onReceive(Object o) throws Exception {
        if (o instanceof AkkaProxiedMethodCallVoid) {
            o = (AkkaProxiedMethodCall) o
            def methodName = o.getMethodName()
            def arguments = o.arguments
            T.(methodName)(*arguments)
        } else if (o instanceof AkkaProxiedMethodCall) {
            o = (AkkaProxiedMethodCallVoid) o
            def methodName = o.getMethodName()
            def arguments = o.arguments
            def reply = T.(methodName)(*arguments)
            getSender().tell(reply, getSelf())
        }
    }
}
