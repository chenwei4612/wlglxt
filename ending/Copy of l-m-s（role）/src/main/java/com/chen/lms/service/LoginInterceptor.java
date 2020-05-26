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
// * ������Ҫʵ���û���¼��顪����������û�û�е�¼����ת����¼ҳ�棬��
// * ¼�ɹ�����ת��֮ǰ���ʵ�ҳ�档
// *
// * @author zhangwei
// */
//@Component
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//    public static final String USER_SESSION_NAME = "username";
//    /**
//     * ����
//     * Ԥ����ص�����
//     * 1> �����������true ��ʾ����ִ����һ��������
//     * 2> �����������false �����������ж�
//     * �������������������������������������ʱ��Ҫͨ��response������Ӧ
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
//        log.debug("VerifyInterceptor====> preHandle����ִ��" );
//        if (attribute != null) {
//            return true;
//        }
//        response.sendRedirect("/account/login?next=" + request.getRequestURI());
//        return false;
//    }
//    /**
//     * ����ص�������
//     * ʵ�ִ������ĺ���������Ⱦ��ͼ֮ǰ����
//     * ��ʱ����ͨ��modelAndView��ģ�����ݽ��д�������ͼ���д���
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.debug("VerifyInterceptor====> preHandle2����ִ��" );
//    }
//    /**
//     * ������������ϻص�������������ͼ��Ⱦ���ʱ����
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.debug("VerifyInterceptor====> afterCompletion ����ִ��" );
//    }
//}