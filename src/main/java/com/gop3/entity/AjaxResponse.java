package com.gop3.entity;

import lombok.Data;

/**
 * Create by Drgn on 2019/11/21 15:36
 */
@Data
public class AjaxResponse {
    private int code;//状态码，200表示请求成功、404表示用户请求资源不存在、500表示后台服务器出错
    private String message;//状态信息
    private Object data;//可能返回的数据

    private AjaxResponse(){}

    /**
     * @Description: 返回响应时错误信息给前台
     * @Author: Drgn
     * @Date: 2019/11/21 15:40
     * @param code: 错误状态码
     * @param message:错误信息
     * @return: com.gop3.entity.AjaxResponse
     **/
    public static AjaxResponse error(int code, String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(code);
        ajaxResponse.setMessage(message);
        return ajaxResponse;
    }

    /**
     * @Description: 返回响应成功信息
     * @Author: Drgn
     * @Date: 2019/11/21 15:49
     * @return: com.gop3.entity.AjaxResponse
     **/
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        return ajaxResponse;
    }

    /**
     * @Description: 返回响应成功信息，并发送响应体
     * @Author: Drgn
     * @Date: 2019/11/21 15:53
     * @param data: 发送给前台的响应体
     * @return: com.gop3.entity.AjaxResponse
     **/
    public static AjaxResponse success(Object data){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("success");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
}
