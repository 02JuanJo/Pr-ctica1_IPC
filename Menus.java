package practica_ipc1;

import java.util.Random;
import java.util.Scanner;

public class Menus {
    Lectura lectura = new Lectura();
   
    String [] lista;
    String sopa[][];
    int numero;
    int a = 1;
    int b = 1;
    int c = 1;
    String player;
    int tablero;
    
    //int fila, columna = tablero;
    
    public void MenuPrincipal() throws InterruptedException{
        
        int principal = 0;
    do{
               
        System.out.println("\n\n\n\n\n");
        System.out.println("S O P A   D E   L E T R A S");
        System.out.println(" ");
        System.out.println("Menú");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Historial de Partidas");
        System.out.println("3. Puntuaciones altas");
        System.out.println("4. Jugadores que han perdido");
        System.out.println("5. Información del Desarrollador");
        System.out.println("6. Salir");
        principal = lectura.LeerNum();
        
        switch(principal){
            
            case 1: 
                System.out.println("\n\n\n\n\n");
                System.out.println("\n\n\n\n\n");   
                Thread.sleep (1000);
                Player();
                Tablero();
                SubmenuPartida();
                System.out.println("\n\n\n\n\n");       
                break;  
                           
            case 2: 
                System.out.println("\n\n\n\n\n");
                System.out.println("\n\n\n\n\n");
                System.out.println("H I S T O R I A L");
                break;
                
            case 3: 
                System.out.println("\n\n\n\n\n");
                System.out.println("\n\n\n\n\n");
                System.out.println("P U N T U A C I O N E S   A L T A S");
                break;              
                
            case 4: 
                System.out.println("\n\n\n\n\n");
                System.out.println("\n\n\n\n\n");
                System.out.println("Jugadores que han perdido.");
                break;
                
            case 5: 
                System.out.println("\n\n\n\n\n");
                System.out.println("\n\n\n\n\n");
                System.out.println("D E S A R R O L L A D O R");
                System.out.println("NetBeans IDE 8.2\n"+"Java: 1.8.0_111\n" +
                "Runtime: Java SE Runtime Environment 1.8.0_111-b14" + "JDK 1.8");
                break;
                
            case 6: 
                System.exit(0);
                break;
        }
    }while(principal>6||principal<1);   
    }
    
    public void SubmenuPartida()throws InterruptedException{
        
        int submenu = 0; 
    do{
        System.out.println("\n\n\n\n\n");
        System.out.println("N U E V A   P A R T I D A");
        System.out.println("1. Banco de Palabras");
        System.out.println("2. Jugar");
        System.out.println("3. Terminar Partida");
        submenu = lectura.LeerNum();

        switch(submenu){

            case 1: 
                System.out.println("\n\n\n\n\n");
                SubmenuPalabras();
            break;
         
            case 2:
                System.out.println("IMPRESION DE TABLERO");
                VisualizarTablero();
            break;

            case 3:
                MenuPrincipal();    
            break;

            default:
                System.out.println(" ");
            break;
        }
    }while(submenu>3||submenu<1);     
    }
    
    public void SubmenuPalabras()throws InterruptedException{
    
        int subsubmenu = 0;
    do{
        System.out.println("P A L A B R A S");
        System.out.println("1. Insertar Palabra");
        System.out.println("2. Modificar Palabra");
        System.out.println("3. Eliminar Palabra");
        System.out.println("4. Regresar");
        subsubmenu = lectura.LeerNum();

        switch(subsubmenu){

            case 1: 
                System.out.println("\n\n\n\n\n");
                System.out.println("A G R E G A R");
                Agregar();
                SubmenuPalabras();
            break;

            case 2:
                System.out.println("\n\n\n\n\n");
                System.out.println("M O D I F I C A R");
                Modificar();
                SubmenuPalabras();
            break;

            case 3:
                System.out.println("\n\n\n\n\n");
                System.out.println("E L I M I N A R");
                Eliminar();
                SubmenuPalabras();
            break;

            case 4:
                System.out.println("\n\n\n\n\n");
                SubmenuPartida();
            break;
                        
            default:
            break;
        }
    }while(subsubmenu>3||subsubmenu<1);
    }

    public void Agregar() throws InterruptedException{
    
        System.out.println("Cuantas palabras desea ingresar (Max. 20)");
        numero = lectura.LeerNum();
        String texto = lectura.LeerString();
        lista = new String [numero];
        
        
    if(numero<20&&numero>=1){ 
        for (int i = 0; i<lista.length; i++){ 
            System.out.println("\n");
            System.out.println("Ingrese una palabra (Entre 5 y 10 caracteres)");
            lista[i] = lectura.LeerString();
            
            if(lista[i].length()>=5 && lista[i].length()<=10){                
                System.out.println("Guardando...");
                System.out.println("\n");  
            }else{
                System.out.println("No se puede guardar, rango no específicado.");
                System.out.println("\n\n");
                i = i - 1;
            }
        }        
        
            System.out.println("La lista de palabras es: ");
            for(int i = 0; i < lista.length; i++){
            System.out.println((a++)+". "+lista[i]+" "); 
            }
            Thread.sleep (2000);
            System.out.println("\n\n\n\n");
            
    }else{
        System.out.println("Dato fuera del límite..");
        Thread.sleep (2000);
        System.out.println("\n\n\n\n");                 
        }
    }  
    
