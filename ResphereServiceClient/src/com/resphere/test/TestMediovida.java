package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Mediovida;
import com.resphere.service.MediovidaFacadeREST;

public class TestMediovida {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String id = "1437410208";
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.mediovida";
		testMediovidaByIdFacade(id,url);
		//testMediovidaFacade(url);
	}

	public static void testMediovidaFacade(String url){
		MediovidaFacadeREST servicio = new MediovidaFacadeREST(Mediovida.class, url);
		List<Mediovida> lista = servicio.getAll();
		for(Mediovida item:lista)
			System.out.println(item.getHombres());
		
	}
	
	public static void testMediovidaByIdFacade(String id, String url){
		MediovidaFacadeREST servicio = new MediovidaFacadeREST(Mediovida.class, url);
		List<Mediovida> lista = servicio.getAllById(id);
		for(Mediovida item:lista)
			System.out.println(item.getHombres());
		
	}
}
