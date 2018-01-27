package com.github.vlsidlyarevich.application.web.security.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Security logging pointcut holder.
 */
@Aspect
public class SecurityLoggingPointcut {

    /**
     * Pointcut for security services.
     */
    @Pointcut("execution(public * com.github.vlsidlyarevich.application.web.security.service..*(..))")
    public void logService() {

    }
}
