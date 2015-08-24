package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Tipoacceso;
import com.resphere.service.TipoaccesoFacadeREST;

public class TestTipoacceso {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String id = "1438659310";
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.tipoacceso";
		//testTipoacceso(url);
		//testTipoaccesoJson(url);
		testTipoaccesoById(url, id);
	}
	
	static void testTipoacceso(String url){
		TipoaccesoFacadeREST servicio = new TipoaccesoFacadeREST(Tipoacceso.class, url);
		List<Tipoacceso> tipos = servicio.getAll();
		if(tipos != null){
			for(Tipoacceso item: tipos)
				System.out.println(item.getIdevento() + ":" + item.getTipoacceso());
		}
	}

	static void testTipoaccesoById(String url, String id){
		TipoaccesoFacadeREST servicio = new TipoaccesoFacadeREST(Tipoacceso.class, url);
		List<Tipoacceso> tipos = servicio.getAllById(id);
		if(tipos != null){
			for(Tipoacceso item: tipos)
				System.out.println(item.getIdevento() + ":" + item.getTipoacceso());
		}
	}
	
	static void testTipoaccesoJson(String url){
		TipoaccesoFacadeREST servicio = new TipoaccesoFacadeREST(Tipoacceso.class, url);
		//List<Tipoacceso> tipos = servicio.getAllJson();
		/*if(tipos != null){
			for(Tipoacceso item: tipos)
				System.out.println(item.getIdevento() + ":" + item.getTipoacceso());
		}*/
		System.out.println(servicio.getAllJson());
	}
}
