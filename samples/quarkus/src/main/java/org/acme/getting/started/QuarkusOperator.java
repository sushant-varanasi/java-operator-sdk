package org.acme.getting.started;

import com.github.containersolutions.operator.Operator;
import com.github.containersolutions.operator.sample.CustomServiceController;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class QuarkusOperator {

    private static final Logger LOGGER = Logger.getLogger("QuarkusOperator");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Quarkus Operator starting");
        KubernetesClient client = new DefaultKubernetesClient();
        Operator operator = new Operator(client);
        operator.registerController(new CustomServiceController(client));
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("Quarkus Operator stopping");
    }

}
