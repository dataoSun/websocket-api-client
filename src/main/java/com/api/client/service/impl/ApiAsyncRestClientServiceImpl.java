package com.api.client.service.impl;

import com.api.client.ApiCallback;
import com.api.client.CallBackAdapter;
import com.api.client.R;
import com.api.client.service.ApiAsyncRestClientService;
import com.api.client.service.ApiService;
import retrofit2.Callback;
import static com.api.client.core.ApiServiceGenerator.*;

/**
 * @author datao
 * @date: 2019/11/26 19:51
 */
public class ApiAsyncRestClientServiceImpl implements ApiAsyncRestClientService {

    private String key;

    private String secret;

    private ApiService apiService;


    public ApiAsyncRestClientServiceImpl(){
        apiService = createService(ApiService.class);
    }

    public ApiAsyncRestClientServiceImpl(String key, String secret){
        apiService = createService(ApiService.class, key, secret);
    }

    @Override
    public void test(String p, String o, CallBackAdapter<R<String>> callback) {
        apiService.test(p,o).enqueue(callback);
    }
}
