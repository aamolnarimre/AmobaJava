package amoba;

import java.util.Scanner;

public class Amoba {
    private static final int SIZE = 3;
    private static String[][] tabla = new String[SIZE][SIZE];
    private static String aktualisJatekos = "X";

    public static void main(String[] args) {
        beallitasTabla();
        kepernyo();

        while (true) {
            jatekosMozgasa();
            kepernyo();
            if (nyertesEllenorzese()) {
                System.out.println("Gratulálok! " + aktualisJatekos + " nyert!");
                break;
            }
            if (megteltTabla()) {
                System.out.println("Döntetlen!");
                break;
            }
            jatekosValtasa();
        }
    }

    private static void beallitasTabla() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tabla[i][j] = " ";
            }
        }
    }

    private static void kepernyo() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + tabla[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    private static void jatekosMozgasa() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Kérem a sor és az oszlop számát (pl. 1 2): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!ervenyesMozgas(row, col));
        tabla[row][col] = aktualisJatekos;
    }

    private static boolean ervenyesMozgas(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || !tabla[row][col].equals(" ")) {
            System.out.println("Érvénytelen lépés! Kérem, válasszon másik pozíciót.");
            return false;
        }
        return true;
    }

    private static boolean nyertesEllenorzese() {
        // Sorok és oszlopok ellenőrzése
        for (int i = 0; i < SIZE; i++) {
            if (tabla[i][0].equals(aktualisJatekos) && tabla[i][1].equals(aktualisJatekos) && tabla[i][2].equals(aktualisJatekos) ||
                tabla[0][i].equals(aktualisJatekos) && tabla[1][i].equals(aktualisJatekos) && tabla[2][i].equals(aktualisJatekos)) {
                return true;
            }
        }
        // Átlók ellenőrzése
        if (tabla[0][0].equals(aktualisJatekos) && tabla[1][1].equals(aktualisJatekos) && tabla[2][2].equals(aktualisJatekos) ||
            tabla[0][2].equals(aktualisJatekos) && tabla[1][1].equals(aktualisJatekos) && tabla[2][0].equals(aktualisJatekos)) {
            return true;
        }
        return false;
    }

    private static boolean megteltTabla() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (tabla[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void jatekosValtasa() {
        aktualisJatekos = (aktualisJatekos.equals("X")) ? "O" : "X";
    }
}
