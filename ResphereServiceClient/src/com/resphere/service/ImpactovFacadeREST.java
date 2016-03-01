package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Impactov;

public class ImpactovFacadeREST extends AbstractFacade<Impactov> {

	public ImpactovFacadeREST(Class<Impactov> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}

	public List<Impactov> getAllById(String id){
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
