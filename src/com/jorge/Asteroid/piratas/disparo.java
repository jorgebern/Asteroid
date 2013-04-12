package com.jorge.Asteroid.piratas;


public class disparo {

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
	int xAnterior;
	int yAnterior;
	
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
		if(direccion == ARRIBA){
			this.y -= 2;
			this.yAnterior = y+1;
		} else if(direccion == IZQUIERDA) {
			this.x -= 2;
			this.xAnterior = x+1;
		}else if(direccion == ABAJO)  {
			this.y += 2;
			this.yAnterior = y-1;
		} else if(direccion == DERECHA) {
			this.x += 2;
			this.xAnterior = x-1;
		}
        	
        /*if(direccion == ARRIBADERECHA) {
        	this.y -= 2;
        	this.x += 2;
        } 
        if(direccion == ARRIBAIZQUIERDA) {
        	this.y -= 2;
        	this.x -= 2;
        }
        if(direccion == ABAJODERECHA) {
        	this.y += 2;
        	this.x += 2;
        }
        if(direccion == ABAJOIZQUIERDA) {
        	this.y += 2;
        	this.x -= 2;
        }*/
        
        duracion++;
        
        if(duracion >= 4) {
        	visible = false;
        }
	}
	
	
	
}
