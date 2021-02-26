package io.github.javaapis.api;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;

public class RequestClient {
    private final String key;
    private final String userAgent = "glimesh4j/1.0";
    private static final String apiUrl = "https://glimesh.tv/api";
    private final OkHttpClient client;

    public RequestClient(String key) {
        this.key = key;
        client = new OkHttpClient();
    }

    public OkHttpClient getHttpClient() {
        return client;
    }

    public JSONObject buildRequest(String name, String params, String data, String key) {
        String graphBody = new RequestBuilder()
            .setType(name, params)
            .setData(data)
            .build();

        System.out.println("graphBody: " + graphBody);

        RequestBody body = RequestBody.create(graphBody,
            MediaType.parse("application/text; charset=utf-8"));

        System.out.println("Body: " + body);

        Request request = new Request.Builder()
            .url(apiUrl)
            .post(body)
            .addHeader("Authorization", key)
            .addHeader("User-Agent", userAgent)
            .build();

        return performRequest(request);
    }

    /**
     * Actually perform the request
     * @param request a request
     * @return a response
     */
    private JSONObject performRequest(Request request) {
        try (Response response = client.newCall(request).execute()) {
            String body;
            ResponseBody responseBody = response.body();
            if(responseBody == null) {
                body = "{}";
            } else {
                body = responseBody.string();
            }
            if (body.equals("Bad Request")) {
                throw new IllegalArgumentException("Bad request received");
            }
            System.out.println("Body: " + body);
            return new JSONObject(body);
        } catch (IOException e) {
            return new JSONObject("{error: 'IOException'}");
        }
    }
}
