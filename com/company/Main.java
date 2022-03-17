package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clasa Main este clasa cea care opereaza cu fisierele de input si output,
 * in vederea calcularii celui mai scurt drum dintre doua puncte,
 * data fiind o harta a orasului.
 */
public class Main {

    /**
     * Se adauga o strada avand informatiile primite, in harta.
     * @param harta obiectul harta
     * @param detaliiStrada string ce contine informatiile despre o strada
     */
    public static void AdaugaStradaCitita(Harta harta, String detaliiStrada) {
        String[] elemente = detaliiStrada.split(" ");
        String start = elemente[0];
        String destinatie = elemente[1];
        int cost = Integer.parseInt(elemente[2]);
        int gabarit = Integer.parseInt(elemente[3]);
        harta.addStreet(start, destinatie, cost, gabarit);
    }

    /**
     * Metoda main citeste din fisierul de input, modeleaza informatiile
     * cu ajutorul celorlalte clase, si scrie in fisierul de output.
     * @param args niciunul
     */
    public static void main(String[] args) {
        Harta harta = new Harta();
        try {
            // fisier input
            File fisier = new File("map.in");
            Scanner input = new Scanner(fisier);
            // fisier output
            FileWriter fisierOut = new FileWriter("map.out");

            String primaLinie = input.nextLine();
            String primulCuvant = primaLinie.substring(0, primaLinie.indexOf(" "));
            int nrStrazi = Integer.parseInt(primulCuvant);
            // se citesc strazile
            for (int i = 0; i < nrStrazi; i++) {
                String detaliiStrada = input.nextLine();
                AdaugaStradaCitita(harta, detaliiStrada);
            }
            // se citesc restul liniilor
            while(input.hasNextLine()) {
                String comanda = input.nextLine();
                String[] elemente = comanda.split(" ");
                if (elemente[0].equals("drive")) {
                    String vehicle = elemente[1];
                    String start = elemente[2];
                    String end = elemente[3];
                    String rezultat = harta.drive(vehicle, start, end);
                    // pentru functia drive, se scrie rezultatul in fisier
                    fisierOut.write(rezultat + "\n");
                } else {
                    String type = elemente[0];
                    String start = elemente[1];
                    String end = elemente[2];
                    int cost = Integer.parseInt(elemente[3]);
                    harta.addRestriction(type, start, end, cost);
                }
            }
            input.close();
            fisierOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
