import java.awt.*;

public class Gui extends Panel {
    /**
     * c'est la classe qui dessine tout le jeu
     *
     * @param carte
     * @param joueurX
     * @param largeurCase
     * @param hauteurCase
     */
    private Carte carte;
    private Lutin joueurX;
    private static int largeurCase;
    private static int hauteurCase;
    private int points = 0;

    public Gui(Carte carte) {
        this.carte = carte;
        joueurX = new Lutin(6, 2, carte);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int newHauteurCase = getHeight() / carte.getY();
        int newLargeurCase = getWidth() / carte.getX();
        if (hauteurCase != newHauteurCase || largeurCase != newLargeurCase) {
            hauteurCase = newHauteurCase;
            largeurCase = newLargeurCase;
        }
        joueurX.paint(g);
        // Dessiner le score

        for (int y = 1; y <= carte.getY(); y++) {
            for (int x = 1; x <= carte.getX(); x++) {
                if (carte.mur(x, y)) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect((x - 1) * largeurCase, (y - 1) * hauteurCase, largeurCase, hauteurCase);
                } else if (carte.caisse(x, y) != null) {
                    g.setColor(Color.BLUE);
                    g.fillRect((x - 1) * largeurCase, (y - 1) * hauteurCase, largeurCase, hauteurCase);
                }
            }
        }
        for (int i = 0; i < Caisse.getListposFinales().size(); i++) {
            int x = Caisse.getListposFinales().get(i)[0];
            int y = Caisse.getListposFinales().get(i)[1];
            g.setColor(Color.RED);
            g.fillOval((x - 1) * largeurCase, (y - 1) * hauteurCase, largeurCase, hauteurCase);
        }
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.white);
        String res = "Score: " + points + " points";
        int x = (getWidth() - g.getFontMetrics().stringWidth(res)) / 2;
        g.drawString(res, x, 16);
    }

    public void setPoints() {
        points++;
    }
    public int getPoints(){
        return points;
    }

    public Lutin getJoueurX() {
        return joueurX;
    }

    public static int getLargeurCase() {
        return largeurCase;
    }

    public static void setLargeurCase(int largeurCase) {
        Gui.largeurCase = largeurCase;
    }

    public static int getHauteurCase() {
        return hauteurCase;
    }

    public static void setHauteurCase(int hauteurCase) {
        Gui.hauteurCase = hauteurCase;
    }
}

