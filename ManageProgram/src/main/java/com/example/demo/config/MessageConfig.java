package com.example.demo.config;

import java.io.IOException;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	    sessionLocaleResolver.setDefaultLocale(Locale.KOREAN); // 기본 로케일 설정
	    
	    return sessionLocaleResolver;
	}

	
//	@Bean
//	public LocaleResolver localeResolver() {
//	    CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//	    cookieLocaleResolver.setDefaultLocale(Locale.KOREAN); // 기본 로케일 설정
//	    cookieLocaleResolver.setCookieName("localeInfo"); // 쿠키 이름 설정
//	    cookieLocaleResolver.setCookieMaxAge(3600); // 쿠키 유지 시간 설정 (여기서는 1시간)
//	    return cookieLocaleResolver;
//	}
	
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
	    localeInterceptor.setParamName("lang"); 
	    return localeInterceptor;
	}
	
	

	
	 @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setDefaultLocale(Locale.KOREAN);
	        messageSource.setBasename("classpath:messages/messages");
	        messageSource.setDefaultEncoding("UTF-8");
	        // 로케일에 해당하는 연결파일 없는경우 시스템 로케일 불러오기
	        messageSource.setFallbackToSystemLocale(true);
	        return messageSource;
	    }
	 
//	 @Bean
//	 public MessageSourceAccessor messageSourceAccessor() throws IOException{
//		 return new MessageSourceAccessor(messageSource());
//	 }

}
