package com.hy.demo.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired ApiInterceptor apiInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        super.addInterceptors(registry);
        registry.addInterceptor(apiInterceptor);
//        registry.addInterceptor(new ApiInterceptor());
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/study/**")
                .excludePathPatterns("/study/login.html", "/study/login/**");
    }

   @Bean
    public ApiInterceptor intercpetor(){
        return new ApiInterceptor();
    }

    /**
     *Spring Boot 中 RestController 返回的字符串默认使用 Jackson 引擎，
     * 它也提供了工厂类，我们可以自定义 JSON 引擎，
     * 这里将 JSON 引擎替换为 fastJSON
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        /*
        1.需要先定义一个convert转换消息的对象；
        2.添加fastjson的配置信息，比如是否要格式化返回的json数据
        3.在convert中添加配置信息
        4.将convert添加到converters中
         */
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);//结果是否格式化,默认为false
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);

    }

}
