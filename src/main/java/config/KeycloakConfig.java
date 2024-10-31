package config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.admin.client.Keycloak;

@ApplicationScoped
@Setter
@Getter
@Slf4j
public class KeycloakConfig {

  AdminCredential admin;

  @ConfigProperty(name = "keycloak.auth-server-url")
  String authServerUrl;

  @Produces
  @ApplicationScoped
  public Keycloak keycloakAdminClient() {

    return Keycloak.getInstance(authServerUrl, "master", admin.username, admin.password,
        "admin-cli");
  }

  @Getter
  @Setter
  @ApplicationScoped
  public static class AdminCredential {

    @ConfigProperty(name = "keycloak.admin.username")
    String username;

    @ConfigProperty(name = "keycloak.admin.password")
    String password;
  }
}
