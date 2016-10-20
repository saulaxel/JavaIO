/**
 * Universidad Nacional Autonoma de MExico
 * IngenierIa en computaciOn
 * Ingeniero MartInez Ortiz SaUl Axel
 * Clases personales de entrada y salída a pantalla
 * Ultima modificaciOn: 19 de octubre de 2016
 * DescripciOn: Clase simplificada de entrada
 * Recursos o fuentes:
    DocumentaciOn de java
 **/

/**
 * Clase Escritor, que se encarga de imprimir a pantalla de la 
 * forma estandar además de una que otra forma curiosa
 */
public class Escritor{
    /**
     * Constante que contiene el común de una terminal recién abierta
     */
    public static final int ANCHO_PANTALLA_NORMAL = 80;
    /**
     * Constante con el alto común de una terminal recién abierta 
     */
    public static final int ALTO_PANTALLA_NORMAL = 24;
    
    /**
     * Cadena que esta clase imprime al principio de cada línea
     */
    public String p; // Prefijo para los mensajes
    /**
     * Objeto caja usado para imprimir encerrando el texto en cajas
     * de caracteres Unicode
     */
    public Caja caja;

    /**
     * Constructor que recibe e inicializa los dos atributos 
     * variables de la clase
     * @param p Cadena de prefijo para la impresión
     * @param c Objeto Caja usado para imprimir en cajas Unicode
     */
    public Escritor(String p, Caja c){
	this.p = p;
	this.caja = c;
    }

    /**
     * Constructor que recibe e inicializa la cadena que sirve 
     * de prefijo
     * @param p Cadena usada como prefijo para la impresión
     */
    public Escritor(String p){
	this.p = p;
	this.caja = new Caja();
    }

    /**
     * Constructor que solo recibe el objeto Caja, inicializa la 
     * cadena de prefijo en un único espacio
     */
    public Escritor(Caja c){
	p = " ";
	this.caja = c;
    }

    /**
     * Constructor que recibe un entero representante de un número de
     * caja predefinido, inicializa el prefijo a un único espacio e
     * intena crear la caja cuyo número se paso en el constructor
     */
    public Escritor( int numeroCaja ){
	p = " ";
	try{
	    caja = new Caja( numeroCaja );
	}catch(Caja.NoExisteCajaException nece){
	    caja = new Caja();
	}
    }
    
    /**
     * Constructor vacio, inicializa el prefijo a un espacio y el objeto
     * Caja a la caja estandar
     */
    public Escritor(){
	p = " ";
	caja = new Caja();
    }

    public void escribe(Object o){
	System.out.print(p + o);
    }

    public void escribeLinea(Object o){
	System.out.println(p + o);
    }

    /**
     * Método que dibuja un conjunto de cadenas
     * @param cadenas Grupo de cadenas a dibujar en columnas
     */
    public String parrafosEnColumnas(String[] cadenas){
	String[][] c; // C es nuevamente un alias de "cadenas" solo que
		      // este en especIfico se refiere a la matrIz cuadrada
		      // formada despuEs de subdividir estas en cada 
		      // caracter de salto de lInea
	String dibujo = ""; // Valor que serA devuelto por la funciOn
	int numCadenas = cadenas.length; // NUmero de cadenas recibidas
	int numRenglones = 0; // MAximo de renglones (cadena mAs larga)
	int[] largo; // Arraglo de largos de cada renglOn de las cadenas

	largo = new int[numCadenas];
	c = new String[numCadenas][];
	int ren = 0;
	for(int i = 0; i < numCadenas; ++i){
	    largo[i] = cadenas[i].substring(0,cadenas[i].indexOf('\n')).length();
	    c[i] = cadenas[i].split("\n");
	    ren = c[i].length;
	    if( ren > numRenglones ){
		numRenglones = ren;
	    }
	}
	
	int i;
	dibujo += p+caja.getPos(2);
	for(i = 0; i+1 < numCadenas; ++i){
	    dibujo += repite(caja.getPos(0),largo[i]+2) + caja.getPos(8);
	}
	dibujo += repite(caja.getPos(0),largo[i]+2) + caja.getPos(3) + "\n";
	i = 0;
	while( i < numRenglones ){
	    dibujo += p+caja.getPos(1);
	    for(int j = 0; j < numCadenas; ++j){
		if( j<c.length && i< c[j].length &&c[j][i] != null ){
		    dibujo += " " +c[j][i] + " " + caja.getPos(1);
		}
	    }
	    dibujo += '\n';
	    ++i;
	}
	dibujo += p+caja.getPos(4);
	for(i = 0; i+1 < numCadenas; ++i){
	    dibujo += repite(caja.getPos(0),largo[i]+2) + caja.getPos(9);
	}
	dibujo += repite(caja.getPos(0),largo[i]+2)+caja.getPos(5)+"\n";
	return dibujo;
    }

