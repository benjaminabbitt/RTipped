package name.benjaminAbbitt.akkaSupport;

import akka.actor.ActorRef;
import name.benjaminAbbitt.messagingAbstraction.Teller;

import static com.google.common.base.Preconditions.checkNotNull;

public class AkkaTeller implements Teller {
    private ActorRef sender;
    private ActorRef target;

    public AkkaTeller(ActorRef sender, ActorRef target) {
        this.sender = checkNotNull(sender);
        this.target = checkNotNull(target);
    }

    @Override
    public void tell(Object msg) {
        target.tell(msg, sender);
    }
}
