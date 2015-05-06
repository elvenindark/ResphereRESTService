package com.resphere.test;

import java.util.ArrayList;

import com.resphere.server.model.Ubicacion;
import com.resphere.util.Reflection;


public class TestReflection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reflection r;
		Ubicacion e = new Ubicacion();
		/*e.setAmenazas("amenaza");
		e.setDescripcion("descripcion");
		e.setEfectos("efectos");
		e.setFecha("fecha");
		e.setHora("hora");
		e.setIdevento("idevento");*/
		r = new Reflection(e.getClass());
		ArrayList<String> getters = new ArrayList<String>();
		ArrayList<String> valores = new ArrayList<String>();
		ArrayList<String> setters = new ArrayList<String>();
		ArrayList<String> atributos = new ArrayList<String>();
		ArrayList<String> atributos2 = new ArrayList<String>();
		ArrayList<String> atributos3 = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		
		getters = r.returnGetters();
		valores = r.returnDatos(e);
		setters = r.returnSetters();
		atributos = r.returnFields();
		atributos3 = r.returnAtributos();
		String[] search = new String[atributos3.size()];
		atributos3.toArray(search);
		
		for(int i = 0;i < atributos3.size(); i++){
			r.set(e, atributos3.get(i), "1758896555");
		}	
		
		System.out.println(e.getCanton()+";"+e.getAltitud()+";"+e.getClass().getName());
		/*for(int i = 0; i < atributos3.size(); i++){
			values.add("spam");
		}
		
		try {
			Ubicacion u = Ubicacion.class.newInstance();
			u = (Ubicacion) r.setObject(u, values);
			System.out.println(u.getCanton());
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		
		String statement = "id INTEGER PRIMARY KEY, ";
		for (int i = 0; i < r.returnAtributos().size(); i++){
			statement = statement + r.returnAtributos().get(i) + " TEXT";
			if(i != r.returnAtributos().size()-1)
				statement = statement + ",";
		}
		String sqlStatement = "CREATE TABLE IF NOT EXISTS " + Ubicacion.class.getSimpleName() + " ("
				+ statement + ")";
		
		System.out.println(sqlStatement);
		
		for(int i = 0; i < search.length; i++){
			System.out.println(search[i]);
		}
		
		/*for(int i = 0; i < atributos.size(); i++){
			//System.out.println("size >"+atributos.size());
			atributos2.add(getters.get(i).toLowerCase().replace("get", ""));
			System.out.println("campos "+i+"> "+getters.get(i)+" valor "+i+"> "+valores.get(i)+" atributos"+i+"> "+atributos.get(i) );
			//System.out.println("atributo "+i+"> "+atributos.get(i));
		}
		for(int i = 0; i < atributos2.size(); i++){
			System.out.println("atributos2 "+i+"> "+atributos2.get(i));
		}
		for(int i = 0; i < atributos3.size(); i++){
			System.out.println("atributos3 "+i+"> "+atributos3.get(i));
		}*/
	}

}