    public String parrafoEnCaja(String s, int ancho){
	String dibujo = "";
	String cadenaCortada,cadenaRestante = s;
	int indiceCorte;
	
	dibujo += caja.getPos(2) + repite(caja.getPos(0),ancho) + caja.getPos(3) + "\n"; 
	while(cadenaRestante != ""){
	    if( (indiceCorte = cadenaRestante.indexOf('\n')) < ancho -1 && indiceCorte != -1 ){
		cadenaCortada = cadenaRestante.substring(0, indiceCorte);
		cadenaRestante = cadenaRestante.substring(indiceCorte, cadenaRestante.length());
	    }else if( cadenaRestante.length() > ancho ){
		cadenaCortada = cadenaRestante.substring(0,ancho - 1);
		cadenaRestante = cadenaRestante.substring(ancho, cadenaRestante.length());
	    }else{
		cadenaCortada = cadenaRestante.substring(0,cadenaRestante.length() - 1);
		cadenaRestante = "";
	    }
	    dibujo += caja.getPos(1);
	    dibujo += cadenaCortada + repite(' ',ancho - cadenaCortada.length()) + caja.getPos(1) + "\n"; 
	}
	dibujo += caja.getPos(4) + repite(caja.getPos(0),ancho) + caja.getPos(5) + "\n";

	return dibujo;
    }

    public String parrafosEnCaja(String[] cadenas,int ancho){
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
	res += p+caja.getPos(2)+repite(caja.getPos(0),ancho)+caja.getPos(3)+"\n";
	i = 0;
	while( i < numRenglones ){
	    res += p+caja.getPos(1);
	    for(int j = 0; j < numCadenas; ++j){
		if( j<c.length && i< c[j].length &&c[j][i] != null ){
		    res += " " +c[j][i];
		}
	    }
	    res +=  " " + caja.getPos(1) + "\n";
	    ++i;
	}
	res += p+caja.getPos(4)+repite(caja.getPos(0),ancho)+caja.getPos(5)+"\n";
	return res;
    } 


    public void imprimeEnCaja(){

    }
    
    public void saltarLinea(){
	System.out.println();
    }

    public  void saltarLinea(Number n){
	System.out.print(repite('\n',n));
    }

    public static String repite(char c, Number veces){
	String caracterRepetido = "";
	int n = (int) veces;
	for( int i = 0; i < n; ++i ){
	    caracterRepetido += "" +c;
	}

	return caracterRepetido;
    }

    public static String repite(String s, Number veces){
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
	    s.caja.getPos(2) +
	    s.caja.getPos(0) +
	    s.caja.getPos(3) + "\n" +
	    s.caja.getPos(1) + " " +
	    s.caja.getPos(1) + "\n" + 
	    s.caja.getPos(4) +
	    s.caja.getPos(0) +
	    s.caja.getPos(5)
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
	    s.caja.setCaracteresCaja(i);
	    System.out.println(
		    s.parrafosEnColumnas(cadena)
	    );
	}
	s.caja.setCaracteresCaja(8);
	s.caja.setCaracteresCaja(
		' ', s.caja.getCaracterCaja(8,1),
		s.caja.getCaracterCaja(8,3), s.caja.getCaracterCaja(8,2),
		s.caja.getCaracterCaja(8,5), s.caja.getCaracterCaja(8,4),
		' ',' ',' ',' ',
		s.caja.getPos(10)
	);
	s.p = "    ";
	System.out.println(
		s.parrafosEnCaja(cadena, 72) + "\n" +
		s.parrafosEnColumnas(cadena)
	);

	System.out.println(s.parrafoEnCaja("Ispusadf asdfadsfjdaskfjaksdjflk jlkjalksdjflkjakljfklj lkajlkdsjflka" +
	"asdfdafdasfasdfkjsadkjflkdsajflkjsadlkfjñlkasjdflkcjdsalkfjlaksjflkjdsklfjadklj"+
	"asdfdskfjsaldkjfdlkdsajlfkjadslkjfdlkadsjdflkjadslkfjlakjfdlkajslkdjflksajflkj" +
	"asdfjsadkfjlsdakjdflksajlkfjadslkfdjlksadjflkdsajlkfjdsalkfjlkdajsflkjalksdjflkjakls",60));

	System.out.println(s.parrafosEnCaja(cadena,72));
    }
}
