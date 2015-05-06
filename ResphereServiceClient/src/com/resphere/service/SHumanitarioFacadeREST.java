package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Sectorhumanitario;

public class SHumanitarioFacadeREST extends AbstractFacade<Sectorhumanitario> {

	public SHumanitarioFacadeREST(Class<Sectorhumanitario> entityClass,
			String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public List<Sectorhumanitario> getAllById(String id){
		try {
			return super.getAllById(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Sectorhumanitario get(String id){
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
}
