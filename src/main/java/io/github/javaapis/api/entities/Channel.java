package io.github.javaapis.api.entities;

import io.github.javaapis.Glimesh4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Channel {
    private final JSONObject channelData;
    private final Glimesh4j glimesh4j;

    private Category category;
    private List<ChatMessage> chatMessages;
    private OffsetDateTime insertedAt, updatedAt;
    private List<ModerationLog> moderationLogs;
    private List<ChannelModerator> moderators;
    private ChannelStatus status;
    private Stream stream;
    private User streamer;
    private List<Tag> tags;

    public Channel(JSONObject data, Glimesh4j glimesh4j) {
        this.channelData = data;
        this.glimesh4j = glimesh4j;
    }

    /**
     * The internal ID used to represent this channel
     * @return this channel's ID
     */
    public String getId() {
        return channelData.getString("id");
    }

    /**
     * @return the title of the channel
     */
    public String getTitle() {
        return channelData.getString("title");
    }

    /**
     * Gets a list of the banned people for this channel
     * @return a list of ChannelBans
     */
    public List<ChannelBan> getChannelBans() {
        JSONArray bansJson = channelData.getJSONArray("bans");
        List<ChannelBan> bans = new ArrayList<>();
        for (Object ban : bansJson) {
            bans.add(new ChannelBan((JSONObject) ban, glimesh4j, this));
        }
        return bans;
    }

    public String getChatRulesHtml() {
        return channelData.getString("chatRulesHtml");
    }

    public String getChatRulesMd() {
        return channelData.getString("chatRulesMd");
    }

    public String getLanguage() {
        return channelData.getString("language");
    }

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return channelData.getString("thumbnail");
    }

    /**
     * @return whether or not this channel is inaccessible
     */
    public boolean isInaccessible() {
        return channelData.getBoolean("inaccessible");
    }
}
