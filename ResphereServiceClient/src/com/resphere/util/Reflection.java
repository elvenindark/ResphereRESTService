package com.resphere.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.ArrayList;

public class Reflection {

	private static Class aClass;
	private static Object object;
	public Reflection(Class aClass){
		this.aClass = aClass;
	}
	
	public Reflection(Class aClass, Object o){
		this.object = o;
		aClass.cast(this.object);
	}
	
	public ArrayList<String> returnDatos(Object o){
		this.object = o;
		aClass.cast(this.object);
		ArrayList<String> metodos = new ArrayList<String>();
		ArrayList<String> valores = new ArrayList<String>();
		metodos.addAll(returnGetters());
		//metodos.addAll(returnFields());
		Method[] metods = new Method[metodos.size()];		
		for(int i = 0; i < metodos.size(); i++){
			try {
				metods[i] = aClass.getDeclaredMethod(metodos.get(i));
				valores.add(String.valueOf(metods[i].invoke(object)));						
				//valores.add((String) metods[i].invoke(object));
			} catch (NoSuchMethodException e) {
				e.printStackTrace(); return null;
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace(); return null;
			} catch (InvocationTargetException e) {
				e.printStackTrace(); return null;
			}	
			
		}	
		return valores;
	}
	
	public Object setObject(Object o, ArrayList<String> values){
		this.object = o;
		aClass.cast(this.object);
		ArrayList<String> metodos = new ArrayList<String>();
		metodos.addAll(returnSetters());
		Method[] metods = new Method[metodos.size()];		
		for(int i = 0; i < metodos.size(); i++){
			try {
				metods[i] = aClass.getDeclaredMethod(metodos.get(i), String.class);
				metods[i].invoke(o, values.get(i));						
			} catch (NoSuchMethodException e) {
				e.printStackTrace(); return null;
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace(); return null;
			} catch (InvocationTargetException e) {
				e.printStackTrace(); return null;
			}			
		}	
		return o;
	}
	
	//Siempre y cuando los campos del objeto enviado sean del mismo tipo 
	//que del bean
	public Boolean set(Object object, String atributo, String value){
		Class<?> clazz = object.getClass();
		while(clazz!=null){
			try {
				Field field = aClass.getDeclaredField(atributo);
				field.setAccessible(true);
				//System.out.println(field.getType().getName());
				if(field.getType().getName()=="java.lang.String"){
					field.set(object, value);
				}
				if(field.getType().getName()=="java.lang.Double"){
					field.set(object, Double.valueOf(value));
				}
				if(field.getType().getName()=="java.math.BigInteger"){					
					field.set(object, BigInteger.valueOf(Long.parseLong(value)));
				}
				else{
					field.set(object, clazz.cast(value));
				}
				return true;
			} catch (NoSuchFieldException e) {
				e.printStackTrace(); return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace(); return false;
			}
		}		
		return false;
	}	
			
	public ArrayList<String> returnGetters(){
		Method[] methods = aClass.getMethods();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> fields = new ArrayList<String>();
		fields.addAll(returnFields());
		int flag = 0;
		  
		if(flag == 1)
		for(Method method : methods){
			if(isGetter(method)) list.add(method.getName());
			System.out.println("getter si: " + method.getName());
		 }
		else{
			for(Method method : methods){
				  
				for(int i = 0; i < fields.size(); i++){
					if(method.getName().toLowerCase().contains(fields.get(i)) && method.getName().startsWith("get")){
						list.add(method.getName());						
						break;
					}					
				}				
			}
		}
		return list;
	}

	public ArrayList<String> returnSetters(){
		Method[] methods = aClass.getMethods();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> fields = new ArrayList<String>();
		fields.addAll(returnFields());
		int flag = 0;
		  
		if(flag == 1)
		for(Method method : methods){
			if(isSetter(method)) list.add(method.getName());		    
		 }
		else{
			for(Method method : methods){
				  
				for(int i = 0; i < fields.size(); i++){
					if(method.getName().toLowerCase().contains(fields.get(i)) && method.getName().startsWith("set")){
						list.add(method.getName());
						break;
					}
				}
			}
		}
		return list;
	}
	
	public ArrayList<String> returnFields(){
		ArrayList<String> privateFields = new ArrayList<String>();
	    Field[] allFields = aClass.getDeclaredFields();
	    for (Field field : allFields) {
	        if (Modifier.isPrivate(field.getModifiers())&&!field.getName().startsWith("serial")) {
	            privateFields.add(field.getName());
	        }
	    }
	    return privateFields;
	}
	
	public ArrayList<String> returnFields1(){
		ArrayList<String> privateFields = new ArrayList<String>();
		ArrayList<String> fields = new ArrayList<String>();
		privateFields = returnGetters();
		for(int i = 0 ; i < privateFields.size(); i ++){
			fields.add(privateFields.get(i).substring(3).toLowerCase());
		}
		return fields;
	}

	public ArrayList<String> returnAtributos(){
		ArrayList<String> privateFields = new ArrayList<String>();
		ArrayList<String> getters = returnGetters();
		for(int i = 0; i < getters.size(); i++){
			privateFields.add(getters.get(i).toLowerCase().replace("get", ""));
		}
		return privateFields;
	}
	
	public static boolean isGetter(Method method){
		if(!method.getName().startsWith("get"))      return false;
		if(method.getParameterTypes().length != 0)   return false;  
		if(void.class.equals(method.getReturnType())) return false;
			return true;
	}	
	
	public static boolean isSetter(Method method){
	  if(!method.getName().startsWith("set")) return false;
	  if(method.getParameterTypes().length != 1) return false;
	  	return true;
	}
}
