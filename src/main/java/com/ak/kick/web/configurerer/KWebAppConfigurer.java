package com.ak.kick.web.configurerer;

import com.ak.kick.web.interceptor.KInterceptor1;
import com.ak.kick.web.interceptor.KInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ak on 7/6/17.
 */
@Configuration
public class KWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new KInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new KInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


}
