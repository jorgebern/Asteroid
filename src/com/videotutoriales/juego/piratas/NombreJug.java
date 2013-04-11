package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pantalla;

public class NombreJug extends Pantalla {      

	
	public static int letra1 = 0;
	public static int letra2 = 0;
	public  static int letra3 = 0;
	Mundo mundo;
	
	public NombreJug(Juego juego, Mundo mundo) {
        super(juego);
        this.mundo = mundo;
    }

    Nave nave = new Nave();
    
    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
            	
            	//Letra1
            	if(event.x > 30 && event.x < 82 && event.y > 10 && event.y < 42 ) {
            		letra1++;
            		if(letra1 >= 26)
            			letra1 = 0;
            	}
            	
            	if(event.x > 30 && event.x < 82 && event.y > 150 && event.y < 182 ) {
            		letra1--;
            		if(letra1 <= -1)
            			letra1 = 25;
            	}
            	
            	//Letra2
            	if(event.x > 100 && event.x < 142 && event.y > 10 && event.y < 42 ) {
            		letra2++;
            		if(letra2 >= 26)
            			letra2 = 0;
            	}
            	
            	if(event.x > 100 && event.x < 142 && event.y > 150 && event.y < 182 ) {
            		letra2--;
            		if(letra2 <= -1)
            			letra2 = 25;
            	}
            	
            	//Letra3
            	if(event.x > 170 && event.x < 250 && event.y > 10 && event.y < 42 ) {
            		letra3++;
            		if(letra3 >= 26)
            			letra3 = 0;
            	}
            	
            	if(event.x > 170 && event.x < 250 && event.y > 150 && event.y < 182 ) {
            		letra3--;
            		if(letra3 <= -1)
            			letra3 = 25;
            	}
            	
            	if (event.x > 380 && event.y > 250 && 
                		event.x < 440 && event.y < 310) {
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    Configuraciones.addScore(mundo.puntuacion, letra1, letra2, letra3);
                    Configuraciones.save(juego.getFileIO()); 
                    juego.setScreen(new PantallaMaximasPuntuaciones(juego));
                    return;
            	}
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();      
        g.drawPixmap(Assets.fondo, 0, 0);
        
      //Letra 1
        g.drawPixmap(Assets.flechaArriba, 30, 10);
        AsignarImagen(40,75,letra1);
        g.drawPixmap(Assets.flechaAbajo, 30, 150);
        
        
      //Letra 2
        g.drawPixmap(Assets.flechaArriba, 100, 10);
        AsignarImagen(120,75,letra2);
        g.drawPixmap(Assets.flechaAbajo, 100, 150);
        
        
      //Letra 3
        g.drawPixmap(Assets.flechaArriba, 170, 10);
        AsignarImagen(180,75,letra3);
        g.drawPixmap(Assets.flechaAbajo, 170, 150);
        
        g.drawPixmap(Assets.botones, 380, 250, 0, 105, 64, 64);
        
    }
    
    public void AsignarImagen(int x, int y, int letra) {
    	
    	Graficos g = juego.getGraphics();
    	
    	switch(letra) {
    	case 0://A
    		g.drawPixmap(Assets.A, x, y);
		break;
    	case 1://B
    		g.drawPixmap(Assets.B, x, y);
		break;
    	case 2://C
    		g.drawPixmap(Assets.C, x, y);
		break;
    	case 3://D
    		g.drawPixmap(Assets.D, x, y);
		break;
    	case 4://E
    		g.drawPixmap(Assets.E, x, y);
		break;
    	case 5://F
    		g.drawPixmap(Assets.F, x, y);
		break;
    	case 6://G
    		g.drawPixmap(Assets.G, x, y);
		break;
    	case 7://H
    		g.drawPixmap(Assets.H, x, y);
		break;
    	case 8://I
    		g.drawPixmap(Assets.I, x, y);
		break;
    	case 9://J
    		g.drawPixmap(Assets.J, x, y);
		break;
    	case 10://K
    		g.drawPixmap(Assets.K, x, y);
		break;
    	case 11://L
    		g.drawPixmap(Assets.L, x, y);
		break;
    	case 12://M
    		g.drawPixmap(Assets.M, x, y);
		break;
    	case 13://N
    		g.drawPixmap(Assets.N, x, y);
		break;
    	case 14://O
    		g.drawPixmap(Assets.O, x, y);
		break;
    	case 15://P
    		g.drawPixmap(Assets.P, x, y);
		break;
    	case 16://Q
    		g.drawPixmap(Assets.Q, x, y);
		break;
    	case 17://R
    		g.drawPixmap(Assets.R, x, y);
		break;
    	case 18://S
    		g.drawPixmap(Assets.S, x, y);
		break;
    	case 19://T
    		g.drawPixmap(Assets.T, x, y);
		break;
    	case 20://U
    		g.drawPixmap(Assets.U, x, y);
		break;
    	case 21://V
    		g.drawPixmap(Assets.V, x, y);
		break;
    	case 22://W
    		g.drawPixmap(Assets.W, x, y);
		break;
    	case 23://X
    		g.drawPixmap(Assets.X, x, y);
		break;
    	case 24://Y
    		g.drawPixmap(Assets.Y, x, y);
		break;
    	case 25://Z
    		g.drawPixmap(Assets.Z, x, y);
		break;
    	}
    	
    	
    }
    

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
