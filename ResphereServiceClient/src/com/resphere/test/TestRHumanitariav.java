package com.resphere.test;

import java.io.IOException;
import java.util.List;

import com.resphere.server.model.Respuestahumanitaria;
import com.resphere.server.model.Respuestahumanitariav;
import com.resphere.service.RespuestahumanitariavFacadeREST;

public class TestRHumanitariav {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "35";
		String idsector = "01";
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.respuestahumanitariav";
			
		//TestRHumanitariaGet(url, id);
		TestRHumanitariaGetByIds(url, id, idsector);
		//TestRHumanitariaGetAll(url);
	}
	
	public static void TestRHumanitariaGet(String url, String id){
		RespuestahumanitariavFacadeREST servicio = new RespuestahumanitariavFacadeREST(Respuestahumanitariav.class, url);
		Respuestahumanitariav respuesta = servicio.get(id);
		if(respuesta!=null)
			System.out.println(respuesta.getAplica()+";"+respuesta.getIdevento()+";"+respuesta.getIdindicadorclave()+";"+respuesta.getObservacion());
	}
	
	public static void TestRHumanitariaGetByIds(String url, String id, String idsector){
		RespuestahumanitariavFacadeREST servicio = new RespuestahumanitariavFacadeREST(Respuestahumanitariav.class, url);
		List<Respuestahumanitariav> respuestas = servicio.getAllByIds(id, idsector);
		if(respuestas!=null){
			for(Respuestahumanitariav respuesta: respuestas)
				System.out.println(respuesta.getAplica()+";"+respuesta.getIdevento()+";"+respuesta.getIdindicadorclave()+";"+respuesta.getIdsectorhumanitario());
		}

	}
	
}
