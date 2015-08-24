package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Servicio;

public class ServicioFacadeREST extends AbstractFacade<Servicio> {

	public ServicioFacadeREST(Class<Servicio> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public void post(Servicio e) throws ClientProtocolException, IOException, JSONException{
		super.post(e);
	}

	public Servicio get(String id){
		try {
			return super.get(id);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Servicio> getAll(){
		try {
			return super.getAll();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Servicio> getAllById(String id){
		try {
			return super.getAllById(id);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
