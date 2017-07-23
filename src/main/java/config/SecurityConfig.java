package config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

/**
 * Created by 12917 on 2017/7/15.
 */
@Configuration
@EnableWebMvcSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("John")
//                .password("password")
//                .authorities("USER")
//                .and()
//                    .withUser("Margaret")
//                    .password("green")
//                    .authorities("USER","ADMIN");
        auth.jdbcAuthentication()
                .dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT Username,Password,Enable FROM User WHERE Username=?")
                .authoritiesByUsernameQuery("SELECT Username,Permission FROM UserPermission WHERE Username=?")
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/jsp/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .authorizeRequests()
                .antMatchers("/public/**","/register","/jsp/**","/","/getcode","/reg").permitAll()
                .antMatchers("/secure/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
           .and().formLogin()
                .loginPage("/login").failureUrl("/login?failed=true")
                .defaultSuccessUrl("/secure/index.jsp")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
           .and().logout()
                .logoutUrl("/logout").logoutSuccessUrl("/login")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .permitAll()
           .and().sessionManagement()
                .sessionFixation().changeSessionId()
                .maximumSessions(1).maxSessionsPreventsLogin(true).and()
           .and().csrf().disable();

    }


}
