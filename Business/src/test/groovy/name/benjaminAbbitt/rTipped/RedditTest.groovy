package name.benjaminAbbitt.rTipped

import org.junit.Test

import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

public class RedditTest {

    @Test
    public void testGetPostedListForUser() {
        Client client = ClientBuilder.newClient()
        Reddit reddit = new Reddit(client)

        TipBot tipBot = new name.benjaminAbbitt.rTipped.TipBot(/.*Verified\*\*\:.*\[(?<originator>\w+).*(?<money>\d+.\d+)\s+USD.*\[(?<receiver>\w+)\].*/, "changeTip")

        reddit.getPostedList(tipBot)

    }
}
