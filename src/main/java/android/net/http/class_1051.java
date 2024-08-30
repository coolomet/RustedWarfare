package android.net.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

// $FF: renamed from: android.net.http.a
class class_1051 implements HttpRequestInterceptor {
    // $FF: synthetic field
    final AndroidHttpClient a;

    private class_1051(AndroidHttpClient var1) {
        this.a = var1;
    }

    public void process(HttpRequest var1, HttpContext var2) {
        class_1053 var3 = AndroidHttpClient.a(this.a);
        if (var3 != null && class_1053.a(var3) && var1 instanceof HttpUriRequest) {
            class_1053.a(var3, AndroidHttpClient.a((HttpUriRequest)var1, false));
        }

    }

    // $FF: synthetic method
    class_1051(AndroidHttpClient var1, AndroidHttpClient$1 var2) {
        this(var1);
    }
}
