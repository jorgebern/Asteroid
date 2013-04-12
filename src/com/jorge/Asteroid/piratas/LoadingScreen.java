package com.jorge.Asteroid.piratas;


import com.jorge.Asteroid.marco.Graficos;
import com.jorge.Asteroid.marco.Juego;
import com.jorge.Asteroid.marco.Pantalla;
import com.jorge.Asteroid.marco.Graficos.PixmapFormat;

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
        Assets.alien = g.newPixmap("alien.png", PixmapFormat.ARGB4444);
        
        Assets.flechaArriba = g.newPixmap("arrowUp.png", PixmapFormat.ARGB4444);
        Assets.flechaIzquierda = g.newPixmap("arrowLeft.png", PixmapFormat.ARGB4444);
        Assets.flechaAbajo = g.newPixmap("arrowDown.png", PixmapFormat.ARGB4444);
        Assets.flechaDerecha = g.newPixmap("arrowRight.png", PixmapFormat.ARGB4444);
        
        Assets.disparoArriba = g.newPixmap("disparoArriba.png", PixmapFormat.ARGB4444);
        Assets.disparoAbajo = g.newPixmap("disparoAbajo.png", PixmapFormat.ARGB4444);
        Assets.disparoDerecha = g.newPixmap("disparoDerecha.png", PixmapFormat.ARGB4444);
        Assets.disparoIzquierda = g.newPixmap("disparoIzquierda.png", PixmapFormat.ARGB4444);
        Assets.vidas = g.newPixmap("vidas.png", PixmapFormat.ARGB4444);
        Assets.pad = g.newPixmap("pad.png", PixmapFormat.ARGB4444);
        Assets.button = g.newPixmap("Button.png", PixmapFormat.ARGB4444);
        Assets.explosion = g.newPixmap("explosion.png", PixmapFormat.ARGB4444);
        
        
        //------------------------------------------
        //                Letras
        //----------------------------------------
        Assets.A = g.newPixmap("Letras/A.png", PixmapFormat.ARGB4444);
        Assets.B = g.newPixmap("Letras/B.png", PixmapFormat.ARGB4444);
        Assets.C = g.newPixmap("Letras/C.png", PixmapFormat.ARGB4444);
        Assets.D = g.newPixmap("Letras/D.png", PixmapFormat.ARGB4444);
        Assets.E = g.newPixmap("Letras/E.png", PixmapFormat.ARGB4444);
        Assets.F = g.newPixmap("Letras/F.png", PixmapFormat.ARGB4444);
        Assets.G = g.newPixmap("Letras/G.png", PixmapFormat.ARGB4444);
        Assets.H = g.newPixmap("Letras/H.png", PixmapFormat.ARGB4444);
        Assets.I = g.newPixmap("Letras/I.png", PixmapFormat.ARGB4444);
        Assets.J = g.newPixmap("Letras/J.png", PixmapFormat.ARGB4444);
        Assets.K = g.newPixmap("Letras/K.png", PixmapFormat.ARGB4444);
        Assets.L = g.newPixmap("Letras/L.png", PixmapFormat.ARGB4444);
        Assets.M = g.newPixmap("Letras/M.png", PixmapFormat.ARGB4444);
        Assets.N = g.newPixmap("Letras/N.png", PixmapFormat.ARGB4444);
        Assets.O = g.newPixmap("Letras/O.png", PixmapFormat.ARGB4444);
        Assets.P = g.newPixmap("Letras/P.png", PixmapFormat.ARGB4444);
        Assets.Q = g.newPixmap("Letras/Q.png", PixmapFormat.ARGB4444);
        Assets.R = g.newPixmap("Letras/R.png", PixmapFormat.ARGB4444);
        Assets.S = g.newPixmap("Letras/S.png", PixmapFormat.ARGB4444);
        Assets.T = g.newPixmap("Letras/T.png", PixmapFormat.ARGB4444);
        Assets.U = g.newPixmap("Letras/U.png", PixmapFormat.ARGB4444);
        Assets.V = g.newPixmap("Letras/V.png", PixmapFormat.ARGB4444);
        Assets.W = g.newPixmap("Letras/W.png", PixmapFormat.ARGB4444);
        Assets.X = g.newPixmap("Letras/X.png", PixmapFormat.ARGB4444);
        Assets.Y = g.newPixmap("Letras/Y.png", PixmapFormat.ARGB4444);
        Assets.Z = g.newPixmap("Letras/Z.png", PixmapFormat.ARGB4444);
        
        
        //-----------------------------------
        //           Sonidos
        //-----------------------------------
        
        Assets.pulsar = juego.getAudio().nuevoSonido("pulsar.ogg");
        Assets.ataque = juego.getAudio().nuevoSonido("ataque.ogg");
        Assets.derrota = juego.getAudio().nuevoSonido("derrota.ogg");
        Assets.disparo = juego.getAudio().nuevoSonido("disparo.ogg");
        
        
        
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