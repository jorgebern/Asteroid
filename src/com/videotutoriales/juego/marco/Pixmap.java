package com.videotutoriales.juego.marco;

import com.videotutoriales.juego.marco.Graficos.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}
