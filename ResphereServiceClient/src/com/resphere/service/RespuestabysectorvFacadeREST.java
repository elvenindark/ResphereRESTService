package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Respuestabysectorv;

public class RespuestabysectorvFacadeREST extends AbstractFacade<Respuestabysectorv> {

	public RespuestabysectorvFacadeREST(Class<Respuestabysectorv> entityClass,
			String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}

	public List<Respuestabysectorv> getAllByIds(String idevento, String idsector) throws ClientProtocolException, IOException{
		return super.getAllByIds(idevento, idsector);
	}
}
