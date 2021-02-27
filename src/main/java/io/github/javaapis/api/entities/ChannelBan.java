package io.github.javaapis.api.entities;

import io.github.javaapis.Glimesh4j;
import org.json.JSONObject;

public class ChannelBan {
    private final JSONObject banData;
    private final Glimesh4j glimesh4j;
    private final Channel channel;

    public ChannelBan(JSONObject data, Glimesh4j glimesh4j, Channel channel) {
        this.banData = data;
        this.glimesh4j = glimesh4j;
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public Glimesh4j getGlimesh4j() {
        return glimesh4j;
    }

    public String getReason() {
        return banData.getString("reason");
    }
}
