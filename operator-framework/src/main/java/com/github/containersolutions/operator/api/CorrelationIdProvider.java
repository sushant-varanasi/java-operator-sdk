package com.github.containersolutions.operator.api;

import java.util.Map;


public interface CorrelationIdProvider {

    Map<String, String> correlationIds();

}
