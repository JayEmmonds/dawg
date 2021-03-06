package com.comcast.video.dawg.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.comcast.video.dawg.common.security.DawgSpringLdapConfigurer;
import com.comcast.video.dawg.common.security.jwt.DawgJwtEncoder;
import com.comcast.video.dawg.common.security.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DawgShowConfiguration config;
    
    @Autowired
    private ShowAuthenticationSuccessHandler successHandler;
    
    @Autowired
    private DawgJwtEncoder jwtEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(jwtEncoder, super.authenticationManager());
        http
            .addFilterBefore(jwtAuthFilter, BasicAuthenticationFilter.class)
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/health/**").permitAll()
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            .antMatchers("/plugins/**").hasAnyRole("ADMIN")
            .antMatchers("/view/plugins/**").hasAnyRole("ADMIN")
            .antMatchers("/login**").permitAll()
            .antMatchers("/**").hasAnyRole("ADMIN", "SHOW")
            .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login?error")
                    .successHandler(successHandler)
                    .permitAll()
            .and()
                .logout().logoutSuccessHandler(successHandler).permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/login?unauthorized=")
            .and()
                .headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        DawgSpringLdapConfigurer.configureGlobal(auth, config.getLdapAuthConfig(), new BCryptPasswordEncoder());
    }
}