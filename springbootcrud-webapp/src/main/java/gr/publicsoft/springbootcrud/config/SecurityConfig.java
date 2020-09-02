package gr.publicsoft.springbootcrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;
/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String CONSUMER = "CONSUMER";



    @Autowired
    protected void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root")
                .password(passwordEncoder().encode("1234"))
                .roles(CONSUMER);
    }
    /**
     * The type Permit all configurer adapter.
     * Configures the http Security
     */
    @Configuration
    public static class PermitAllConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").hasRole(CONSUMER)
                    .and().httpBasic()
                    .and().headers().httpStrictTransportSecurity()
                    .includeSubDomains(true)
                    .maxAgeInSeconds(Duration.ofDays(365).getSeconds());
        }
    }
    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
