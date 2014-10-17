#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月9日
 */
package ${package}.manager;

import java.util.List;

import ${package}.model.User;
import ${package}.vo.UserVO;
import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;

/**
 * @author wangzhigang
 * @time 2014年10月9日
 */

public interface UserManager {

	/**根据userId获取用户信息
	 * @param userId 用户ID
	 * @return
	 */
	public User getUser(String userId);
	/**列出所有的用户信息
	 * @return
	 */
	public List<User> listAll();
	/**添加用户
	 * @param user 用户信息
	 */
	public void save(User user) ;
	/**更新用户信息
	 * @param user 用户信息
	 */
	public void update(User user);
	/**根据ID号删除用户
	 * @param userId 用户ID
	 */
	public void delete(String userId) ;
	/**分页查询
	 * @param userVO  查询参数
	 * @param pageBounds 分页参数
	 * @return 结果列表
	 */
	public List<User> pageList(UserVO userVO, PageBounds pageBounds) ;
}
