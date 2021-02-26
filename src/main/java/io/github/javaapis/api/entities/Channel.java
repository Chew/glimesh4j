package io.github.javaapis.api.entities;

import io.github.javaapis.Glimesh4j;
import org.json.JSONObject;

import java.time.OffsetDateTime;
import java.util.List;

public class Channel {
    private final JSONObject channelData;
    private final Glimesh4j glimesh4j;

    private List<ChannelBan> bans;
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
