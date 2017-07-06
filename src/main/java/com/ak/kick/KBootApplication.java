package com.ak.kick;

import com.ak.kick.web.filter.KFilter;
import com.ak.kick.web.listener.KHttpSessionListener;
import com.ak.kick.web.listener.KServletContextListener;
import com.ak.kick.web.servlet.Servlet1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpSessionListener;

/**
 * Created by ak on 6/5/17.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class KBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(KBootApplication.class, args);
    }


    /**
     * servlet 监听器注册
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new KServletContextListener());
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> kHttpSessionListener() {
        return new ServletListenerRegistrationBean<HttpSessionListener>(new KHttpSessionListener());
    }


    @Bean
    public HttpSessionListener httpSessionListener() {
        // MySessionListener should implement javax.servlet.http.HttpSessionListener
        return new KHttpSessionListener();
    }


    /**
     * 过滤器注册
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        return new FilterRegistrationBean(new KFilter());
    }

    /**
     * servlet 注册
     * @return
     */
    /*@Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new Servlet1());
    }*/


    /**
     * 过滤路径
     * @param dispatcherServlet
     * @return
     */
   /* @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        registration.addUrlMappings("*.json");
        return registration;
    }*/

}
