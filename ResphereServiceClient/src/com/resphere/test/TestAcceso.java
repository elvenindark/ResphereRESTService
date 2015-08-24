package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Acceso;
import com.resphere.service.AccesoFacadeREST;

public class TestAcceso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String id = "1392190489";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.acceso";
		testAcceso(url);
		//testAccesoById(id);
	}
	static void testAcceso(String url){
		AccesoFacadeREST servicio = new AccesoFacadeREST(Acceso.class, url);
		List<Acceso> accesos = servicio.getAll();
		if(accesos!=null){
			for(Acceso item : accesos)
				System.out.println(item.getIdevento() + ":" + item.getTransporte());
		}
	}
	
	static void testAccesoById(String id){
		
	}
}
