package com.github.containersolutions.operator.sample;

import com.github.containersolutions.operator.api.LogEnricher;
import io.fabric8.kubernetes.client.CustomResource;

import java.util.HashMap;
import java.util.Map;

public class CustomService extends CustomResource implements LogEnricher {

    private ServiceSpec spec;

    public ServiceSpec getSpec() {
        return spec;
    }

    public void setSpec(ServiceSpec spec) {
        this.spec = spec;
    }

    @Override
    public Map<String, String> logEntries() {
        Map<String, String> myCorrelationIds = new HashMap<>();
        String traceId = getMetadata().getAnnotations().get("traceId");
        if (traceId != null) {
            myCorrelationIds.put("traceId", traceId);
        }
        return myCorrelationIds;
    }
}