    public void Modificar() throws InterruptedException{
        String palabra;
        String cambio ="";
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra a modificar:");
        palabra = scanner.nextLine();
        boolean validacion = false; 
        for (int i = 0; i<lista.length; i++){ 
            if(lista[i].equals(palabra)){
                System.out.println("Ingrese la palabra que sustituirá la anterior..");
                cambio = scanner.nextLine();
                                 
                if(cambio.length()>=5 && cambio.length()<=10){
                    System.out.println("Guardando...");
                    lista[i]=cambio;
                    System.out.println("\n");      
                    validacion = true;
                }else{
                    System.out.println("No se puede guardar, rango no específicado.");
                    System.out.println("\n\n");
                    i = i - 1;
                }
           
                
            } 
        }
        
        if(validacion==false){
                System.out.println("Palabra no encontrada.");
        }

    }
    
    public void Eliminar() throws InterruptedException{
        String eliminada;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra que será eliminada..");
        eliminada = scanner.nextLine();
        
        for (int i = 0; i<lista.length; i++){ 
            if(lista[i].equals(eliminada)){
                lista[i] = null;
                System.out.println("Palabra eliminada éxitosamente..");
                System.out.println("\n\n\n\n");                
            }
        }
            System.out.println("La lista de palabras es: ");
            for(int i = 0; i < lista.length; i++){
            System.out.println((c++)+". "+lista[i]+" "); 
            }
            Thread.sleep (2000);
            System.out.println("\n\n\n\n");
    }
    
    public void Player(){
    Scanner sr = new Scanner (System.in);
    System.out.println("Ingresa tu nombre: ");
    player = sr.nextLine();
    }
    
    public void Tablero(){
    Scanner sr = new Scanner (System.in);
    System.out.println("Ingresa el tamaño del tablero cuadrado (Min. 10): ");
    tablero = sr.nextInt();
    
        if(tablero>=10){
            System.out.println("\n\n");
            System.out.println("Guardando...");
            System.out.println("El nombre del jugador es " + player);
            System.out.println("El tamaño del tablero es (" + tablero + ", " + tablero + ")");
            
        }else{
            do{
                System.out.println("Ingresa el tamaño del tablero cuadrado (Min. 10): ");
                tablero = sr.nextInt();
                System.out.println("\n\n");
                System.out.println("Guardando...");
                System.out.println("El nombre del jugador es " + player);
                System.out.println("El tamaño del tablero es (" + tablero + ", " + tablero + ")");
                }while(tablero<10);
    
        }
        String sopa[][] = new String [tablero][tablero];
    }
    
    
    public void VisualizarTablero(){
        for(int i = 0; i<=tablero;i++){
            System.out.print("|");
            for(int j = 0; j<=tablero; j++){
                System.out.print(sopa[i][j]+"|");                
            }
            System.out.println();
        }
    }
    
    
    /*public void Horizontal(String sopa[][], String lista[], int tablero){
        for(int i = 0; i<lista.length;i++){
            //sopa[tablero][tablero+i]=""+lista.charAt(i);
            
        }
    }
    */
    /*public void Vertical(String sopa[][], String palabra, int fila, int columna){
        for(int i = 0; i<lista.length;i++){
            sopa[fila+i][columna]=""+palabra.charAt(i);
            
        }
    } */   
    
    
    /*public void Random(){
        int filas = 5;
        int columnas = 10;

        char matriz [][] = new char[filas][columnas];
        Random random = new Random();
        int posFila = random.nextInt(filas); //Asigna un numero aleatorio entre 0 y (filas - 1)
        int posColumna = random.nextInt(columnas); //Asigna un numero aleatorio entre 0 y (columnas - 1)

        //Ya con ambos numeros aleatorios ya podes colocar el conjunto de caracteres.
        //Para la posicion horizonta o vertical podrias hacer lo mismo

        int orientacion = random.nextInt(2); //Asigna un numero aleatorio entre 0 y 1
        if(orientacion = 0 ){
        //aqui el codigo para insertar horizontal
        }else{
        //aqui el codigo para insertar vertical
}*/
    
    
    }
    
    

    
    




// Se coloca "null" en lugar de un espacio en blanco (en teoría si elimina)