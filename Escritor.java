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
    public static final int ANCHO_PANTALLA_NORMAL = 80;
    public static final int ALTO_PANTALLA_NORMAL = 24;

    public Caja cj;

    public Escritor(){
	cj = new Caja();
    }
    
    public Escritor( int numeroCaja ){
	try{
	    cj = new Caja( numeroCaja );
	}catch(Exception e){
	    e.getMessage();
	}
    }

    public void escribir(Object o){
	System.out.print(o);
    }

    public void escribirLinea(Object o){
	System.out.println(o);
    }

    public String dibujaCaja(String[] cadenas,int[] tamanos){
	String[][] c;
	String res = "";
	int numCadenas = cadenas.length;
	int numRenglones = 0;

	c = new String[numCadenas][];
	int ren = 0;
	for(int i = 0; i < numCadenas; ++i){
	    c[i] = cadenas[i].split("\n");
	    ren = c[i].length;
	    if( ren > numRenglones ){
		numRenglones = ren;
	    }
	}
	
	int i;
	res += cj.getPos(2);
	for(i = 0; i+1 < numCadenas; ++i){
	    res += repetir(cj.getPos(0),tamanos[i]+2) + cj.getPos(8);
	}
	res += repetir(cj.getPos(0),tamanos[i]+2) + cj.getPos(3) + "\n";
	i = 0;
	while( i < numRenglones ){
	    res += cj.getPos(1);
	    for(int j = 0; j < numCadenas; ++j){
		if( j<c.length && i< c[j].length &&c[j][i] != null ){
		    res += " " +c[j][i] + " " + cj.getPos(1);
		}
	    }
	    res += '\n';
	    ++i;
	}
	res += cj.getPos(4);
	for(i = 0; i+1 < numCadenas; ++i){
	    res += repetir(cj.getPos(0),tamanos[i]+2) + cj.getPos(9);
	}
	res += repetir(cj.getPos(0),tamanos[i]+2) + cj.getPos(5) + "\n";
	return res;
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
	    caracterRepetido += "" +c;
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

    public static void main(String[] args){
	Escritor s = new Escritor(2);

	System.out.println(
	    "" +
	    s.cj.getPos(2) +
	    s.cj.getPos(0) +
	    s.cj.getPos(3) + "\n" +
	    s.cj.getPos(1) + " " +
	    s.cj.getPos(1) + "\n" + 
	    s.cj.getPos(4) +
	    s.cj.getPos(0) +
	    s.cj.getPos(5)
	);

	String[] cadena = new String[] {
	    "AAAAAAAAAAAAXXAAA\n" +
	    "AAAAAAAAAAAAXXAAA\n" +
	    "AAAAAAAAAAAAXXAAA\n" +
	    "AAAAAAAAAAAAXXAAA\n",
	    "BBBBBBBBBBBBBXXBB\n" +
	    "BBBBBBBBBBBBBXXBB\n" +
	    "BBBBBBBBBBBBBXXBB\n" +
	    "BBBBBBBBBBBBBBXXB\n",
	    "CCCCCCCCCCXXXXCC\n" +
	    "CCCCCCCCCCXXXXCC\n" +
	    "CCCCCCCCXXCCXXCC\n" +
	    "CCCCCCCCCXXCXXCC\n",
	    "DDDDDDDDDDXXDDDDC\n" +
	    "DDDDDDDDDXXDDDDDC\n" +
	    "DDDDDDDDXXDDDDDDC\n" +
	    "DDDDDDDXXDDDDDDdD\n" 
	};


	for(int i = 1; i < 10; ++i){
	    System.out.println("Caja: " + i);
	    s.cj.setCaracteresCaja(i);
	    System.out.println(
		    s.dibujaCaja(cadena,
		    new int[] {17,17,16,17})
	    );
	}
	s.cj.setCaracteresCaja(8);
	s.cj.setCaracteresCaja(
		' ', s.cj.getCaracterCaja(8,1),
		s.cj.getCaracterCaja(8,3), s.cj.getCaracterCaja(8,2),
		s.cj.getCaracterCaja(8,5), s.cj.getCaracterCaja(8,4),
		' ',' ',' ',' ',
		s.cj.getPos(10)
	);

	System.out.println(
		s.dibujaCaja(cadena,
		new int[] {17,17,16,17})
	);
	
    }
}
