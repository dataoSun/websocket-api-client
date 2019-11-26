package com.api.client;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author datao
 * @date: 2019/11/26 14:20
 */
@Builder
@AllArgsConstructor
public class R<T> {

    private Integer code;

    private String msg;

    private T data;

    public static final String SUCCESS = "SUCCESS";

    public R() {
        this.code = 200;
        this.msg = SUCCESS;
    }

    public static R success(){
        return new R();
    }

}
