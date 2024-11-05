package todolist.user.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean<EncryptFilter> loggingFilter()
    {
        FilterRegistrationBean<EncryptFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new EncryptFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
