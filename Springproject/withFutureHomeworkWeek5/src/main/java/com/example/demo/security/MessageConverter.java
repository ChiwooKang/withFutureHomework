package com.example.demo.security;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class MessageConverter implements WebMvcConfigurer { // 메세지 컨버터 삽입할때
	
//	@Bean
    public HttpMessageConverter<?> htmlEscapingConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes()); // 
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        MappingJackson2HttpMessageConverter htmlEscapingConverter =
                new MappingJackson2HttpMessageConverter();
        htmlEscapingConverter.setObjectMapper(objectMapper);

        return htmlEscapingConverter;
    }
	
	
	/*
	 * spring mvc 구조 자체를 바꿀때
	 * 
	 * @Bean 
	 * public MappingJackson2HttpMessageConverter jsonEscapeConverter() { //
	 * MappingJackson2HttpMessageConverter Default ObjectMapper 설정 및 ObjectMapper
	 * Config 설정 ObjectMapper objectMapper =
	 * Jackson2ObjectMapperBuilder.json().build();
	 * objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
	 * return new MappingJackson2HttpMessageConverter(objectMapper); }
	 */


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(htmlEscapingConverter());
//    	Iterator keys = converters.iterator();
//    	while(keys.hasNext()) {
//    		System.out.println(" add before keys.next() : " + keys.next());
//    	}
    	
    	for(int i = 0; i < converters.size(); i ++) {
    		System.out.println(" remove before converters.get(i) : " + converters.get(i).getSupportedMediaTypes() + " : " + converters.get(i));
    	}
    	
//    	for(int i = 0; i < converters.size(); i ++) {
//    		if(converters.get(i).getSupportedMediaTypes().contains("application/json") 
//    				&& converters.get(i).getSupportedMediaTypes().contains("application/json, application/*+json")
//    				) {
//    			converters.remove(i);
//    			System.out.println("1111111111111111111111111111");
//    		}
//    	}
    	
    	Iterator<HttpMessageConverter<?>> keys = converters.iterator();

    	while(keys.hasNext()) {
//    		if (converters..getSupportedMediaTypes().contains(MediaType.APPLICATION_JSON)) {
//    			
//    		}
    		HttpMessageConverter converter = keys.next();
    		if(converter.getSupportedMediaTypes().contains("application/json") ) {
    			System.out.println(converter);
    			keys.remove();
    		}
    	}
    	
    	
    	for(int i = 0; i < converters.size(); i ++) {
    		System.out.println(" remove after converters.get(i) : " + converters.get(i).getSupportedMediaTypes() + " : " + converters.get(i));
    	}
    	
    	
    }

}