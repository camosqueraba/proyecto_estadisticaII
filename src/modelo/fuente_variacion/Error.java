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
public class Error {
    
    private byte grados_libertad;
    private float suma_cuadrados;
    private float cuadrado_medio;
    
    public Error(){
        
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
    
    
}
