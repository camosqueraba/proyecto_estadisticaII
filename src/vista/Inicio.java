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
                byte tratamientos = 9 ;
                //byte tratamientos = sc.nextByte();
                System.out.println("digite numero de replicas");
                byte replicas = 4;
                //byte replicas = sc.nextByte();
                
                
                //float tabladatos[][] = new float[tratamientos][replicas];
                //float tabladatos[][] = new float[3][4];
                
               float tabladatos[][] = {{34,35,37,36},{72,109,153,86},{76,80,47,42},{157,218,60,224},{59,113,63,92},{69,149,66,135},{55,140,35,92},{235,123,71,142},{76,139,180,152}};
               
                /*for(byte x=0; x<tratamientos; x++){
                    for(byte y=0; y<replicas; y++){
                        
                        System.out.println("Digite el valor del tratamiento "+(x+1)+" en la replica "+(y+1));
                        float valor = sc.nextFloat();
                        //System.out.println("valor "+valor);
                        //System.out.println("Tabla datos 00 "+tabladatos[0][0]);
                        //tabladatos[tratamientos][replicas] = valor;
                        tabladatos[x][y] = valor;
                    }
                }*/
                ControladorDCA controlador = new ControladorDCA(tratamientos, replicas, tabladatos);
                //TablaDatosDCA tabla = new TablaDatosDCA(tratamientos, replicas, tabladatos);
                System.out.println("\n\n");
                System.out.println("grados libertad tratamiento "+ controlador.datosTratamiento().getGrados_libertad());
                System.out.println("suma cuadrados tratamiento "+ controlador.datosTratamiento().getSuma_cuadrados());
                System.out.println("Cuadrado medio tratamiento "+ controlador.datosTratamiento().getCuadrado_medio());
                System.out.println("F Calculada tratamiento "+ controlador.datosTratamiento().getF_calculada());
                System.out.println("\n\n");
                System.out.println("grados libertad error "+ controlador.datosError().getGrados_libertad());
                System.out.println("Suma Cuadrados error "+ controlador.datosError().getSuma_cuadrados());
                System.out.println("Cuadrado medio error "+ controlador.datosError().getCuadrado_medio());
                System.out.println("\n\n");
                System.out.println("Grados libertad Total "+controlador.datosTotal().getGrados_libertad());
                System.out.println("Suma cuadrados total "+controlador.datosTotal().getSuma_cuadrados());
                
                
            break;
        }
    }
    
}
