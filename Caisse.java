import java.util.ArrayList;
import java.util.List;

public class Caisse {
    /**
     * @param listeCaisses: c'est la liste des objets caisses
     * @param x
     * @param y
     * @param style
     * @param posFinales: c'est la position finale des caisses
     */
    private static List<Caisse> listeCaisses = new ArrayList<>();
    private int x;
    private int y;
    private char style;
    private static List<int[]> ListposFinales = new ArrayList<>();
    private int[] posFinales;

    Caisse(int x, int y, char style, int[] posFinales) {
        this.x = x;
        this.y = y;
        this.style = style;
        this.posFinales = posFinales;
        ListposFinales.add(posFinales);
        listeCaisses.add(this);
    }

    public char getStyle() {
        return style;
    }

    public void setStyle(char style) {
        this.style = style;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static List<Caisse> getListeCaisses() {
        return listeCaisses;
    }

    public static void setListeCaisses(List<Caisse> listeCaisses) {
        Caisse.listeCaisses = listeCaisses;
    }

    public static List<int[]> getListposFinales() {
        return ListposFinales;
    }

    public static void setListposFinales(List<int[]> listposFinales) {
        ListposFinales = listposFinales;
    }

    public int[] getPosFinales() {
        return posFinales;
    }

    public void setPosFinales(int[] posFinales) {
        this.posFinales = posFinales;
    }
}
