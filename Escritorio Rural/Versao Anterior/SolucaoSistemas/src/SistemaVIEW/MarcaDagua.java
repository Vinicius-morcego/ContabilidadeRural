/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaVIEW;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Vinicius
 */
public class MarcaDagua extends JPanel {

    private BufferedImage img = null;
    private int x = 0;
    private int y = 0;

    public MarcaDagua(String caminho) throws IOException {
        this.img = ImageIO.read(new File(caminho));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gp = (Graphics2D) g.create();
        gp.setComposite(AlphaComposite.SrcOver.derive(0.9f));//50% de transparência
        gp.drawImage(img, x, y, this.getWidth(), this.getHeight(), null);

        gp.dispose();
    }
}
