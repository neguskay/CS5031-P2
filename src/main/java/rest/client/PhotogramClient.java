package rest.client;


import rest.resources.UsersResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PhotogramClient {
  public static void main(String[] args){
    Client client = ClientBuilder.newClient();

    Response response= client.target("http://localhost:8080/photogram/users").request(MediaType.APPLICATION_JSON).get();
    //UsersResource resource = response.readEntity(UsersResource.class);
    System.out.println(response);

  }
    /*System.out.println("This is client");
    try {
      Client client = Client.create();

      WebResource webResource = client
        .resource("http://localhost:8080/photogram/get");

      ClientResponse response = webResource.accept("application/json")
        .get(ClientResponse.class);

      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : "
          + response.getStatus());
      }

      String output = response.getEntity(String.class);

      System.out.println("Output from Server .... \n");
      System.out.println(output);
    }catch (Exception e) {

      e.printStackTrace();

    }

  }*/
}
