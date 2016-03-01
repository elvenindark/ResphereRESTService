package com.resphere.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.resphere.server.model.Respuestabysectorv;
import com.resphere.service.RespuestabysectorvFacadeREST;

public class TestRespuestabysectorv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://hp-hp:8080/respherers/webresources/com.resphere.server.model.respuestabysectorv";
		String idevento = "1438885596";
		String idevento1 = "1447768774";
		String idsector = "1";
		//testGetRespuestabysectorvByIds(url, idevento, idsector);
		testGetRespuestabysectorvById(url, idevento1);
		
	}
	
	public static void testGetRespuestabysectorvByIds(String url, String idevento, String idsector){
		RespuestabysectorvFacadeREST servicio = new RespuestabysectorvFacadeREST(Respuestabysectorv.class, url);
		if(servicio!=null){
			try {
				List<Respuestabysectorv> lista = servicio.getAllByIds(idevento, idsector);
				if(lista!=null)
					for(Respuestabysectorv item:lista)
						System.out.println(item.getIdevento()+";"+item.getIndicadorclave()+";"+item.getObservacion());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void testGetRespuestabysectorvById(String url, String idevento){
		RespuestabysectorvFacadeREST servicio = new RespuestabysectorvFacadeREST(Respuestabysectorv.class, url);
		if(servicio!=null){
			try {
				List<Respuestabysectorv> lista = servicio.getAllById(idevento);
				if(lista!=null)
					for(Respuestabysectorv item:lista)
						System.out.println(item.getIdevento()+";"+item.getIndicadorclave()+";"+item.getObservacion());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
