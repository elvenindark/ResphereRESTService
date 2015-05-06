package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Indicadorclave;

public class IClaveFacadeREST extends AbstractFacade<Indicadorclave> {

	public IClaveFacadeREST(Class<Indicadorclave> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}

	public List<Indicadorclave> getAll(){
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
	
	public List<Indicadorclave> getAllByIdNE(String id){
		try {
			return super.getQueryById("nesencial", id);
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
