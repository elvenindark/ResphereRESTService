package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Normaminima;
import com.resphere.service.NMinimaFacadeREST;

public class TestNMinima {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.normaminima";
		testGetAllByQuery("4", url);
	}
	
	public static void testGetAllByQuery(String id, String url){
		NMinimaFacadeREST service = new NMinimaFacadeREST(Normaminima.class, url);
		List<Normaminima> lista = service.getAllByIdSH(id);
		for(int i = 0; i < lista.size(); i++)
			System.out.println("- " + lista.get(i).getNormaminima());
	}

}
