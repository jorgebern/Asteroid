package com.videotutoriales.juego.piratas;

import java.util.ArrayList;
import java.util.Random;

public class Mundo  {
    static final int MUNDO_ANCHO = 20;
    static final int MUNDO_ALTO = 9;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.3f;
    static final float TICK_DECREMENTO = 0.05f;

    public Nave jollyroger;
    public obstaculo obstaculo;
    public disparo Disparo;
    public boolean finalJuego = false;
    public int puntuacion = 0;

    boolean campos[][] = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;
    
    ArrayList<meteorito> meteorito;
    ArrayList<disparo> disparos;

    public Mundo(Nave nave, ArrayList<meteorito> meteorito, ArrayList<disparo> disparos) {
        jollyroger = nave;
        colocarObtaculo();
        colocarDisparo();
        this.meteorito = meteorito;
        this.disparos = disparos;
    }

    public void comprobarEnemigo() {
    
    	if(obstaculo.visible) {
			if(jollyroger.x  >= obstaculo.x && jollyroger.y  >= obstaculo.y &&
					jollyroger.x  <= obstaculo.x && jollyroger.y  <= obstaculo.y) {
				jollyroger.vidas--;
			}
    	}
		
    }
    
    public void colocarDisparo() {
    	
    	 Disparo = new disparo(jollyroger.x, jollyroger.y, jollyroger.direccion);
    }

    private void colocarObtaculo() {
        for (int x = 0; x < MUNDO_ANCHO; x++) {
            for (int y = 0; y < MUNDO_ALTO; y++) {
                campos[x][y] = false;
            }
        }

        int botinX = random.nextInt(MUNDO_ANCHO);
        int botinY = random.nextInt(MUNDO_ALTO);
        
        while (true) {
            if (campos[botinX][botinY] == false)
                break;
            botinX += 1;
            if (botinX >= MUNDO_ANCHO) {
            	botinX = 0;
            	botinY += 1;
                if (botinY >= MUNDO_ALTO) {
                	botinY = 0;
                }
            }
        }
        obstaculo = new obstaculo(botinX, botinY);
    }

    public void update(float deltaTime) {
        if (finalJuego)
        
            return;

        tiempoTick += deltaTime;

        while (tiempoTick > tick) {
        	tiempoTick -= tick;
        	
            DestruirMeteorito();
            MatarEnemigo();
            
            jollyroger.Avanzar();
            Disparo.Avanzar();
            comprobarEnemigo();
            
            for(int i =0;i<meteorito.size();i++) {
            	 meteorito.get(i).Avanzar();
            }
           
            if (jollyroger.comprobarColision(meteorito)) { 
            	jollyroger.vidas--;               
            }
            
            if(jollyroger.vidas <= 0) {
            	finalJuego = true;
            	return;
            }
            }
        }
    

    public void DestruirMeteorito() {
		
    	for(int i =0;i<meteorito.size();i++) {
    		if(meteorito.get(i).x == Disparo.x && meteorito.get(i).y == Disparo.y && meteorito.get(i).visible) {
    			meteorito.get(i).visible = false;
    			puntuacion += 50;
    		}
    		
    		if(meteorito.get(i).xAnterior == Disparo.x && meteorito.get(i).yAnterior == Disparo.y && meteorito.get(i).visible) {
    			meteorito.get(i).visible = false;
    			puntuacion += 50;
    		}
    	}
    	
		
	}
    
    public void MatarEnemigo() {
    	
    		if(Disparo.x == obstaculo.x && Disparo.y == obstaculo.y || Disparo.xAnterior == obstaculo.x && Disparo.yAnterior == obstaculo.y) {
    			obstaculo.x = random.nextInt(MUNDO_ANCHO);
    			obstaculo.y = random.nextInt(MUNDO_ALTO);
    			puntuacion +=20;
    		
    		}
    		
    		if(obstaculo.x == Disparo.xAnterior+1 &&obstaculo.x == Disparo.x - 1 && obstaculo.y == Disparo.yAnterior + 1 && 
    				obstaculo.y == Disparo.y - 1) {
    			
    		}
    }
    
}
