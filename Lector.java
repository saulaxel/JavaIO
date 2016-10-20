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
    private String p; // prefijo
    private String prompt; // Cadena que indica al usuario que debe ingresar algo

    public Lector(){
	p = " ";
	prompt = "> ";
    }
    
    public Lector(String p){
	this.p = p;
	prompt = "> ";
    }

    public Lector(String p, String prompt){
	this.p = p;
	this.prompt = prompt;
    }

    public int pedirEntero(){
	return leerEntero(
		"",
		"",
		Integer.MIN_VALUE,
		Integer.MAX_VALUE
	);
    }

    public int pedirEntero(String mensajeInicial){
	return leerEntero(
		mensajeInicial + "\n",
		"",
		Integer.MIN_VALUE,
		Integer.MAX_VALUE
	);
    }

    public int pedirEntero(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerEntero(
		mensajeInicial + "\n",
		mensajeError + "\n",
		Integer.MIN_VALUE,
		Integer.MAX_VALUE
	); 
    }

    public int pedirEntero(
	    String mensajeInicial,
	    String mensajeError,
	    int min,
	    int max
    ){
	return leerEntero(
		mensajeInicial + "\n",
		mensajeError + "\n",
		min,
		max
	);
    }

    public int pedirEntero(
	    int min,
	    int max
    ){
	return leerEntero("", "", min, max);
    }

    public double pedirDoble(){
	return leerDoble(
		"",
		"",
		Double.MIN_VALUE,
		Double.MAX_VALUE
	);
    }

    public double pedirDoble(String mensajeInicial){
	return leerDoble(
		mensajeInicial + "\n",
		"",
		Double.MIN_VALUE,
		Double.MAX_VALUE
	);
    }

    public double pedirDoble(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerDoble(
		mensajeInicial + "\n",
		mensajeError + "\n",
		Double.MIN_VALUE,
		Double.MAX_VALUE
	);
    }

    public double pedirDoble(
	    String mensajeInicial,
	    String mensajeError,
	    Double min,
	    Double max
    ){
	return leerDoble(
		mensajeInicial + "\n",
		mensajeError + "\n",
		min,
		max
	);
    }

    public double pedirDoble(double min, double max){
	return leerDoble("","", min, max);
    }

    public String pedirCadena(){
	return leerCadena("","");
    }

    public String pedirCadena(String mensajeInicial){
	return leerCadena(mensajeInicial + "\n", "");
    }

    public String pedirCadena(
	    String mensajeInicial,
	    String mensajeError
    ){
	return leerCadena(mensajeInicial + "\n", mensajeError + "\n");
    }

    public String pedirPalabra(){
	String palabra = pedirCadena();
	return palabra.substring(0,palabra.indexOf(' '));
    }

    public String pedirPalabra(String mensajeInicial){
	String palabra = pedirCadena(mensajeInicial);
	return palabra.substring(0,palabra.indexOf(' '));
    }

    public String pedirPalabra(
	String mensajeInicial,
	String mensajeError
    ){
	String palabra = pedirCadena(mensajeInicial,mensajeError);
	return palabra.substring(0,palabra.indexOf(' '));
    }

    private int leerEntero(
	    String mensajeInicial, 
	    String mensajeError,
	    int min,
	    int max
    ){
	boolean noLeido = true;
	int entero = 0;
	System.out.print(p + mensajeInicial);
	do{
	    System.out.print(prompt);
	    try{
		entero = escaner.nextInt();
		if( entero >= min && entero <= max ){
		    noLeido = false;
		}
	    }catch(Exception e){
		System.out.print(mensajeError);
	    }

	}while( noLeido );

	return entero;
    }

    private double leerDoble(
	    String mensajeInicial, 
	    String mensajeError,
	    double min,
	    double max
    ){
	boolean noLeido = true;
	double doble = 0;
	System.out.print(p + mensajeInicial);
	do{
	    System.out.print(prompt);
	    try{
		doble = escaner.nextInt();
		if( doble >= min && doble <= max ){
		    noLeido = false;
		}
	    }catch(Exception e){
		System.out.print(mensajeError);
	    }

	}while( noLeido );

	return doble;
    }

    private String leerCadena(
	    String mensajeInicial, 
	    String mensajeError
    ){
	boolean noLeido = true;
	String cadena = "";
	System.out.print(p + mensajeInicial);
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
