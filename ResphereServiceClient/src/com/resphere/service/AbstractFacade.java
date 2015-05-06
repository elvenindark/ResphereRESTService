package com.resphere.service;

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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.resphere.server.model.Poblacion;
import com.resphere.util.Reflection;

import java.lang.reflect.Array;
import java.nio.charset.UnsupportedCharsetException;

@SuppressWarnings("deprecation")
public abstract class AbstractFacade<T> {

	private Class<T> entityClass;
	private T[] array;
	private static String URL_Base;
	private Reflection r;
	
	private ArrayList<String> atributos;
	private ArrayList<String> valores;
	
    public AbstractFacade(Class<T> entityClass, String url) {
        this.entityClass = entityClass;
        this.URL_Base = url;
    }
    
    //Post object
  	public void post(T e) throws ClientProtocolException, IOException, JSONException{
  		HttpClient client = new DefaultHttpClient();
  		HttpResponse response = client.execute(setPost(e));
  		client.getConnectionManager().shutdown();
  	}
  	
  	public void postList(List<T> list) throws UnsupportedCharsetException, ClientProtocolException, IOException, JSONException{
  		HttpClient client = HttpClientBuilder.create().build();//new DefaultHttpClient();
  		HttpResponse response = client.execute(setPostList(list));
  		client.getConnectionManager().shutdown();
  	}
    
  	//Get object
  	public T get(String id) throws ClientProtocolException, IOException, JSONException{		
  		HttpGet httpRequest = setGet(id);
  		//CloseableHttpResponse response = getResponse(httpRequest);	
  		HttpResponse response = getResponse(httpRequest);
  		String output = getJsonString(response);
  		T e = getEntityFromJson(output);
  		//response.close();	
  		return e;  		
  	}

  	//Get todos los objetos
  	public List<T> getAll() throws ClientProtocolException, IOException{
		HttpGet httpRequest = setGet();
		//CloseableHttpResponse response = getResponse(httpRequest);
		HttpResponse response = getResponse(httpRequest);
		String output = getJsonString(response);
		List<T> entities = getEntitiesFromJson(output);
		//System.out.println(output);
		return entities;
	}
  	
  	//Get todos los objetos por id
  	public List<T> getAllById(String id) throws ClientProtocolException, IOException {
		String url;
		url = URL_Base + "/" + "findAll" + "/" + id;
		HttpGet httpRequest = setGetUrl(url);
		//CloseableHttpResponse response = getResponse(httpRequest);	
		HttpResponse response = getResponse(httpRequest);
		String output = getJsonString(response);
		List<T> entities = getEntitiesFromJson(output);
		//System.out.println(output);
		return entities;
	}
  	
  	//Get todos los objetos por dos parametros y consulta
  	public List<T> getAllByIds(String id1, String id2) throws ClientProtocolException, IOException{
  		String url;
  		url = URL_Base + "/" + "query" + "/" + id1 + "/" + id2;
  		HttpGet httpRequest = setGetUrl(url);
  		HttpResponse response = getResponse(httpRequest);
  		String output = getJsonString(response);
  		List<T> entities = getEntitiesFromJson(output);
  		return entities;
  	}
  	
  	//Get todos los objetos por consulta personalizada e id
  	public List<T> getQueryById(String query, String id) throws ClientProtocolException, IOException {
		String url;
		url = URL_Base + "/" + query + "/" + id;
		HttpGet httpRequest = setGetUrl(url);
		//CloseableHttpResponse response = getResponse(httpRequest);	
		HttpResponse response = getResponse(httpRequest);	
		String output = getJsonString(response);
		List<T> entities = getEntitiesFromJson(output);
		//System.out.println(output);
		return entities;
	}
  	  	
  	//Get all Json objects tipo string
  	public String getAllJson() throws ClientProtocolException, IOException{
  		HttpGet httpRequest = setGet();
		//CloseableHttpResponse response = getResponse(httpRequest);	
		HttpResponse response = getResponse(httpRequest);
		String output = getJsonString(response);
		return output;
  	}
  	
