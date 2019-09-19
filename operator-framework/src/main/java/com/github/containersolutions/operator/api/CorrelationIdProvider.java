package com.github.containersolutions.operator.api;

import java.util.Map;

/**
 * todo document this, discuss naming with Marek
 */
public interface CorrelationIdProvider {

    Map<String, String> correlationIds();

}
