#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月8日
 */
package ${package}.vo;

import java.io.Serializable;


/**
 * @author wangzhigang
 * @time 2014年10月8日
 */
public class UserVO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 220933752025819646L;
	private String userId;
	private String userName;
	private String gender;
	private int  age = -1;

	/**
	 * 
	 */
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
