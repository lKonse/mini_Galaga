
package ipc1.practica2_201700584;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Random;


public class naveEnemiga_201700584 {
}

class naveEnemiga implements Runnable{
    private File ubicacionNaveEnemiga;
    
    static Thread hiloNaveEnemiga;
    static int navesSalir = 0, numeroGenerado = 0;
    int contador = 1, b = 0;
    
    static Image[] imagenNaveEnemiga = new Image[80];
    static int[] YEnemiga = new int[80];
    static int[] XEnemiga = new int[80];
    static String[] existe = new String[80];
    
    Random aleatorio = new Random();
    
    public naveEnemiga(){
        
        for(int n = 0; n < existe.length; n++){
                if(existe[n] == null){
                    existe[n] = "No Existe";
                }
            }
        
        hiloNaveEnemiga = new Thread(this);

    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5000);
//DIBUJAR NAVES-------------------------------------------------------------------------------------------------------------
                ubicacionNaveEnemiga = new File("src/Imagenes/navesEnemigas/naveEnemiga1.png");

                numeroGenerado = aleatorio.nextInt(4);
                while(numeroGenerado < 2){
                    numeroGenerado = aleatorio.nextInt(4);
                }

                navesSalir = navesSalir + numeroGenerado;
                System.out.println(navesSalir);

                for(int n = 0; n < navesSalir; n++){
                    if(existe[n].equals("No Existe")){
                        imagenNaveEnemiga[n] = ImageIO.read(ubicacionNaveEnemiga);

                        switch (contador) {
                            case 1:
                                YEnemiga[n] = 70;
                                existe[n] = "En Movimiento";
                                break;
                            case 2:
                                YEnemiga[n] = 170;
                                existe[n] = "En Movimiento";
                                break;
                            case 3:
                                YEnemiga[n] = 270;
                                existe[n] = "En Movimiento";
                                
                                contador = 0;
                                break;
                            default:
                                break;
                        }
                        contador++;
  
                    }
                }
                
                
                Thread.sleep(1000);
                for(int n = 0; n < navesSalir; n++){
                    if(existe[n].equals("En Movimiento")){
                        XEnemiga[n] += 100;
                    }
                }
                
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se encontro la imagen", "ERROR", 0);
            } catch (InterruptedException ex) {
                Logger.getLogger(naveEnemiga.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
//MOVER NAVES ENEMIGAS---------------------------------------------------------------------------------------------------------------------

