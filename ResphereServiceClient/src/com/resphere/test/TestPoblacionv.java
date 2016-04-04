package com.resphere.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Poblacionv;
import com.resphere.service.PoblacionvFacadeREST;

public class TestPoblacionv {

	public static void main(String[] args) {
		
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.poblacionv";
		String id = "1447771362";
		
		try {
			testAll(url);
			testALLById(url, id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testAll(String url) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		PoblacionvFacadeREST servicio = new PoblacionvFacadeREST(Poblacionv.class, url);
		if(servicio!=null){
			for(Poblacionv item: servicio.getAll()){
				System.out.println("Poblacion es " + item.getTipoafectacion());
			}
		}
	}
	
	private static void testALLById(String url, String id) throws ClientProtocolException, IOException{
		// TODO Auto-generated method stub
				PoblacionvFacadeREST servicio = new PoblacionvFacadeREST(Poblacionv.class, url);
				if(servicio!=null){
					for(Poblacionv item: servicio.getAllById(id)){
						System.out.println("Poblacion es " + item.getTipoafectacion());
					}
				}
		
	}
	
}
