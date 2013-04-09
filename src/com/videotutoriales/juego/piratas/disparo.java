package com.videotutoriales.juego.piratas;

import java.util.ArrayList;

public class disparo{

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
	int direccion;
	boolean visible = true;
	int duracion;
	
	

	public disparo() {
		this.direccion = meteorito.ABAJO;
		duracion = 0;
	}
	
	public disparo(int x, int y) {
		this.x= x;
		this.y = y;
		this.direccion = meteorito.ABAJO;
		duracion = 0;
	}
	
	public disparo(int x, int y, int direccion) {
		this.x= x;
		this.y = y;
		this.direccion = direccion;
		duracion = 0;
		
	}
	
	//------------------------MOVIMIENTOS-----------------------------
	public void Avanzar() {
		if(direccion == ARRIBA)
            this.y -= 100;
        if(direccion == IZQUIERDA)
        	this.x -= 100;
        if(direccion == ABAJO)
        	this.y += 100;
        if(direccion == DERECHA)
        	this.x += 100;
        if(direccion == ARRIBADERECHA) {
        	this.y -= 100;
        	this.x += 100;
        } 
        if(direccion == ARRIBAIZQUIERDA) {
        	this.y -= 100;
        	this.x -= 100;
        }
        if(direccion == ABAJODERECHA) {
        	this.y += 100;
        	this.x += 100;
        }
        if(direccion == ABAJOIZQUIERDA) {
        	this.y += 100;
        	this.x -= 100;
        }
        
        duracion++;
        
        if(duracion >= 3) {
        	visible = false;
        }
	}
	
	public ArrayList comprobarColision(ArrayList<meteorito> meteoritos) {
		
		for(int i =0;i<meteoritos.size();i++) {
			if(this.x/63 == meteoritos.get(i).x && this.y/63 == meteoritos.get(i).y && this.visible) {
				meteoritos.get(i).visible = false;
				this.visible = false;
			}
		}
		
		return meteoritos;
	}
	
}
