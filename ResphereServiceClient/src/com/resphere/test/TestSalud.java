package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Salud;
import com.resphere.service.SaludFacadeREST;

public class TestSalud {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String id = "";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.salud";
		testSalud(url);
	}
	
	public static void testSalud(String url){
		SaludFacadeREST servicio = new SaludFacadeREST(Salud.class, url);
		List<Salud> saluds = servicio.getAll();
		if(saluds != null){
			for(Salud item: saluds)
				System.out.println(item.getIdevento() + ":" + item.getIdtiposalud());
		}
	}
}
