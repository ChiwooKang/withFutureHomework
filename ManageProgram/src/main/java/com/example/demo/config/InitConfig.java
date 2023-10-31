package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InitConfig {
   
   private final PasswordEncoder passwordEncoder;
   private final UserRepository userRepository;
   
   private static final Logger logger = LoggerFactory.getLogger(InitConfig.class);
   
   @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
           try {
              
       
            // 어드민 사용자 생성
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123")); 
            admin.setRole("ROLE_ADMIN");
            logger.info(" 관리자 저장시도");
            userRepository.save(admin);
            logger.info(" 관리자 저장완료");

            // 일반 사용자 생성
            User user = new User();
            user.setUsername("user1");
            user.setPassword(passwordEncoder.encode("123")); 
            user.setRole("ROLE_USER");
            logger.info(" 사용자 저장시도");
            userRepository.save(user);
            logger.info(" 사용자 저장완료");
            
            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("123")); 
            user2.setRole("ROLE_MANAGER");
            logger.info(" 사용자 저장시도");
            userRepository.save(user2);
            logger.info(" 사용자 저장완료");
            
            }catch(Exception e){
               logger.error("에러 발생", e);
            }
        };

   }
}