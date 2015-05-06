package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;


import com.resphere.server.model.Ubicacion;
import com.resphere.service.UbicacionFacadeREST;


public class TestUbicacion {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
		// TODO Auto-generated method stub

		String id = "1407799997";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.ubicacion";
		//testUbicacionADO();
		//testUbicacionRESTClient(id, url);
		//testUbicacionRESTClientAll(url);
		//testUbicacionFacade(id, url);
		//testUbicacionFacadeAll(url);
		testUbicacionAllJson(url);
		
	}

	public static void testUbicacionFacade(String id, String url) throws ClientProtocolException, IOException, JSONException{
		UbicacionFacadeREST servicio = new UbicacionFacadeREST(Ubicacion.class, url);
		Ubicacion e = new Ubicacion();
		e = servicio.get(id);
		System.out.println(e.getIdubicacion()+" "+e.getProvincia()+" "+e.getCanton()+" "+
				e.getParroquia()+" "+e.getLatitud()+" "+e.getLongitud());
	}
	
	public static void testUbicacionAllJson(String url){
		UbicacionFacadeREST servicio = new UbicacionFacadeREST(Ubicacion.class, url);
		
		System.out.println(servicio.getAllJson());
	}
	
	public static void testUbicacionFacadeAll(String url) throws ClientProtocolException, IOException{
		UbicacionFacadeREST servicio = new UbicacionFacadeREST(Ubicacion.class, url);
		List<Ubicacion> Ubicacions = servicio.getAll();
		for(Ubicacion e: Ubicacions)
			System.out.println(e.getIdubicacion()+" "+e.getProvincia()+" "+e.getCanton()+" "+
					e.getParroquia()+" "+e.getLatitud()+" "+e.getLongitud());
	}
		
}

