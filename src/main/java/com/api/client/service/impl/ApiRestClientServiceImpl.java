package com.api.client.service.impl;

import com.api.client.R;
import com.api.client.service.ApiRestClientService;
import com.api.client.service.ApiService;

import static com.api.client.core.ApiServiceGenerator.*;

/**
 * @author datao
 * @date: 2019/11/26 14:59
 */
public class ApiRestClientServiceImpl implements ApiRestClientService {

    private String key;

    private String secret;

    private ApiService apiService;

    public ApiRestClientServiceImpl(){
        apiService = createService(ApiService.class);
    }

    public ApiRestClientServiceImpl(String key, String secret){
        apiService = createService(ApiService.class, key, secret);
    }

    @Override
    public R<String> test(String p, String o) {
        return executeSync(apiService.test(p, o));
    }
}
