package net.sunmingchun.www.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * net.sunmingchun.www.util
 * Created by smc
 * date on 2016/3/1.
 * Email:sunmch@163.com
 * http调用实体类
 * wepapi的接口调用
 */
public final class HttpUtils {

    private static Logger log = LoggerFactory.getLogger(HttpUtils.class);
    public static HttpUtils httpUtils = null;

    private HttpUtils() {

    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class){
                httpUtils = new HttpUtils();
            }
        }
        return httpUtils;
    }

    public void asyncGet(String url) {
        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClients.createDefault();
        closeableHttpAsyncClient.start();
        final HttpGet request = new HttpGet(url);
        List<Future<HttpResponse>> respList = new LinkedList<Future<HttpResponse>>();
        respList.add(closeableHttpAsyncClient.execute(request, null));
        for (Future<HttpResponse> response : respList) {
            try {
                response.get().getStatusLine();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            closeableHttpAsyncClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void asyncPost() {

    }

    public String get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        StringBuffer sb = new StringBuffer();
        try {
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
            InputStream inputStream = closeableHttpResponse.getEntity().getContent();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            log.error("获取地址：{}失败，错误信息如下：{}", url, e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public String post(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringBuffer sb = new StringBuffer();
        if (params != null && params.size() > 0) {  //当有查询条件的时候
            UrlEncodedFormEntity uefEntity = null;
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                formparams.add(new BasicNameValuePair(key, params.get(key)));
            }
            try {
                uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.error("UnsupportedEncodingException: 异常，获取地址：{}失败，错误信息如下：{}", url, e.getMessage());
            }
            httpPost.setEntity(uefEntity);
        }
        try {
            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpPost);
            InputStream inputStream = closeableHttpResponse.getEntity().getContent();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            log.error("IOException：异常,获取地址：{}失败，错误信息如下：{}", url, e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.get("https://open.weixin.qq.com/");
    }

}
