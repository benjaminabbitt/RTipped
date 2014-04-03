package name.benjaminAbbitt.rTipped.tipWatcher

import akka.actor.UntypedActor
import org.springframework.beans.factory.annotation.Autowired
import scala.concurrent.duration.Duration

import java.util.concurrent.TimeUnit

class TipWatcherActor extends UntypedActor {

    Tipwatcher service

    @Autowired
    public TipWatcherActor(Tipwatcher service) {
        this.service = service;
    }

    @Override
    void onReceive(Object msg) throws Exception {
        if (msg.equals("tick")) {
//            def out = new PollReddit(service.getNextBot())
//            getContext().actorSelection(REDDIT_ACTOR).tell(out, self())
        }

    }

    @Override
    public void preStart() {
        tick()
    }

    private void tick() {
        getContext().system().scheduler().scheduleOnce(Duration.create(5, TimeUnit.MINUTES), getSelf(), "tick", getContext().dispatcher(), null)
    }

}
