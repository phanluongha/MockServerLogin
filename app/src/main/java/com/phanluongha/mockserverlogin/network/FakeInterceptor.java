package com.phanluongha.mockserverlogin.network;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class FakeInterceptor implements Interceptor {

    // data of result success
    private static final String RESULT_SUCCESS = "{\n" +
            "  \"status\": \"success\",\n" +
            "  \"result\": {\n" +
            "    \"email\": \"abc@gmail.com\"\n" +
            "  }\n" +
            "}";

    // data of result fail
    private static final String RESULT_FAIL = "{\n" +
            "  \"code\": 404,\n" +
            "    \"error\": \"Email or Password not invalid\"\n" +
            "}\n";

    //data for login
    private static final String DATA_TO_LOGIN = "email=haphan%40gmail.com&password=123";


    private String mContentType = "application/json";


    /**
     * Set content type for header
     *
     * @param contentType Content type
     * @return FakeInterceptor
     */
    public FakeInterceptor setContentType(String contentType) {
        mContentType = contentType;
        return this;
    }

    @Override
    public Response intercept(Chain chain) {
        RequestBody request = chain.request().body();
        String a = stringifyRequestBody(chain.request());
        boolean verifyLogin = a.equalsIgnoreCase(DATA_TO_LOGIN);
        Response response = null;
        if (verifyLogin) {
            response = new Response.Builder()
                    .code(200)
                    .message(RESULT_SUCCESS)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse(mContentType), RESULT_SUCCESS.getBytes()))
                    .addHeader("content-type", mContentType)
                    .build();
        }else{
            response = new Response.Builder()
                    .code(200)
                    .message(RESULT_FAIL)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse(mContentType), RESULT_FAIL.getBytes()))
                    .addHeader("content-type", mContentType)
                    .build();
        }
        return response;
    }

    private String stringifyRequestBody(Request request) {
        if (request.body() != null) {
            try {
                final Request copy = request.newBuilder().build();
                final Buffer buffer = new Buffer();
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            } catch (final IOException e) {
            }
        }
        return "";
    }
}
