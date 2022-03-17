package com.company;
import java.util.ArrayList;

/**
 * Clasa Strada este o reprezentare a unei strazi avand un nume, un cost de
 * parcurgere, o limita de gabarit, o lista de posibile ambuteiaje, un punct
 * de plecare, si o destinatie.
 */
public class Strada {
    private String nume;
    private int cost;
    private int gabarit;
    private ArrayList<Ambuteiaj> listaAmbuteiaje = new ArrayList<>();
    private String start;
    private String destinatie;

    /**
     * Creeaza un obiect de tip Strada
     */
    public Strada(){

    }

    /**
     * Creeaza un obiect de tip strada, setand pentru acceasta punctul de
     * start, punctul destinatie, costul de parcurgere si limita de gabarit
     * @param start punctul de start al strazii
     * @param destinatie punctul destinatie al strazii
     * @param cost costul de parcurgere al strazii
     * @param gabarit limita de gabarit a strazii
     */
    public Strada(String start, String destinatie, int cost, int gabarit){
        this.cost = cost;
        this.gabarit = gabarit;
        this.start = start;
        this.destinatie = destinatie;
    }

    /**
     * Intoarcele valoarea campului nume pentru un obiect de tip Strada
     * @return numele strazii
     */
    public String getNume() {
        return nume;
    }

    /**
     * Intoarce valoarea campului cost pentru un obiect de tip Strada
     * @return costul obiectului de tip strada
     */
    public int getCost() {
        return cost;
    }

    /**
     * Intoarce valoarea campului gabarit pentru un obiect de tip Strada
     * @return gabaritul obiectului de tip strada
     */
    public int getGabarit() {
        return gabarit;
    }

    /**
     * Returneaza lista ambuteiajelor de pe strada
     * @return lista ambuteiajelor
     */
    public ArrayList<Ambuteiaj> getListaAmbuteiaje() {
        return listaAmbuteiaje;
    }

    /**
     * Intoarce punctul de inceput al strazii
     * @return punctul de start
     */
    public String getStart() {
        return start;
    }

    /**
     * Intoarce punctul destinatie al strazii
     * @return punctul destinatie
     */
    public String getDestinatie() {
        return destinatie;
    }

    /**
     * Seteaza pentru un obiect de tip strada, numele acestuia
     * @param nume numele strazii
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * Seteaza pentru un obiect de tip strada, costul acestuia
     * @param cost costul corespunzator strazii
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Seteaza pentru un obiect de tip strada, gabaritul acestuiia
     * @param gabarit gabaritul corespunzator strazii
     */
    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    /**
     * Seteaza pentru un obiect de tip strada, lista ambuteiajelor
     * @param listaAmbuteiaje lista de ambuteiaje
     */
    public void setListaAmbuteiaje(ArrayList<Ambuteiaj> listaAmbuteiaje) {
        this.listaAmbuteiaje = listaAmbuteiaje;
    }

    /**
     * Seteaza pentru un obiect de tip strada, punctul de start
     * @param start punct de start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Seteaza pentru un obiect de tip strada, punctul destinatie
     * @param destinatie punct destinatie
     */
    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }
}
