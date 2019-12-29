package com.api.test;

import com.api.client.R;
import com.api.client.core.ApiClientFactory;
import com.api.client.service.ApiRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;

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

    @Test
    public void test2(){

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("wd", "中国");
        String ret = excute(null, "/s", "GET", null, queryParams, null);
        System.out.println(ret);
    }

    public static final String baseUrl = "https://www.baidu.com/";

    public <T> T excute(Class<T> retClassType, String path, String method, Map<String, Object> headerParams, Map<String, Object> queryParams, Map<String, Object> formParams){
        ObjectMapper objectMapper = new ObjectMapper();
        Call call = builderCall(path, method, headerParams, queryParams, formParams);
        StringBuilder ret = new StringBuilder();
        T result = null;
        Reader reader = null;
        try {
            Response response = call.execute();
            if (response.isSuccessful()){
                reader = response.body().charStream();
                if (Objects.nonNull(retClassType)){
                    result = objectMapper.readValue(reader, retClassType);
                }else {
                    char[] chars = new char[1024*10];

                    while (reader.read(chars) != -1){
                        ret.append(new String(chars));
                    }
                }
                result = (T) ret.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(reader)){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    private Call builderCall(String path, String method, Map<String, Object> headerParams, Map<String, Object> queryParams, Map<String, Object> formParams){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = builderRequest(path, method, headerParams, queryParams, formParams);
        return okHttpClient.newCall(request );
    }

    private Request builderRequest(String path, String method, Map<String, Object> headerParams, Map<String, Object> queryParams, Map<String, Object> formParams) {
        final String url = builderUrl(path, queryParams);
        final Request.Builder builder = new Request.Builder();
        Headers headers = builderHeader(method, headerParams);
        RequestBody body = builderBody(method, formParams);
        return builder.url(url).headers(headers).method(method, body).build();
    }

    private RequestBody builderBody(String method, Map<String, Object> formParams) {
        if ("GET".equalsIgnoreCase(method)){
            return null;
        }
        FormBody.Builder formBuilder  = new FormBody.Builder();
        if (Objects.isNull(formParams) || formParams.isEmpty()){
            return null;
        }
        for (Map.Entry<String, Object> param : formParams.entrySet()) {
            formBuilder.add(param.getKey(), String.valueOf(param.getValue()));
        }
        return formBuilder.build();
    }

    private Headers builderHeader(String method, Map<String, Object> headerParams) {
        final Headers.Builder headerBuilder = new Headers.Builder();
        if ("POST".equalsIgnoreCase(method)){
            headerBuilder.add("Content-Type", "application/x-www-form-urlencoded");
        }
        if (Objects.nonNull(headerParams) && !headerParams.isEmpty()){
            Iterator<Map.Entry<String, Object>> it = headerParams.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String, Object> entry = it.next();
                headerBuilder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return headerBuilder.build();
    }

    private String builderUrl(String path, Map<String, Object> queryParams) {
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append(path);
        if (Objects.nonNull(queryParams) && !queryParams.isEmpty()){
            String prefix = path.contains("?") ? "&" : "?";
            Iterator<Map.Entry<String, Object>> it = queryParams.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String, Object> entry = it.next();
                if (Objects.nonNull(entry.getValue())){
                    if (prefix != null) {
                        url.append(prefix);
                        prefix = null;
                    } else {
                        url.append("&");
                    }
                    String value = String.valueOf(entry.getValue());
                    url.append(escapeString(entry.getKey())).append("=").append(escapeString(value));
                }
            }
        }
        return url.toString();
    }

    public String escapeString(String str) {
        try {
            return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }
}
