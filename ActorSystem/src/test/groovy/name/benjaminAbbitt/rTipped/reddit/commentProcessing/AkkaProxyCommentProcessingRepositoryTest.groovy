package name.benjaminAbbitt.rTipped.reddit.commentProcessing

import akka.actor.ActorRef
import akka.actor.ActorSelection
import akka.util.Timeout
import org.junit.Test

import static org.mockito.Mockito.mock


class AkkaProxyCommentProcessingRepositoryTest {
    @Test
    public void testInterception(){
        def sender = mock(ActorRef)
        def target = mock(ActorSelection)
        def timeout = mock(Timeout)

        def repos = new AkkaProxyCommentProcessingRepository(sender, target, timeout)
        repos.hasBeenProcessed("a", "b")
        repos.isProcessed("a", "b")
    }

}
