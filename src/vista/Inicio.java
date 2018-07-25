/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorDBA;
import controlador.ControladorDCA;
import controlador.ControladorDCL;
import java.util.Scanner;
import modelo.tablas_datos.TablaDatosDCA;

/**
 *
 * @author carlos
 */
public class Inicio {
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Selecione el diseño");
        System.out.println("1: DCA");
        System.out.println("2: DBA");
        System.out.println("3: DCL");
        
        
        byte  opcion = sc.nextByte();
        
        switch (opcion){
            
            case 1:
                
                System.out.println("digite numero de tratamientos");
                byte tratamientos =  3;
                //byte tratamientos = sc.nextByte();
                System.out.println("digite numero de replicas");
                byte replicas = 4;
                //byte replicas = sc.nextByte();
                
                
                //float tabladatos[][] = new float[tratamientos][replicas];
                //float tabladatos[][] = new float[3][4];
                
               float tabladatos[][] = {{13,12,13,11},{11,14,13,12},{9,8,11,9}};
               //float tabladatos[][] = {{34,35,37,36},{72,109,153,86},{76,80,47,42},{157,218,60,224},{59,113,63,92},{69,149,66,135},{55,140,35,92},{235,123,71,142},{76,139,180,152}};
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
                System.out.println("Factor correccion "+ controlador.getTabla_anova_dca().getTabla_datos_dca().factorCorreccion());
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
            
            case 2:
                byte tratamientos_dba =  6;
                byte bloques_dba = 4;
                float tabladatos_dba[][] = {{12,17,20,10},{13,20,23,19},{14,20,29,22},{10,18,26,22},{12,17,21,12},{8,9,14,13}};
                ControladorDBA controlador_dba = new ControladorDBA(tratamientos_dba, bloques_dba, tabladatos_dba);
                
                System.out.println("Factor correccion "+ controlador_dba.getTabla_anova_dba().getTabla_datos_dba().factorCorreccion());
                System.out.println("\n\n");
                System.out.println("grados libertad bloque "+ controlador_dba.datosBloque().getGrados_libertad());
                System.out.println("suma cuadrados bloque "+ controlador_dba.datosBloque().getSuma_cuadrados());
                System.out.println("cuadrado medio bloque "+ controlador_dba.datosBloque().getCuadrado_medio());
                System.out.println("F Calculada bloque "+ controlador_dba.datosBloque().getF_calculada());
                System.out.println("\n\n");
                System.out.println("grados libertad tratamiento "+ controlador_dba.datosTratamiento().getGrados_libertad());
                System.out.println("suma cuadrados tratamiento "+ controlador_dba.datosTratamiento().getSuma_cuadrados());
                System.out.println("Cuadrado medio tratamiento "+ controlador_dba.datosTratamiento().getCuadrado_medio());
                System.out.println("F Calculada tratamiento "+ controlador_dba.datosTratamiento().getF_calculada());
                System.out.println("\n\n");
                System.out.println("grados libertad error "+ controlador_dba.datosError().getGrados_libertad());
                System.out.println("Suma Cuadrados error "+ controlador_dba.datosError().getSuma_cuadrados());
                System.out.println("Cuadrado medio error "+ controlador_dba.datosError().getCuadrado_medio());
                System.out.println("\n\n");
                System.out.println("Grados libertad Total "+controlador_dba.datosTotal().getGrados_libertad());
                System.out.println("Suma cuadrados total "+controlador_dba.datosTotal().getSuma_cuadrados());
                break; 
            
            case 3:
                byte tratamientos_dcl = 6;
                float valor_tratamientos [] = {40.0f, 42.0f, 40.7f, 32.7f, 43.5f, 34.6f };
                double [][][] tabla_datos_dcl  = {{{35,4},{ 40,0},{40.7,2},{ 42,1f},{32.7,3},{34.6,5}},{{42.3,3} ,{43.5,4},{ 42.7,0}, {42.6,5},{41.6,1},{ 30.6,2}},{{41,5},{39.5,2},{39.1,3},{ 38.8,4},{42.4,0},{31.1,1}},{{32.9,2},{34.8,3},{43.7,1},{43.3,0},{43.5,5},{35.5,4}},{{38.2,0},{43.8,1},{44.7,5},{37,2},{40.9,4},{37.1,3}},{{35,1},{41.7,5},{43.2,4},{39.1,3},{37.6,2},{27.5,0}}};
                ControladorDCL controlador_dcl = new ControladorDCL(tratamientos_dcl, valor_tratamientos, tabla_datos_dcl);
                
                System.out.println("Factor correccion "+ controlador_dcl.getTabla_anova_dcl().getTabla_datos_dcl().factorCorreccion());
                System.out.println("\n\n");
                System.out.println("grados libertad bloque "+ controlador_dcl.datosHilera().getGrados_libertad());
                System.out.println("suma cuadrados bloque "+ controlador_dcl.datosHilera().getSuma_cuadrados());
                System.out.println("cuadrado medio bloque "+ controlador_dcl.datosHilera().getCuadrado_medio());
                System.out.println("F Calculada bloque "+ controlador_dcl.datosHilera().getF_calculada());
                System.out.println("\n\n");
               
                System.out.println("grados libertad bloque "+ controlador_dcl.datosColumna().getGrados_libertad());
                System.out.println("suma cuadrados bloque "+ controlador_dcl.datosColumna().getSuma_cuadrados());
                System.out.println("cuadrado medio bloque "+ controlador_dcl.datosColumna().getCuadrado_medio());
                System.out.println("F Calculada bloque "+ controlador_dcl.datosColumna().getF_calculada());
                 System.out.println("\n\n");
                System.out.println("grados libertad tratamiento "+ controlador_dcl.datosTratamiento().getGrados_libertad());
                System.out.println("suma cuadrados tratamiento "+ controlador_dcl.datosTratamiento().getSuma_cuadrados());
                System.out.println("Cuadrado medio tratamiento "+ controlador_dcl.datosTratamiento().getCuadrado_medio());
                System.out.println("F Calculada tratamiento "+ controlador_dcl.datosTratamiento().getF_calculada());
                System.out.println("\n\n");
                System.out.println("grados libertad error "+ controlador_dcl.datosError().getGrados_libertad());
                System.out.println("Suma Cuadrados error "+ controlador_dcl.datosError().getSuma_cuadrados());
                System.out.println("Cuadrado medio error "+ controlador_dcl.datosError().getCuadrado_medio());
                System.out.println("\n\n");
                System.out.println("Grados libertad Total "+controlador_dcl.datosTotal().getGrados_libertad());
                System.out.println("Suma cuadrados total "+controlador_dcl.datosTotal().getSuma_cuadrados());
                break;
        }
    }
}
