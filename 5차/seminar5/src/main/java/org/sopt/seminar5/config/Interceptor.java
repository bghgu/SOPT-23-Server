package org.sopt.seminar5.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ds on 2018-11-07.
 */

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    /**
     * 컨트롤러 메소드 실행 직전에 수행
     * true 를 반환하면 계속 진행이 되고  false 를 리턴하면 실행 체인(다른 인터셉터, 컨트롤러 실행)이 중지되고 반환
     * 필터의 응답 처리가 있다면 그것은 실행이 된다.
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 컨트롤러 메소드 실행 직후에 실행
     * View 페이지가 렌더링 되기전에 ModelAndView 객체를 조작 가능
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * View 페이지가 렌더링 되고 난 후 에 실행
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    /**
     * Servlet 3.0 부터 비동기 요청이 가능
     * 비동기 요청시 postHandle와 afterCompletion 은 실행되지 않고, 이 메소드가 실행
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }
}
