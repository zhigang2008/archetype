#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.manager.UserManager;
import ${package}.model.User;
import ${package}.vo.UserVO;
import com.htffund.etrade.sdk.base.json.JsonResult;
import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;
import com.htffund.etrade.sdk.base.vo.PageVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	static final Logger log = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	private UserManager userManager;
	
	/**列出所有记录
	 * @param model 数据对象
	 * @return
	 */
	@RequestMapping(value = "listAll.htm")
	public String list(Model model){
		log.debug("into user listAll");
		model.addAttribute("userList",userManager.listAll());
		return "user/listall";
	}
	/**分页查询
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list.htm")
	public String pageList(UserVO userVO,PageVO pageVO, Model model){
		log.debug("into user list");
		PageBounds pageBounds=pageVO.toPageBounds();
		List<User> pageList=userManager.pageList(userVO,pageBounds);
		//分页查询结果列表		
		model.addAttribute("pageList",pageList);
		//回传查询参数
		model.addAttribute("params",userVO);
		return "user/list";
	}
	
	/**根据ID查询记录信息
	 * @param userId 用户ID
	 * @param model 数据对象
	 * @return
	 */
	@RequestMapping(value = "show.htm")
	public String getUserById(@RequestParam("userId") String userId,Model model){
		log.debug("into user getbyID");
		model.addAttribute("user",userManager.getUser(userId));
		return "user/show";
	}

	/**转到添加用户界面
	 * @return 
	 */
	@RequestMapping(value = "add.htm")
	public String addUser(){
		log.debug("into user add");
		return "user/add";
	}
	
	/**添加用户
	 * @return json结果
	 */
	@RequestMapping(value = "save.htm")
	@ResponseBody
	public JsonResult saveUser(User user){
		log.debug("into user save");
		log.debug(user.getUserName());
		userManager.save(user);
		return new JsonResult(true,"return ok");
	}
	
	/**转到用户编辑页面
	 * @return
	 */
	@RequestMapping(value = "edit.htm")
	public String editUser(@RequestParam("userId") String userId,Model model){
		log.debug("into user edit");
		model.addAttribute("user",userManager.getUser(userId));
		return "user/edit";
	}
	
	/**更新用户信息
	 * @return json结果
	 */
	@RequestMapping(value = "update.htm")
	@ResponseBody
	public JsonResult updateUser(User user){
		log.debug("into user update");
		userManager.update(user);
		return new JsonResult(true,"return ok");
	}
	/**删除用户
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value = "delete.htm")
	@ResponseBody
	public JsonResult deleteUser(@RequestParam("userId") String userId){
		log.debug("into user delete");
		userManager.delete(userId);
		return new JsonResult(true,"return ok");
	}
	/**用户是否存在
	 * @param userId 用户ID
	 * @return 是否存在
	 */
	@RequestMapping(value = "notExist.htm")
	@ResponseBody
	public boolean userNotExist(@RequestParam("userId") String userId){
		log.debug("into user exist");
		log.debug("userId="+userId);
		User user=userManager.getUser(userId);
		if(user!=null&&user.getUserId()!=null){
			return false;
		}else{
		    return true;
		}
	}
	
}
