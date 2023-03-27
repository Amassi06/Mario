import java.awt.*;

public class Lutin {
    /**
     * notre objet lutin
     *
     * @param x
     * @param y
     * @param carte
     */
    private int x;
    private int y;
    private Carte carte;

    public Lutin(int x, int y, Carte carte) {
        this.x = x;
        this.y = y;
        this.carte = carte;
    }

    private boolean espaceLibre(int i, int j) {
        return !carte.mur(i, j) && carte.caisse(i, j) == null;
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillOval((x - 1) * Gui.getLargeurCase(), (y - 1) * Gui.getHauteurCase(), Gui.getLargeurCase(), Gui.getHauteurCase());
    }

    public boolean haut() {
        if (espaceLibre(x, y - 1)) {
            y--;
            return true;
        }
        if (y - 2 == 0) { // eviter de sortir de la carte BUG !!
            System.out.println("[INFO] il ya un obstacle");
            return false;
        }
        if (carte.caisse(x, y - 1) != null && espaceLibre(x, y - 2)) {
            carte.caisse(x, y - 1).setY(y - 2);
            y--;
            return true;
        }
        System.out.println("[INFO] il ya un obstacle");
        return false;
    }

    public boolean bas() {
        if (espaceLibre(x, y + 1)) {
            y++;
            return true;
        }
        if (y + 2 == carte.getY() + 1) { // eviter de sortir de la carte BUG !!
            System.out.println("[INFO] il ya un obstacle");
            return false;
        }
        if (carte.caisse(x, y + 1) != null && espaceLibre(x, y + 2)) {
            carte.caisse(x, y + 1).setY(y + 2);
            y++;
            return true;
        }
        System.out.println("[INFO] il ya un obstacle");
        return false;
    }

    public boolean gauche() {
        if (espaceLibre(x - 1, y)) {
            x--;
            return true;
        }
        if (carte.caisse(x - 1, y) != null && espaceLibre(x - 2, y)) {
            carte.caisse(x - 1, y).setX(x - 2);
            x--;
            return true;
        }
        System.out.println("[INFO] il ya un obstacle");
        return false;
    }

    public boolean droite() {
        if (espaceLibre(x + 1, y)) {
            x++;
            return true;
        }
        if (carte.caisse(x + 1, y) != null && espaceLibre(x + 2, y)) {
            carte.caisse(x + 1, y).setX(x + 2);
            x++;
            return true;
        }
        System.out.println("[INFO] il ya un obstacle");
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}