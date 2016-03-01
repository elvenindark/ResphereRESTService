package com.resphere.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Monitoreorespuesta;

public class MonitoreoFacadeREST extends AbstractFacade<Monitoreorespuesta> {

	public MonitoreoFacadeREST(Class<Monitoreorespuesta> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}

	public void post(Monitoreorespuesta e) throws ClientProtocolException, IOException, JSONException{
		super.post(e);
	}
	
	public List<Monitoreorespuesta> getAll(){
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
	
	public List<Monitoreorespuesta> getAllById(String id){
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
	
	public List<Monitoreorespuesta> getAllByIds(String id, int idsector){
		try {
			return super.getAllByIds(id, String.valueOf(idsector));
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
