package com.beenoisy.springboot.interceptor;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问统计<br>
 * 2015年5月8日:下午4:01:38
 * 
 * @author Keen | jacks808@163.com | ziyi.wang@renren-inc.com<br>
 */
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Object handler) throws Exception {

        StringBuilder headerBuilder = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            Object headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName.toString());
            headerBuilder.append(headerName).append("=").append(headerValue);
        }

        StringBuffer requestURL = request.getRequestURL();

        String remoteHost = request.getRemoteHost();

        String requestParamMap = map2String(request.getParameterMap());

        StringBuilder builder = new StringBuilder();
        builder.append("RequestURL: ").append(requestURL).append("\n");
        builder.append("RemoteHost: ").append(remoteHost).append("\n");
        builder.append("RequestHeaders: ").append(headerBuilder.toString()).append("\n");
        builder.append("RequestParam: ").append(requestParamMap).append("\n");

        System.out.println(builder.toString());
        return true;
    }

    private static String map2String(
                    Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Set<String> keySet = map.keySet();
        for (Object key : keySet) {
            String[] value = (String[]) map.get(key);
            sb.append(key + "=" + Arrays.toString(value) + " ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void postHandle(
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Object handler,
                    ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Object handler,
                    Exception ex) throws Exception {

    }

}
