package com.qiumingjie.springboot.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author QiuMingJie
 * @date 2020-01-03 10:13
 * @Description 设置拦截器
 * <p>
 * Filter过滤器：拦截web访问url地址。
 * Interceptor拦截器：拦截以 .action结尾的url，拦截Action的访问。
 * Spring AOP拦截器：只能拦截Spring管理Bean的访问（业务层Service）
 * Filter与Interceptor联系与区别
 * 1. 拦截器是基于java的反射机制，使用代理模式，而过滤器是基于函数回调。
 * 2. 拦截器不依赖servlet容器，过滤器依赖于servlet容器。
 * 3. 拦截器只能对action起作用，而过滤器可以对几乎所有的请求起作用（可以保护资源）。
 * 4. 拦截器可以访问action上下文，堆栈里面的对象，而过滤器不可以。
 * 5. 执行顺序：过滤前-拦截前-Action处理-拦截后-过滤后。
 */

@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        System.out.println("initFilterBean");
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            System.out.println("destroy");
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :" + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            System.out.println("init");
            // TODO Auto-generated method stub
        }
    }


}
