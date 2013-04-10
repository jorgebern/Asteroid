package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Pantalla;
import com.videotutoriales.juego.marco.Input.TouchEvent;

public class PantallaMaximasPuntuaciones extends Pantalla {
    String lineas[] = new String[5];

    public PantallaMaximasPuntuaciones(Juego juego) {
        super(juego);

        for (int i = 0; i < 5; i++) {
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
        int x =150;
        
        for (int i = 0; i <3; i++) {
            dibujarTexto(g, lineas[i], x, y);
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
