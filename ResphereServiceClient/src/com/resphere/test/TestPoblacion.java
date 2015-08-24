package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Poblacion;
import com.resphere.service.PoblacionFacadeREST;

public class TestPoblacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String id = "1436895095";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.poblacion";
		//testPoblacionAllJson(url);
		testPoblacionAllById(id, url);
	}

	public static void testPoblacionFacade(String id, String url) throws ClientProtocolException, IOException, JSONException{
		PoblacionFacadeREST servicio = new PoblacionFacadeREST(Poblacion.class, url);
		Poblacion e = new Poblacion();
		e = servicio.get(id);
		System.out.println(e.getIdevento());
	}
	
	public static void testPoblacionAllJson(String url){
		PoblacionFacadeREST servicio = new PoblacionFacadeREST(Poblacion.class, url);		
		System.out.println(servicio.getAllJson());
	}
	
	public static void testPoblacionAllById(String id, String url){
		PoblacionFacadeREST servicio = new PoblacionFacadeREST(Poblacion.class, url);
		List<Poblacion> lista = servicio.getAllById(id);
		for(int i = 0; i < lista.size(); i++){
			System.out.println(lista.get(i).getIdevento() + " " +lista.get(i).getNumero());
		}
	}
}
