package com.backend.demo.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.authenticatemodel.AuthenticationRequest;
import com.backend.demo.authenticatemodel.AuthenticationResponse;
import com.backend.demo.entity.Customer;
import com.backend.demo.entity.DeliveryAgent;
import com.backend.demo.entity.Users;
import com.backend.demo.jwtconfig.JwtUtil;
import com.backend.demo.service.BlackListedService;
import com.backend.demo.service.CustomerService;
import com.backend.demo.service.DeliveryAgentService;
import com.backend.demo.service.UserDetailsService;
import com.backend.demo.service.UserService;



@RestController
public class AuthenticationController {
	
	@Autowired
	private DeliveryAgentService agentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlackListedService blackListedService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtUtil jwtUtil;

//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getPhoneNumber(), authenticationRequest.getPassword()));
//        } catch (BadCredentialsException e) {
//
//            return new ResponseEntity(new AuthenticationResponse("Incorrect username or password"),HttpStatus.NOT_FOUND);
//        }
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getPhoneNumber());
//        System.out.println(userDetails.getAuthorities());
//        final String jwt = jwtUtil.generateToken(userDetails);
//        
//        if(userDetails.getAuthorities()
//        		.contains("ROLE_CUSTOMER")) {
//            Customer myCustomer=customerService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
//
//        	myCustomer.setPassword("****");
//            return ResponseEntity.ok(new AuthenticationResponse("success",jwt,myCustomer));
//        }else if(userDetails.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_CUSTOMER"))) {
//            DeliveryAgent agent=agentService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
//        	agent.setPassword("****");
//            return ResponseEntity.ok(new AuthenticationResponse("success",jwt,agent));
//        }else if(userDetails.getAuthorities().stream().collect(Collectors.toList())
//        		.contains("ROLE_ADMIN") 
//        		||
//        		userDetails.getAuthorities().stream().collect(Collectors.toList())
//        		.contains("ROLE_MANAGER")
//        		){
//            Users user=userService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
//        	user.setPassword("****");
//            return ResponseEntity.ok(new AuthenticationResponse("success",jwt,user));
//        }else {
//            return new ResponseEntity(new AuthenticationResponse("Incorrect username or password"),HttpStatus.NOT_FOUND);
//
//        }
//}
    
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getPhoneNumber(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AuthenticationResponse("Incorrect username or password"), HttpStatus.NOT_FOUND);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getPhoneNumber());
        System.out.println(userDetails.getAuthorities());
        final String jwt = jwtUtil.generateToken(userDetails);

        if (userDetails.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_CUSTOMER"))) {
            Customer myCustomer = customerService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
            myCustomer.setPassword("****");
            return ResponseEntity.ok(new AuthenticationResponse("success", jwt, myCustomer));
        } else if (userDetails.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_AGENT"))) {
            DeliveryAgent agent = agentService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
            agent.setPassword("****");
            return ResponseEntity.ok(new AuthenticationResponse("success", jwt, agent));
        } else if (userDetails.getAuthorities().stream().anyMatch(authority ->
                authority.getAuthority().equals("ROLE_ADMIN") || authority.getAuthority().equals("ROLE_MANAGER"))) {
            Users user = userService.findByPhoneNumber(Integer.parseInt(userDetails.getUsername()));
            user.setPassword("****");
            return ResponseEntity.ok(new AuthenticationResponse("success", jwt, user));
        } else {
            return new ResponseEntity<>(new AuthenticationResponse("Incorrect username or password"), HttpStatus.NOT_FOUND);
        }
    }

       
        
        
    
    @PostMapping("/signout")
    public ResponseEntity<?> signOut(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            Date expirationDate = jwtUtil.extractExpiration(token);
            blackListedService.blacklistToken(token, LocalDateTime.ofInstant(expirationDate.toInstant(), ZoneId.systemDefault()));
        }
        return new ResponseEntity(new AuthenticationResponse("Sign Out Successfully"),HttpStatus.OK);
    }
    

}
