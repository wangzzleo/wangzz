package com.wangzz.net.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wangzz.dictionary.NameScore;
import lombok.Data;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class HttpTest {
    public static void main(String[] args) {


        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService service = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory);


        for (int i = 0; i < 800; i++) {
            PaymentOrderDTO paymentOrderDTO = new PaymentOrderDTO();
            if (i%3 == 1) {
                paymentOrderDTO.setCustAccount("11010219721601");
                paymentOrderDTO.setAccountName("平安测试六零零零三四一五八六二六");
            } else if (i%3 == 2) {
                paymentOrderDTO.setCustAccount("6230580000054508325");
                paymentOrderDTO.setAccountName("平安测试七八八零六");
            } else {
                paymentOrderDTO.setCustAccount("6230580000074308748");
                paymentOrderDTO.setAccountName("平安测试三四六五九");
            }
            paymentOrderDTO.setContractId("CH2019101088" + i);
            Runnable httpClientTestThread = new HttpClientTestThread(paymentOrderDTO);
            service.execute(httpClientTestThread);
        }

        while (service.isTerminated()) {
            return;
        }

    }

    static class GetThread extends Thread {

        private final CloseableHttpClient httpClient;
        private final HttpContext context;
        private final HttpGet httpget;

        public GetThread(CloseableHttpClient httpClient, HttpGet httpget) {
            this.httpClient = httpClient;
            this.context = HttpClientContext.create();
            this.httpget = httpget;
        }

        @Override
        public void run() {
            try {
                CloseableHttpResponse response = httpClient.execute(
                        httpget, context);
                try {
                    HttpEntity entity = response.getEntity();
                } finally {
                    response.close();
                }
            } catch (ClientProtocolException ex) {
                // Handle protocol errors
            } catch (IOException ex) {
                // Handle I/O errors
            }
        }

    }

    static class HttpClientTestThread extends Thread {

        private PaymentOrderDTO dto;

        public HttpClientTestThread(PaymentOrderDTO dto) {
            this.dto =dto;
        }

        public static int nextInt(final int startInclusive, final int endExclusive) {
            if (startInclusive == endExclusive) {
                return startInclusive;
            }
            Random RANDOM = new Random();

            return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
        }

        @Override
        public void run() {
            try {
                String callFlow = LocalDate.now().toString().replace("-", "") + System.nanoTime() + String.format("%04d", nextInt(0, 9999));;
                //String url = "http://localhost:8083/pay/api/sendPayment?"+ "sceneId=10000212&providerId=10050021&paymentMode=2&bankName=兴业银行&custAccount="+dto.getCustAccount()+"&accountName="+dto.getAccountName()+"&paymentAmount=1&flowStatus=true&certType=1&certNo="+dto.getCertNo()+"&callFlow="+callFlow;
                String url = "http://localhost:8083/pay/api/sendPayment?"+ "sceneId=10000212&providerId=10050021&paymentMode=1&bankName=平安银行&custAccount="+dto.getCustAccount()+"&accountName="+dto.getAccountName()+"&paymentAmount=1&flowStatus=true&contractId=" + dto.getContractId() + "&effectStartDate=2019-09-23&effectEndDate=2020-10-23&callFlow="+callFlow;
                String url1 = "http://localhost:8083/pay/api/sendPayment?"+ "sceneId=10000210&providerId=10050007&paymentMode=1&bankName=平安银行股份有限公司上海九江路支行&custAccount=123455555&accountName=平安银行测试2222&paymentAmount=1&flowStatus=true&bankCode=307290023031&callFlow="+callFlow;
                String res = HttpClientUtilOld.sendPostSSLRequest(url , null,"UTF-8", "application/x-www-form-urlencoded");
                System.out.println(res);
            }  catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


    @Data
    public static class PaymentOrderDTO implements Serializable {
        /**必填     唯一支付指令流水(上游流水号、订单号)*/
        private String callFlow;
        /**必填   外部系统订单号   */
        private String outOrderNo;
        /**必填  支付方式 1:代付(放款)，2:代收(回款)*/
        private Integer paymentMode;
        /**必填  申请单号、贷款编号   */
        private Long applyId;
        /**必填  场景ID*/
        private Integer sceneId;
        /**必填  资金(信托项目)ID*/
        private Integer fundsId;
        /**必填  资金来源(方)ID*/
        private Integer providerId;
        /**必填  产品ID */
        private Integer productId;
        /**必填  商户编号、供应商id*/
        private String merchantNo;
        /**必填  证件类型: 1身份证、2签证、3护照、4户口本、5港澳通行证、7党员证、6军人证、7团员证、8居住证*/
        private Integer certType;
        /**可选  证件号码  */
        private String certNo;
        /**必填  客户账户名称 */
        private String accountName;
        /**可选  客户账户，银行卡或第三方账号 */
        private String custAccount;
        /**必填 手机号  */
        private String mobile;
        /**必填 流程状态，是否请求第三方。1需要调用第三方支付，0:不用调用第三方，先有第三方结果，反向生成支付数据 */
        private Boolean flowStatus;
        /**可选  银行名称 */
        private String bankName;
        /**可选  银行编码 */
        private String bankCode;
        /**必填  订单日期(下单时间) yyyy-MM-dd HH:mm:ss */
        private String orderDate;
        /**必填  付款(扣款)金额*/
        private BigDecimal paymentAmount;
        /**可选   第三方支付回调时间，支付时间 yyyy-MM-dd HH:mm:ss*/
        private String paymentTime;
        /**可选  支付状态 0等待处理 1支付中 2支付成功 3支付失败 */
        private Integer paymentStatus;
        /**必填  房互网--国投-宝付用户签约协议号 */
        private String protocolNo;
        /**必填  房互网-国投-宝付用户id */
        private String userId;
        /**可选  兴业银行-期数 */
        private Integer term;
        /**必填  对公对私标志- 账务推送: 2-对公  1-对私*/
        private Integer pubOrpriFlag;
        /**托管户直放-必填  合同编号 */
        private String contractId;
        /**生效开始日 yyyy-MM-dd*/
        private String effectStartDate;
        /**生效结束日 yyyy-MM-dd*/
        private String effectEndDate;
    }

    private void createName() {
        int i = 1;
        while (true) {
            String url = "https://hanyu.baidu.com/hanyu/ajax/search_list?wd=%E5%B8%A6%E5%A5%B3&device=pc&from=home&userid=238816338&pn=" + (++i) +"&_=1555914238360";
            String charset = "UTF-8";
            String mimeType = "application/x-www-form-urlencoded";
            List<BasicNameValuePair> pairList = new ArrayList<>();
//            pairList.add(new BasicNameValuePair("wd", "带女"));
//            pairList.add(new BasicNameValuePair("device", "pc"));
//            pairList.add(new BasicNameValuePair("from", "home"));
//            pairList.add(new BasicNameValuePair("userid", "238816338"));
//            pairList.add(new BasicNameValuePair("pn", String.valueOf(i++)));
//            pairList.add(new BasicNameValuePair("_", "1555914238359"));

            List<Header> headersList = new ArrayList<>();
            headersList.add(new BasicHeader("Cookie", "BIDUPSID=E4E3F546D8DFE526F9CE0CB7D0E4BF40; PSTM=1554272179; BAIDUID=9AFAA641F6E3FB26AB382AD7B79ABA7C:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDUSS=jRpeTV2T0dtSFhjSGZGQlJkYUFSa01EQXFlSmVFa1p6dmxDSk9kRmJNTkxiTjljRVFBQUFBJCQAAAAAAAAAAAEAAABSDDwO1vHJyNHauuzR1QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEvft1xL37dcM; PSINO=2; locale=zh; ZD_ENTRY=baidu; H_PS_PSSID=1458_21123_28723_28558_28836_28584_26350_28603; delPer=1; Hm_lvt_010e9ef9290225e88b64ebf20166c8c4=1555483336,1555483969,1555485589,1555659482; Hm_lpvt_010e9ef9290225e88b64ebf20166c8c4=1555659897"));
            headersList.add(new BasicHeader("Referer", "https://hanyu.baidu.com/s?wd=%E4%BA%94%E8%A1%8C%E5%B1%9E%E6%B0%B4%E7%9A%84%E5%AD%97&from=poem"));
            headersList.add(new BasicHeader("Host", "hanyu.baidu.com"));
            headersList.add(new BasicHeader("Accept", "application/json, text/javascript, */*; q=0.01"));
            headersList.add(new BasicHeader("Accept-Encoding", "gzip, deflate, br"));
            headersList.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"));
            headersList.add(new BasicHeader("Connection", "keep-alive"));
            headersList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36"));
            headersList.add(new BasicHeader("X-Requested-With", "zh-CN,zh;q=0.9"));
            Header[] headers = new Header[headersList.size()];
            String baiduWx = HttpClientUtil.sendPostSSLRequest(url, headersList.toArray(headers),pairList, charset, mimeType);
            JSONArray retArray = JSON.parseObject(baiduWx).getJSONArray("ret_array");

            retArray.forEach((j) -> {
                String name = "子"+((JSONObject)j).get("name").toString().charAt(2);
                NameScore.nameScoreTest(charset, mimeType, name);
            });
        }
        //System.out.println(retArray);
    }
}
