package com.api.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * WebSocket Listener
 * @author datao
 * @date: 2019/11/29 17:47
 */
public class ApiWebSocketListener<T> extends WebSocketListener {

    private ApiCallback<T> apiCallback;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private final ObjectReader objectReader;

    private boolean closing = false;

    public ApiWebSocketListener(ApiCallback<T> callback, Class<T> classType){
        this.apiCallback = callback;
        objectReader = objectMapper.readerFor(classType);
    }


    @Override
    public void onMessage(WebSocket webSocket, String test) {
        try {
            T ret = objectReader.readValue(test);
            apiCallback.onResponse(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        closing = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            apiCallback.onFailure(t);
        }
    }
}
