package name.benjaminAbbitt.akkaSupport;

import akka.actor.ActorSelection;
import akka.util.Timeout;
import name.benjaminAbbitt.messagingAbstraction.Asker;
import scala.concurrent.Await;
import scala.concurrent.Future;

import static com.google.common.base.Preconditions.checkNotNull;


public class AkkaAsker implements Asker {
    private ActorSelection target;
    private Timeout timeout;

    public AkkaAsker(ActorSelection target, Timeout timeout) {
        this.target = checkNotNull(target);
        this.timeout = checkNotNull(timeout);
    }


    @Override
    public Object ask(Object msg) throws Exception {
        Future<Object> future;

        future = akka.pattern.Patterns.ask(target, msg, timeout);

        return Await.result(future, timeout.duration());
    }
}
