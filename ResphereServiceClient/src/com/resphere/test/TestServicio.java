package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Servicio;
import com.resphere.service.ServicioFacadeREST;

public class TestServicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "";
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.servicio";
		testServicio(url);
		//testServicioById(url, id);
	}
	
	public static void testServicio(String url){
		ServicioFacadeREST servicio = new ServicioFacadeREST(Servicio.class, url);
		List<Servicio> servicios = servicio.getAll();
		if(servicios!=null){
			for(Servicio item: servicios)
				System.out.println(item.getObservacion());
		}else
			System.out.print("No se encontraron datos");
	}
	
	public static void testServicioById(String url, String id){
		ServicioFacadeREST servicio = new ServicioFacadeREST(Servicio.class, url);
		List<Servicio> servicios = servicio.getAllById(id);
		if(servicios!=null){
			for(Servicio item: servicios)
				System.out.println(item.getObservacion());
		}else
			System.out.print("No se encontraron datos");
	}

}
