package com.spring.restaurant.config;

import com.spring.restaurant.model.Category;
import com.spring.restaurant.model.Order;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestApiConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] prventeMethod={HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.PATCH};
        disableHttpMethod(Order.class,config,prventeMethod);
        disableHttpMethod(Category.class,config,prventeMethod);

        /*config.getExposureConfiguration()
                .forDomainType(Order.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(prventeMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(prventeMethod));
        config.getExposureConfiguration()
                .forDomainType(Category.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(prventeMethod)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(prventeMethod)));*/
    }
    public void disableHttpMethod(Class classname,RepositoryRestConfiguration config,HttpMethod[] prventeMethod){
        config.getExposureConfiguration()
                .forDomainType(classname)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(prventeMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(prventeMethod));
    }
}
