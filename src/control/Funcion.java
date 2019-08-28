package control;

/**
 *
 * @author JSRA
 */
import java.math.BigDecimal;
import java.util.*;

/**
 * La variable permitida es x. La expresión puede contener las constantes pi y
 * e. Los operadores válidos de la expresión son: OPERACIÓN OPERADOR suma +
 * resta - multiplicación * división / potencias ^ módulo % paréntesis ( )
 * logaritmo (base e) ln( ) logaritmo (base 10) log( ) valor absoluto abs( )
 * número aleatorio rnd( ) seno sen( ) coseno cos( ) tangente tan( ) secante
 * sec( ) cosecante csc( ) cotangente cot( ) signo sgn( ) arcoseno asen( )
 * arcocoseno acos( ) arcotangente atan( ) arcosecante asec( ) arcocosecante
 * acsc( ) arcocotangente acot( ) seno hiperbólico senh( ) coseno hiperbólico
 * cosh( ) tangente hiperbólica tanh( ) secante hiperbólica sech( ) cosecante
 * hiperbólica csch( ) cotangente hiperbólica coth( ) raices cuadradas sqrt( )
 * arcoseno hiperbólico asenh( ) arcocoseno hiperbólico acosh( ) arcotangente
 * hiperbólica atanh( ) arcosecante hiperbólica asech( ) arcocosecante
 * hiperbólica acsch( ) arcocotangente hiperbólica acoth( ) redondeo round( )
 *
 * Algunos ejemplos de expresiones válidas son:
 * x+cos(3)*tan(x^(2*pi*x-1))/acos(1/2) cosh(x)+abs(1-x^2)%3
 */
public class Funcion {

    //Atributos de clase
    //Guarda la última expresión que se tradujo a postfijo para poder evaluar en ella sin dar una nueva expresión
    private String ultimaParseada;
    private String funcion, expresionposFija;

    //------------------------------
    //Constructor
    public Funcion() {
        ultimaParseada = "0";
        funcion = "";
        expresionposFija = "";
    }

    //--------------------------
    //Constructor
    public Funcion(String expresion) {
        ultimaParseada = "0";
        funcion = expresion;
        expresionposFija = parsear(expresion);
    }
    //--------------------------

    public String getFuncion() {
        return funcion;
    }

    public String getExpresionposFija() {
        return expresionposFija;
    }

