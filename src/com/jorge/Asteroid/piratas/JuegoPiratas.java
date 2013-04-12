package com.jorge.Asteroid.piratas;

import com.jorge.Asteroid.marco.Pantalla;
import com.jorge.Asteroid.marco.androidimpl.AndroidJuego;

public class JuegoPiratas extends AndroidJuego {
    @Override
    public Pantalla getStartScreen() {
    	return new LoadingScreen(this); 
    }
}
