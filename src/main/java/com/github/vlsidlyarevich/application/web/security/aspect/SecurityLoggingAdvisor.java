package com.github.vlsidlyarevich.application.web.security.aspect;

import com.github.vlsidlyarevich.application.audit.Auditor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Security services logging advisor.
 */
@Aspect
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityLoggingAdvisor {

    private final Auditor auditor;

    /**
     * Log service call.
     *
     * @param joinPoint the join point
     */
    @Before("com.github.vlsidlyarevich.application.web.security.aspect.SecurityLoggingPointcut.logService()")
    public void serviceLogBeforeAdvice(final JoinPoint joinPoint) {
        auditor.logService(joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }
}
