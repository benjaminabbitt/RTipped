package name.benjaminAbbitt.rTipped.reddit.commentProcessing

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.util.Timeout
import name.benjaminAbbitt.akkaSupport.AkkaProxy

class AkkaProxyCommentProcessingRepository extends AkkaProxy implements CommentProcessingRepository{
    AkkaProxyCommentProcessingRepository(ActorRef sender, ActorSelection target, Timeout timeout) {
        super(sender, target, timeout)
    }

    @Override
    public Boolean isProcessed(String userName, String id) {
    }

    @Override
    public void hasBeenProcessed(String userName, String id) {
    }
}
