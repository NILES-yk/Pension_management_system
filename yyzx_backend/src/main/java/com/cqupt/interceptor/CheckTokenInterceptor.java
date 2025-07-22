package com.cqupt.interceptor;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component //让SpringBoot识别到
public class CheckTokenInterceptor implements HandlerInterceptor {
    //重写preHandle方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行预检请求OPTIONS
        if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        //关于图片的静态资源访问，不用拦截
        if(request.getRequestURI().contains("/images")) {
            return true;
        }
        //获取token
        String token = request.getHeader("token");
        //检验token
        if(token == null) {
            throw new RuntimeException("token为空,请登录");
        }
        else{
            //检验token的有效性
            JwtParser parser = Jwts.parser();
            //解析token的key必须和生成的token的key一致
            parser.setSigningKey("cqupt123456");
            //判断token是否正确
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        }
        return true;
    }
}
