package com.api.client.core;

import com.api.client.service.ApiAsyncRestClient;
import com.api.client.service.ApiRestClient;
import com.api.client.service.ApiWebSocketClient;
import com.api.client.service.impl.ApiAsyncRestClientImpl;
import com.api.client.service.impl.ApiRestClientImpl;
import com.api.client.service.impl.ApiWebSocketClientImpl;
import lombok.Getter;
import lombok.Setter;
import static com.api.client.core.ApiServiceGenerator.getSharedClient;

/**
 * @author datao
 * @date: 2019/11/29 16:01
 */
public class ApiClientFactory {

    @Getter
    @Setter
    private String apiKey;

    @Getter
    @Setter
    private String secret;

    /**
     * Instantiates a new ApiClientFactory
     * @param apiKey
     * @param secret
     */
    private ApiClientFactory(String apiKey, String secret){
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * instance of ApiClientFactory with apiKey and secret
     * @param apiKey
     * @param secret
     * @return
     */
    public static ApiClientFactory instance(String apiKey, String secret){
        return new ApiClientFactory(apiKey, secret);
    }

    /**
     * instance of ApiClientFactory without apikey and secret
     * @return
     */
    public static ApiClientFactory instance(){
        return new ApiClientFactory(null, null);
    }

    /**
     * Instantiates a new ApiRestClientService
     * @return
     */
    public ApiRestClient newRestClient(){
        return new ApiRestClientImpl(apiKey, secret);
    }

    /**
     * Instantiates a new ApiAsyncRestClientService
     * @return
     */
    public ApiAsyncRestClient newAsyncRestClient(){
        return new ApiAsyncRestClientImpl(apiKey, secret);
    }

    /**
     * Instantiates a new ApiWebSocketClient
     * @return
     */
    public ApiWebSocketClient newApiWebSocketClient(){
        return new ApiWebSocketClientImpl(getSharedClient());
    }



}
