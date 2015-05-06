package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;



import com.resphere.model.Respuestahumanitaria;
import com.resphere.service.RespuestahumanitariaFacadeREST;

public class TestRHumanitaria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "1395407422";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.respuestahumanitaria";
		Respuestahumanitaria respuesta = new Respuestahumanitaria();		
		respuesta.setIdevento(id);
		respuesta.setIdindicadorclave("2");		
		respuesta.setAplica("on");
		respuesta.setObservacion("no hay observaciones");		
		//TestRHumanitariaPost(respuesta, url);
		//TestRHumanitariaGet(url, id);
		TestRHumanitariaGetAll(url);
	}

	public static void TestRHumanitariaPost(Respuestahumanitaria respuesta, String url){
		RespuestahumanitariaFacadeREST servicio = new RespuestahumanitariaFacadeREST(Respuestahumanitaria.class, url);
		try {
			servicio.post(respuesta);
			System.out.println("correcto");
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
	}
	
	public static void TestRHumanitariaGet(String url, String id){
		RespuestahumanitariaFacadeREST servicio = new RespuestahumanitariaFacadeREST(Respuestahumanitaria.class, url);
		try {
			List<Respuestahumanitaria> respuestas = servicio.getAllById(id);
			if(respuestas!=null)
				for(Respuestahumanitaria respuesta:respuestas)
					System.out.println(respuesta.getAplica()+";"+respuesta.getIdevento()+";"+respuesta.getIdindicadorclave()+";"+respuesta.getObservacion());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void TestRHumanitariaGetAll(String url){
		RespuestahumanitariaFacadeREST servicio = new RespuestahumanitariaFacadeREST(Respuestahumanitaria.class, url);
		
		try {
			List<Respuestahumanitaria> respuestas = servicio.getAll();
			if(respuestas!=null)
				for(Respuestahumanitaria respuesta:respuestas)
					System.out.println(respuesta.getAplica()+";"+respuesta.getIdevento()+";"+respuesta.getIdindicadorclave()+";"+respuesta.getObservacion());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
