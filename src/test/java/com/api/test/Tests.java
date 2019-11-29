package com.api.test;

import com.api.client.R;
import com.api.client.core.ApiClientFactory;
import com.api.client.core.ApiServiceGenerator;
import com.api.client.service.ApiRestClient;
import org.junit.Test;
/**
 * @author datao
 * @date: 2019/11/29 15:52
 */
public class Tests {

    @Test
    public void test() {
        ApiRestClient client = ApiClientFactory.instance("apiKey", "secret").newRestClient();
        R r = client.test("p", "o");
        System.out.println(r);
    }
}
