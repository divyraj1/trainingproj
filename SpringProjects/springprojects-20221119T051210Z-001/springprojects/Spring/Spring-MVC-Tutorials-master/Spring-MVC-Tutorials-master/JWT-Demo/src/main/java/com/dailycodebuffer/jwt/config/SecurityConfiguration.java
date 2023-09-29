package com.dailycodebuffer.jwt.config;

import com.dailycodebuffer.jwt.filter.JwtFilter;
import com.dailycodebuffer.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtFilter jwtFilter;
//for jwt token we will be adding two dependency first one will be io.jsonwebtoken and the other will be javax.xml.bind
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService);
        //we will be implementing a customuserDetailService service sprig boot will be providing us userDetailService
        //and we need to use ourUserDetail service so what we will be doing here is we will be getting users from the database
        //and for that user we will be creating a custom user user object	and this we will do using the userService
        //class that we will be creating in this project he has not implemented the database layer he has is just creating  a 
        //dummy user so we made the class and passed the object of that user
        
    }
      //now we will be creating jwt behaviour  class that will be responsible for all the jwt behaviour 
      //to create a token to validate a token and all the other methods
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception
    {    //this method will be responsible to give us Authentication manager Object which 
    	//will be required by us during authentication in the home Controller
        return super.authenticationManagerBean();
    }
//here we will be bypassing the methods and will allow that it should first generate the authentication token
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")//here we are giving the api information and it will be permited to all the user
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  //here we will be tailing the spring security  not to use session management as we are creating statless behaviour 
   //and now we will be creating filter over that which filter we have to use
    }
}
//in jwt token we have to send the jwt token in each request but we will be using a filter here which will be cheking 
//that the token is valid so we have made a pakage filter and inside this package we will be creating a class
