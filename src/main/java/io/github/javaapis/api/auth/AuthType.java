package io.github.javaapis.api.auth;

public enum AuthType {
    BEARER("Bearer"),
    CLIENT_ID("Client-ID");

    private final String type;

    AuthType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
