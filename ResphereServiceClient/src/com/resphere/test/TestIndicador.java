package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import com.resphere.server.model.Indicadorclave;

import com.resphere.service.IClaveFacadeREST;
import com.resphere.service.IndicadorFacadeREST;

public class TestIndicador {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException{
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.indicadorclave";
		String id = "4";
		/*testIndicadorAllJson(url);
		List<Indicadorclave> lista = testIndicadorGetAll(url);
		for(int i = 0; i < lista.size(); i++)
			System.out.println(lista.get(i).getIdindicadorclave() + " : " + lista.get(i).getIndicadorclave());*/
		//getAllByQuery(url, "2");
		get(id, url);
		
	}
	
	public static void get(String id, String url){
		IClaveFacadeREST service = new IClaveFacadeREST(Indicadorclave.class, url);
		Indicadorclave indicador = service.get(id);
		System.out.println("descripcion> \n" + indicador.getIndicadorclave());
	}
	
	public static void getAllByQuery(String url, String id){
		IClaveFacadeREST service = new IClaveFacadeREST(Indicadorclave.class, url);
		List<Indicadorclave> lista = service.getAllByIdNE(id);
		for(int i = 0; i < lista.size(); i++)
			System.out.println(lista.get(i).getIndicadorclave());
	}

	public static void testIndicadorAllJson(String url){
		IndicadorFacadeREST servicio = new IndicadorFacadeREST(Indicadorclave.class, url);
		System.out.println("response es>" + servicio.getAllJson());
	}
	
	public static List<Indicadorclave> testIndicadorGetAll(String url){
		IndicadorFacadeREST servicio = new IndicadorFacadeREST(Indicadorclave.class, url);
		return servicio.getAll();		
	}
}
