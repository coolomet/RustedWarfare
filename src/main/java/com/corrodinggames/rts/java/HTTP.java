package com.corrodinggames.rts.java;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.net.HTTPService;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public strictfp class HTTP extends HTTPService {
    public HttpClient a(int var1, boolean var2) {
        RequestConfig.Builder var3 = RequestConfig.custom();
        var3 = var3.setConnectTimeout(var1);
        var3 = var3.setConnectionRequestTimeout(var1);
        HttpClientBuilder var4 = HttpClientBuilder.create();
        var4.setDefaultRequestConfig(var3.build());
        CloseableHttpClient var5 = var4.build();
        return var5;
    }

    public void a(HttpClient var1) {
        if (var1 instanceof CloseableHttpClient) {
            CloseableHttpClient var2 = (CloseableHttpClient)var1;

            try {
                var2.close();
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        } else {
            GameEngine.log("closeHttpClient: Didn't close");
        }

    }
}
