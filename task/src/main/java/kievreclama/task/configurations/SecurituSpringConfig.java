package kievreclama.task.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import kievreclama.task.controllers.TaskAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurituSpringConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private TaskAuthenticationProvider authProvider;
	
	@Override
    protected void configure(
      AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/").permitAll()
            	.antMatchers("/task").permitAll()
            	.antMatchers("/resources/**").permitAll()
            	.anyRequest().authenticated()
                .and()
            .formLogin()
            	.loginPage("/login")
            	.usernameParameter("username")
            	.passwordParameter("password")
            	.permitAll()
            	.and()
            .logout()
            	.permitAll()
            	.and()
            .csrf()
            	.disable();
    }
	
	@Bean
    public ShaPasswordEncoder getShaPasswordEncoder(){
        return new ShaPasswordEncoder();
    }
}
