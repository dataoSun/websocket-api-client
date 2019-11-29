package com.api.client.service;

import com.api.client.R;

/**
 *  sync request
 * @author datao
 * @date: 2019/11/26 14:54
 */
public interface ApiRestClient {

    R<String> test(String p, String o);
}
