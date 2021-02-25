package io.github.javaapis.api.entities;

import org.json.JSONObject;

import java.time.OffsetDateTime;
import java.util.List;

public class Channel {
    private List<ChannelBan> bans;
    private Category category;
    private List<ChatMessage> chatMessages;
    private String chatRulesHtml, chatRulesMd, hmacKey, id, language, streamKey, thumbnail, title;
    private final boolean inaccessible;
    private OffsetDateTime insertedAt, updatedAt;
    private List<ModerationLog> moderationLogs;
    private List<ChannelModerator> moderators;
    private ChannelStatus status;
    private Stream stream;
    private User streamer;
    private List<Tag> tags;

    public Channel(JSONObject data) {
        this.inaccessible = data.getBoolean("inaccessible");
    }

    public boolean isInaccessible() {
        return inaccessible;
    }
}
