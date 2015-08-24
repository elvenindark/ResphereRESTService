package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Impacto;
import com.resphere.service.ImpactoFacadeREST;

public class TestImpacto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.impacto";
		testImpacto(url);
	}
	
	public static void testImpacto(String url){
		ImpactoFacadeREST servicio = new ImpactoFacadeREST(Impacto.class, url);
		List<Impacto> impactos = servicio.getAll();
		if(impactos != null){
			for(Impacto item : impactos)
				System.out.println(item.getIdevento() + ":" + item.getIdtipoimpacto());
		}
	}

}
