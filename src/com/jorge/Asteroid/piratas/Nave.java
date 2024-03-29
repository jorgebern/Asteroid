package com.jorge.Asteroid.piratas;

import java.util.ArrayList;

public class Nave {

	public static final int ARRIBA = 0;
    public static final int IZQUIERDA= 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    
    public static final int ARRIBADERECHA = 4;
    public static final int ARRIBAIZQUIERDA = 5;
    public static final int ABAJODERECHA = 6;
    public static final int ABAJOIZQUIERDA = 7;
    
    
	int x;
	int y;
	int vidas;
	int direccion;
	String imagen;
	int numeroDisparos = 0;
	
	
	
	public Nave() {
		this.x= 5;
		this.y = 6;
		this.vidas = 3;
		this.direccion =0;
		this.imagen = "nave1";
	}
	
	public Nave(int x, int y) {
		this.x= x;
		this.y = y;
		this.vidas = 3;
		this.direccion =0;
	}
	
	//------------------------MOVIMIENTOS-----------------------------
	public void Avanzar() {
		if(direccion == ARRIBA)
            this.y -= 1;
        if(direccion == IZQUIERDA)
        	this.x -= 1;
        if(direccion == ABAJO)
        	this.y += 1;
        if(direccion == DERECHA)
        	this.x += 1;
        
        if(direccion == ARRIBADERECHA) {
        	this.y -= 1;
        	this.x += 1;
        } 
        if(direccion == ARRIBAIZQUIERDA) {
        	this.y -= 1;
        	this.x -= 1;
        }
        if(direccion == ABAJODERECHA) {
        	this.y += 1;
        	this.x += 1;
        }
        if(direccion == ABAJOIZQUIERDA) {
        	this.y += 1;
        	this.x -= 1;
        }
        
        if(this.x < 0)
        	this.x = 14;
        if(this.x > 14)
        	this.x = 0;
        if(this.y < 0)
        	this.y = 8;
        if(this.y > 8)
        	this.y = 0;
	}
	
	public void girarIzquierda() {
        	direccion = IZQUIERDA;
    }
    
    public void girarDerecha() {
        	direccion = DERECHA;
    }
    
    public void girarDerechaArriba() {
    	direccion = ARRIBADERECHA;
    }
    
    public void girarArribaIzquierda() {
    	direccion = ARRIBAIZQUIERDA;
    }
    
    public void girarAbajoDerecha() {
    	direccion = ABAJODERECHA;
    }
    
    public void girarAbajoIzquierda() {
    	direccion = ABAJOIZQUIERDA;
    }
	
    //---------------------------------------------------------------------------
	
    
	public boolean comprobarColision(ArrayList<meteorito> meteoritos) {
		
		boolean tocado = false;
		
		for(int i = 0;i < meteoritos.size();i++) {
			if(this.x == meteoritos.get(i).x && this.y == meteoritos.get(i).y
					&& meteoritos.get(i).visible) {
				tocado = true;
			}
		}

		return tocado;
	}
	
	

    
    
}
