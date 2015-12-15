#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月8日
 */
package ${package}.model;

import java.io.Serializable;

/**
 * @author wangzhigang
 * @time 2014年10月8日
 */
public class BackResult implements Serializable {
	
	private static final long serialVersionUID = -413545001375585093L;
	/**
	 * 错误代码
	 */
	private String errCode;
	/**
	 * 错误信息
	 */
	private String errMsg;

	/**
	 * 
	 */
	public BackResult() {
		
	}

	/** 获取错误代码
	 * @return  错误代码
	 */
	public String getErrCode() {
		return errCode;
	}

	/** 设置错误代码
	 * @param errCode 错误代码
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**获取错误信息
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**设置错误信息
	 * @param errMsg 错误信息
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
