package com.api.client.service;

import com.api.client.CallBackAdapter;
import com.api.client.R;

/**
 * async request
 * @author datao
 * @date: 2019/11/26 14:55
 */
public interface ApiAsyncRestClient {

    void test(String p, String o, CallBackAdapter<R<String>> callback);
}
