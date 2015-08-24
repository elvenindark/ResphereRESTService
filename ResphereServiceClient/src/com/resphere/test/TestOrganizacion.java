package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Organizacion;
import com.resphere.service.OrganizacionFacadeREST;

public class TestOrganizacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.organizacion";
		String id = "";
		testOrganizacion(url);
	}
	
	public static void testOrganizacion(String url){
		OrganizacionFacadeREST servicio = new OrganizacionFacadeREST(Organizacion.class, url);
		List<Organizacion> organizaciones = servicio.getAll();
		if(organizaciones != null){
			for(Organizacion item : organizaciones)
				System.out.println(item.getContacto() + ":" + item.getIdorganizacion());
		}
	}

}
