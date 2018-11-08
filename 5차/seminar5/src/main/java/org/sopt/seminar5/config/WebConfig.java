package org.sopt.seminar5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ds on 2018-11-07.
 */

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] EXCLUDE_ERROR_PATH = {
            "/no-session",
            "/no-token",
            "/token-error",
            "/unValued-token",
            "/token-session-error"
    };

    private static final String[] EXCLUDE_PATH = {
            "/emc/login",
            "/emc/clear",
            "/vote/access",
            "/vote/boardcast",
            "/vote/test"
    };

    @Autowired
    private Interceptor interceptor;

    public WebConfig(final Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);
    }

}