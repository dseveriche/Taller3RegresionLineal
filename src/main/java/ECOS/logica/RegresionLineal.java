package ECOS.logica;

import java.util.ArrayList;

public class RegresionLineal {
	/**
	 * Nombre:                       Daniel MAuricio Alvarez                                                                       
	 * Fecha :                       28/02/2016
	 * Descripción:                  funciocn crear para multipar array list y retornar 
	 * la multiplicacion lista 
	 * */	
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static ArrayList<Double> MultiplicarLista( ArrayList<Double> num1, ArrayList<Double> num2){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < num1.size(); x++)
			resultado.add( num1.get(x) * num2.get(x));
		return resultado;
	}
	/*
	 * saber el cuadrado de las arraylist devolviendo un arraylist double
	 * */
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static ArrayList<Double> ListaCuadrada( ArrayList<Double> numeros){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < numeros.size(); x++)
			resultado.add(numeros.get( x) * numeros.get( x));
		return resultado;
	}
		/**
		* descripcion  crear una un atributo double sumando los numero de la lista
		* @param ArrayList
		* @return sumatoria
		*/
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Sumatoria( ArrayList<Double> numeros){
		
		double sumatoria = 0;
		for( double x: numeros)
			sumatoria += x;
		return sumatoria;
	}
	/**
	* descripcion  crear una un atributo double promedio los numero de la lista
	* @param ArrayList
	* @return promedio
	*/
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Promedio( ArrayList<Double> numeros){
		return Sumatoria(numeros) / numeros.size();
	}
	/*
	 * return el valor de N para la regresion lineal 
	 * resiviendo como parametro el promedio de la
	 * columna X
	 * */
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double N( double promedioX){

		return promedioX * promedioX;
	}
	/**
	* descripcion  retorna el valor beta 1 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta1
	*/
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Beta1( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double CuadradaPromedioX = promedioX * promedioX;
		double sumatoriaMultiplicarLista = Sumatoria( MultiplicarLista( num1, num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ((sumatoriaMultiplicarLista) - (( N * promedioX) * promedioY)) / (sumatoriaCuadradaX - (N * CuadradaPromedioX ));
	}
	/**
	* descripcion  retorna el valor RYX de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta1
	*/
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Ryx( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double sumatoriaMultiplicarXY = Sumatoria( MultiplicarLista( num1, num2)); 
		double sumatoriaX = Sumatoria(num1);
		double sumatoriaY = Sumatoria(num2);
		double sumatoriaCuadradaY = Sumatoria(ListaCuadrada( num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ( (N * ( sumatoriaMultiplicarXY) - ( sumatoriaX * sumatoriaY))/ (Math.sqrt((N*sumatoriaCuadradaX - Math.pow(sumatoriaX,2))*(N*sumatoriaCuadradaY - Math.pow(sumatoriaY,2)))));
	}
	
	/**
	* descripcion  retorna el valor R^2 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return R2
	*/
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double R2( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double ryx = Ryx( num1, num2);
		
		return ryx * ryx;
	}
	/**
	* descripcion  retorna el valor B0 de la regresion lineal
	* resiviendo como parametro dos  ArrayList double 
	* @param ArrayList<Double> num1, ArrayList<Double> num2
	* @return Beta0
	*/
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Beta0( ArrayList<Double> num1, ArrayList<Double> num2){

		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double b1 = Beta1( num1, num2);
		return promedioY - 	( b1 * promedioX);
	}
	
	/**
	* descripcion  etorna el valor Yk de la regresion lineal
	* resiviendo como parametro dos  ArrayList double  y la constante XK
	* @param ArrayList<Double> num1, ArrayList<Double> num2, costante xk
	* @return YK
	*/
	
	// ----------------------------------------------------------
	// Métodos
	// ----------------------------------------------------------

	public static double Yk( ArrayList<Double> num1, ArrayList<Double> num2, double Xk){

		double b1 = Beta1( num1, num2);
		double b0 = Beta0( num1, num2);
		return b0 + ( b1 * Xk);
	}
	
}
