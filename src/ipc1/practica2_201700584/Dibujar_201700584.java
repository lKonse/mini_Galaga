
package ipc1.practica2_201700584;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import javax.swing.*;

public class Dibujar_201700584 {
    
}
class Dibujar extends JPanel implements ActionListener {
    
    naveJugador naveJugador = new naveJugador();
    disparoJugador disparo = new disparoJugador();
    naveEnemiga enemiga = new naveEnemiga();
    
    Timer timer = new Timer(1,this);
    Image imagenFondo;
    File ubicacionFondo;
    static int YP;
    
    public Dibujar(){
        
        
//        try {
//            AudioInputStream sonido = AudioSystem.getAudioInputStream(new File("src/Audio/TruecolorAlchemist.wav").getAbsoluteFile());
//            Clip clip = AudioSystem.getClip();
//            clip.open(sonido);
//            clip.start();
//        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
//            Logger.getLogger(Dibujar.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        naveEnemiga.hiloNaveEnemiga.start();
        
        setFocusable(true);//Establecer la imagen en el JPanel
        addKeyListener(new teclado());//Que el teclado este a la escucha
        timer.start();
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        try {
            ubicacionFondo = new File("src/Imagenes/Fondo/fondoEstrellas.jpg");
            imagenFondo = ImageIO.read(ubicacionFondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", 0);
        }
        g.drawImage(imagenFondo, 0, 0, 800, 500, this);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(naveJugador.retornarImagen(), 700, naveJugador.retornarY(), 50, 50, null);
        g2.drawImage(disparo.retornarImagenDisparo(), disparo.XDisparo, disparo.YDisparo, 30, 15, this);
        g2.drawImage(disparo.gifExplosion, disparo.XExplosion, disparo.YExplosion, 50, 50, this);
        
        for(int n = 0; n < enemiga.navesSalir; n++){
            if(enemiga.existe[n].equals("En Movimiento")){
                g2.drawImage(enemiga.imagenNaveEnemiga[n], enemiga.XEnemiga[n], enemiga.YEnemiga[n], 70, 70, this);
                
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        naveJugador.moverNaveJugador();
        YP = naveJugador.retornarY();
        repaint();
    }

    
    private class teclado extends KeyAdapter{//Accion al presioanr una tecla
        public void keyPressed(KeyEvent e){
            naveJugador.keyPressed(e);
            disparo.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            naveJugador.keyReleased(e);
        }
    }
        
}
