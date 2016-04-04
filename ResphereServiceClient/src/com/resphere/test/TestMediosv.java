package com.resphere.test;

import java.io.IOException;

import com.resphere.server.model.Mediovidav;
import com.resphere.service.MediovidavFacadeREST;

public class TestMediosv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.mediovidav";
		String id = "1447771362";
		
		//testAll(url);
		testALLById(url, id);
	}

	private static void testALLById(String url, String id) {
		// TODO Auto-generated method stub
		MediovidavFacadeREST servicio = new MediovidavFacadeREST(Mediovidav.class, url);
		if(servicio!=null){
			for(Mediovidav item: servicio.getAllById(id)){
				System.out.println("mediov: " + item.getTipomediovida());
			}
		}
		
	}

	private static void testAll(String url) {
		// TODO Auto-generated method stub
		
	}

}
