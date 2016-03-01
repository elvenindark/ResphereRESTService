package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Poblacionv;

public class PoblacionvFacadeREST extends AbstractFacade<Poblacionv> {

	public PoblacionvFacadeREST(Class<Poblacionv> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public List<Poblacionv> getAllById(String id){
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
