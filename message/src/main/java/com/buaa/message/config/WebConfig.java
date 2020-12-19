package com.buaa.message.config;

//import com.maidou.idol.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述:
 * 验证token是否有效
 *
 * @author xy
 * @create 2019-08-07 16:54
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        //添加拦截器
//        //放行某些特定不需要验证的请求
//        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/user/login","/user/register","/img/**");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + UPLOAD_FOLDER);
    }
}
