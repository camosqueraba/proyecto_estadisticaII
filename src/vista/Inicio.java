/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Inicio {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Selecione el diseño");
        System.out.println("1: DCA");
        System.out.println("2: DBA");
        
        
        byte  opcion = sc.nextByte();
        
        switch (opcion){
            
            case 1:
                
                System.out.println("digite numero de tratamientos");
                byte tratamientos = sc.nextByte();
                System.out.println("digite numero de replicas");
                byte replicas = sc.nextByte();
                
                float tabladatos[][] = new float[tratamientos][replicas];
                
                for(byte x=0; x<tratamientos; x++){
                    for(byte y=0; y<replicas; y++){
                        
                        System.out.println("Digite el valor del tratamiento "+(x+1)+" en la replica "+(y+1));
                        float valor = sc.nextFloat();
                        
                    }
                }
        }
    }
    
}
