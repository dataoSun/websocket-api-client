package com.api.client.service.impl;

import com.api.client.CallBackAdapter;
import com.api.client.R;
import com.api.client.service.ApiAsyncRestClient;
import com.api.client.service.ApiService;
import static com.api.client.core.ApiServiceGenerator.*;

/**
 * @author datao
 * @date: 2019/11/26 19:51
 */
public class ApiAsyncRestClientImpl implements ApiAsyncRestClient {

    private String key;

    private String secret;

    private ApiService apiService;


    public ApiAsyncRestClientImpl(){
        apiService = createService(ApiService.class);
    }

    public ApiAsyncRestClientImpl(String key, String secret){
        apiService = createService(ApiService.class, key, secret);
    }

    @Override
    public void test(String p, String o, CallBackAdapter<R<String>> callback) {
        apiService.test(p,o).enqueue(callback);
    }
}
