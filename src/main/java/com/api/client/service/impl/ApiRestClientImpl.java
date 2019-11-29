package com.api.client.service.impl;

import com.api.client.R;
import com.api.client.service.ApiRestClient;
import com.api.client.service.ApiService;

import static com.api.client.core.ApiServiceGenerator.*;

/**
 * @author datao
 * @date: 2019/11/26 14:59
 */
public class ApiRestClientImpl implements ApiRestClient {

    private String key;

    private String secret;

    private ApiService apiService;

    public ApiRestClientImpl(){
        apiService = createService(ApiService.class);
    }

    public ApiRestClientImpl(String key, String secret){
        apiService = createService(ApiService.class, key, secret);
    }

    @Override
    public R<String> test(String p, String o) {
        return executeSync(apiService.test(p, o));
    }
}
