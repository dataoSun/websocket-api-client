package com.api.client;

/**
 * @author datao
 * @date: 2019/11/26 20:05
 */
@FunctionalInterface
public interface ApiCallback<T> {

    void onResponse(T t);

    default void onFailure(Throwable e){}
}
