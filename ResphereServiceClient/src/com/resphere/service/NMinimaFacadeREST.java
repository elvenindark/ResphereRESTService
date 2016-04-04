package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Normaminima;

public class NMinimaFacadeREST extends AbstractFacade<Normaminima> {

	public NMinimaFacadeREST(Class<Normaminima> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}
	
	public Normaminima get(String id){
		try {
			return super.get(id);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Normaminima> getAll(){
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
	
	public List<Normaminima> getAllByIdSH(String id){
		try {
			return super.getQueryById("shumanitario", id);
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
