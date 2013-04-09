package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pantalla;

public class ElegirNave extends Pantalla {      
    public ElegirNave(Juego juego) {
        super(juego);
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
                if(event.x > 64 && event.y > 100 && event.x < 164 && event.y < 200 ) {
                	nave.imagen = "barco";
                    juego.setScreen(new PantallaJuego(juego, nave));
                    if(Configuraciones.sonidoHabilitado)
                        Assets.pulsar.play(1);
                    return;
                }
                
                if(event.x > 200 && event.y > 100 && event.x < 300 && event.y < 200 ) {
                	nave.imagen = "nave1";
                	juego.setScreen(new PantallaJuego(juego,nave));
                    if(Configuraciones.sonidoHabilitado)
                    	
                        Assets.pulsar.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();      
        g.drawPixmap(Assets.fondo, 0, 0);
        
        g.drawPixmap(Assets.barcoboton, 64, 100);
        g.drawPixmap(Assets.nave1boton, 200, 100);
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