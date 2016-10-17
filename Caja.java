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

public class Caja {
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

    public static final String[] descCaracter = {
	"Barra horizontal",
	"Barra vertival",
	"Esquina superior izquierda",
	"Esquina superior derecha",
	"Esquina inferior izquierda",
	"Esquina inferior derecha",
	"Secci\u00f3n lateral izquierda",
	"Secci\u00f3n lateral derecha",
	"Secci\u00f3n superior",
	"Secci\u00f3n inferior",
	"Cruz central"
    };
    
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
    
    public Caja(){
	caracteresCaja = caracteresCaja1;
    }

    public Caja( int numeroCaja ) throws NoExisteCajaException{
	usarCajaPredefinida(numeroCaja);
    }

    public Caja(
	    char barraHorizontal,
	    char barraVertical,
	    char esquinaSuperiorIzquierda,
	    char esquinaSuperiorDerecha,
	    char esquinaInferiorIzquierda,
	    char esquinaInferiorDerecha,
	    char barraLateralIzquierda,
	    char barraLateralDerecha,
	    char barraSuperior,
	    char barraInferior,
	    char cruzCentral
    ){
	caracteresCaja = new char[]{
		barraHorizontal,
		barraVertical,
		esquinaSuperiorIzquierda,
		esquinaSuperiorDerecha,
		esquinaInferiorIzquierda,
		esquinaInferiorDerecha,
		barraLateralIzquierda,
		barraLateralDerecha,
		barraSuperior,
		barraInferior,
		cruzCentral
	};
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

    public void usarCajaPredefinida(int numeroCaja) 
	throws NoExisteCajaException{
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

		default:
		    throw new NoExisteCajaException(
			    "Se te recuerda que solo existen 9 plantillas" +
			    "de cajas"
		    );
	    }
	}else{
	    System.out.println();
	}
    }

    public char getCaracterCaja(int numeroCaja, int posicion){ 
	try{
	    switch( numeroCaja ){
		case 0:
		    return caracteresCaja1[posicion%11];
		case 1:
		    return caracteresCaja2[posicion%11];
		case 2:
		    return caracteresCaja3[posicion%11];
		case 3:
		    return caracteresCaja4[posicion%11];
		case 4:
		    return caracteresCaja5[posicion%11];
		case 5:
		    return caracteresCaja6[posicion%11];
		case 6:
		    return caracteresCaja7[posicion%11];
		case 7:
		    return caracteresCaja8[posicion%11];
		case 8:
		    return caracteresCaja9[posicion%11];
		default:
		    throw new NoExisteCajaException(
			    "Se te recuerda que solo existen 9 plantillas" +
			    "de cajas"
		    );
		
	    }
	}catch(NoExisteCajaException nece){
	    System.out.println(nece.getMessage());
	}
	return ' ';
    }

    public char getPos(int pos){
	if( pos > -1 && pos < 11 ){
	    return caracteresCaja[pos];
	}else{
	    return 0;
	}
    }

    public void setCaracteresCaja(int numeroCaja){
	try{
	    usarCajaPredefinida(numeroCaja);
	}catch(NoExisteCajaException nece){
	    System.out.println(nece.getMessage());
	}
    }

    public void setCaracteresCaja(
	    char barraHorizontal,
	    char barraVertical,
	    char esquinaSuperiorIzquierda,
	    char esquinaSuperiorDerecha,
	    char esquinaInferiorIzquierda,
	    char esquinaInferiorDerecha,
	    char barraLateralIzquierda,
	    char barraLateralDerecha,
	    char barraSuperior,
	    char barraInferior,
	    char cruzCentral
    ){
	caracteresCaja[0] = barraHorizontal;
	caracteresCaja[1] = barraVertical;
	caracteresCaja[2] = esquinaSuperiorIzquierda;
	caracteresCaja[3] = esquinaSuperiorDerecha;
	caracteresCaja[4] = esquinaInferiorIzquierda;
	caracteresCaja[5] = esquinaInferiorDerecha;
	caracteresCaja[6] = barraLateralIzquierda;
	caracteresCaja[7] = barraLateralDerecha;
	caracteresCaja[8] = barraSuperior;
	caracteresCaja[9] = barraInferior;
	caracteresCaja[10] = cruzCentral;
    }

    public void setCaracteresCaja(){
	int pos = 0;
	int lat[] = new int[] {0,0,0,0,0,0,0,0,0,0,0};
	boolean listo = false;
	int i = 0;
	char c = ' ';

	caracteresCaja = caracteresCaja1;

	do{
	    System.out.println("\n\n\n\n\nPersonalize su caja:");
	    System.out.println("(Use las flechas ariba y abajo para"+
		    "moverse entre las opciones\ny las flechas de" + 
		    "izquierda y derecha para cambiar de bordes de\n" +
		    "caja, al final de cada acciOn realizada presione enter"); 
	    System.out.println("Vista previa:");
	    verCaracteresCaja();

	    for(i = 0; i < 11; ++i){
		System.out.printf("%-30s:  \t",descCaracter[i]);
		System.out.print("| "+getCaracterCaja(lat[i],i)+" |");
		if( pos == i ){
		    System.out.println("\t<-----"); 
		}else{
		    System.out.println();
		}
	    }
	    System.out.printf("%-43s ","¡Estoy listo!");
	    if( 11 == pos ){
		System.out.println("\t<-----");
	    }else{
		System.out.println();
	    }

	    try{ c = (char) System.in.read(); }catch(Exception e){}

	    if( c == 'A' ){
		if( pos > 0 ){
		    --pos;
		}
	    }else if( c == 'B' ){
		if( pos < 11 ){
		    ++pos;
		}
	    }else if( c == 'D' ){
		if( lat[pos] > 0 ){
		System.out.println("lat[pos]:" + lat[pos]);
		    lat[pos] -= 1;
		    caracteresCaja[pos] = getCaracterCaja(lat[pos],pos); 
		}
	    }else if( c == 'C' ){
		if( lat[pos] < 8 ){
		System.out.println("lat[pos]:" + lat[pos]);
		    lat[pos] += 1;
		    caracteresCaja[pos] = getCaracterCaja(lat[pos],pos);
		}
	    }
	}while( !listo );
    }

    class NoExisteCajaException extends Exception{
	public NoExisteCajaException(String mensaje){
	    super(mensaje);
	}
    }

    public static void main(String[] args){
	new Caja().setCaracteresCaja();
    }
}
