package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Sectorhumanitario;
import com.resphere.service.SHumanitarioFacadeREST;

public class TestSHumanitario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.sectorhumanitario";
		testGetAll(url);
	}

	public static void testGetAll(String url){
		SHumanitarioFacadeREST service = new SHumanitarioFacadeREST(Sectorhumanitario.class, url);
		try {
			List<Sectorhumanitario> lista = service.getAll();
			for(int i = 0; i < lista.size(); i++)
				System.out.print(lista.get(i).getIdsectorhumanitario() + " ");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
