package name.benjaminAbbitt.rTipped

import name.benjaminAbbitt.rTipped.domain.TipBot

import javax.ws.rs.client.Client

public class Reddit {
    private Client client

    public Reddit(Client client) {
        this.client = client
    }

    public Object getPostedList(TipBot bot) {
        def response = client.target("http://www.reddit.com/user/changetip").request("application/json").get()
        println response.readEntity(String)
    }
}
