import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class run {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody b = RequestBody.create(mediaType, "username=admin&password=123456&grant_type=password&client_id=client&client_secret=123456");
        Request request = new Request.Builder()
                .url("http://localhost:10020/oauth/token")
                .method("POST", b)
                .addHeader("Authorization", "Basic Y2xpZW50OjEyMzQ1Ng==")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "JSESSIONID=7E61266231BC3DF3261CE52EB38B5E79")
                .build();
        Response r = client.newCall(request).execute();
        JSONObject jsonObject = JSONObject.parseObject(r.body().string());
        System.out.println(jsonObject.get("access_token"));



    }
}
