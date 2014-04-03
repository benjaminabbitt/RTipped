package name.benjaminAbbitt.rTipped

import com.fasterxml.jackson.databind.ObjectMapper

import javax.ws.rs.client.Client

public class Reddit {
    private Client client

    public Reddit(Client client) {
        this.client = client
    }

    public Object getPostedList(TipBot bot) {
        def response = client.target("http://www.reddit.com/user/changetip.json").request("application/json").get()

        def responseEntity = response.readEntity(String)

        ObjectMapper mapper = new ObjectMapper();



        def map = mapper.readValue(responseEntity, Map)
        println map
    }
}
