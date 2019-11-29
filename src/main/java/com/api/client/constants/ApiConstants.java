package com.api.client.constants;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @date: 2019/11/26 14:53
 */
public class ApiConstants {

    /**
     * Api base url
     */
    public static final String API_BASE_URL = "http://127.0.0.1:8080/";

    /**
     * WebSocket base url
     */
    public static final String WEB_SOCKET_URL = "wss://";

    /**
     * HTTP Header to be used for API-KEY authentication.
     */
    public static final String API_KEY_HEADER = "APIKEY";

    public static final String API_SIGN_HEADER = "SIGNATURE";

    /**
     * Decorator to indicate that an endpoint requires an API key.
     * If there is a secret in the request header, the validity of the key will be verified
     */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";

    /**
     * Decorator to indicate that an endpoint requires a signature.
     * If there is a secret in the request header, the validity of the key and secret will be verified
     */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";

    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     *  - Example ToStringStyle.JSON_STYLE
     */
    public static ToStringStyle TO_STRING_BUILDER_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
