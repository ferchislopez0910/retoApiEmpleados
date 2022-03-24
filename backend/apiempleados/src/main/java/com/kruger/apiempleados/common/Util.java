package com.kruger.apiempleados.common;

/**
 * Clase que crea la contraseña para el usuario
 * @author ferch
 *
 */
public class Util {
	/**
	 * createPassword - Metodo que crea la contraseña para el usuario
	 * @param prefijo
	 * @return
	 */
	
	public static String createPassword(String prefijo) {
		int min = 1000;
		int max = 9999;
		
		int temp = (int)(Math.random()*(max - min + 1) + min);
		
		
		return prefijo + temp;
	}
}

