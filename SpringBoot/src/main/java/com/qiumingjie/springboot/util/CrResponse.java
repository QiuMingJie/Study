package com.qiumingjie.springboot.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Bug_Zheng
 */
public class CrResponse implements Serializable {

    private static final long serialVersionUID = 5860504802659429680L;

    private int code;

    private String msg;

    private Object data;

    public CrResponse() {
        this.code = 200;
        this.msg = "操作成功";
    }


    public static CrResponse error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static CrResponse error(String msg) {
        return error(500, msg);
    }


    public static CrResponse error(int code, String msg) {
        CrResponse crResponse = new CrResponse();
        crResponse.setCode(code);
        crResponse.setMsg(msg);
        return crResponse;
    }

    public static CrResponse ok(String msg) {
        CrResponse crResponse = new CrResponse();
        crResponse.setMsg(msg);
        return crResponse;
    }

    public static CrResponse ok(Object data) {
        CrResponse crResponse = new CrResponse();
        crResponse.setData(data);
        return crResponse;
    }

    public static CrResponse ok() {
        return new CrResponse();
    }

    /**
     * data作为Map类型存放数据
     *
     * @param key
     * @param value
     * @return
     */
    public CrResponse putData(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        this.data = (Map<String, Object>) data;
        ((Map<String, Object>) data).put(key, value);
        return this;
    }

    /**
     * 获取Map类型的Data
     *
     * @return
     */
//	@JsonIgnore
//	public Map<String,Object> getMapData() {
//		if(this.data == null) {
//			this.data = new HashMap<String, Object>();
//		} else if(!(this.data instanceof Map)) {
//			throw new CrException("data存在,但不是Map类型");
//		}
//
//		return (Map<String, Object>) this.data;
//	}
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
