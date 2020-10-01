package com.github.containersolutions.operator.sample;

import com.github.containersolutions.operator.api.Context;
import com.github.containersolutions.operator.api.Controller;
import com.github.containersolutions.operator.api.ResourceController;
import com.github.containersolutions.operator.api.UpdateControl;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import static java.lang.String.format;

@Controller(
        crdName = "tomcat-operator",
        customResourceClass = CR)
public class Controller implements ResourceController<CR> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final KubernetesClient kubernetesClient;

    public Controller(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public UpdateControl<Schema> createOrUpdateResource(CR schema, Context<Schema> context) {
        return UpdateControl.noUpdate();
    }

    @Override
    public boolean deleteResource(Schema schema, Context<Schema> context) {
        return true;
    }
}
