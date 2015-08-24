package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Accion;
import com.resphere.service.AccionFacadeREST;

public class TestAccion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.accion";
		String id = "";
		testAccion(url);
	}
	
	public static void testAccion(String url){
		AccionFacadeREST servicio = new AccionFacadeREST(Accion.class, url);
		List<Accion> acciones = servicio.getAll();
		if(acciones!=null){
			for(Accion item:acciones)
				System.out.println(item.getFecha() + ":" + item.getIdevento());
		}
	}

}
