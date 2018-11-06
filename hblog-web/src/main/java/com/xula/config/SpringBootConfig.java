package com.xula.config;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;
import com.xula.base.engine.ModuleDirective;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {
  @Bean(name = "jfinalViewResolver")
  public JFinalViewResolver getJFinalViewResolver() {
    JFinalViewResolver jfr = new JFinalViewResolver();
    jfr.setDevMode(true);

    jfr.setSourceFactory(new ClassPathSourceFactory());

    JFinalViewResolver.engine.setBaseTemplatePath("/templates/html/");

    jfr.addSharedFunction("common/column.html");
    jfr.addSharedFunction("layout/footer.html");
    jfr.addSharedFunction("layout/header.html");
    jfr.addSharedFunction("common/link.html");
    jfr.addSharedFunction("common/filter.html");
    jfr.addSharedFunction("common/user-nav.html");
    jfr.addSharedFunction("layout/intro.html");


    jfr.addDirective("module", ModuleDirective.class);
    
    jfr.setSuffix(".html");
    jfr.setContentType("text/html;charset=UTF-8");
    jfr.setOrder(0);
    return jfr;
  }
}