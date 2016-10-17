/**
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Ingeniero MartInez Ortiz SaUl Axel
 * Clases personales de entrada y salida a pantalla 
 * Ultima modificaciOn: 16 de octubre de 2016
 * DescripciOn: Clase simplificada de entrada
 * Recursos o fuentes:
    DocumentaciOn de java
 **/

import java.util.Scanner;
// No importo java IOEXception por que no se mostrarAn los
// mensajes de error de dicha clase
public final class Lector{
    private static final Scanner escaner = new Scanner(System.in);
    private static String prompt = "> ";

    public static int pedirEntero(){
	return leerEntero("","");
    }
    public static int pedirEntero(String mensajeInicial){
	return leerEntero(mensajeInicial + "\n","");
    }
    public static int pedirEntero(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerEntero(mensajeInicial + "\n", mensajeError + "\n"); 
    }
    public static double pedirDoble(){
	return leerDoble("","");
    }
    public static double pedirDoble(String mensajeInicial){
	return leerDoble(mensajeInicial + "\n", "");
    }
    public static double pedirDoble(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerDoble(mensajeInicial + "\n", mensajeError + "\n");
    }
    public static String pedirCadena(){
	return leerCadena("","");
    }
    public static String pedirCadena(String mensajeInicial){
	return leerCadena(mensajeInicial + "\n", "");
    }
    public static String pedirCadena(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerCadena(mensajeInicial + "\n", mensajeError + "\n");
    }
    public static String pedirPalabra(){
	String palabra = pedirCadena();
	return palabra.substring(0,palabra.indexOf(' '));
    }
    public static String pedirPalabra(String mensajeInicial){
	String palabra = pedirCadena(mensajeInicial);
	return palabra.substring(0,palabra.indexOf(' '));
    }
    public static String pedirPalabra(
	String mensajeInicial,
	String mensajeError
    ){
	String palabra = pedirCadena(mensajeInicial,mensajeError);
	return palabra.substring(0,palabra.indexOf(' '));
    }

    private static int leerEntero(
	    String mensajeInicial, 
	    String mensajeError
    ){
	boolean noLeido = true;
	int entero = 0;
	System.out.print(mensajeInicial);
	do{
	    System.out.print(prompt);
	    try{
		entero = escaner.nextInt();
		noLeido = false;
	    }catch(Exception e){
		System.out.print(mensajeError);
	    }

	}while( noLeido );

	return entero;
    }

    private static double leerDoble(
	    String mensajeInicial, 
	    String mensajeError
    ){
	boolean noLeido = true;
	double doble = 0;
	System.out.print(mensajeInicial);
	do{
	    System.out.print(prompt);
	    try{
		doble = escaner.nextInt();
		noLeido = false;
	    }catch(Exception e){
		System.out.print(mensajeError);
	    }

	}while( noLeido );

	return doble;
    }

    private static String leerCadena(
	    String mensajeInicial, 
	    String mensajeError
    ){
	boolean noLeido = true;
	String cadena = "";
	System.out.print(mensajeInicial);
	do{
	    System.out.print(prompt);
	    try{
		cadena = escaner.nextLine();
		noLeido = false;
	    }catch(Exception e){
		System.out.print(mensajeError);
	    }

	}while( noLeido );

	return cadena;
    }
}
