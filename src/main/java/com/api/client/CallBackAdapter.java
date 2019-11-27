package com.api.client;

import com.api.client.exception.ApiError;
import com.api.client.exception.ApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.api.client.core.ApiServiceGenerator.getApiError;

import java.io.IOException;

/**
 * @author datao
 * @date: 2019/11/26 20:08
 */
public class CallBackAdapter<T> implements Callback<T> {

    private ApiCallback<T> apiCallback;

    public CallBackAdapter(ApiCallback<T> apiCallback){
        this.apiCallback = apiCallback;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()){
            apiCallback.onResponse(response.body());
        }else {
            try {
                ApiError apiError = getApiError(response);
                onFailure(call, new ApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new ApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof ApiException) {
            apiCallback.onFailure(throwable);
        } else {
            apiCallback.onFailure(new ApiException(throwable));
        }
    }
}
