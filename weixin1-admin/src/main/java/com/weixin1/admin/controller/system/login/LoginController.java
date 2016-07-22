package com.weixin1.admin.controller.system.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weixin1.common.base.controller.BaseController;
import com.weixin1.common.util.Const;
import com.weixin1.common.util.PageData;
import com.weixin1.common.util.Tools;

@Controller
public class LoginController extends BaseController {
	
	/**
	 * 获取登录用户的IP
	 * @throws Exception 
	 */
	public void getRemortIP(String USERNAME) throws Exception {  
		PageData pd = new PageData();
		HttpServletRequest request = this.getRequest();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {  
			ip = request.getRemoteAddr();  
	    }else{
	    	ip = request.getHeader("x-forwarded-for");  
	    }
		pd.put("userName", USERNAME);
	}  
	
	/**
	 * 访问登录页
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView toLogin()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		mv.setViewName("system/admin/login");
		mv.addObject("pd",pd);
		return mv;
	}
	
	/**
	 * 请求登录，验证用户
	 */
	@RequestMapping(value="/login_login")
	@ResponseBody
	public Object login()throws Exception{
		return null;
//		Map<String,String> map = new HashMap<String,String>();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		String errInfo = "";
//		//验证码注释，生产时放开
//		String KEYDATA[] = pd.getString("KEYDATA").split(",");
////		String KEYDATA[] = (pd.getString("KEYDATA")+"1111").split(",");
//		
//		if(null != KEYDATA && KEYDATA.length == 3){
//			//shiro管理的session
//			Subject currentUser = SecurityUtils.getSubject();  
//			Session session = currentUser.getSession();
//			String sessionCode = (String)session.getAttribute(Const.SESSION_SECURITY_CODE);		//获取session中的验证码
//			//验证码注释，生产时放开
//			String code = KEYDATA[2];
//			if(null == code || "".equals(code)){
//				errInfo = "nullcode"; //验证码为空
//			}else{
//				String USERNAME = KEYDATA[0];
//				String PASSWORD  = KEYDATA[1];
//				//验证码注释，生产时放开
//				if(Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)){
//				//if(Tools.notEmpty(sessionCode)){	
//					String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();	//密码加密
//					User user = new User();
//					user.setUserName(USERNAME);
//					user.setUserPwd(passwd);					 
//					user = userService.getUser(user);
//					if(user != null){
//						user.setLastLoginTime(DateUtil.fomatDate(DateUtil.getTime()));
//						userService.doModifyUserById(user);
//						 
//						session.setAttribute(Const.SESSION_USER, user);
//						session.removeAttribute(Const.SESSION_SECURITY_CODE);
//						
//						//shiro加入身份验证
//						Subject subject = SecurityUtils.getSubject(); 
//					    UsernamePasswordToken token = new UsernamePasswordToken(USERNAME, PASSWORD); 
//					    try { 
//					        subject.login(token); 
//					    } catch (AuthenticationException e) { 
//					    	errInfo = "身份验证失败！";
//					    }
//					}else{
//						errInfo = "usererror"; 				//用户名或密码有误
//					}
//				}else{
//					errInfo = "codeerror";				 	//验证码输入有误
//				}
//				if(Tools.isEmpty(errInfo)){
//					errInfo = "success";					//验证成功
//				}
//			}
//		}else{
//			errInfo = "error";	//缺少参数
//		}
//		map.put("result", errInfo);
//		map.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
//		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value="/main/{changeMenu}")
	public ModelAndView login_index(@PathVariable("changeMenu") String changeMenu){
		return null;
//		ModelAndView mv = this.getModelAndView();
//		PageData pd = new PageData();
//		pd = this.getPageData();
//		try{
//			
//			//shiro管理的session
//			Subject currentUser = SecurityUtils.getSubject();  
//			Session session = currentUser.getSession();
//			
//			User user = (User)session.getAttribute(Const.SESSION_USER);
//			if (user != null) {
//				String roleRights = (String)session.getAttribute(Const.SESSION_MENU_RIGHTS);
//				if(!Tools.notEmpty(roleRights)){
//					roleRights = roleRightService.getAllRights(user);
//					session.setAttribute(Const.SESSION_MENU_RIGHTS, roleRights);	//把全部权限放到session中
//				}
//				if(null == session.getAttribute(Const.SESSION_USERNAME)){
//					session.setAttribute(Const.SESSION_USERNAME, user.getUserName());	//放入用户名
//				}
//				
//				List<Menu> allmenuList = new ArrayList<Menu>();
//				
//				if(null == session.getAttribute(Const.SESSION_allmenuList)){
//					allmenuList = menuService.queryListAllMenu();
//					if(Tools.notEmpty(roleRights)){
//						for(Menu menu : allmenuList){
//							menu.setHasMenu(RightsHelper.testRights(roleRights, menu.getMenuId()));
//							if(menu.isHasMenu()){
//								List<Menu> subMenuList = menu.getSubMenu();
//								for(Menu sub : subMenuList){
//									sub.setHasMenu(RightsHelper.testRights(roleRights, sub.getMenuId()));
//								}
//							}
//						}
//					}
//					session.setAttribute(Const.SESSION_allmenuList, allmenuList);			//菜单权限放入session中
//				}else{
//					allmenuList = (List<Menu>)session.getAttribute(Const.SESSION_allmenuList);
//				}
//				 
//				
//				if(null == session.getAttribute(Const.SESSION_BUTTON_RIGHTS)){
//					session.setAttribute(Const.SESSION_BUTTON_RIGHTS, roleRightService.getButtonRights(user));	//按钮权限放到session中
//				}
//				
//				mv.setViewName("system/admin/index");
//				mv.addObject("user", user);
//				mv.addObject("menuList", allmenuList);
//				List<Menu> resourceMenuList = menuService.getResourceMenu(user.getUserId());
//				mv.addObject("resourceMenuList",resourceMenuList);
//				
//			}else {
//				mv.setViewName("system/admin/login");//session失效后跳转登录页面
//			}
//			
//			
//		} catch(Exception e){
//			mv.setViewName("system/admin/login");
//			logger.error(e.getMessage(), e);
//		}
//		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
//		mv.addObject("pd",pd);
//		return mv;
	}
	
	/**
	 * 进入tab标签
	 * @return
	 */
	@RequestMapping(value="/tab")
	public String tab(){
		return "system/admin/tab";
	}
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value="/login_default")
	public String defaultPage(){
		return "system/admin/default";
	}
	
	/**
	 * 用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		
		//shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(Const.SESSION_allmenuList);
		session.removeAttribute(Const.SESSION_menuList);
		session.removeAttribute(Const.SESSION_QX);
		session.removeAttribute(Const.SESSION_userpds);
		session.removeAttribute(Const.SESSION_USERNAME);
		session.removeAttribute(Const.SESSION_USERROL);
		session.removeAttribute("changeMenu");
		
		//shiro销毁登录
		Subject subject = SecurityUtils.getSubject(); 
		subject.logout();
		
		pd = this.getPageData();
		String  msg = pd.getString("msg");
		pd.put("msg", msg);
		
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		mv.setViewName("system/admin/login");
		mv.addObject("pd",pd);
		return mv;
	}

}
