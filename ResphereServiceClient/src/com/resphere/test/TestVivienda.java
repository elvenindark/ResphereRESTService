package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Vivienda;
import com.resphere.service.ViviendaFacadeREST;

public class TestVivienda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "1459377975";
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.vivienda";
		//testViviendaAllJson(url);
		testVivienda(id, url);
		//testViviendaId(id, url);
		
	}

	public static void testVivienda(String id, String url) {
		ViviendaFacadeREST servicio = new ViviendaFacadeREST(Vivienda.class, url);
		Vivienda e = new Vivienda();
		e = servicio.get(id);
		System.out.print(e.getIdevento()+";"+e.getTotalv());
	}
	
	public static void testViviendaId(String id, String url){
		ViviendaFacadeREST servicio = new ViviendaFacadeREST(Vivienda.class, url);
		
		try {
			List<Vivienda> viviendas = servicio.getAllById(id);
			for(Vivienda i: viviendas)
				System.out.println(i.getIdevento());
			viviendas = servicio.getAllById(id);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testViviendaAllJson(String url){
		ViviendaFacadeREST servicio = new ViviendaFacadeREST(Vivienda.class, url);
		
		System.out.println(servicio.getAllJson());
	}
}
