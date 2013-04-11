package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Pantalla;
import com.videotutoriales.juego.marco.Input.TouchEvent;

public class PantallaMaximasPuntuaciones extends Pantalla {
    String lineas[] = new String[3];
    String letras[] = new String[3];

    public PantallaMaximasPuntuaciones(Juego juego) {
        super(juego);

        
        for (int i = 0; i < 3; i++) {
        	 
            lineas[i] = "" + (i + 1) + ". " + Configuraciones.maxPuntuaciones[i];
        }
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (event.x > 380 && event.y > 250 && 
                		event.x < 440 && event.y < 310) {
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
        g.drawPixmap(Assets.menuprincipal, 150, 20, 0, 42, 196, 42);

        int y = 100;
        int x =50;
        
        for (int i = 0; i <3; i++) {
            dibujarTexto(g, lineas[i], x, y);
            letras = Configuraciones.nombres[i].split("Ü");
            AsignarImagen(x+120, y, Integer.parseInt(letras[0]));
            AsignarImagen(x + 140, y, Integer.parseInt(letras[1]) );
            AsignarImagen(x + 160, y, Integer.parseInt(letras[2]) );
            y += 50;
            if(y >= 250) {
            	y= 100;
            	x = 200;
            }
        }

        g.drawPixmap(Assets.botones, 380, 250, 0, 105, 64, 64);
    }

    public void dibujarTexto(Graficos g, String linea, int x, int y) {
        int len = linea.length();
        for (int i = 0; i < len; i++) {
            char character = linea.charAt(i);
    
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
        }
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
