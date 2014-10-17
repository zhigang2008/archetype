#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月8日
 */
package ${package}.dao;

import java.util.List;

import ${package}.model.User;
import ${package}.vo.UserVO;
import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;

/**
 * @author wangzhigang
 * @time 2014年10月8日
 */
public interface UserMapper {
	
	public List<User> listAll();
	
	public User getUserById(String uid);

	public void save(User user);
	
	public void update(User user);
	
	public void deleteById(String userId);

	public List<User> pageList(UserVO userVO, PageBounds pageBounds);

}
