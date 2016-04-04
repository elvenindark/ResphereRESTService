package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Respuestahumanitariav;

public class RespuestahumanitariavFacadeREST extends
		AbstractFacade<Respuestahumanitariav> {

	public RespuestahumanitariavFacadeREST(
			Class<Respuestahumanitariav> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public Respuestahumanitariav get(String id){
		try {
			return super.get(id);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Respuestahumanitariav> getAll(){
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
	
	public List<Respuestahumanitariav> getAllById(String id){
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
	
	public List<Respuestahumanitariav> getAllByIds(String idevento, String idsector){
		try {
			return super.getAllByIds(idevento, idsector);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
