package rest;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * Main Class.
 * Entry point of API.
 */
public class Main {
  Gson gson = new Gson();
  public static final String BASE_URI = "http://localhost:8080/photogram/"; //photogram/

  /**
   * Starts the Server.
   * @return HTTP Server
   */
  public static HttpServer startServer() {
    // create a resource config that scans for JAX-RS resources and providers
    final ResourceConfig rc = new ResourceConfig().packages("rest");

    // create and start a new instance of grizzly http server
    // exposing the Jersey application at BASE_URI
    return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
  }

  /**
   * Main method.
   * @param args String arguments if needed.
   * @throws IOException Input/Output Exception for server ports.
   */
  public static void main(String[] args) throws IOException {
    final HttpServer server = startServer();
    System.out.println(String.format("Jersey app started with WADL available at "
          + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
    System.in.read();
    server.stop();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getPhoto() {
    return gson.toJson("Type a getter/poster");
  }
}
