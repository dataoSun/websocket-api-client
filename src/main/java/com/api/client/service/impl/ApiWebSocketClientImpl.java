package com.api.client.service.impl;

import com.api.client.ApiCallback;
import com.api.client.ApiWebSocketListener;
import com.api.client.R;
import com.api.client.service.ApiWebSocketClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.io.Closeable;

/**
 * WebSocket client
 * @author datao
 * @date: 2019/11/29 17:16
 */
public class ApiWebSocketClientImpl implements ApiWebSocketClient {

    private OkHttpClient client;

    public ApiWebSocketClientImpl(OkHttpClient client){
        this.client = client;
    }


    @Override
    public Closeable test(String channel, ApiCallback<R> callback) {
        return createWebSocket(channel, new ApiWebSocketListener<R>(callback, R.class));
    }

    private Closeable createWebSocket(String channel, ApiWebSocketListener<?> listener) {

        Request request = new Request.Builder().build();
        WebSocket webSocket = client.newWebSocket(request, listener);
        return () -> {
            final int code = 1000;
            listener.onClosing(webSocket, code, null);
            webSocket.close(code, null);
            listener.onClosed(webSocket, code, null);
        };
    }


}
