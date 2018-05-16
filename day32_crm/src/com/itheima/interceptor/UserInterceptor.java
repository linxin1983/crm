package com.itheima.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器，判断当前系统是否已经登录，如果登录，继续执行。如果没有登录，跳转到登录页面
 * @author Administrator
 */
public class UserInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 335018670739692955L;
	
	/**
	 * 进行拦截的方法
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 获取session对象
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user == null){
			/*HttpServletResponse response = ServletActionContext.getResponse();
			response.setDateHeader("Expires", 0);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");*/
			// 说明，没有登录，后面就不会执行了
			
			return "login";
		}
		return invocation.invoke();
	}

}












