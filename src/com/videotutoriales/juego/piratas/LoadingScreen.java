package com.videotutoriales.juego.piratas;


import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Pantalla;
import com.videotutoriales.juego.marco.Graficos.PixmapFormat;

public class LoadingScreen extends Pantalla{
    public LoadingScreen(Juego juego) {
        super(juego);
    }

    @Override
    public void update(float deltaTime) {
        Graficos g = juego.getGraphics();
        Assets.fondo = g.newPixmap("fondo.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.menuprincipal = g.newPixmap("menuprincipal.png", PixmapFormat.ARGB4444);
        Assets.botones = g.newPixmap("botones.png", PixmapFormat.ARGB4444);
        Assets.ayuda1 = g.newPixmap("ayuda1.png", PixmapFormat.ARGB4444);
        Assets.ayuda2 = g.newPixmap("ayuda2.png", PixmapFormat.ARGB4444);
        Assets.numeros = g.newPixmap("numeros.png", PixmapFormat.ARGB4444);
        Assets.preparado = g.newPixmap("preparado.png", PixmapFormat.ARGB4444);
        Assets.menupausa = g.newPixmap("menupausa.png", PixmapFormat.ARGB4444);
        Assets.finjuego = g.newPixmap("finjuego.png", PixmapFormat.ARGB4444);
        
        Assets.barcoarriba = g.newPixmap("barcoarriba.png", PixmapFormat.ARGB4444);
        Assets.barcoizquierda = g.newPixmap("barcoizquierda.png", PixmapFormat.ARGB4444);
        Assets.barcoabajo = g.newPixmap("barcoabajo.png", PixmapFormat.ARGB4444);
        Assets.barcoderecha = g.newPixmap("barcoderecha.png", PixmapFormat.ARGB4444);
        Assets.nave1arriba = g.newPixmap("nave1Arriba.png", PixmapFormat.ARGB4444);
        Assets.nave1izquierda = g.newPixmap("nave1Izquierda.png", PixmapFormat.ARGB4444);
        Assets.nave1abajo = g.newPixmap("nave1Abajo.png", PixmapFormat.ARGB4444);
        Assets.nave1derecha = g.newPixmap("nave1Derecha.png", PixmapFormat.ARGB4444);
        Assets.nave1boton = g.newPixmap("nave1Boton.png", PixmapFormat.ARGB4444);
        Assets.barcoboton = g.newPixmap("barcoBoton.png", PixmapFormat.ARGB4444);
        Assets.meteorito = g.newPixmap("Meteorito.png", PixmapFormat.ARGB4444);
        Assets.objetos = g.newPixmap("objetos.png", PixmapFormat.ARGB4444);
        Assets.muerte = g.newPixmap("muerte.png", PixmapFormat.ARGB4444);
        Assets.alien = g.newPixmap("alien.png", PixmapFormat.ARGB4444);
        
        Assets.botin1 = g.newPixmap("botin1.png", PixmapFormat.ARGB4444);
        Assets.botin2 = g.newPixmap("botin2.png", PixmapFormat.ARGB4444);
        Assets.botin3 = g.newPixmap("botin3.png", PixmapFormat.ARGB4444);
        
        Assets.disparoArriba = g.newPixmap("disparoArriba.png", PixmapFormat.ARGB4444);
        Assets.disparoAbajo = g.newPixmap("disparoAbajo.png", PixmapFormat.ARGB4444);
        Assets.disparoDerecha = g.newPixmap("disparoDerecha.png", PixmapFormat.ARGB4444);
        Assets.disparoIzquierda = g.newPixmap("disparoIzquierda.png", PixmapFormat.ARGB4444);
        Assets.vidas = g.newPixmap("vidas.png", PixmapFormat.ARGB4444);
        
        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.ogg");
        Assets.ataque = juego.getAudio().nuevoSonido("ataque.ogg");
        Assets.derrota = juego.getAudio().nuevoSonido("derrota.ogg");
        
        
        
        Configuraciones.cargar(juego.getFileIO());       
        juego.setScreen(new MainMenuScreen(juego));
    }

    @Override
    public void present(float deltaTime) {

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