package com.api.client.service;

import com.api.client.R;
import com.api.client.constants.ApiConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 *  Package request , return Call
 * @author datao
 * @date: 2019/11/26 14:52
 */
public interface ApiService {

    /**
     * For example test
     * @param p
     * @param o
     * @return
     */
    @Headers(value = {ApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/api/test")
    Call<R<String>> test(@Query("p") String p, @Query("o") String o);
}
