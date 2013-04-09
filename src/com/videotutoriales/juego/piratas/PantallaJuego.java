package com.videotutoriales.juego.piratas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pixmap;
import com.videotutoriales.juego.marco.Pantalla;

public class PantallaJuego extends Pantalla  implements SensorEventListener{
    
	//TODO
    public final float Y = juego.getInput().getAccelY();
    public final float X = juego.getInput().getAccelX();
    
	enum EstadoJuego {
        Preparado,
        Ejecutandose,
        Pausado,
        FinJuego
    }
    
    EstadoJuego estado = EstadoJuego.Preparado;
    Mundo mundo;
    int antiguaPuntuacion = 0;
    String puntuacion = "0";
    int disp = 0;
    Random random = new Random();
    ArrayList<meteorito> meteoros = new ArrayList<meteorito>();
    ArrayList<disparo> disparos = new ArrayList<disparo>();

    boolean nivel =true;
    
    public PantallaJuego(Juego juego, Nave nave) {
        super(juego);
        meteorito mete = new meteorito();
        meteoros.add(mete);
        meteoros.add(new meteorito(8,5));
        mundo = new Mundo(nave, meteoros, disparos);
        
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();
        
        if(estado == EstadoJuego.Preparado)
            updateReady(touchEvents);
        if(estado == EstadoJuego.Ejecutandose)
            updateRunning(touchEvents, deltaTime);
        if(estado == EstadoJuego.Pausado)
            updatePaused(touchEvents);
        if(estado == EstadoJuego.FinJuego)        	
            updateGameOver(touchEvents);
            
    }
    
    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)        	
            estado = EstadoJuego.Ejecutandose;
    }
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {   
    	
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 380 && event.y > 0 && event.x < 420 && event.y < 42 ) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    estado = EstadoJuego.Pausado;
                    return;
                }
            }
            
           
            
            
            if(event.type == TouchEvent.TOUCH_DOWN) {

                if(event.x > 420 && event.y > 230
                		&& event.x < 460 && event.y < 270 ) {
                	if(Configuraciones.sonidoHabilitado)
                       
                	disparos = mundo.jollyroger.disparar(disparos);
                }
                
                if(event.x > 380 && event.y > 270
                		&& event.x < 420 && event.y < 310 ) {
                	mundo.puntuacion+=50;
                	nivel = true;
                }
                
            }
            
        }
        
        //TODO
        if(juego.getInput().getAccelY() > 6  ) {
       	   mundo.jollyroger.direccion = Nave.ABAJO;
          }else if(juego.getInput().getAccelY() < 5  ) {
        	   mundo.jollyroger.direccion = Nave.ARRIBA;
           }else if(juego.getInput().getAccelX() <0  ) {
     	   mundo.jollyroger.girarDerecha();
        } else if(juego.getInput().getAccelX() > 0  ) {
     	   mundo.jollyroger.girarIzquierda();
        } else if(juego.getInput().getAccelY() > Y && juego.getInput().getAccelX() < X ) {
       	   mundo.jollyroger.direccion = Nave.ABAJODERECHA;
          }else if(juego.getInput().getAccelY() > Y && juego.getInput().getAccelX() > X ) {
        	   mundo.jollyroger.direccion = Nave.ABAJOIZQUIERDA;
           }else if(juego.getInput().getAccelY() < Y && juego.getInput().getAccelX() < X ) {
        	   mundo.jollyroger.direccion = Nave.ARRIBADERECHA;
           }else if(juego.getInput().getAccelY() < Y && juego.getInput().getAccelX() > X) {
        	   mundo.jollyroger.direccion = Nave.ARRIBAIZQUIERDA;
           }

        if(Integer.parseInt(puntuacion) != 0 && nivel) {
        	subirNivel();
        	nivel = false;
        }
        
        	
        mundo.update(deltaTime);
        if(mundo.finalJuego) {        	
            if(Configuraciones.sonidoHabilitado)
                Assets.derrota.play(1);               
            estado = EstadoJuego.FinJuego;
        }
        if(antiguaPuntuacion != mundo.puntuacion) {
            antiguaPuntuacion = mundo.puntuacion;
            puntuacion = "" + antiguaPuntuacion;
            if(Configuraciones.sonidoHabilitado)
                Assets.ataque.play(1);
        }
    }
    
    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 200 && event.x <= 400 ) {
                    if(event.y > 100 && event.y <= 148) {
                        if(Configuraciones.sonidoHabilitado)
                            Assets.pulsar.play(1);
                        estado = EstadoJuego.Ejecutandose;
                        return;
                    }                    
                    if(event.y > 148 && event.y < 196) {
                        if(Configuraciones.sonidoHabilitado)
                            Assets.pulsar.play(1);
                        juego.setScreen(new MainMenuScreen(juego));                        
                        return;
                    }
                }
            }
        }
    }
    
    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                   event.y >= 200 && event.y <= 264) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);                        
                    juego.setScreen(new MainMenuScreen(juego));
                    return;
                }
            }
        }
    }
    

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        
        g.drawPixmap(Assets.fondo, 0, 0);
        drawWorld(mundo);
        if(estado == EstadoJuego.Preparado) 
            drawReadyUI();
        if(estado == EstadoJuego.Ejecutandose)
            drawRunningUI();
        if(estado == EstadoJuego.Pausado)
            drawPausedUI();
        if(estado == EstadoJuego.FinJuego)
        	drawGameOverUI();
            
        
        drawText(g, puntuacion, g.getWidth() / 2 - puntuacion.length()*20 / 2, 0);                
    }
    
    
    
    private void drawWorld(Mundo mundo) {
        Graficos g = juego.getGraphics();
        Nave jollyroger = mundo.jollyroger;
        
        obstaculo botin = mundo.obstaculo;
        
        
        
        Pixmap stainPixmap = null;
          stainPixmap = Assets.alien;
        int x = botin.x * 32;
        int y = botin.y * 32;      
        g.drawPixmap(stainPixmap, x, y); 
        
        for(int i =0;i<meteoros.size();i++) {
        	if(meteoros.get(i).visible) {
		        Pixmap meteoritos = null;
		        if(meteoros.get(i).tipo== meteorito.TIPO_1)
		        	g.drawPixmap(Assets.objetos, x ,y , 2, 64, 32, 32);
		        if(meteoros.get(i).tipo == meteorito.TIPO_2)
		        	meteoritos = Assets.meteorito;
		        if(meteoros.get(i).tipo == meteorito.TIPO_3)
		        	meteoritos = Assets.meteorito;
		         x = meteoros.get(i).x * 32;
		         y = meteoros.get(i).y * 32;      
		        g.drawPixmap(meteoritos, x, y );
        	}
        }
        
        
        
        Pixmap headPixmap = null;
        if(jollyroger.imagen.equals("barco")) {
        	headPixmap = Assets.barcoarriba;
	        if(jollyroger.direccion == Nave.ARRIBA) 
	            headPixmap = Assets.barcoarriba;
	        if(jollyroger.direccion == Nave.IZQUIERDA) 
	            headPixmap = Assets.barcoizquierda;
	        if(jollyroger.direccion == Nave.ABAJO) 
	            headPixmap = Assets.barcoabajo;
	        if(jollyroger.direccion == Nave.DERECHA) 
	            headPixmap = Assets.barcoderecha; 
	        x = jollyroger.x*32 + 16;
	        y = jollyroger.y * 32 + 16;
	        g.drawPixmap(headPixmap, x - headPixmap.getWidth() / 2, y - headPixmap.getHeight() / 2);
	        
        }else if(jollyroger.imagen.equals("nave1"))  {
        	headPixmap = Assets.nave1arriba;
        	if(jollyroger.direccion == Nave.ARRIBA) 
	            headPixmap = Assets.nave1arriba;
	        if(jollyroger.direccion == Nave.IZQUIERDA) 
	            headPixmap = Assets.nave1izquierda;
	        if(jollyroger.direccion == Nave.ABAJO) 
	            headPixmap = Assets.nave1abajo;
	        if(jollyroger.direccion == Nave.DERECHA) 
	            headPixmap = Assets.nave1derecha;
	        
	        x = jollyroger.x*32 + 16;
	        y = jollyroger.y * 32 + 16;
	        g.drawPixmap(headPixmap, x - headPixmap.getWidth() / 2, y - headPixmap.getHeight() / 2);
        }
        for(int i =0;i<disparos.size();i++) {
        	if(disparos.get(i).visible) {
        		if(disparos.get(i).direccion == disparo.ABAJO)
        			headPixmap = Assets.disparoAbajo;
        		if(disparos.get(i).direccion == disparo.ARRIBA)
    	        	headPixmap = Assets.disparoArriba;
        		if(disparos.get(i).direccion == disparo.DERECHA)
    	        	headPixmap = Assets.disparoDerecha;
        		if(disparos.get(i).direccion == disparo.IZQUIERDA)
    	        	headPixmap = Assets.disparoIzquierda;
        		
	            x = jollyroger.x*32 + 16;
	            y = jollyroger.y * 32 + 16;
	            g.drawPixmap(headPixmap, disparos.get(i).x, disparos.get(i).y);
        	}
        }
        

    }
    
    private void drawReadyUI() {
        Graficos g = juego.getGraphics();
        
        g.drawPixmap(Assets.preparado, 150, 100);
        g.drawLine(50, 416, 480, 416, Color.BLACK);
    }
    
    private void drawRunningUI() {
        Graficos g = juego.getGraphics();

        g.drawPixmap(Assets.botones, 420 ,230 , 0, 65, 42, 40);
        g.drawPixmap(Assets.botones, 380 ,270 , 42, 65, 40, 40);
        
        if(estado == EstadoJuego.Ejecutandose){
        	g.drawPixmap(Assets.botones, 380 ,0 , 82, 65, 42, 42);
        }
        
        
    }
    
    private void drawPausedUI() {
        Graficos g = juego.getGraphics();
        
        g.drawPixmap(Assets.menupausa, 200, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graficos g = juego.getGraphics();
        
        g.drawPixmap(Assets.finjuego, 62, 100);
        g.drawPixmap(Assets.botones, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    
    
    public void drawText(Graficos g, String line, int x, int y) {
    	int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numeros, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth; 
            
            int xvida=0;
            for(int v =0;v<mundo.jollyroger.vidas;v++) {
            	
            	g.drawPixmap(Assets.vidas, xvida, 0);
            	xvida+=32;
            }
        }
    }
    
    public void subirNivel() {
    	
    	if(nivel) {
    		meteoros.add(new meteorito(0,random.nextInt(500), random.nextInt(7) , 1));
    	
    	}
    		
    }
    
    @Override
    public void pause() {
        if(estado == EstadoJuego.Ejecutandose)
            estado = EstadoJuego.Pausado;
        
        if(mundo.finalJuego) {        	
            Configuraciones.addScore(mundo.puntuacion);
            Configuraciones.save(juego.getFileIO());           
        }
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
    	
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		
		
	}
}