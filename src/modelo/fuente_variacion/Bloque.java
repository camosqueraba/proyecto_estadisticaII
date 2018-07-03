/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.fuente_variacion;

/**
 *
 * @author carlos
 */
public class Bloque {
    
    private byte grados_libertad;
    private float suma_cuadrados;
    private float cuadrado_medio;
    private float f_calculada;
    private float f_tabulada_05;
    private float f_tabulada_01;

    public Bloque(){
    
    }

    public byte getGrados_libertad() {
        return grados_libertad;
    }

    public void setGrados_libertad(byte grados_libertad) {
        this.grados_libertad = grados_libertad;
    }

    public float getSuma_cuadrados() {
        return suma_cuadrados;
    }

    public void setSuma_cuadrados(float suma_cuadrados) {
        this.suma_cuadrados = suma_cuadrados;
    }

    public float getCuadrado_medio() {
        return cuadrado_medio;
    }

    public void setCuadrado_medio(float cuadrado_medio) {
        this.cuadrado_medio = cuadrado_medio;
    }

    public float getF_calculada() {
        return f_calculada;
    }

    public void setF_calculada(float f_calculada) {
        this.f_calculada = f_calculada;
    }

    public float getF_tabulada_05() {
        return f_tabulada_05;
    }

    public void setF_tabulada_05(float f_tabulada_05) {
        this.f_tabulada_05 = f_tabulada_05;
    }

    public float getF_tabulada_01() {
        return f_tabulada_01;
    }

    public void setF_tabulada_01(float f_tabulada_01) {
        this.f_tabulada_01 = f_tabulada_01;
    }
    
}
