package com.api.client.exception;

import lombok.*;

/**
 * @author datao
 * @date: 2019/11/26 15:47
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError {

    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String msg;
}
