/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDCA;
import java.util.Scanner;
import modelo.tablas_datos.TablaDatosDCA;

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
                //byte tratamientos = 2;
                byte tratamientos = sc.nextByte();
                System.out.println("digite numero de replicas");
               // byte replicas = 3;
                byte replicas = sc.nextByte();
                
                
                float tabladatos[][] = new float[tratamientos][replicas];
                //float tabladatos[][] = new float[3][3];
                
                for(byte x=0; x<tratamientos; x++){
                    for(byte y=0; y<replicas; y++){
                        
                        System.out.println("Digite el valor del tratamiento "+(x+1)+" en la replica "+(y+1));
                        float valor = sc.nextFloat();
                        //System.out.println("valor "+valor);
                        //System.out.println("Tabla datos 00 "+tabladatos[0][0]);
                        //tabladatos[tratamientos][replicas] = valor;
                        tabladatos[x][y] = valor;
                    }
                }
                ControladorDCA controlador = new ControladorDCA(tratamientos, replicas, tabladatos);
                //TablaDatosDCA tabla = new TablaDatosDCA(tratamientos, replicas, tabladatos);
                System.out.println("grados liberta tratamiento "+ controlador.datosTratamiento().getGrados_libertad());
            break;
        }
    }
    
}
