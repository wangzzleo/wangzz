package com.wangzz.http;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    /**
     * 连接超时
     */
    public static final int connTimeout=10000;
    /**
     * 响应超时
     */
    public static final int readTimeout=600000;
    /**
     * 默认字符编码
     */
    public static final String charset="UTF-8";
    //private static HttpClient client = null;

    private static PoolingHttpClientConnectionManager cm = null;

    static {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();

        cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(128);
        cm.setDefaultMaxPerRoute(128);
        //client = HttpClients.custom().setConnectionManager(cm).build();
    }

    public static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();

        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
        return httpClient;
    }

    public static String sendPostSSLRequest(String url, String body ,String charset,String mimeType){
        HttpEntity entity = null;
        if (StringUtils.isNotBlank(body)) {
            entity = new StringEntity(body, ContentType.create(mimeType, charset));
        }
        return sendPostSSLRequest(url, entity, charset, mimeType);
    }

    public static String sendPostSSLRequest(String url, List<BasicNameValuePair> pairList , String charset, String mimeType){
        HttpEntity entity = null;
        if (pairList != null && pairList.size() > 0) {
            try {
                entity = new UrlEncodedFormEntity(pairList, charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sendPostSSLRequest(url, entity, charset, mimeType);
    }


    /**
     * 发送一个 Post 请求, 使用指定的字符集编码.
     *
     * @param url
     * @param entity entity
     * @param charset 编码
     * @return ResponseBody, 使用指定的字符集编码.
     * @throws ConnectTimeoutException 建立链接超时异常
     * @throws SocketTimeoutException  响应超时
     * @throws Exception
     */
    public static String sendPostSSLRequest(String url, HttpEntity entity ,String charset ,String mimeType){
        HttpClient client = null;
        HttpGet post = new HttpGet(url);
        String result = "通信失败";
        try {

            post.setHeader("Content-Type", mimeType);
            post.setHeader("Cookie", "BIDUPSID=E4E3F546D8DFE526F9CE0CB7D0E4BF40; PSTM=1554272179; BAIDUID=9AFAA641F6E3FB26AB382AD7B79ABA7C:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDUSS=jRpeTV2T0dtSFhjSGZGQlJkYUFSa01EQXFlSmVFa1p6dmxDSk9kRmJNTkxiTjljRVFBQUFBJCQAAAAAAAAAAAEAAABSDDwO1vHJyNHauuzR1QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEvft1xL37dcM; PSINO=2; locale=zh; ZD_ENTRY=baidu; H_PS_PSSID=1458_21123_28723_28558_28836_28584_26350_28603; delPer=1; Hm_lvt_010e9ef9290225e88b64ebf20166c8c4=1555483336,1555483969,1555485589,1555659482; Hm_lpvt_010e9ef9290225e88b64ebf20166c8c4=1555659897");
            post.setHeader("Referer", "https://hanyu.baidu.com/s?wd=%E4%BA%94%E8%A1%8C%E5%B1%9E%E6%B0%B4%E7%9A%84%E5%AD%97&from=poem");
            post.setHeader("Host", "hanyu.baidu.com");
            post.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            post.setHeader("Accept-Encoding", "gzip, deflate, br");
            post.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
            post.setHeader("Connection", "keep-alive");
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
            post.setHeader("X-Requested-With", "zh-CN,zh;q=0.9");


            if (entity != null) {
                //post.setEntity(entity);
            }
            // 设置参数
            RequestConfig.Builder customReqConf = RequestConfig.custom();
            customReqConf.setConnectTimeout(connTimeout);
            customReqConf.setSocketTimeout(readTimeout);
            post.setConfig(customReqConf.build());

            HttpResponse res;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();

                res = client.execute(post);

            } else {
                // 执行 Http 请求.
                client = HttpClientUtil.getHttpClient();
                res = client.execute(post);
            }

            result = IOUtils.toString(res.getEntity().getContent(), charset);
        } catch (GeneralSecurityException e) {

            e.printStackTrace();
        } catch (ClientProtocolException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            post.releaseConnection();
            if (url.startsWith("https") && client != null&& client instanceof CloseableHttpClient) {
                try {
                    ((CloseableHttpClient) client).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    /**
     * 创建 SSL连接
     * @return
     * @throws GeneralSecurityException
     */

    private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl)
                        throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert)
                        throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns,
                                   String[] subjectAlts) throws SSLException {
                }

            });

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } catch (GeneralSecurityException e) {
            throw e;
        }
    }


}
