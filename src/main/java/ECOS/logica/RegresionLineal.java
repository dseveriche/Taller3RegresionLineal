package ECOS.logica;

import java.util.ArrayList;

public class RegresionLineal {
	/*
	 * funciocn crear para multipar array list y retornar 
	 * la multiplicacion lista 
	 * */	
	public static ArrayList<Double> MultiplicarLista( ArrayList<Double> num1, ArrayList<Double> num2){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < num1.size(); x++)
			resultado.add( num1.get(x) * num2.get(x));
		return resultado;
	}
	/*
	 * saber el cuadrado de las arraylist devolviendo un arraylist double
	 * */
	public static ArrayList<Double> ListaCuadrada( ArrayList<Double> numeros){
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		for( int x = 0; x < numeros.size(); x++)
			resultado.add(numeros.get( x) * numeros.get( x));
		return resultado;
	}
	/*
	 * crear una un atributo double sumando los numero de la lista
	 * */
	public static double Sumatoria( ArrayList<Double> numeros){
		
		double sumatoria = 0;
		for( double x: numeros)
			sumatoria += x;
		return sumatoria;
	}
	/*
	 * retorna el numero promedio de un alarraylist double
	 * */
	public static double Promedio( ArrayList<Double> numeros){
		return Sumatoria(numeros) / numeros.size();
	}
	/*
	 * return el valor de N para la regresion lineal 
	 * resiviendo como parametro el promedio de la
	 * columna X
	 * */
	public static double N( double promedioX){

		return promedioX * promedioX;
	}
	/*
	 * retorna el valor beta 1 de la regresion lineal
	 * resiviendo como parametro dos  araaylist doubel 
	 * */
	public static double Beta1( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double CuadradaPromedioX = promedioX * promedioX;
		double sumatoriaMultiplicarLista = Sumatoria( MultiplicarLista( num1, num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ((sumatoriaMultiplicarLista) - (( N * promedioX) * promedioY)) / (sumatoriaCuadradaX - (N * CuadradaPromedioX ));
	}
	/*
	 * retorna Rxy de la regresion lienal resividiendo 
	 * como parametro de dos arratylist double
	 * */
	public static double Ryx( ArrayList<Double> num1, ArrayList<Double> num2){
		
		int N = num1.size();
		double sumatoriaMultiplicarXY = Sumatoria( MultiplicarLista( num1, num2)); 
		double sumatoriaX = Sumatoria(num1);
		double sumatoriaY = Sumatoria(num2);
		double sumatoriaCuadradaY = Sumatoria(ListaCuadrada( num2));
		double sumatoriaCuadradaX = Sumatoria(ListaCuadrada( num1));
		return ( (N * ( sumatoriaMultiplicarXY) - ( sumatoriaX * sumatoriaY))/ (Math.sqrt((N*sumatoriaCuadradaX - Math.pow(sumatoriaX,2))*(N*sumatoriaCuadradaY - Math.pow(sumatoriaY,2)))));
	}
	
	/*
	 * retorna la reiz cudadra de de R resiviebdi como
	 * dos array list ocmo parametros
	 * */
	public static double R2( ArrayList<Double> num1, ArrayList<Double> num2){
		
		double ryx = Ryx( num1, num2);
		
		return ryx * ryx;
	}
	/*
	 * retorna el valor de beta cero ctomando como
	 * parametro dos array list double
	 * */
	public static double Beta0( ArrayList<Double> num1, ArrayList<Double> num2){

		double promedioX = Promedio( num1);
		double promedioY = Promedio( num2);
		double b1 = Beta1( num1, num2);
		return promedioY - 	( b1 * promedioX);
	}
	/*
	 * retorna el valor de Yk resiviendo como parametro dos arraylist 
	 * double y la constante XK
	 * */
	public static double Yk( ArrayList<Double> num1, ArrayList<Double> num2, double Xk){

		double b1 = Beta1( num1, num2);
		double b0 = Beta0( num1, num2);
		return b0 + ( b1 * Xk);
	}
	
}
