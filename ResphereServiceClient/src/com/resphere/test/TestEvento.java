package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;


import com.resphere.server.model.Evento;
import com.resphere.service.EventoFacadeREST;


public class TestEvento {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
		// TODO Auto-generated method stub

		String id = "1392190489";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.evento";
		//testEventoADO();
		//testEventoRESTClient(id, url);
		//testEventoRESTClientAll(url);
		//testEventoFacade(id, url);
		//testEventoFacadeAll(url);
		testEventoAllJson(url);
		
	}

	public static void testEventoFacade(String id, String url) throws ClientProtocolException, IOException, JSONException{
		EventoFacadeREST servicio = new EventoFacadeREST(Evento.class, url);
		Evento e = new Evento();
		e = servicio.get(id);
		System.out.println(e.getIdevento()+" "+e.getAmenazas()+" "+e.getDescripcion()+" "+
				e.getEfectos()+" "+e.getFecha()+" "+e.getHora());
	}
	
	public static void testEventoAllJson(String url){
		EventoFacadeREST servicio = new EventoFacadeREST(Evento.class, url);
		
		System.out.println(servicio.getAllJson());
	}
	
	public static void testEventoFacadeAll(String url) throws ClientProtocolException, IOException{
		EventoFacadeREST servicio = new EventoFacadeREST(Evento.class, url);
		List<Evento> eventos = servicio.getAll();
		for(Evento e: eventos)
			System.out.println(e.getIdevento()+" "+e.getAmenazas()+" "+e.getDescripcion()+" "+
					e.getEfectos()+" "+e.getFecha()+" "+e.getHora());
	}
		
}
