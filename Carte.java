import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Carte {
    /**
     * @param plan
     * @param col commence par 1
     * @param lig commence par 1
     */
    private static int[] plan;
    private int col;
    private int lig;

    public Carte(String path) {
        File file = new File(path);
        plan = new int[(int) file.length()];
        try (FileReader fr = new FileReader(file)) {
            int content;
            boolean condition_satisfait = false;
            int i = 0;
            int c = 0; // calculer la hauteur
            while ((content = fr.read()) != -1) {
                plan[i] = content;
                i++;
                if (content == 10) {
                    c++;
                    if (!condition_satisfait) {
                        col = i - 1;
                        condition_satisfait = !condition_satisfait;
                    }
                }
            }
            lig = c;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculePosition(int i, int j) {
        int a = col;
        return (--j * ++a) + --i;
    }

    public void placeCaisse(Caisse c) {
        Caisse.getListeCaisses().add(c);
    }

    public void retireCaisse(int i, int j) {
        Caisse.getListeCaisses().remove(caisse(i, j));
    }

    public boolean mur(int i, int j) {
        return (plan[calculePosition(i, j)] == 88);
    }

    public boolean position(Caisse c, int x, int y) {
        return (c.getPosFinales()[0] == x && c.getPosFinales()[1] == y);
    }

    public Caisse caisse(int x, int y) {
        for (Caisse c : Caisse.getListeCaisses()) {
            if (c.getX() == x && c.getY() == y)
                return c;
        }
        return null;
    }

    public int getX() {
        return col;
    }

    public int getY() {
        return lig;
    }

    @Override
    public String toString() {
        String a = "";
        for (int e : plan)
            a += (char) e;
        return a;
    }

}
