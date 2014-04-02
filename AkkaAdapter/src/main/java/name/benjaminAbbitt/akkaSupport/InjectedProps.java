package name.benjaminAbbitt.akkaSupport;

import akka.actor.Props;
import org.springframework.context.ApplicationContext;

public class InjectedProps {
    public static Props create(Class clazz, ApplicationContext context, String name) {
        return Props.create(InjectedActorFactory.class, clazz, context, name);
    }
}
