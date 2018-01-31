package com.cn.util;

import java.util.Map;

import org.springframework.util.StringUtils;
/**
 * 创建时间：2018/1/20  0:55
 * 项目名称：SpringMVC
 *
 * @author mahua
 * Package com.cn.util
 * @version 1.0
 * 类说明：返回类型
 */
public class ResultUtils {

    public static final String result_code = "resultCode";

    public static final String message = "msg";

    public static final String data = "data";

    public static final String ROWS = "rows";

    public static final Integer status_code_ok = 200;

    public static final Integer status_code_param_error = 406;

    public static final Integer status_code_conflict = 409;

    public static final Integer status_code_notfound = 404;

    public static final Integer status_code_sign_error = 403;

    public static final Integer status_code_sys_error = 500;

    /**
     * 状态正常
     * @param result
     */
    public static void resultCodeOk(Map<String, Object> result) {
        result.put(result_code, status_code_ok);
    }

    /**
     * 参数错误
     * @param result
     */
    public static void paramsError406(Map<String, Object> result) {
        result.put(result_code, status_code_param_error);
        result.put(message, "参数错误");
    }

    /**
     * 参数错误
     * @param result
     * @param errorMsg
     */
    public static void paramsError406(Map<String, Object> result, String errorMsg) {
        result.put(result_code, status_code_param_error);
        if (!StringUtils.isEmpty(errorMsg)) {
            result.put(message, errorMsg);
        }
    }

    /**
     * 业务冲突
     * @param result
     * @param errorMsg
     */
    public static void conflict409(Map<String, Object> result, String errorMsg) {
        result.put(result_code, status_code_conflict);
        if (!StringUtils.isEmpty(errorMsg)) {
            result.put(message, errorMsg);
        }
    }

    /**
     * 签名错误
     * @param result
     */
    public static void signError403(Map<String, Object> result) {
        result.put(result_code, status_code_sign_error);
        result.put(message, "签名错误");
    }

    /**
     * 签名错误
     * @param result
     * @param errorMsg
     */
    public static void signError403(Map<String, Object> result, String errorMsg) {
        result.put(result_code, status_code_sign_error);
        if (!StringUtils.isEmpty(errorMsg)) {
            result.put(message, errorMsg);
        }
    }

    /**
     * 服务器错误
     * @param result
     */
    public static void sysError500(Map<String, Object> result) {
        result.put(result_code, status_code_sys_error);
        result.put(message, "服务器错误");
    }

    /**
     * 服务器错误
     * @param result
     * @param errorMsg
     */
    public static void sysError500(Map<String, Object> result, String errorMsg) {
        result.put(result_code, status_code_sys_error);
        if (!StringUtils.isEmpty(errorMsg)) {
            result.put(message, errorMsg);
        }
    }

    /**
     * 资源不存在
     * @param result
     * @param errorMsg
     */
    public static void notFound404(Map<String, Object> result, String errorMsg) {
        result.put(result_code, status_code_notfound);
        if (!StringUtils.isEmpty(errorMsg)) {
            result.put(message, errorMsg);
        }
    }
}
