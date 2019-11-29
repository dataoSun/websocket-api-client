package com.api.client.service.impl;

import com.api.client.ApiCallback;
import com.api.client.R;
import com.api.client.service.ApiWebSocketClient;
import okhttp3.OkHttpClient;

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
    public Closeable test(String channel, ApiCallback<R<String>> callback) {
        return createWebSocket(channel);
    }

    private Closeable createWebSocket(String channel) {
        return null;
    }


}