  	//METODOS UTILITARIOS -- getAll()
  	public HttpGet setGet() throws ClientProtocolException, IOException{
		//CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpRequest = new HttpGet(URL_Base);
		httpRequest.addHeader("accept", "application/json");	
		return httpRequest;
	}
  	
  	//METODOS UTILITARIOS -- get(id)
  	public HttpGet setGet(String id) throws ClientProtocolException, IOException{
		HttpGet httpRequest = new HttpGet(URL_Base+"/"+id);
		httpRequest.addHeader("accept", "application/json");	
		return httpRequest;
	}
  	
  	public HttpGet setGetUrl(String url){
  		HttpGet httpRequest = new HttpGet(url);
		httpRequest.addHeader("accept", "application/json");	
		return httpRequest;
  	}
  	
  	public List<T> getEntitiesFromJson(String output){
		Gson gson = new Gson();
		array=(T[])Array.newInstance(entityClass, 0);
		T[] arrayEntities = (T[]) gson.fromJson(output, array.getClass());
		List<T> list = Arrays.asList(arrayEntities);
		return list;
	}  	
  	
  	//public CloseableHttpResponse getResponse(HttpGet httpRequest) throws ClientProtocolException, IOException{
  	public HttpResponse getResponse(HttpGet httpRequest) throws ClientProtocolException, IOException{
		//CloseableHttpClient client = HttpClients.createDefault();
  		//HttpClient client = HttpClientBuilder.create().build();
  		HttpClient client = new DefaultHttpClient();
		//CloseableHttpResponse response = client.execute(httpRequest);
		HttpResponse response = client.execute(httpRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
		//return (CloseableHttpResponse) response;
		return response;
	}
  	
  	public String getJsonString(HttpResponse response) throws IOException{
  	//public String getJsonString(CloseableHttpResponse response) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;		
		StringBuilder buffer = new StringBuilder();
		while ((output = br.readLine()) != null) {
			buffer.append(output);
		}
		output = buffer.toString(); 
		return output;
	}
  	
  	public T getEntityFromJson(String output){
		Gson g = new Gson();
		return g.fromJson(output, entityClass);
	}

  	//METODOS UTILITARIOS post(T entity)
    public HttpPost setPost(T e) throws UnsupportedEncodingException, JSONException{
		HttpPost httpPost = new HttpPost(URL_Base);
		StringEntity entity = new StringEntity(serialize(e).toString(), HTTP.UTF_8);
		entity.setContentType("application/json");
		httpPost.setEntity(entity);		
		return httpPost;
	}	
    
    public HttpPost setPostList(List<T> list) throws UnsupportedCharsetException, JSONException{
    	HttpPost httpPost = new HttpPost(URL_Base+"/list");
    	StringEntity entity = new StringEntity(serializeList(list).toString(), HTTP.UTF_8);
    	entity.setContentType("application/json");
    	httpPost.setEntity(entity);
    	return null;
    }
    
    public JSONObject serialize(T e) throws JSONException{
		setEntityToString(e);
		JSONObject json = new JSONObject();
		for(int i = 0; i < atributos.size(); i++){
			json.put(atributos.get(i), valores.get(i));			
		}
		System.out.print(json);
		return json;
	}
    
    public JSONArray serializeList(List<T> list) throws JSONException{
    	JSONArray jarray = new JSONArray();
    	for(int i = 0; i < list.size(); i++){
    		jarray.put(serialize(list.get(i)));
    	}
    	return jarray;
    }
    
	public void setEntityToString(T e){
		r = new Reflection(e.getClass());
		atributos = new ArrayList<String>();
		valores = new ArrayList<String>();
		atributos = r.returnFields1();
		//atributos = r.returnGetters();
		valores = r.returnDatos(e);
	}
}
