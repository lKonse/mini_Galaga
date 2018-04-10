
package ipc1.practica2_201700584;
import javax.swing.*;
import java.awt.*;

public class ventanaJuego_201700584 {
    
}
class marcoJuego extends JFrame{
    public marcoJuego(){
        
        add(new Dibujar());
        setTitle("mini-GALAGA");
        setSize(800,500);
        setLocationRelativeTo(null);//Poner pantalla en medio
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
