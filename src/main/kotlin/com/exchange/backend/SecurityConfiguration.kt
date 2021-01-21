package com.exchange.backend

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var env: Environment

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        var PUBLIC_URLS = arrayOf(
            env.getProperty("springdoc.swagger-ui.path"),
            "/swagger-ui/*",
            "/v3/api-docs/swagger-config",
            "/v3/api-docs",
        )

        println("# Public Urls: ${PUBLIC_URLS.contentToString()}")

        http.cors().and().csrf().disable().authorizeRequests()
            .antMatchers(*PUBLIC_URLS).permitAll()
            .antMatchers(HttpMethod.POST, "/user/register").permitAll()
            .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
