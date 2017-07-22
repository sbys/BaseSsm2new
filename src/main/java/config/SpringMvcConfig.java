package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

/**
 * Created by 12917 on 2017/7/11.
 */
@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
        //resourceViewResolver.setPrefix("/jsp");
        resourceViewResolver.setSuffix(".jsp");
        //可以在jsp页面中通过${}访问beans
        resourceViewResolver.setExposeContextBeansAsAttributes(true);
        return resourceViewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //设置静态文件处理
        configurer.enable();
    }
    @Bean(name="multipartResolver")

    public CommonsMultipartResolver getResolver() throws IOException {

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        resolver.setMaxUploadSizePerFile(5242880);//5MB



        return resolver;

    }
}
