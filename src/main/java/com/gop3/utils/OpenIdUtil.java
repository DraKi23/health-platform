package com.gop3.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gop3.po.OpenIdJson;

/**
 * Create by jinli on 2020/2/8 21:57
 */
//@RestController
public class OpenIdUtil {
    private String appID = "wx9c6c9a6f04c15d81";//小程序id
    private String appSecret = "9cb9c2fcfd0b34c78c59ec3abfd4e098";//小程序密钥
   // @PostMapping("/getopenid")
    /**
     * @Description: 用code换取openid
     * @Author: jinli
     * @Date: 2020/2/12 10:19
     * @param code: 登陆凭证
     * @return: java.lang.String 返回openid
     **/
    public String getOpenid(String code) throws JsonProcessingException {
        String result = "";
        //HttpUtil是自定义工具类
        try{//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + this.appID + "&secret="
                            + this.appSecret + "&js_code="
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
