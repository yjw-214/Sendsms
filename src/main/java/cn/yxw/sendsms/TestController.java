package cn.yxw.sendsms;

import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t.do")
    @ResponseBody
    public String t(@RequestParam String mobile){
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode="274c58ff1d8f4bef8f8efa95a3c21446";
        Map<String,String> headers = new HashMap<String, String>();

        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("mobile",mobile);
        headers.put("param", "code:1234");
        headers.put("tpl_id", "TP1710262");
        Map<String, String> bodys = new HashMap<String, String>();
        HttpResponse response ;
        String en = "";
        try {
            /**
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            response = HttpUtils.doPost(host, path, method, headers, headers, bodys);
            System.out.println(response.toString());
            //获取response的body
            en = EntityUtils.toString(response.getEntity());
            System.out.println(en);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(en);
        }finally {
            System.out.println(en);
            System.out.println(en);
            return en;
        }

    }
}
