import javax.swing.*;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;



public class Main {
    static List<int[]> maListcopie = new ArrayList<>();

    public static void main(String[] args) {

        Caisse caisses[] = {new Caisse(2, 4, 'H', new int[]{2, 2}),
                new Caisse(5, 4, 'H', new int[]{4, 7}),
                new Caisse(6, 6, 'H', new int[]{5, 2}),
                new Caisse(5, 7, 'H', new int[]{10, 2})
        };
        maListcopie.addAll(Caisse.getListposFinales());

        Carte ma_carte = new Carte("plan");

        Gui panel = new Gui(ma_carte);
        Frame frame = new Frame("Sokoban");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        panel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        panel.getJoueurX().haut();
                        break;
                    case KeyEvent.VK_DOWN:
                        panel.getJoueurX().bas();
                        break;
                    case KeyEvent.VK_RIGHT:
                        panel.getJoueurX().droite();
                        break;
                    case KeyEvent.VK_LEFT:
                        panel.getJoueurX().gauche();
                        break;
                }
                panel.repaint();

                for (Caisse x : caisses)
                    if (isCorrectPlaceForCaisse(x)) {
                        panel.setPoints();
                        if (panel.getPoints() == Caisse.getListeCaisses().size()) {
                            JOptionPane.showMessageDialog(panel, "Bravo, vous avez gagné !");
                            System.exit(0);
                        }
                    }
            }
        });
    }

    private static boolean isCorrectPlaceForCaisse(Caisse caisse) {
        for (int[] e : maListcopie) {
            if (e[0] == caisse.getX() && e[1] == caisse.getY()) {
                maListcopie.remove(e);
                return true;
            }
        }
        return false;
    }
}