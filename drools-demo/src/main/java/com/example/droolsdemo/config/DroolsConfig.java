package com.example.droolsdemo.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
public class DroolsConfig {

    private KieServices kieServices = KieServices.Factory.get();

    private KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        //kieFileSystem.write(ResourceFactory.newClassPathResource("offers.drl"));
        for(Resource resource : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newUrlResource(resource.getURL()));
        }

        return kieFileSystem;
    }

    private Resource[] getRuleFiles() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String drlFilePath = "/rules";
        return resolver.getResources("classpath*:" + drlFilePath + "**/*.*");
    }

    @Bean
    public KieContainer kieContainer() throws IOException {
        System.out.println("Container created...");
        kieRepository();
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();

        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }

    private void kieRepository() {
        KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(new KieModule() {
            @Override
            public ReleaseId getReleaseId() {
                return kieRepository.getDefaultReleaseId();
            }
        });
    }

    @Bean
    public KieSession kieSession() throws IOException {
        System.out.println("session created...");
        return kieContainer().newKieSession();
    }
}
