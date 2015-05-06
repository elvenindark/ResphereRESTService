package com.resphere.service;

import java.io.IOException;
import java.util.List;


import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Ubicacion;

public class UbicacionFacadeREST extends AbstractFacade<Ubicacion> {

	public UbicacionFacadeREST(Class<Ubicacion> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public void post(Ubicacion e) throws ClientProtocolException, IOException, JSONException{
		super.post(e);
	}
	
	public Ubicacion get(String id) {
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
	
	public List<Ubicacion> getAll(){
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
	
	public String getAllJson(){
		try {
			return super.getAllJson();
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

