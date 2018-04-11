
package ipc1.practica2_201700584;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class disparo_201700584 { 
}

class disparoJugador implements Runnable{
    
    naveJugador naveJugador = new naveJugador();
    
    private File ubicacionDisparo, ubicacionExplosion;
    private Image imagenDisparo;
    static Image imagenExplosion;
    static int XDisparo = 1200, YDisparo, moverDisparoX;
    
    int b = 0;
    int golpes = 0;
    int XPosicionExplosion = 1200, YPosicionExplosion = 100;
    
    static Thread hiloDisparo;
    
    public disparoJugador(){
        hiloDisparo = new Thread(this);
        
        imagenExplosion = Toolkit.getDefaultToolkit().createImage("src/Imagenes/Explosiones/Explosion1.gif");

        try{
            ubicacionDisparo = new File("src/Imagenes/Explosiones/disparo.png");
            imagenDisparo = ImageIO.read(ubicacionDisparo);
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", 0);
        }
    }
    
    public void keyPressed(KeyEvent e){
        int tecla = e.getKeyCode();
        
        if(tecla == KeyEvent.VK_SPACE){
            
            if(b == 0){
                hiloDisparo.start();
            }
            if(b == 1){
                hiloDisparo.resume();
            }
            
        }
    }
    
    @Override
    public void run() {
        try {
            while(true){
                if(XDisparo <= 0){//Cuando llegue a 0 que se suspenda el proceso
                    XDisparo = 1200;
                    hiloDisparo.suspend(); 
                }
                
                audioDisparo("src/Audio/sonidoDisparoJugador.wav");
                XDisparo = 700;
                YDisparo = Dibujar.YP + 18;
                while(XDisparo > 0){
                    
                    Thread.sleep(2);
                    XDisparo -= 1;
                    b = 1;
                    
                    //EN CASO QUE LE DE A UNA NAVE-------------------------------------------------------------------
                    for(int n = 1; n <= 50; n++){
                        if(XDisparo == naveEnemiga.XEnemiga && YDisparo == naveEnemiga.YEnemiga+n){
                            
                            if(golpes < 2){
                                golpes++;
                            }
                            else if(golpes == 2){
                                
                                XPosicionExplosion = naveEnemiga.XEnemiga;
                                YPosicionExplosion = naveEnemiga.YEnemiga;
                                naveEnemiga.XEnemiga = 1200;
                                Thread.sleep(400);
                                XPosicionExplosion = 1200;
                            }
                        }
                    }
                }
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(disparoJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Image retornarImagenDisparo(){
        return imagenDisparo;
    }
    
    //AUDIO--------------------------------------------------------------------------------------------------------------
    public void audioDisparo(String nombreSonido){
        try{
            AudioInputStream sonido = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(sonido);
            clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println("ERROR: "+ e);
        }
    }
}
