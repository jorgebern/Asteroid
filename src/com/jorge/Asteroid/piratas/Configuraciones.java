package com.jorge.Asteroid.piratas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jorge.Asteroid.marco.FileIO;

public class Configuraciones {
    public static boolean sonidoHabilitado = true;
    public static int[] maxPuntuaciones = new int[] { 0, 0, 0 };
    public static String[] nombres = new String[] {"0�1�2","3�4�5", "6�7�8"};

    public static void cargar(FileIO files) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    files.leerArchivo("asteroid")));
            sonidoHabilitado = Boolean.parseBoolean(in.readLine());
            
            for (int i = 0; i < 3; i++) {
            	String lineas[] = in.readLine().split("��");
                maxPuntuaciones[i] = Integer.parseInt(lineas[0]);
                nombres[i] = lineas[1];
            }
           
        } catch (IOException e) {
            // :( Est� bien aqu� deber�a ir algo
        } catch (NumberFormatException e) {
            // :/ Nadie es perfecto
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }

    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    files.escribirArchivo("asteroid")));
            out.write(Boolean.toString(sonidoHabilitado));
            out.write("\n");
            for (int i = 0; i < 3; i++) {
                out.write(Integer.toString(maxPuntuaciones[i]) +  "��" + nombres[i] + "��");
                out.write("\n");
            }

        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }

    public static void addScore(int score, int letra1, int letra2, int letra3) {
        
    	for (int i = 0; i < 3; i++) {
            if (maxPuntuaciones[i] < score) {
                for (int j = 2; j > i; j--) {
                	maxPuntuaciones[j] = maxPuntuaciones[j - 1];
                }
                maxPuntuaciones[i] = score;
                nombres[i] = letra1 + "�" + letra2 + "�" + letra3;
                break;
            }
        }
    }
}