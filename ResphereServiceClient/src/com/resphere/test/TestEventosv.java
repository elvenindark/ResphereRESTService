package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Eventosv;
import com.resphere.service.EventosvFacadeREST;

public class TestEventosv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.eventosv";
		testEventosvAll(url);
	}

	public static void testEventosvAll(String url){
		EventosvFacadeREST service = new EventosvFacadeREST(Eventosv.class, url);
		List<Eventosv> list = service.getAll();
		if(list!=null)
			for(int i = 0; i <list.size(); i++)
				System.out.println(list.get(i).getIdevento() + " " + list.get(i).getEvento());
		else
			System.out.println("servicio stop");
	}
}
