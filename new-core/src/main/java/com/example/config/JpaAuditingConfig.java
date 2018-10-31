package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class JpaAuditingConfig {
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public class AuditorAwareImpl implements AuditorAware<String>{

        @Override
        public String getCurrentAuditor() {
            //Xử lý get username sử dụng spring security
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if(auth == null || !auth.isAuthenticated()){
                return null;
            }else {
                return auth.getName();
            }
        }
    }
}
