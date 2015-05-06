package com.resphere.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.resphere.server.model.Evento;
import com.resphere.util.Reflection;


public class EventoRESTClient {

	private static String URL_Base;
	private Evento e;
	private Reflection r;
	
	private ArrayList<String> atributos;
	private ArrayList<String> valores;
		
	public EventoRESTClient(String url){
		EventoRESTClient.URL_Base = url;
	}
	
	//Post evento
	public void post(Evento e) throws ClientProtocolException, IOException, JSONException{
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(setPost(e));
		client.getConnectionManager().shutdown();
	}
	
	//Get evento
	public Evento get(String id) throws ClientProtocolException, IOException, JSONException{		
		HttpGet httpRequest = setGet(id);
		CloseableHttpResponse response = getResponse(httpRequest);	
		String output = getJsonString(response);
		Evento e = getEventoFromJson(output);
		response.close();	
		return e;
		//Funciona y trae la cadena json
		/*JSONObject json = new JSONObject(output);
		System.out.println("\n"+json);*/
	}
	
	//Get all eventos
	public List<Evento> getAll() throws ClientProtocolException, IOException{
		HttpGet httpRequest = setGet();
		CloseableHttpResponse response = getResponse(httpRequest);	
		String output = getJsonString(response);
		List<Evento> eventos = getEventosFromJson(output);
		System.out.println(output);
		return eventos;
	}
	
	public void setEventoToString(Evento e){
		r = new Reflection(e.getClass());
		atributos = new ArrayList<String>();
		valores = new ArrayList<String>();
		atributos = r.returnGetters();
		valores = r.returnDatos(e);
	}
		
	public JSONObject serialize(Evento e) throws JSONException{
		setEventoToString(e);
		JSONObject json = new JSONObject();
		for(int i = 0; i < atributos.size(); i++){
			json.put(atributos.get(i), valores.get(i));
		}
		return json;
	}
		
	public HttpPost setPost(Evento e) throws UnsupportedEncodingException, JSONException{
		HttpPost httpPost = new HttpPost(URL_Base);
		StringEntity entity = new StringEntity(serialize(e).toString(), HTTP.UTF_8);
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		return httpPost;
	}			
	
	public HttpGet setGet(String id) throws ClientProtocolException, IOException{
		HttpGet httpRequest = new HttpGet(URL_Base+"/"+id);
		httpRequest.addHeader("accept", "application/json");	
		return httpRequest;
	}
	
	public HttpGet setGet() throws ClientProtocolException, IOException{
		HttpGet httpRequest = new HttpGet(URL_Base);
		httpRequest.addHeader("accept", "application/json");	
		return httpRequest;
	}
	
	public CloseableHttpResponse getResponse(HttpGet httpRequest) throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(httpRequest);
		//HttpResponse response = client.execute(httpRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
		return response;
	}
	
	public String getJsonString(CloseableHttpResponse response) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;		
		StringBuilder buffer = new StringBuilder();
		while ((output = br.readLine()) != null) {
			buffer.append(output);
		}
		output = buffer.toString(); 
		return output;
	}
	
	public Evento getEventoFromJson(String output){
		Evento e = new Evento();
		Gson g = new Gson();
		e = g.fromJson(output, Evento.class);
		return e;
	}
	
	public List<Evento> getEventosFromJson(String output){
		Gson gson = new Gson();
		Evento[] arrayEvento = gson.fromJson(output, Evento[].class);
		List<Evento> list = Arrays.asList(arrayEvento);
		return list;
	}
		
}

/*public EventoRESTClient(String url, Evento e){
this.URL_Base = url;
this.e = e;
r = new Reflection(e.getClass());
}*/

/*public void setEventoToString(){
atributos = new ArrayList<String>();
valores = new ArrayList<String>();
atributos = r.returnGetters();
valores = r.returnDatos(e);
}*/


/*public JSONObject serialize() throws JSONException{
setEventoToString();
JSONObject json = new JSONObject();
for(int i = 0; i < atributos.size(); i++){
	json.put(atributos.get(i), valores.get(i));
}
return json;
}*/

/*public HttpPost setPost() throws UnsupportedEncodingException, JSONException{
HttpPost httpPost = new HttpPost(URL_Base);
StringEntity entity = new StringEntity(serialize().toString(), HTTP.UTF_8);
entity.setContentType("application/json");
httpPost.setEntity(entity);
return httpPost;
}*/


/*public void post() throws ClientProtocolException, UnsupportedEncodingException, IOException, JSONException{
HttpClient client = new DefaultHttpClient();
HttpResponse response = client.execute(setPost());						
client.getConnectionManager().shutdown();
}*/

