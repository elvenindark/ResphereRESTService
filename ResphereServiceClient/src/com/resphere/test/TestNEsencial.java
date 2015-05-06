package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Normaesencial;
import com.resphere.service.NEsencialFacadeREST;

public class TestNEsencial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.normaesencial";
		getAllByQuery("1", url);
	}

	public static void getAllByQuery(String id, String url){
		NEsencialFacadeREST service = new NEsencialFacadeREST(Normaesencial.class, url);
		try {
			List<Normaesencial> lista = service.getQueryById("nminima", id);
			for(int i = 0; i < lista.size(); i++)
				System.out.println(lista.get(i).getNormaesencial());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
