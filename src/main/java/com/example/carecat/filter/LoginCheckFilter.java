package com.example.carecat.filter;

import com.alibaba.fastjson.JSON;
import com.example.carecat.common.BaseContext;
import com.example.carecat.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
 /**
     * 登录检查过滤器
     * @author 何若为人
     */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    /**
     * 路径匹配器
     */
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("拦截到请求：{}",request.getRequestURI());
        String requestURI = request.getRequestURI();
        //放行的路径
        String[] urls = new String[]{
                "/backend/**",
                "/user/login",
                "/user/register",
                "/user/logout",
                "/front/**",
                "/common/**",
        };
        //若匹配或者已登录，放行
        boolean check = check(urls,requestURI);
        if(check){
            //放行
            log.info("请求无需处理");
            filterChain.doFilter(request,response);
            return;
        }
        if(request.getSession().getAttribute("user")!=null){
            //放行
            log.info("已经登录");
            BaseContext.setCurrentId((Long) request.getSession().getAttribute("user"));
            filterChain.doFilter(request,response);
            return;
        }
        log.info("未登录！");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    /**
     * 路径匹配，检查请求是否可以放行
     * @param requestURI 请求路径
     * @return 匹配与否
     */
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match) {
                return  true;
            }
        }
        return false;
    }
}

