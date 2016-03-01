package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Respuestahumanitaria;

public class RespuestahumanitariaFacadeREST extends
		AbstractFacade<Respuestahumanitaria> {

	public RespuestahumanitariaFacadeREST(
			Class<Respuestahumanitaria> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public void post(Respuestahumanitaria respuesta) throws ClientProtocolException, IOException, JSONException{		
			super.post(respuesta);		
	}
	
	public List<Respuestahumanitaria> getAll() throws ClientProtocolException, IOException{
		return super.getAll();
	}
	
	public List<Respuestahumanitaria> getAllById(String id) throws ClientProtocolException, IOException{
		return super.getAllById(id);
	}

}
