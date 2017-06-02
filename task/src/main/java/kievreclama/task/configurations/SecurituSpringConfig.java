package kievreclama.task.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurituSpringConfig extends WebSecurityConfigurerAdapter {
	
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
            	.usernameParameter("username").passwordParameter("password")
            	.permitAll()
            	.and()
            .logout()
            	.permitAll()
            	.and()
            .csrf()
            	.disable();
    }
	
	
}
