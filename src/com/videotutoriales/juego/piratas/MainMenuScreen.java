package com.videotutoriales.juego.piratas;

import java.util.List;
import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pantalla;

public class MainMenuScreen extends Pantalla {
    public MainMenuScreen(Juego juego) {
        super(juego);               
    }   

    @Override
    public void update(float deltaTime) {
    	
        List<TouchEvent> touchEvents = juego.getInput().getTouchEvents();
        juego.getInput().getKeyEvents();       
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(inBounds(event, 0, 0, 64, 64)) {
                    Configuraciones.sonidoHabilitado = !Configuraciones.sonidoHabilitado;
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                }
                if(inBounds(event, 10, 150, 189, 48) ) {
                    juego.setScreen(new ElegirNave(juego));
                    if(Configuraciones.sonidoHabilitado)
                        {Assets.pulsar.play(1);                    
                        }                   
                        
                       
                        
                    return;
                }
                if(inBounds(event, 10, 200, 190, 45) ) {
                    juego.setScreen(new PantallaMaximasPuntuaciones(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
                if(inBounds(event, 10, 245, 192, 42) ) {
                    juego.setScreen(new PantallaAyuda(juego));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
            }
        }
    }
    
    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();
        
        g.drawPixmap(Assets.fondo, 0, 0);
        g.drawPixmap(Assets.logo, 200, 20);
        g.drawPixmap(Assets.menuprincipal, 10, 150);
        if(Configuraciones.sonidoHabilitado)
            g.drawPixmap(Assets.botones, 0, 0, 0, 0, 64, 64);
        else
            g.drawPixmap(Assets.botones, 0, 0, 68, 0, 64, 64);
    }

    @Override
    public void pause() {        
        Configuraciones.save(juego.getFileIO());
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
