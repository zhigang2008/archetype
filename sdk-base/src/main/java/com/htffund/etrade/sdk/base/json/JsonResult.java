/**
 * wangzhigang
 * 2014年10月10日
 */
package com.htffund.etrade.sdk.base.json;

import java.io.Serializable;

/**用来提交Json数据对象
 * @author wangzhigang
 * @time 2014年10月10日
 */
public class JsonResult implements Serializable {
	
	/**
	 * 成功标志
	 */
	private boolean success;
	/**
	 * 消息
	 */
	private String  message;
	/**
	 * 结果对象
	 */
	private Object result;

	/**
	 * 默认构造方法
	 */
	public JsonResult() {
		// TODO Auto-generated constructor stub
	}
	
	/**带参数的构造方法
	 * @param ok 是否成功
	 * @param msg 消息
	 */
	public JsonResult(boolean ok,String msg) {
		this.success=ok;
		this.message=msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
