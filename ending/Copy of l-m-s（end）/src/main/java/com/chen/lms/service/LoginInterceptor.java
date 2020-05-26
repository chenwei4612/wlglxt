//package com.chen.lms.service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * 现在需要实现用户登录检查——如果发现用户没有登录，跳转到登录页面，登
// * 录成功后跳转回之前访问的页面。
// *
// * @author zhangwei
// */
//@Component
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//    public static final String USER_SESSION_NAME = "username";
//    /**
//     * 作用
//     * 预处理回调方法
//     * 1> 如果方法返回true 表示继续执行下一个拦截器
//     * 2> 如果方法返回false 请求处理流程中断
//     * 不会继续调用其他的拦截器或处理器方法，此时需要通过response产生响应
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object attribute = request.getSession().getAttribute(USER_SESSION_NAME);
//        log.debug("VerifyInterceptor====> preHandle方法执行" );
//        if (attribute != null) {
//            return true;
//        }
//        response.sendRedirect("/account/login?next=" + request.getRequestURI());
//        return false;
//    }
//    /**
//     * 后处理回调方法，
//     * 实现处理器的后处理（但在渲染视图之前），
//     * 此时可以通过modelAndView对模型数据进行处理或对视图进行处理
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.debug("VerifyInterceptor====> preHandle2方法执行" );
//    }
//    /**
//     * 整个请求处理完毕回调方法，即在视图渲染完毕时调用
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.debug("VerifyInterceptor====> afterCompletion 方法执行" );
//    }
//}