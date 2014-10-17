#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月9日
 */
package ${package}.manager.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.dao.UserMapper;
import ${package}.manager.UserManager;
import ${package}.model.User;
import ${package}.vo.UserVO;
import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;

/**
 * @author wangzhigang
 * @time 2014年10月9日
 */
@Service("userManager")
public class UserManagerImpl implements UserManager {
	static final Logger log = LogManager.getLogger(UserManagerImpl.class.getName());
	
	@Autowired
	private UserMapper userMapper;


	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}getUser(java.lang.String)
	 */
	public User getUser(String userId){
		return userMapper.getUserById(userId);
	}

	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}listAll()
	 */
	public List<User> listAll(){
		return userMapper.listAll();
	}

	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}save(${package}.model.User)
	 */
	public void save(User user) {
		userMapper.save(user);
		
	}

	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}update(${package}.model.User)
	 */
	public void update(User user) {
		userMapper.update(user);
		
	}

	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}delete(java.lang.String)
	 */
	public void delete(String userId) {
		userMapper.deleteById(userId);

	}

	/* (non-Javadoc)
	 * @see ${package}.manager.UserManager${symbol_pound}pageList(${package}.vo.UserVO, com.htffund.etrade.sdk.base.paginator.domain.PageBounds)
	 */
	public List<User> pageList(UserVO userVO, PageBounds pageBounds) {
		List<User> list= userMapper.pageList(userVO,pageBounds);
		return  list;
		
	}
}
