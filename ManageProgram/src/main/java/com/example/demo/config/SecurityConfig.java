package com.example.demo.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//   
//    private final UserService userService;
//
//    public SecurityConfig(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      
//        http.authorizeRequests()
//            .antMatchers("/books/login").permitAll()
//            .antMatchers(HttpMethod.POST, "/books/**").hasAnyRole("ADMIN")
//            .antMatchers(HttpMethod.PUT, "/books/**").hasAnyRole("ADMIN")
//            .antMatchers(HttpMethod.DELETE, "/books/**").hasAnyRole("ADMIN")
//            .antMatchers(HttpMethod.GET, "/books/allBooks", "/books/searchNumber").hasAnyRole("ADMIN", "USER")
//            .antMatchers("/static/**").permitAll()
//            // ... 다른 구성
//
//            .and()
//            .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//
//            .logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/books/logout"))
//            .logoutSuccessHandler((request, response, authentication) -> {  
//                response.getWriter().write("{\"message\": \"Logout successful\"}");
//            })
//            .invalidateHttpSession(true)
//            .clearAuthentication(true)
//            .deleteCookies("JSESSIONID")
//            .permitAll()
//
//            .and()
//            .exceptionHandling()
//            .authenticationEntryPoint((request, response, authException) -> {  
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//            })
//
//            .and()
//            .csrf().disable();
//        
//        return http.build();
//    }
// 
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//   
//    @Bean
//    public AuthenticationFilter authenticationFilter() throws Exception {
//        AuthenticationFilter filter = new AuthenticationFilter();
//        filter.setAuthenticationManager(authenticationManagerBean());
//        filter.setAuthenticationSuccessHandler((request, response, authentication) -> { 
//            response.getWriter().write("{\"message\": \"Login successful\"}");
//        });
//        filter.setAuthenticationFailureHandler((request, response, exception) -> { 
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("{\"message\": \"Login failed\"}");
//        });
//        return filter;
//    }
//}


// 동기식 검사코드
@Configuration
@EnableWebSecurity
public class SecurityConfig {
   
    private final UserService userService;

       public SecurityConfig(UserService userService) {
           this.userService = userService;
       }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 
        http.authorizeRequests()
        .antMatchers("/books/login").permitAll()
        .antMatchers(HttpMethod.POST, "/books/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/books/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/books/**").hasAnyRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/books/allBooks", "/books/searchNumber").hasAnyRole("ADMIN", "USER")
        .antMatchers("/static/**").permitAll()
        .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
       // .anyRequest().authenticated() // 모든 요청에 대해 인증된 사용자만 접근 가능하도록 설정

        .and()
           .formLogin() 
           .loginPage("/books/login")  
            .defaultSuccessUrl("/books/allBooks") 
            .failureUrl("/books/login?error=true")
            .and()
            .logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/books/logout"))
	            .logoutSuccessUrl("/books/login?logout=true")
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .deleteCookies("JSESSIONID")
           .and() 
           .httpBasic()
              .and()
           .csrf().disable();
        
       return http.build();
   }
 
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
}
