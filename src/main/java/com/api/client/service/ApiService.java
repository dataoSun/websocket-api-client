package com.api.client.service;

import com.api.client.R;
import retrofit2.Call;
import retrofit2.http.Headers;

/**
 *  Package request , return Call
 * @author datao
 * @date: 2019/11/26 14:52
 */
public interface ApiService {

    @Headers(value = {})
    Call<R<String>> test(String p, String o);
}
