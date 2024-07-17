package SEP_Backend.SEP.configurations;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class AppConfiguration {
   
	    @Autowired
	    private JwtAuthenticationFilter filter;

	    @Bean
	    public FilterRegistrationBean<JwtAuthenticationFilter> authenticateFilter(){
	    	FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<JwtAuthenticationFilter>();
	    	registrationBean.setFilter(filter);
	    	registrationBean.addUrlPatterns("/secure/*");
	    	return registrationBean;
	    }
	    
	    
	   /* @Bean
		public CorsWebFilter corsWebFilter() {
			final CorsSystemConfiguration corsConfig = new CorsSystemConfiguration();
			corsConfig.setAllowedOrigins(Collections.singletonList("*"));
			corsConfig.setMaxAge(3600L);
			corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));
			corsConfig.addAllowedHeader("*");

			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", corsConfig);

			return new CorsWebFilter(source);
		}*/
	    
	    
	    
	    
}
