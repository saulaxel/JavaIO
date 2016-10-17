/**
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Ingeniero MartInez Ortiz SaUl Axel
 * Clases personales de entrada y salída a pantalla
 * Ultima modificaciOn: 16 de octubre de 2016
 * DescripciOn: Clase simplificada de entrada
 * Recursos o fuentes:
    DocumentaciOn de java
 **/


public class Escritor{
    private static final String explicacionCaja = "" +
        " Estructura de los arreglos 'caracteresCaja':\n" +
        " Primeros 2: Caracteres internos horizontal y vertical\n" +
        "            respectivamente\n" +
        " Del 3 al 6: Esquinas superior izquierda,\n" +
        "             superior derecha, inferior izquierda\n" +
        "             e inferior derecha respectivamente\n" +
        "Del 7 al 10: Caracteres laterales\n" +
        "             lateral izquierdo, lateral derecho\n" +
        "             lateral superior y lateral inferior\n" +
        "             respectivamente\n" +
        "11avo: Caracter de cruz central\n";
    private static final char[] caracteresCaja1 = {
	'-','|',
	'+','+','+','+',
	'+','+','+','+',
	'+'
    };
    private static final char[] caracteresCaja2 = {
	'\u2550','\u2551',
	'\u2554','\u2557','\u255a','\u255d',
	'\u2560','\u2563','\u2566','\u2569',
	'\u256b'
    };
    private static final char[] caracteresCaja3 = {
	'\u2500','\u2502',
	'\u250c','\u2510','\u2514','\u2518',
	'\u251c','\u2524','\u252c','\u2534',
	'\u253c'
    };
    private static final char[] caracteresCaja4 = {
	'\u2501','\u2503',
	'\u250f','\u2513','\u2517','\u251b',
	'\u2523','\u252b','\u2533','\u253b',
	'\u254b'
    };
    private static final char[] caracteresCaja5 = {
	'\u2504','\u2506',
	'+','+','+','+',
	'+','+','+','+',
	'+'
    };
    private static final char[] caracteresCaja6 = {
	'\u2505','\u2507',
	'+','+','+','+',
	'+','+','+','+',
	'+'
    };
    private static final char[] caracteresCaja7 = {
	'\u254c','\u254e',
	'+','+','+','+',
	'\u251c','\u2524','\u252c','\u2534',
	'+'
    };
    private static final char[] caracteresCaja8 = {
	'\u254d','\u254f',
	'+','+','+','+',
	'+','+','+','+',
	'+'
    };
    private static final char[] caracteresCaja9 = {
	'\u2500','\u2502',
	'\u256d','\u256e','\u2570','\u256f',
	'\u251c','\u2524','\u252c','\u2534',
	'\u253c'
    };

    private char[] caracteresCaja;

    public Escritor(){
	caracteresCaja = caracteresCaja1;
    }
    
    public Escritor( int numeroCaja){
	setCaracteresCaja( numeroCaja );
    }

    public void escribir(Object o){
	System.out.print(o);
    }

    public static void escribirLinea(Object o){
	System.out.println(o);
    }

    public static void escribeEnCaja(){
    }
    
    public static void saltarLinea(){
	System.out.println();
    }

    public static void saltarLinea(Number n){
	System.out.print(repetir('\n',n));
    }

    public static String repetir(char c, Number veces){
	String caracterRepetido = "";
	int n = (int) veces;
	for( int i = 0; i < n; ++i ){
	    caracterRepetido += c;
	}

	return caracterRepetido;
    }
    public static String repetir(String s, Number veces){
	String cadenaRepetida = "";
	int n = (int) veces;
	for( int i = 0; i < n; ++i ){
	    cadenaRepetida += s;
	}

	return cadenaRepetida;
    }

    public void verCaracteresCaja(){
	System.out.println(
		"" +
		caracteresCaja[2] +
		caracteresCaja[0] +
		caracteresCaja[8] +
		caracteresCaja[0] +
		caracteresCaja[3] +
		"\n" +
		caracteresCaja[1] + 
		" " +
		caracteresCaja[1] +
		" " +
		caracteresCaja[1] +
		"\n" +
		caracteresCaja[6] +
		caracteresCaja[0] +
		caracteresCaja[10] +
		caracteresCaja[0] +
		caracteresCaja[7] + 
		"\n" +
		caracteresCaja[1] +
		" " +
		caracteresCaja[1] +
		" " +
		caracteresCaja[1] +
		"\n" +
		caracteresCaja[4] +
		caracteresCaja[0] +
		caracteresCaja[9] +
		caracteresCaja[0] +
		caracteresCaja[5]
	);

    }

    public static void verExplicacionCaja(){
	System.out.println(explicacionCaja);
    }

    public void setCaracteresCaja(int numeroCaja){
	if( numeroCaja > 0 && numeroCaja < 10 ){
	    switch( numeroCaja ){
		case 1:
		caracteresCaja = caracteresCaja1;
		break;

		case 2:
		caracteresCaja = caracteresCaja2;
		break;

		case 3:
		caracteresCaja = caracteresCaja3;
		break;

		case 4:
		caracteresCaja = caracteresCaja4;
		break;

		case 5:
		caracteresCaja = caracteresCaja5;
		break;

		case 6:
		caracteresCaja = caracteresCaja6;
		break;

		case 7:
		caracteresCaja = caracteresCaja7;
		break;

		case 8:
		caracteresCaja = caracteresCaja8;
		break;

		case 9:
		caracteresCaja = caracteresCaja9;
		break;

	    }
	}else{
	    System.out.println("No se ha encontrado la caja especificada");
	}
    }

    public static void main(String[] args){
	new Escritor(1).verCaracteresCaja();
	new Escritor(2).verCaracteresCaja();
	new Escritor(3).verCaracteresCaja();
	new Escritor(4).verCaracteresCaja();
	new Escritor(5).verCaracteresCaja();
	new Escritor(6).verCaracteresCaja();
	new Escritor(7).verCaracteresCaja();
	new Escritor(8).verCaracteresCaja();
	new Escritor(9).verCaracteresCaja();
    }
}
