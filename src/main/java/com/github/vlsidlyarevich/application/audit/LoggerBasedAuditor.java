package com.github.vlsidlyarevich.application.audit;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Logger based {@link Auditor} implementation.
 */
@Slf4j
@Service
public class LoggerBasedAuditor implements Auditor {

    @Override
    public void logService(final String serviceName, final String methodName,
                           final Object[] args) {
        validateServiceName(serviceName);
        validateMethodName(methodName);

        log.info("Message : Called service: {} for method: {} with arguments: {}",
                serviceName, methodName, args);
    }

    private void validateMethodName(final String methodName) {
        if (StringUtils.isBlank(methodName)) {
            throw new IllegalArgumentException("Method is mandatory");
        }
    }

    private void validateServiceName(final String serviceName) {
        if (StringUtils.isBlank(serviceName)) {
            throw new IllegalArgumentException("Service name is mandatory");
        }
    }
}