    /**
     * Método que transformará la expresión infija a postfija
     *
     * @param expresion El string con la expresión a parsear.
     * @return Un String con la expresión parseada en notación postfija.
     * @exception SintaxException Error de escritura en la expresión.
     */
    public String parsear(String expresion) throws SintaxException {
        Stack PilaNumeros = new Stack(); //Pila donde se guardarán los números al parsear
        Stack PilaOperadores = new Stack(); //Pila donde se guardarán los operadores al parsear
        String expr = quitaEspacios(expresion.toLowerCase());  //minusculas para evitar problemas
        String fragmento; //Guarda el fragmento de texto que se esté utilizando en el momento (ya sea un número, un operador, una función, etc.)
        int pos = 0, tamano = 0; //pos marca la posición del caracter que se está procesando actualmente en el String. tamano indica el tamaño del texto que se procesa en ese momento.
        byte cont = 1; //contador indica el número de caracteres que se sacan del string en un momento indicado, este no puede ser más de seis (la función con más caracteres tiene seis)
        //Este es un arreglo de Strings que guarda todas las funciones y expresiones permitidas, incluso números, y los acomoda en cada posición de acuerdo a su tamaño
        final String funciones[] = {"1 2 3 4 5 6 7 8 9 0 ( ) x e + - * / ^ %",//1
            "pi",//2
            "ln(",//3
            "log( abs( sen( sin( cos( tan( sec( csc( cot( sgn(",//4
            "rnd() asen( asin( acos( atan( asec( acsc( acot( senh( sinh( cosh( tanh( sech( csch( coth( sqrt(",//5
            "round( asenh( acosh( atanh( asech( acsch( acoth("};//6
        //Todas las funciones que trabajan como paréntesis de apertura están aquí.
        final String parentesis = "( ln log abs sen sin cos tan sec csc cot sgn asen asin"
                + " acos atan asec acsc acot senh sinh cosh tanh sech csch"
                + " coth sqrt round asenh asinh acosh atanh asech acsch acoth";
        /*
		 *Esta variable 'anterior' se utiliza para saber cuál había sido la última
		 *expresión parseada y verificar si hay un error en la expresión o si hay
		 *algún menos unario en la expresión, se utiliza:
		 *0 : no ha parseado nada
		 *1 : un número (número, pi, e, x)
		 *2 : un operador binario (+ - * / ^ %)
		 *3 : un paréntesis (( sen( cos( etc.)
		 *4 : cierre de paréntesis ())
		 *Si no se ha parseado nada puede ser cualquier cosa menos (+ * / ^ %)
		 *Si el anterior fue un número puede seguir cualquier cosa
		 *Si lo anterior fue un operador puede seguir cualquier cosa menos otro operador (con excepción de -)
		 *Si lo anterior fue un paréntesis puede seguir cualquier cosa menos (+ * / ^ %)
		 *Si lo anterior fue un cierre de paréntesis debe seguir un operador, un número (en cuyo caso hay un por oculto) u otro paréntesis (también hay un por oculto)
         */
        byte anterior = 0;

        try {
            while (pos < expr.length()) { //Haga mientras la posición sea menor al tamaño de la expresión
                tamano = 0;
                cont = 1;
                while (tamano == 0 && cont <= 6) { //Este while revisa si el pedazo del texto sacado concuerda con algo conocido
                    if (pos + cont <= expr.length() && funciones[cont - 1].contains(expr.substring(pos, pos + cont))) {
                        tamano = cont;
                    }
                    cont++;
                }

                if (tamano == 0) { //Si no encontró nada es por que hubo un error, se pone la ùltima parseada en cero y se lanza una excepción
                    ultimaParseada = "0";
                    throw new SintaxException("Error en la expresión! :(");
                } else if (tamano == 1) { //Si encontró algo de tamaño uno
                    if (esNumero(expr.substring(pos, pos + tamano))) { //Si es un número se encarga de sacarlo completo
                        if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                            sacaOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        fragmento = ""; //aquí se guardará el número sacado
                        do { //Hágalo mientras lo que siga sea un número o un punto o una coma
                            fragmento = fragmento + expr.charAt(pos);
                            pos++;
                        } while (pos < expr.length() && (esNumero(expr.substring(pos, pos + tamano))
                                || expr.charAt(pos) == '.' || expr.charAt(pos) == ','));
                        try { //Tratar de convertirlo en un número
                            Double.valueOf(fragmento);
                        } catch (NumberFormatException e) { //Si no pudo pasarlo a número hay un error
                            ultimaParseada = "0";
                            throw new SintaxException("Número mal digitado");
                        }
                        PilaNumeros.push(fragmento);
                        anterior = 1;
                        pos--;
                    } else if (expr.charAt(pos) == 'x' || expr.charAt(pos) == 'e') { //Si es un número conocido
                        if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                            sacaOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        PilaNumeros.push(expr.substring(pos, pos + tamano));
                        anterior = 1;
                    } else if (expr.charAt(pos) == '+' || expr.charAt(pos) == '*' || expr.charAt(pos) == '/' || expr.charAt(pos) == '%') { //Si es suma, multiplicación o división
                        //Hay error si antes de los operadores no hay nada, hay un paréntesis de apertura o un operador
                        if (anterior == 0 || anterior == 2 || anterior == 3) {
                            throw new SintaxException("Error en la expresión");
                        }

                        sacaOperadores(PilaNumeros, PilaOperadores, expr.substring(pos, pos + tamano));
                        anterior = 2;

                    } else if (expr.charAt(pos) == '^') { //Si es una potencia
                        //Hay error si antes de una potencia no hay nada, hay un paréntesis de apertura o un operador
                        if (anterior == 0 || anterior == 2 || anterior == 3) {
                            throw new SintaxException("Error en la expresión");
                        }

                        PilaOperadores.push("^");
                        anterior = 2;

                    } else if (expr.charAt(pos) == '-') { //Si es una resta
                        //si hay un menos unario
                        if (anterior == 0 || anterior == 2 || anterior == 3) {
                            PilaNumeros.push("-1");
                            sacaOperadores(PilaNumeros, PilaOperadores, "*");
                        } else {//si el menos es binario
                            sacaOperadores(PilaNumeros, PilaOperadores, "-");
                        }
                        anterior = 2;

                    } else if (expr.charAt(pos) == '(') {
                        //si hay una multiplicación oculta
                        if (anterior == 1 || anterior == 4) {
                            sacaOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        PilaOperadores.push("(");
                        anterior = 3;

                    } else if (expr.charAt(pos) == ')') {
                        //Antes de un cierre de paréntesis sólo puede haber un número u otro cierre de paréntesis, sino hay un error
                        if (anterior != 1 && anterior != 4) {
                            throw new SintaxException("Error en la expresión");
                        }

                        while (!PilaOperadores.empty() && !parentesis.contains((String) PilaOperadores.peek())) {
                            sacaOperador(PilaNumeros, PilaOperadores);
                        }
                        if (!((String) PilaOperadores.peek()).equals("(")) {
                            PilaNumeros.push((((String) PilaNumeros.pop()) + " " + ((String) PilaOperadores.pop())));
                        } else {
                            PilaOperadores.pop();
                        }
                        anterior = 4;
                    }
                } else if (tamano >= 2) { //Si lo encontrado es de tamaño dos o mayor (todas las funciones se manejan igual)
                    fragmento = expr.substring(pos, pos + tamano);
                    switch (fragmento) {
                        case "pi":
                            //Si es el número pi
                            if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                                sacaOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaNumeros.push(fragmento);
                            anterior = 1;
                            break;
                        case "rnd()":
                            //Si es la función que devuelve un número aleatorio (la única función que se maneja como un número)
                            if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                                sacaOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaNumeros.push("rnd");
                            anterior = 1;
                            break;
                        default:
                            //Si es cualquier otra función
                            if (anterior == 1 || anterior == 4) { //si hay una multiplicación oculta
                                sacaOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaOperadores.push(fragmento.substring(0, fragmento.length() - 1)); //Se guarda en la pila de funciones sin el paréntesis de apertura (en postfijo no se necesita)
                            anterior = 3;
                            break;
                    }
                }
                pos += tamano;
            }

            //Procesa al final
            while (!PilaOperadores.empty()) { //Saca todos los operadores mientras la pila no esté vacía
                if (parentesis.contains((String) PilaOperadores.peek())) {
                    throw new SintaxException("Hay un paréntesis de más");
                }
                sacaOperador(PilaNumeros, PilaOperadores);
            }

        } catch (EmptyStackException e) { //Si en algún momento se intenta sacar de la pila y está vacía hay un error
            ultimaParseada = "0";
            throw new SintaxException("Expresión mal digitada");
        }

        ultimaParseada = ((String) PilaNumeros.pop()); //Se obtiene el resultado final

        if (!PilaNumeros.empty()) { //Si la pila de números no quedó vacía hay un error
            ultimaParseada = "0";
            throw new SintaxException("Error en la expresión");
        }

        return ultimaParseada; //Se devuelve el resultado evaluado
    }
    //-------------------------------------------------

    /**
     * Esta es la función que evalúa una expresión parseada en un valor double.
     *
     * @param expresionParseada Esta es una expresión en notación postfija (se
     * puede obtener con la función parsear).
     * @param x El valor double en el que se evaluará la función.
     * @return El resultado (un valor double) de evaluar x en la expresión.
     * @exception ArithmeticException Error al evaluar en los reales.
     */
    public double f(String expresionParseada, double x) throws ArithmeticException {
        Stack pilaEvaluar = new Stack(); //Pila de doubles para evaluar
        double a, b; //Estos valores son los que se van sacando de la pila de doubles
        StringTokenizer tokens = new StringTokenizer(expresionParseada); //La expresión partida en tokens
        String tokenActual; //El token que se procesa actualmente

        try {
            while (tokens.hasMoreTokens()) { //Haga mientras hayan más tokens
                tokenActual = tokens.nextToken();
                /*
                 *La idea aquí es sacar el token que sigue y verificar qué es ese
                 *token y manejarlo de manera:
                 *Si es un número se introduce en la pila de números
                 *Si es una función se sacan el valor o los valores necesarios de la pila
                 *de números y se mete el valor evaluado en la función correspondiente (u
                 *operador correspondiente).
                 */
                switch (tokenActual) {
                    case "e":
                        //Si es el número e
                        pilaEvaluar.push(Math.E);
                        break;
                    case "pi":
                        //Si es el número pi
                        pilaEvaluar.push(Math.PI);
                        break;
                    case "x":
                        //Si es una x se introduce el valor a evaluar por el usuario
                        pilaEvaluar.push(x);
                        break;
                    case "+":
                        //Si es una suma se sacan dos números y se suman
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a + b);
                        break;
                    case "-":
                        //Si es resta se sacan dos valores y se restan (así con todos los operadores)
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a - b);
                        break;
                    case "*":
                        //Multiplicación
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a * b);
                        break;
                    case "/":
                        //División
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a / b);
                        break;
                    case "^":
                        //Potencia
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.pow(a, b));
                        break;
                    case "%":
                        //Resto de la división entera
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a % b);
                        break;
                    case "ln":
                        //Si es logaritmo natural sólo se saca un valor de la pila y se evalúa
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a));
                        break;
                    case "log":
                        //Logaritmo en base 10
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a) / Math.log(10));
                        break;
                    case "abs":
                        //Valor absoluto
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.abs(a));
                        break;
                    case "rnd":
                        //Un número a random simplemente se mete en la pila de números
                        pilaEvaluar.push(Math.random());
                        break;
                    case "sen":
                    case "sin":
                        //Seno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.sin(a));
                        break;
                    case "cos":
                        //Coseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.cos(a));
                        break;
                    case "tan":
                        //Tangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.tan(a));
                        break;
                    case "sec":
                        //Secante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.cos(a));
                        break;
                    case "csc":
                        //Cosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.sin(a));
                        break;
                    case "cot":
                        //Cotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.tan(a));
                        break;
                    case "sgn":
                        //Signo
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(sgn(a));
                        break;
                    case "asen":
                    case "asin":
                        //Arcoseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.asin(a));
                        break;
                    case "acos":
                        //Arcocoseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.acos(a));
                        break;
                    case "atan":
                        //Arcotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.atan(a));
                        break;
                    case "asec":
                        //Arcosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.acos(1 / a));
                        break;
                    case "acsc":
                        //Arcocosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.asin(1 / a));
                        break;
                    case "acot":
                        //Arcocotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.atan(1 / a));
                        break;
                    case "senh":
                    case "sinh":
                        //Seno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) - Math.exp(-a)) / 2);
                        break;
                    case "cosh":
                        //Coseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) + Math.exp(-a)) / 2);
                        break;
                    case "tanh":
                        //tangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) - Math.exp(-a)) / (Math.exp(a) + Math.exp(-a)));
                        break;
                    case "sech":
                        //Secante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(2 / (Math.exp(a) + Math.exp(-a)));
                        break;
                    case "csch":
                        //Cosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(2 / (Math.exp(a) - Math.exp(-a)));
                        break;
                    case "coth":
                        //Cotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) + Math.exp(-a)) / (Math.exp(a) - Math.exp(-a)));
                        break;
                    case "asenh":
                    case "asinh":
                        //Arcoseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a + Math.sqrt(a * a + 1)));
                        break;
                    case "acosh":
                        //Arcocoseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a + Math.sqrt(a * a - 1)));
                        break;
                    case "atanh":
                        //Arcotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((1 + a) / (1 - a)) / 2);
                        break;
                    case "asech":
                        //Arcosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((Math.sqrt(1 - a * a) + 1) / a));
                        break;
                    case "acsch":
                        //Arcocosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((sgn(a) * Math.sqrt(a * a + 1) + 1) / a));
                        break;
                    case "acoth":
                        //Arcocotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((a + 1) / (a - 1)) / 2);
                        break;
                    case "sqrt":
                        //Raíz cuadrada
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.sqrt(a));
                        break;
                    case "round":
                        //Redondear
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(new Double(Long.toString(Math.round(a))));
                        break;
                    default:
                        //si es otra cosa tiene que ser un número, simplemente se mete en la pila
                        pilaEvaluar.push(Double.valueOf(tokenActual));
                        break;
                }
            }//while
        } catch (EmptyStackException e) { //Si en algún momento se acabó la pila hay un error
            throw new ArithmeticException("Expresión mal parseada");
        } catch (NumberFormatException e) { //Si hubo error al traducir un número hay un error
            throw new ArithmeticException("Expresión mal digitada");
        } catch (ArithmeticException e) { //Cualquier otro error de división por cero o logaritmo negativo, etc.
            throw new ArithmeticException("Valor no real en la expresión");
        }

        a = ((Double) pilaEvaluar.pop()); //El valor a devolver
        //Si todavía quedó otro valor en la pila hay un error
        if (!pilaEvaluar.empty()) {
            throw new ArithmeticException("Expresión mal digitada");
        }

        return a;
    }

    //----------------------------------funcion f
    /**
     * Esta función evalua la última expresión parseada en el valor x.
     *
     * @param x valor a evaluar.
     * @return la evaluación del polinomio en el valor x.
     */
    public double f(double x) throws ArithmeticException {
        return f(ultimaParseada, x);

    }
    //-------------------------------

    //sacaOperador es una función que se encarga de sacar un operador de la pila y manejarlo de manera apropiada, ya sea un operador unario o binario
    private void sacaOperador(Stack Numeros, Stack operadores) throws EmptyStackException {
        String operador, a, b;
        final String operadoresBinarios = "+ - * / ^ %"; //Lista de los operadores binarios

        try {
            operador = (String) operadores.pop(); //Saca el operador que se debe evaluar

            if (operadoresBinarios.contains(operador)) { //Si es un operador binario saca dos elementos de la pila y guarda la operación
                b = (String) Numeros.pop();
                a = (String) Numeros.pop();
                Numeros.push((a + " " + b + " " + operador));
            } else { //Sino sólo saca un elemento
                a = (String) Numeros.pop();
                Numeros.push((a + " " + operador));
            }
        } catch (EmptyStackException e) {
            throw e;
        }
    }
    //---------------------------------------------

    //sacaOperadores saca los operadores que tienen mayor prioridad y mete el nuevo operador
    private void sacaOperadores(Stack PilaNumeros, Stack PilaOperadores, String operador) {
        //Todas las funciones que se manejan como paréntesis de apertura
        final String parentesis = "( ln log abs sen sin cos tan sec csc cot sgn asen asin acos "
                + "atan asec acsc acot senh sinh cosh tanh sech csch coth "
                + "sqrt round asenh asinh acosh atanh asech acsch acoth";

        //mientras la pila no esté vacía, el operador que sigue no sea un 
        //paréntesis de apertura, la longitud del operador sea uno (para que sea un operador), y la prioridad indique
        //que tiene que seguir sacando elementos
        while (!PilaOperadores.empty() && !parentesis.contains((String) PilaOperadores.peek())
                && ((String) PilaOperadores.peek()).length() == 1
                && prioridad(((String) PilaOperadores.peek()).charAt(0)) >= prioridad(operador.charAt(0))) {
            sacaOperador(PilaNumeros, PilaOperadores); //Saca el siguiente operador
        }
        PilaOperadores.push(operador);//Al final mete el nuevo operador luego de sacar todo lo que tenía que sacar.
    }
    //---------------------------------

    //Método que devuelve la prioridad de una operacion     
    private int prioridad(char s) {
        switch (s) {
            //Si es una suma o una resta devuelve cero
            case '+':
            case '-':
                return 0;
            //Si es multiplicación, división o resto de división devuelve uno
            case '*':
            case '/':
            case '%':
                return 1;
            //Si es potencia devuelve dos
            case '^':
                return 2;
            default:
                break;
        }

        return -1; //Si no fue nada de lo anterior devuelve -1
    }
    //------------------------------------------

    //Método que pregunta si un caracter es un número o no     
    private boolean esNumero(String s) {
        return s.compareTo("0") >= 0 && s.compareTo("9") <= 0; //Si el caracter está entre 0 y 9 (si es un número)
    }
    //--------------------------------

    //Quita los espacios de la cadena
    private String quitaEspacios(String cadena) {
        String unspacedString = "";	//Variable donde lee la función

        for (int i = 0; i < cadena.length(); i++) {	//Le quita los espacios a la espresión que leyó
            //Si el caracter no es un espacio lo pone, sino lo quita.
            if (cadena.charAt(i) != ' ') {
                unspacedString += cadena.charAt(i);
            }
        }

        return unspacedString;
    }
    //------------------------------------

    //Devuelve el signo del número dad0
    private double sgn(double a) {
        //Si el número es negativo devuelve -1
        if (a < 0) {
            return -1;
        } else if (a > 0) {//Si es positivo devuelve 1
            return 1;
        } else {//Si no es negativo ni positivo devuelve cero
            return 0;
        }
    }
    //-------------------------------------------

    //Clase privada SintaxException
    //Esta es la excepción que se lanza si hay algún error sintáctico en la expresión
    private class SintaxException extends ArithmeticException { //En realidad extiende la ArithmeticException

        public SintaxException() { //Si se llama con el mensaje por defecto
            super("Error de sintaxis en el polinomio"); //El constructor llama a la clase superior
        }

        public SintaxException(String e) { //si se llama con otro mensaje
            super(e); //El constructor llama a la clase superior
        }
    }
    //--------------------------------------------

    //Método que redondea el un cadena double 
    public Double redondeo(String resultado, int redondeo) {
        BigDecimal bd = new BigDecimal(resultado);
        bd = bd.setScale(redondeo, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
    //------------------------

////    pruebas
//    public static void main(String[] args) {
//        Funcion p2;
//        Scanner s = new Scanner(System.in);
//        String expresion = "";
//        System.out.println("Escribe la expresión: ");
//            expresion = s.nextLine();
//            p2 = new Funcion(expresion);
//        do {
//            
//            System.out.println("Escribe un valor para x: ");
//            Double x = s.nextDouble();
//            System.out.println("Expresión f(x): " + p2.getFuncion());
//            System.out.println("Expresión posfija de f(x): " + p2.getExpresionposFija());
//            System.out.println("f(" + x + ")= " + p2.f(x) + "\n");
//        } while (!expresion.equals("0"));
//
//    }
////    -------------------------------
}
//---------------------------------------
