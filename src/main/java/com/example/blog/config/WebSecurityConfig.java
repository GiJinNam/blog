package com.example.blog.config;

import com.example.blog.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

//@RequiredArgsConstructor
//@Configuration
// public class WebSecurityConfig {
//    private final UserDetailService userDetailService;
//
//    // 스프링 시큐리티 기능 비활성화
//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring()
//                .requestMatchers(toH2Console())
//                .requestMatchers("/static/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests() //인증 인가 설정
//                .requestMatchers("/login","/signup","/user").permitAll()// 특정요청과 일치하는 url에 대한 액세스 설정
//                // permitAll() : 누구나 접근이 가능하게 설정 /login, /signup, /user로 요청오면 인증/인가없이 접근가능
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") // 로그인 페이지 경로 설정
//                .defaultSuccessUrl("/articles") // 로그인 완료시 이동할 경로 설정
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login") //로그아웃 되었을 때 이동경로
//                .invalidateHttpSession(true) //로그아웃 이후에 세셩을 전체 삭제할지 여부
//                .and()
//                .csrf().disable()
//                .build();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(userDetailService) //사용자 정보를 가져올 서비스설정
//                .passwordEncoder(bCryptPasswordEncoder)// 비밀번호 암호화 인코더
//                .and()
//                .build();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder () {
//        return new BCryptPasswordEncoder();
//        }


//}
