package com.jorge.Asteroid.marco;

import com.jorge.Asteroid.marco.Graficos.PixmapFormat;

public interface Pixmap {
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}
