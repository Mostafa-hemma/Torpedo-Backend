package com.backend.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.demo.jwtconfig.JwtRequestFilter;
import com.backend.demo.jwtconfig.JwtUtil;
import com.backend.demo.service.BlackListedService;
import com.backend.demo.service.UserDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private BlackListedService blackListedService;

    @Autowired
    private UserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                
                .antMatchers(HttpMethod.GET, "/user/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.POST, "/user/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.PUT, "/user/**").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasRole("MANAGER")
                
                .antMatchers(HttpMethod.GET, "/customer/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.POST, "/customer/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/customer/**").hasAnyRole("MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.DELETE, "/customer/**").hasAnyRole("MANAGER","CUSTOMER")

                .antMatchers(HttpMethod.GET, "/customeraddress/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.POST, "/customeraddress/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/customeraddress/**").hasAnyRole("MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.DELETE, "/customeraddress/**").hasAnyRole("MANAGER","CUSTOMER")
                
                .antMatchers(HttpMethod.GET, "/item").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.GET, "/item/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.POST, "/item/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/item/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.DELETE, "/item/**").hasRole("CUSTOMER")
                
                .antMatchers(HttpMethod.GET, "/receiver").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.GET, "/receiver/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.POST, "/receiver/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/receiver/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.DELETE, "/receiver/**").hasRole("CUSTOMER")
                
                .antMatchers(HttpMethod.GET, "/shipment").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.GET, "/shipment/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER","AGENT")
                .antMatchers(HttpMethod.POST, "/shipment/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/shipment/**").hasAnyRole("CUSTOMER","AGENT")
                .antMatchers(HttpMethod.DELETE, "/shipment/**").hasRole("CUSTOMER")
                
                .antMatchers(HttpMethod.GET, "/pickup").hasAnyRole("ADMIN","MANAGER","CUSTOMER")
                .antMatchers(HttpMethod.GET, "/pickup/**").hasAnyRole("ADMIN","MANAGER","CUSTOMER","AGENT")
                .antMatchers(HttpMethod.POST, "/pickup/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.PUT, "/pickup/**").hasAnyRole("CUSTOMER","AGENT")
                .antMatchers(HttpMethod.DELETE, "/pickup/**").hasRole("CUSTOMER")
                
                .antMatchers(HttpMethod.GET, "/agent").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.GET, "/agent/**").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.POST, "/agent/**").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.PUT, "/agent/**").hasAnyRole("ADMIN","MANAGER")
                .antMatchers(HttpMethod.DELETE, "/agent/**").hasAnyRole("ADMIN","MANAGER")
                
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/signout").permitAll()
                .antMatchers("/c/reset-password").permitAll()
                .antMatchers("/a/reset-password").permitAll()
                .antMatchers("/u/reset-password").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.addFilterBefore(new JwtRequestFilter(jwtUtil, customUserDetailsService,blackListedService), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
