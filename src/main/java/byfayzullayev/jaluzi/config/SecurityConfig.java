package byfayzullayev.jaluzi.config;

import byfayzullayev.jaluzi.filtr.JwtTokenFilter;
import byfayzullayev.jaluzi.service.user.ApplicationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationUserDetailService applicationUserDetailService;
    private final JwtTokenFilter jwtTokenFilter;

    @Autowired
    public SecurityConfig(ApplicationUserDetailService applicationUserDetailService, JwtTokenFilter jwtTokenFilter) {
        this.applicationUserDetailService = applicationUserDetailService;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserDetailService).passwordEncoder(this.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(jwtTokenFilter, BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/api/yourjaluzi/user/*").permitAll()
                .antMatchers("/api/yourjaluzi/images/product/**").permitAll()
                .antMatchers("/api/yourjaluzi/clients/*").permitAll()
                .antMatchers("/api/yourjaluzi/category/*").permitAll()
                .antMatchers("/api/yourjaluzi/portfolio/list").permitAll()
                .antMatchers(HttpMethod.GET,"/api/yourjaluzi/category/shortProduct/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/yourjaluzi/category/shortProduct/product/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
