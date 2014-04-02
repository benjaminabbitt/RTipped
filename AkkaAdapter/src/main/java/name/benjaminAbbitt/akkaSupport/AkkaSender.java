package name.benjaminAbbitt.akkaSupport;

import akka.event.EventStream;
import name.benjaminAbbitt.messagingAbstraction.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkNotNull;

public class AkkaSender implements Sender {
    Logger log = LoggerFactory.getLogger(AkkaSender.class);
    private EventStream eventStream;

    public AkkaSender(EventStream eventStream) {
        this.eventStream = checkNotNull(eventStream);
    }

    @Override
    public void send(Object msg) {

        log.debug("Sending Message: {}", msg);
        eventStream.publish(msg);
    }
}
