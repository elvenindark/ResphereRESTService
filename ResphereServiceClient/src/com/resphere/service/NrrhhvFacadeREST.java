package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Nrrhhv;

public class NrrhhvFacadeREST extends AbstractFacade<Nrrhhv> {

	public NrrhhvFacadeREST(Class<Nrrhhv> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public List<Nrrhhv> getAll(){
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
	
	public List<Nrrhhv> getAllById(String id){
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
