package name.benjaminAbbitt.rTipped.spring

import akka.actor.ActorSystem
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import static name.benjaminAbbitt.rTipped.ActorNames.ACTOR_SYSTEM

@Configuration
public class RTippedConfiguration {

    private ActorSystem actorSystem

    @Autowired
    private ApplicationContext applicationContext

    @Bean(name = ACTOR_SYSTEM, destroyMethod = "shutdown")
    public ActorSystem actorSystem() {
        actorSystem = ActorSystem.create(ACTOR_SYSTEM)
        return actorSystem
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
    }
}