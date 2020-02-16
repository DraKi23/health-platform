package com.gop3.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gop3.po.OpenIdJson;

/**
 * Create by jinli on 2020/2/8 21:57
 */
//@RestController
public class OpenIdUtil {
    private static final String APP_ID = "xxxxxx";//小程序id
    private static final String APP_SECRET = "xxxxxx";//小程序密钥
   // @PostMapping("/getopenid")
    /**
     * @Description: 用code换取openid
     * @Author: jinli
     * @Date: 2020/2/12 10:19
     * @param code: 登陆凭证
     * @return: java.lang.String 返回openid
     **/
    public static String getOpenid(String code) throws JsonProcessingException {
        String result = "";
        //HttpUtil是自定义工具类
        try{
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + APP_ID + "&secret="
                            + APP_SECRET + "&js_code="
                            + code
                            + "&grant_type=authorization_code", null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = mapper.readValue(result, OpenIdJson.class);
        return openIdJson.getOpenid();
    }
}
