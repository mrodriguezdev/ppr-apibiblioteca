package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("volumes")
@RegisterRestClient(configKey = "google-api")
public interface GoogleBooksClient {
}
