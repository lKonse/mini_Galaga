
package ipc1.practica2_201700584;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class naveJugador_201700584 {
}

class naveJugador{
    private File ubicacionIMG;
    private int dy;
    private int y;
    private Image imagenJugador;
    
    public naveJugador(){
        y = 60;
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
            dy = -10;
        }
        if(tecla == KeyEvent.VK_DOWN){
            dy = 10;
        }
    }
    
    public void keyReleased(KeyEvent e){//Detectar que se soltaron las teclas
        
        int tecla = e.getKeyCode();//Tomar el codigo de la tecla presionada
        
        if(tecla == KeyEvent.VK_UP){
            dy = 0;
        }
        if(tecla == KeyEvent.VK_DOWN){
            dy =0;
        }
    }
    
    //METODO PARA MOVER LA IMAGEN-----------------------------------------------------------------------------------------------
    public void moverNaveJugador(){
        y+=dy;
    }
    
    //Funciones PARA RETORNAR LOS VALORES
    public int retornarY(){
        return y;
    }
    public Image retornarImagen(){//Retornar que es lo que contiene
        return imagenJugador;
    }
}
