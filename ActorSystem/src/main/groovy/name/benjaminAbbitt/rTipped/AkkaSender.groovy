package name.benjaminAbbitt.rTipped

import akka.actor.ActorRef

public abstract class AkkaSender implements Sender{
    ActorRef target;

    public AkkaSender(ActorRef target){
        this.target = target;
    }
}
