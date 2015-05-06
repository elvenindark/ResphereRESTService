package com.resphere.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import com.resphere.server.model.Vivienda;
import com.resphere.service.ViviendaFacadeREST;

public class TestVivienda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "1395847620";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.vivienda";
		testViviendaAllJson(url);
		try {
			testVivienda(id, url);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testVivienda(String id, String url) throws ClientProtocolException, IOException, JSONException{
		ViviendaFacadeREST servicio = new ViviendaFacadeREST(Vivienda.class, url);
		Vivienda e = new Vivienda();
		e = servicio.get(id);
		System.out.print(e.getIdevento()+";"+e.getTotalv());
	}
	
	public static void testViviendaAllJson(String url){
		ViviendaFacadeREST servicio = new ViviendaFacadeREST(Vivienda.class, url);
		
		System.out.println(servicio.getAllJson());
	}
}
