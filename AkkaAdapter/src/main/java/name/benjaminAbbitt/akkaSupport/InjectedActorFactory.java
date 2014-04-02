package name.benjaminAbbitt.akkaSupport;


import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

public class InjectedActorFactory implements IndirectActorProducer {
    private final Class clazz;
    private final ApplicationContext context;
    private final String name;

    public InjectedActorFactory(Class clazz, ApplicationContext context, String name) {
        this.clazz = clazz;
        this.context = context;
        this.name = name;
    }


    @Override
    public Actor produce() {
        return (Actor) context.getBean(name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<? extends Actor> actorClass() {
        return clazz;
    }
}
