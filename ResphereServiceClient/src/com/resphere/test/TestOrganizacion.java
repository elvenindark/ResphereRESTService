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

		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.organizacion";
		String id = "1459526724";
		//String id = "";
		testOrganizacion(url);
		testOrganizacionById(url, id);
	}
	
	public static void testOrganizacion(String url){
		OrganizacionFacadeREST servicio = new OrganizacionFacadeREST(Organizacion.class, url);
		List<Organizacion> organizaciones = servicio.getAll();
		if(organizaciones != null){
			for(Organizacion item : organizaciones)
				System.out.println(item.getContacto() + ":" + item.getIdorganizacion());
		}
	}
	
	public static void testOrganizacionById(String url, String id){
		OrganizacionFacadeREST servicio = new OrganizacionFacadeREST(Organizacion.class, url);
		List<Organizacion> organizaciones = servicio.getAllById(id);
		if(organizaciones != null){
			for(Organizacion item : organizaciones)
				System.out.println(item.getContacto() + ":" + item.getIdorganizacion());
		}
	}

}
