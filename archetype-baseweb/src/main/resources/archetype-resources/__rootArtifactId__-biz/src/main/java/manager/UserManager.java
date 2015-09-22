#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月9日
 */
package ${package}.manager;

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

/**DEMO 用户操作业务类 
 * @author wangzhigang
 * @time 2014年10月9日
 */
@Service("userManager")
public class UserManager {
	static final Logger log = LogManager.getLogger(UserManager.class.getName());
	
	@Autowired
	private UserMapper userMapper;


	/**根据userId获取用户信息
	 * @param userId 用户ID
	 * @return 用户对象
	 */
	public User getUser(String userId){
		return userMapper.getUserById(userId);
	}

	/**列出所有的用户信息
	 * @return 对象列表
	 */
	public List<User> listAll(){
		return userMapper.listAll();
	}

	/**添加用户
	 * @param user 用户信息
	 */
	public void save(User user) {
		userMapper.save(user);
		
	}

	/**更新用户信息
	 * @param user 用户信息
	 */
	public void update(User user) {
		userMapper.update(user);
		
	}

	/**根据ID号删除用户
	 * @param userId 用户ID
	 */
	public void delete(String userId) {
		userMapper.deleteById(userId);

	}

	/**分页查询
	 * @param userVO  查询参数
	 * @param pageBounds 分页参数
	 * @return 结果列表
	 */
	public List<User> pageList(UserVO userVO, PageBounds pageBounds) {
		List<User> list= userMapper.pageList(userVO,pageBounds);
		return  list;
		
	}
}
