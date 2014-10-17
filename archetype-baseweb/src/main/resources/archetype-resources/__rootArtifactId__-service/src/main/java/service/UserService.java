#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月9日
 */
package ${package}.service;

import ${package}.model.User;

/**
 * @author wangzhigang
 * @time 2014年10月9日
 */

public interface UserService {

	/**根据userId获取用户信息
	 * @param userId 用户ID
	 * @return
	 */
	public User getUser(String userId);

}
