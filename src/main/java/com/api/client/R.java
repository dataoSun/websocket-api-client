package com.api.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author datao
 * @date: 2019/11/26 14:20
 */
@Builder
@Accessors(chain = true)
@Data
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private T data;

    private static final Integer DEFAULT_SUCCESS_CODE = 200;

    private static final Integer DEFAUILT_ERROR_CODE = 5001;

    public static final String SUCCESS = "SUCCESS";

    public R() {
        this.code = DEFAULT_SUCCESS_CODE;
        this.msg = SUCCESS;
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public static R success(){
        return new R();
    }

    public <T> R<T> success(T data){
        return new R<>(data);
    }

    public static R error(String msg){
        return R.builder().code(DEFAUILT_ERROR_CODE).msg(msg).build();
    }

    public static R error(Integer code, String msg){
        return R.error(msg).setCode(code);
    }

    public static R error(Throwable e){
        return R.error(e.getMessage());
    }


}
