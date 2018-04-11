
package ipc1.practica2_201700584;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class naveJugador_201700584 {
}

class naveJugador{
    private File ubicacionIMG;
    private int YMover;
    private int YJugador;
    private Image imagenJugador;
    
    public naveJugador(){
        YJugador = 60;
        try {
            ubicacionIMG = new File("src/Imagenes/navesJugador/naveEspacial3.jpg");
            imagenJugador = ImageIO.read(ubicacionIMG);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", 0);
        }
    }
    //METODO DETECTAR TECLAS---------------------------------------------------------------------------------------------------
    public void keyPressed(KeyEvent e){
        int tecla = e.getKeyCode();//Tomar el codigo de la tecla presionada
        
        if(tecla == KeyEvent.VK_UP){
            if(YJugador > 10){
                YMover = -10;
            }else if(YJugador < 10){
                YMover = 0;
            }
        }
        if(tecla == KeyEvent.VK_DOWN){
            if(YJugador < 400){
                YMover = 10;
            }else if(YJugador > 400){
                YMover = 0;
            }
        }
    }
    
    public void keyReleased(KeyEvent e){//Detectar que se soltaron las teclas
        
        int tecla = e.getKeyCode();//Tomar el codigo de la tecla presionada
        
        if(tecla == KeyEvent.VK_UP){
            YMover = 0;
        }
        if(tecla == KeyEvent.VK_DOWN){
            YMover =0;
        }
    }
    
    //METODO PARA MOVER LA IMAGEN-----------------------------------------------------------------------------------------------
    public void moverNaveJugador(){
        YJugador+=YMover;
    }
    
    //Funciones PARA RETORNAR LOS VALORES
    public int retornarY(){//Retornar la posicion
        return YJugador;
    }
    public Image retornarImagen(){//Retornar la imagen
        return imagenJugador;
    }
}
