package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Respuestav;

public class RespuestavFacadeREST extends AbstractFacade<Respuestav> {

	public RespuestavFacadeREST(Class<Respuestav> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public List<Respuestav> getAll() throws ClientProtocolException, IOException{
		return super.getAll();
	}

}
