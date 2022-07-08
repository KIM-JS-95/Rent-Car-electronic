package com.rentcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfiguration {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
<<<<<<< HEAD
        //해당 경로에 map.xml 파일을 넣음
        configurer.setDefinitions(new String[]{"classpath:/tiles/map.xml"});
=======
        //해당 경로에 tiles.xml 파일을 넣음
        configurer.setDefinitions(new String[]{"classpath:/tiles/member.xml"});
>>>>>>> c683c843e4ce19783d84ab38dc314002ec6a14f6
        configurer.setCheckRefresh(true);
        return configurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }
}