//package com.jq.learning.conf;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//
//
////        消息转换对象
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
////        配置
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
////        格式化输出
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
////        添加消息转化配置
//        converters.add(fastJsonHttpMessageConverter);
//    }
//}