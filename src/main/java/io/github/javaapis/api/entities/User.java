package io.github.javaapis.api.entities;

import io.github.javaapis.Glimesh4j;
import org.json.JSONObject;

public class User {
    private final JSONObject userData;
    private final Glimesh4j glimesh4j;

    public User(JSONObject data, Glimesh4j glimesh4j) {
        this.userData = data;
        this.glimesh4j = glimesh4j;
    }

    public String getAvatar() {
        return userData.getString("avatar");
    }

    public String getAvatarUrl() {
        return userData.getString("avatarUrl");
    }

    public String getDisplayName() {
        return userData.getString("displayname");
    }

    public String getId() {
        return userData.getString("id");
    }

    public String getProfileContentAsHtml() {
        return userData.getString("profileContentHtml");
    }

    public String getProfileContentAsMarkdown() {
        return userData.getString("profileContentMd");
    }

    public String getDiscordServerLink() {
        return "https://discord.gg/" + userData.getString("socialDiscord");
    }

    public String getGuildedLink() {
        return "https://guilded.gg/" + userData.getString("socialGuilded");
    }

    public String getInstagramLink() {
        return "https://instagram.com/" + userData.getString("socialInstagram");
    }

    public String getYouTubeChannelLink() {
        return "https://youtube.com/" + userData.getString("socialYoutube");
    }

    public String getUsername() {
        return userData.getString("username");
    }

    public String getYouTubeIntroURL() {
        return userData.getString("youtubeIntroUrl");
    }
}
