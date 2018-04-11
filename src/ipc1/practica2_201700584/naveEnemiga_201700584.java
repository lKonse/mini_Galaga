
package ipc1.practica2_201700584;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class naveEnemiga_201700584 {
}

class naveEnemiga implements Runnable{
    private File ubicacionNaveEnemiga;
    private Image imagenNaveEnemiga;
    static int XEnemiga = 100, YEnemiga = 100;
    static Thread hiloNaveEnemiga;
    
    public naveEnemiga(){
        try {
            ubicacionNaveEnemiga = new File("src/Imagenes/navesEnemigas/naveEnemiga1.png");
            imagenNaveEnemiga = ImageIO.read(ubicacionNaveEnemiga);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", 0);
        }
    }
    
    public Image retornarImagenEnemiga(){
        return imagenNaveEnemiga;
    }

    @Override
    public void run() {
        
    }
}
