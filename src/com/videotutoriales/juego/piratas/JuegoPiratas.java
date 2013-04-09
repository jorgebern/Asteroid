package com.videotutoriales.juego.piratas;

import com.videotutoriales.juego.marco.Pantalla;
import com.videotutoriales.juego.marco.androidimpl.AndroidJuego;

public class JuegoPiratas extends AndroidJuego {
    @Override
    public Pantalla getStartScreen() {
    	return new LoadingScreen(this); 
    }
}
