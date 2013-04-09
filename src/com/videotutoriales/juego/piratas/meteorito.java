package com.videotutoriales.juego.piratas;

public class meteorito {
	
	public static final int TIPO_1 = 0;
    public static final int TIPO_2 = 1;
    public static final int TIPO_3 = 2;
    
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
	int tipo;
	boolean visible = true;
	
	
	public meteorito() {
		this.x= 5;
		this.y = 6;
		this.direccion = meteorito.ABAJO;
		this.tipo = 1;
	}
	
	public meteorito(int x, int y) {
		this.x= x;
		this.y = y;
		this.direccion = meteorito.ABAJO;
		this.tipo = 1;
	}
	
	public meteorito(int x, int y, int direccion, int tipo) {
		this.x= x;
		this.y = y;
		this.direccion = direccion;
		this.tipo = 2;
	}
	
	//------------------------MOVIMIENTOS-----------------------------
	public void Avanzar() {
		if(direccion == ARRIBA){
			this.yAnterior = y;
            this.y -= 1;
		} else if(direccion == IZQUIERDA) {
			this.xAnterior = x;
			this.x -= 1;
		}else if(direccion == ABAJO)  {
			this.yAnterior = y;
			this.y += 1;
		} else if(direccion == DERECHA) {
			this.xAnterior = x;
			this.x += 1;
		}
		
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
        	this.x = 15;
        if(this.x > 15)
        	this.x = 0;
        if(this.y < 0)
        	this.y = 8;
        if(this.y > 8)
        	this.y = 0;
	}
	
	
    //---------------------------------------------------------------------------
	
}
