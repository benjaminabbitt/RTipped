import akka.actor.UntypedActor
import name.benjaminAbbitt.rTipped.spring.RTippedConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class Master extends UntypedActor {
    @Override
    public void preStart() {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(RTippedConfiguration)

//        final ActorRef communicator = getContext().actorOf(Props.create(InjectedCommunicationActorFactory, springContext, REDDIT_ACTOR), REDDIT_ACTOR)
//        final
//        def throttle = getContext().actorOf(Props.create(TimerBasedThrottler, new Throttler.Rate(1, Duration.create(2, TimeUnit.SECONDS))))
    }

    @Override
    void onReceive(Object o) throws Exception {


    }
}
