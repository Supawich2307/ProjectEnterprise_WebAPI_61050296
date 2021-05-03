/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;


import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.json.JSONObject;

/**
 * Jersey REST client generated for REST resource:onet6_62 [firstpage]<br>
 * USAGE:
 * <pre>
 *        restClient_Onet client = new restClient_Onet();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author supakew
 */
public class restClient_Onet {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/61050296_webService/webresources";

    public restClient_Onet() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("firstpage");
    }

    public String score_Onet6_62() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("fristpage/score");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public String school_Onet6_62() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("fristpage/school");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
