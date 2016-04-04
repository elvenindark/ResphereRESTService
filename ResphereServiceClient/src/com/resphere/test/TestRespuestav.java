package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Respuestav;
import com.resphere.service.RespuestavFacadeREST;

public class TestRespuestav {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://172.30.36.184:8080/respherers/webresources/com.resphere.server.model.respuestav";
		testGetRespuestavAll(url);
	}

	public static void testGetRespuestavAll(String url){
		RespuestavFacadeREST servicio = new RespuestavFacadeREST(Respuestav.class, url);
		if(servicio != null){
			try {
				List<Respuestav> lista = servicio.getAll();
				for(Respuestav item:lista)
					System.out.println(item.getIdevento()+";"+item.getFecha()+";"+item.getParroquia());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
