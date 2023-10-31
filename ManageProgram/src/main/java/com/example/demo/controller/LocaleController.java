//package com.example.demo.controller;
//
//import java.util.Locale;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//@RestController
//@RequestMapping("/locale")
////@RequestMapping(value = "/changeLocale")
//public class LocaleController {
//
//    @GetMapping("/change")
//    public ResponseEntity<String> changeLocale(HttpServletRequest request, HttpServletResponse response,
//                                               @RequestParam String lang) {
//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//        if (localeResolver == null) {
//            throw new IllegalStateException("No LocaleResolver found!");
//        }
//        Locale newLocale = StringUtils.parseLocaleString(lang);
//        localeResolver.setLocale(request, response, newLocale);
//
//        return ResponseEntity.ok("Locale changed to: " + newLocale);
//    }
//    
//    
//    // 랭귀지에 en을 넣어도 될 것 같다,세션에 화면에서 넘어온 랭귀지라는 파라미터를 로케일로 해보기
////    public void changeLocale(String language, HttpSession session) {
////        
////        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(language));
////    }
//}
