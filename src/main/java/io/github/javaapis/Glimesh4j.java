package io.github.javaapis;

import io.github.javaapis.api.RequestBuilder;
import io.github.javaapis.api.RequestClient;
import io.github.javaapis.api.auth.AuthType;
import io.github.javaapis.api.entities.Channel;
import org.json.JSONObject;

public class Glimesh4j {
    private String apiKey;
    private AuthType authType = AuthType.BEARER;
    private RequestClient client;

    public Glimesh4j(String key) {
        this.apiKey = key;
    }

    public Glimesh4j(String key, AuthType authType) {
        this.apiKey = key;
        this.authType = authType;
        client = new RequestClient(key);
    }

    private String getApiKey() {
        System.out.println("Key: " + authType.getType() + " " + apiKey);
        return authType.getType() + " " + apiKey;
    }

    public Channel getChannel(String username) {
        JSONObject response = client.buildRequest("channel", "username: \"" + username + "\"", RequestBuilder.channelRequest, getApiKey());
        return new Channel(response.getJSONObject("data").getJSONObject("channel"), this);
    }

    public RequestClient getRequestClient() {
        return client;
    }
}
