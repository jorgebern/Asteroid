package com.videotutoriales.juego.piratas;
import java.util.List;

import com.videotutoriales.juego.marco.Juego;
import com.videotutoriales.juego.marco.Graficos;
import com.videotutoriales.juego.marco.Input.TouchEvent;
import com.videotutoriales.juego.marco.Pantalla;

public class NombreJug extends Pantalla {      

	public String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", 
			"S", "T", "U", "V", "W", "X", "Y", "Z"};
	public int letra = 0;
	public NombreJug(Juego juego) {
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
            	if(event.x > 10 && event.x < 42 && event.y > 10 && event.y < 42 ) {
            		letra++;
            	}
            	
            	if(event.x > 10 && event.x < 42 && event.y > 100 && event.y < 142 ) {
            		letra--;
            	}
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graficos g = juego.getGraphics();      
        g.drawPixmap(Assets.fondo, 0, 0);
        
        g.drawPixmap(Assets.flechaArriba, 10, 10);
        //Letra 1
        AsignarImagen(1,1,letra);
        g.drawPixmap(Assets.flechaAbajo, 10, 100);
        
        
        
    }
    
    public void AsignarImagen(int x, int y, int letra) {
    	
    	Graficos g = juego.getGraphics();
    	
    	switch(letra) {
    	case 0://A
    		g.drawPixmap(Assets.letras, 10, 50, 7, 10, 37,40);
		break;
    	case 1://B
    		g.drawPixmap(Assets.letras, 10, 50, 42, 10, 40,40);
		break;
    	case 2://C
    		g.drawPixmap(Assets.letras, 10, 50, 82, 10, 40,40);
		break;
    	case 3://D
    		g.drawPixmap(Assets.letras, 10, 50, 115, 10, 40,40);
		break;
    	case 4://E
    		g.drawPixmap(Assets.letras, 10, 50, 155, 10, 40,40);
		break;
    	case 5://F
    		g.drawPixmap(Assets.letras, 10, 50, 190, 10, 40,40);
		break;
    	case 6://G
    		g.drawPixmap(Assets.letras, 10, 50, 230, 10, 40,40);
		break;
    	case 7://H
    		g.drawPixmap(Assets.letras, 10, 50, 260, 10, 40,40);
		break;
    	case 8://I
    		g.drawPixmap(Assets.letras, 10, 50, 300, 10, 37,40);
		break;
    	case 9://J
    		g.drawPixmap(Assets.letras, 10, 50, 330, 10, 40,40);
		break;
    	case 10://K
    		g.drawPixmap(Assets.letras, 10, 50, 370, 10, 40,40);
		break;
    	case 11://L
    		g.drawPixmap(Assets.letras, 10, 50, 410, 10, 40,40);
		break;
    	case 12://M
    		g.drawPixmap(Assets.letras, 10, 50, 450, 10, 40,40);
		break;
    	case 13://N
    		g.drawPixmap(Assets.letras, 10, 50, 480, 10, 40,40);
		break;
    	case 14://Ñ
    		g.drawPixmap(Assets.letras, 10, 50, 520, 10, 40,40);
		break;
    	case 15://O
    		g.drawPixmap(Assets.letras, 10, 50, 560, 10, 40,40);
		break;
    	case 16://P
    		g.drawPixmap(Assets.letras, 10, 50, 600, 10, 37,40);
		break;
    	case 17://Q
    		g.drawPixmap(Assets.letras, 10, 50, 630, 10, 40,40);
		break;
    	case 18://R
    		g.drawPixmap(Assets.letras, 10, 50, 670, 10, 40,40);
		break;
		//----------------------------------------------------------
    	case 19://S
    		g.drawPixmap(Assets.letras, 10, 50, 115, 10, 40,40);
		break;
    	case 20://T
    		g.drawPixmap(Assets.letras, 10, 50, 155, 10, 40,40);
		break;
    	case 21://U
    		g.drawPixmap(Assets.letras, 10, 50, 190, 10, 40,40);
		break;
    	case 22://V
    		g.drawPixmap(Assets.letras, 10, 50, 230, 10, 40,40);
		break;
    	case 23://W
    		g.drawPixmap(Assets.letras, 10, 50, 270, 10, 40,40);
		break;
    	case 24://X
    		g.drawPixmap(Assets.letras, 10, 50, 115, 10, 40,40);
		break;
    	case 25://Y
    		g.drawPixmap(Assets.letras, 10, 50, 155, 10, 40,40);
		break;
    	case 26://Z
    		g.drawPixmap(Assets.letras, 10, 50, 190, 10, 40,40);
		break;
    	}
    	
    	
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
