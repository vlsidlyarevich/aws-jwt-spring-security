package com.github.vlsidlyarevich.application.audit;

/**
 * Service for audit.
 */
public interface Auditor {

    /**
     * Log service call.
     *
     * @param serviceName the service name
     * @param method      the method
     * @param args        the args
     */
    void logService(String serviceName, String method, Object[] args);
}
