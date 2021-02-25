package io.github.javaapis.api;

/**
 * Helper class to assist with building GraphQL requests
 */
public class RequestBuilder {
    // Constant helpers for some requests
    public static final String socialsRequest = "username,identifier,insertedAt,platform,updatedAt,id";
    public static final String userRequest =
        "avatar,avatarUrl,confirmedAt,displayname,id,profileContentMd,profileContentHtml,socials{" + socialsRequest + "},username,youtubeIntroUrl";
    public static final String channelBans = "expiresAt,insertedAt,reason,updatedAt,user {" + userRequest + "}";
    public static final String tagRequest = "countUsage,id,insertedAt,name,slug,updatedAt";
    public static final String categoryRequest = "id,name,slug,tags {" + tagRequest + "}";
    public static final String streamRequest = "avgViewers,avgChatters,countChatters,countViewers,endedAt,id,insertedAt,newSubscribers,peakChatters,peakViewers,resubSubscribers,startedAt,thumbnail,title,updatedAt";
    public static final String channelRequest =
        "bans{" + channelBans + "}," +
            "category{"+ categoryRequest +"}," +
            "chatRulesMd,chatRulesHtml,id,inaccessible,insertedAt,language,status,thumbnail,title,updatedAt," +
            "stream{"+ streamRequest + "}," +
            "streamer{" + userRequest + "}";

    private String query;

    public RequestBuilder() {
        query = "query {%type% {%data%}}";
    }

    public RequestBuilder setType(String name, String params) {
        query = query.replace("%type%", name + "(" + params + ")");
        return this;
    }

    public RequestBuilder setData(String data) {
        query = query.replace("%data%", data);
        return this;
    }

    public String build() {
        return query;
    }
}
