package practica_ipc1;

import java.util.Scanner;

public class Lectura {
    
        Scanner lectura =  new Scanner(System.in);
    
    public String LeerString(){
        
        String caracter;
        
        caracter = lectura.nextLine();
  
        return caracter;
    }
    
    public int LeerNum(){
         
        int numero;
            
        numero =  lectura.nextInt();
      
        return numero;

    }
    
}
