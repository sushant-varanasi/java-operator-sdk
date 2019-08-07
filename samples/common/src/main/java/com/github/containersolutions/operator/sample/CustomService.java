package com.github.containersolutions.operator.sample;

import com.github.containersolutions.operator.api.CorrelationIdProvider;
import io.fabric8.kubernetes.client.CustomResource;

import java.util.HashMap;
import java.util.Map;

public class CustomService extends CustomResource implements CorrelationIdProvider {

    private ServiceSpec spec;

    public ServiceSpec getSpec() {
        return spec;
    }

    public void setSpec(ServiceSpec spec) {
        this.spec = spec;
    }

    @Override
    public Map<String, String> correlationIds() {
        Map<String, String> myCorrelationIds = new HashMap<>();
        String traceId = getMetadata().getAnnotations().get("traceId");
        if (traceId != null) {
            myCorrelationIds.put("traceId", traceId);
        }
        return myCorrelationIds;
    }
}
