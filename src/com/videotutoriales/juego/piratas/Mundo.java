package com.videotutoriales.juego.piratas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Color;

import com.videotutoriales.juego.marco.Graficos;

public class Mundo  {
    static final int MUNDO_ANCHO = 20;
    static final int MUNDO_ALTO = 9;
    static final int INCREMENTO_PUNTUACION = 10;
    static final float TICK_INICIAL = 0.2f;
    static final float TICK_DECREMENTO = 0.05f;

    public Nave jollyroger;
    public Botin botin;
    public boolean finalJuego = false;
    public int puntuacion = 0;

    boolean campos[][] = new boolean[MUNDO_ANCHO][MUNDO_ALTO];
    Random random = new Random();
    float tiempoTick = 0;
    static float tick = TICK_INICIAL;
    
    ArrayList<meteorito> meteorito;
    ArrayList<disparo> disparos;

    public Mundo(Nave nave, ArrayList meteorito, ArrayList disparos) {
        jollyroger = nave;
        colocarBotin();
        this.meteorito = meteorito;
        this.disparos = disparos;
    }

    private void colocarBotin() {
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
        botin = new Botin(botinX, botinY, random.nextInt(3));
    }
    
    public void disparar() {
   	 

    }

    public void update(float deltaTime) {
        if (finalJuego)
        
            return;

        tiempoTick += deltaTime;

        while (tiempoTick > tick) {
        	tiempoTick -= tick;
            jollyroger.Avanzar();
            
            for(int i =0;i<disparos.size();i++) {
            	disparos.get(i).Avanzar();
            }
            
            for(int i =0;i<meteorito.size();i++) {
            	 meteorito.get(i).Avanzar();
            }
            
            for(int i =0;i<disparos.size();i++) {
            	meteorito = disparos.get(i).comprobarColision(meteorito);
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
    
}
