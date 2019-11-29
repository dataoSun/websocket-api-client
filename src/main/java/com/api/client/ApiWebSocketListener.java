package com.api.client;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * WebSocket Listener
 * @author datao
 * @date: 2019/11/29 17:47
 */
public class ApiWebSocketListener<T> extends WebSocketListener {




    @Override
    public void onMessage(WebSocket webSocket, String test) {

    }


    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
    }
}
