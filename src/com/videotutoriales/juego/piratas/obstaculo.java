package com.videotutoriales.juego.piratas;

public class obstaculo {
	
    public static final int TIPO_1 = 0;
    
    public int x, y;
    public boolean visible;

    public obstaculo(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }
}
