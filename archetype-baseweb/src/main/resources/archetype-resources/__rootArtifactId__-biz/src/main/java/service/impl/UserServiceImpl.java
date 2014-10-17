#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月9日
 */
package ${package}.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.manager.UserManager;
import ${package}.model.User;
import ${package}.service.UserService;


/**
 * @author wangzhigang
 * @time 2014年10月9日
 */
public class UserServiceImpl implements UserService {
	static final Logger log = LogManager.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserManager userManager;


	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}getUser(java.lang.String)
	 */
	public User getUser(String userId){
			return userManager.getUser(userId);
	}

	
}
