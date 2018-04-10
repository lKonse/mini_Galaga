
package ipc1.practica2_201700584;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Dibujar_201700584 {
    
}
class Dibujar extends JPanel implements ActionListener{
    
    naveJugador naveJugador = new naveJugador();
    Timer timer = new Timer(100,this);
    Image imagenFondo;
    File ubicacionFondo;
    
    public Dibujar(){
        setFocusable(true);
        addKeyListener(new teclado());
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        naveJugador.moverNaveJugador();
        repaint();
    }
    
    private class teclado extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            naveJugador.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            naveJugador.keyReleased(e);
        }
    }
        
}
