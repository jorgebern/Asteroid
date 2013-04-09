package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pantalla;

public class PantallaAyuda extends Pantalla {      
    public PantallaAyuda(Juego juego) {
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
                if(event.x > 150 && event.y > 200) {
                    juego.setScreen(new PantallaAyuda2(juego));
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
        g.drawPixmap(Assets.ayuda1, 64, 100);
        g.drawPixmap(Assets.botones, 256, 416, 0, 64, 64, 64);
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