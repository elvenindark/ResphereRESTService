package com.resphere.service;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Tipoevento;

public class TipoEventoFacadeREST extends AbstractFacade<Tipoevento> {

	public TipoEventoFacadeREST(Class<Tipoevento> entityClass, String url) {
		super(entityClass, url);
		// TODO Auto-generated constructor stub
	}

	public void post(Tipoevento e) throws ClientProtocolException, IOException, JSONException{
		super.post(e);
	}
	
	public void postList(List<Tipoevento> list) throws UnsupportedCharsetException, ClientProtocolException, IOException, JSONException{
		super.postList(list);
	}
	
	public Tipoevento get(String id) {
		try {
			return super.get(id);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Tipoevento> getAll(){
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
	
	public String getAllJson(){
		try {
			return super.getAllJson();
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
