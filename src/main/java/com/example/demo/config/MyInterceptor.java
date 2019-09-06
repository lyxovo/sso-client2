package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.utils.CommResult;
import com.example.demo.utils.CookieUtils;
import com.example.demo.utils.HttpClientUtil;
import com.example.demo.utils.JsonUtils;

public class MyInterceptor implements HandlerInterceptor {
	/**
	 * 该方法将在请求处理之前(执行controller之前)进行调用，当方法返回true，才会继续执行后续的Interceptor和Controller，当返回值为false
	 * 时不会往下执行，即拦截了。
	 * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法//启动前执行，true放行，false拦截。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//从浏览器中获取cookie
		String token = CookieUtils.getCookieValue(request, "u_token");
       //User user = this.userService.getUserByToken(token);
		
		Object user=null;
		if(!StringUtils.isBlank(token)) {
			//调用sso的查询接口，这里也可拆分在service层再使用httpClient调用sso接口。
			CommResult result = JsonUtils.jsonToPojo(HttpClientUtil.doGet("http://localhost:8083"+"/user/token/"+token), CommResult.class);
			user = result.getData();//{id=17, username=admin, password=null}
		}
		
        if (user==null) {
            // 没有登录，跳转到登录页面，把用户请求的url作为参数传递给登录页面。
        	//request.getRequestURL():浏览器当前登录的url
        	//http://localhost:8083/user/login,登录地址
            response.sendRedirect("http://localhost:8083/page/login?redirect=" + request.getRequestURL());
            // 返回false
            return false;
        }
        request.setAttribute("user", user);
        return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
