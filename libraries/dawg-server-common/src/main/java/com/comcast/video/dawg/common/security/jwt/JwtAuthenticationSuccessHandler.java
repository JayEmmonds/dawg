package com.comcast.video.dawg.common.security.jwt;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class JwtAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements LogoutSuccessHandler {
    
    protected DawgJwtEncoder jwtEncoder;
    
    public JwtAuthenticationSuccessHandler(DawgJwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    /**
     * On successful authentication, save a jwt into the cookies
     * 
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
                    throws ServletException, IOException {
        
        Set<String> roles = new HashSet<String>();
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            roles.add(auth.getAuthority());
        }
        String pass = authentication.getCredentials() == null ? null : authentication.getCredentials().toString();
        String jwt = jwtEncoder.createUserJWT(new DawgCreds(authentication.getName(), pass, roles));
        Cookie cookie = new Cookie(JwtAuthenticationFilter.COOKIE_NAME, jwt);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * When logging out, expire the cookie
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Cookie cookie = new Cookie(JwtAuthenticationFilter.COOKIE_NAME, null);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
