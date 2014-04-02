package name.benjaminAbbitt.rTipped

import name.benjaminAbbitt.rTipped.domain.TipBot
import org.junit.Test

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

public class RedditTest {

    @Test
    public void testGetPostedListForUser() {
        Client client = ClientBuilder.newClient()
        Reddit reddit = new Reddit(client)

        TipBot tipBot

        reddit.getPostedList(tipbot)

    }
}
