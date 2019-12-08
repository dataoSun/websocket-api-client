package com.api.client.service;

import com.api.client.ApiCallback;
import com.api.client.R;

import java.io.Closeable;

/**
 * web socket client
 * @author datao
 * @date: 2019/11/29 17:14
 */
public interface ApiWebSocketClient {

    /**
     * For example test
     * @param channel
     * @param callback
     * @return
     */
    Closeable test(String channel, ApiCallback<R> callback);
}
