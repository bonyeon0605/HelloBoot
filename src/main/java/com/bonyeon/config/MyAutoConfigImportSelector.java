package com.bonyeon.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
          "com.bonyeon.config.autoconfig.DispatcherServletConfig",
          "com.bonyeon.config.autoconfig.TomcatWebServerConfig"

        };
    }
}
