/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import static java.lang.System.console;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXB;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author supakew
 */
@Path("firstpage")
public class onet6_62 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of onet6_62
     */
    public onet6_62() {
    }

    @GET
    @Path("fristpage/school")
    @Produces("application/json")
    public String school_Onet6_62() throws IOException{
            JSONObject jsonArray = null;
            FileWriter file = new FileWriter("/home/supakew/NetBeansProjects/61050296_webService/web/model/school.json");
            try {
                URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=ff332bfe-9674-44b4-80c3-3a3499eea0c4");
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");

                //adding header
                httpURLConnection.setRequestProperty("api-key","wWwrT4XFtd6CbKTLiqYelkbjESmW2DdX");

                String line="";
                InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                StringBuilder response = new StringBuilder();
                try{
                    while ((line=bufferedReader.readLine())!=null){
                        file.write(line);
                        response.append(line);
                    }
                }catch(IOException e){
                    
                }
                file.close();
                bufferedReader.close();
                jsonArray = new JSONObject(response.toString());
                return jsonArray.toString(4);
                
            }catch (Exception e){
                return ""+e;
            }
    }
    @GET
    @Path("fristpage/score")
    @Produces("application/json")
    public String score_Onet6_62()throws IOException {
            JSONObject jsonArray = null;
            FileWriter file = new FileWriter("/home/supakew/NetBeansProjects/61050296_webService/web/modelscore.json");
            try {
                URL url = new URL("https://opend.data.go.th/get-ckan/datastore_search?resource_id=3a49a5c1-fc3a-4b0a-9a51-3a59f842974b");
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");

                //adding header
                httpURLConnection.setRequestProperty("api-key","wWwrT4XFtd6CbKTLiqYelkbjESmW2DdX");

                String line="";
                InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                StringBuilder response=new StringBuilder();
                try{
                    while ((line=bufferedReader.readLine())!=null){
                        file.write(line);
                        response.append(line);
                    }
                }catch (IOException e) {
                    return ""+e;
                }
                file.close();
                bufferedReader.close();
                jsonArray = new JSONObject(response.toString());
                return jsonArray.toString(4);
                
            }catch (Exception e){
                return ""+e;
            }
    }
    @PUT
    @Consumes("application/xml")
    public void putXml(org.json.JSONObject content) {
    }
}
