package com.resphere.test;

import java.util.List;

import com.resphere.server.model.Monitoreorespuesta;
import com.resphere.service.MonitoreoFacadeREST;

public class TestMonitoreo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/respherers/webresources/com.resphere.server.model.monitoreorespuesta";
		//testMonitoreoGetAll(url);
		Monitoreorespuesta monitoreo = new Monitoreorespuesta();
		monitoreo.setCumple("cumple");
		monitoreo.setIdrespuesta(21);
		monitoreo.setObservacion("testing");
		String idevento = "1447768774";
		int idsector = 2;
		testMonitoreoGetAllByIds(url, idevento, idsector);
		//testSaveMonitoreo(monitoreo, url);
	}
	
	public static void testMonitoreoGetAll(String url){
		MonitoreoFacadeREST servicio = new MonitoreoFacadeREST(Monitoreorespuesta.class, url);
		try{
			List<Monitoreorespuesta> monitoreos = servicio.getAll();
			if(monitoreos != null){
				for(Monitoreorespuesta item: monitoreos){
					System.out.println(item.getObservacion());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void testMonitoreoGetAllByIds(String url, String idevento, int idsector){
		MonitoreoFacadeREST servicio = new MonitoreoFacadeREST(Monitoreorespuesta.class, url);
		try{
			List<Monitoreorespuesta> monitoreos = servicio.getAllByIds(idevento, idsector);
			if(monitoreos != null ){
				for(Monitoreorespuesta item: monitoreos){
					System.out.println(item.getObservacion()+item.getCumple());
				}
			}
			else
				System.out.println("vacio");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void testSaveMonitoreo(Monitoreorespuesta e, String url){
		MonitoreoFacadeREST servicio = new MonitoreoFacadeREST(Monitoreorespuesta.class, url);
		try{
			servicio.post(e);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
