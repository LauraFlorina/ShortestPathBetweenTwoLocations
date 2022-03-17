package com.company;

/**
 * Clasa Vehicul este o reprezentare a unui vehicul, avand ca atribute: gabarit, cost
 */
public class Vehicul {
    private int gabarit;
    private int cost;

    /**
     * Creeaza un obiect de tip vehicul
     */
    public Vehicul() {
    }

    /**
     * Creeaza un obiect de tip vehicul, avand ca valori pentru atributele sale
     * valoarea parametrilor gabarit si cost
     * @param gabarit valoarea gabaritului corespunzator obiectului de tip
     *                vehicul
     * @param cost valoarea costului corespunzator obiectului de tip vehicul
     */
    public Vehicul(int gabarit, int cost) {
        this.gabarit = gabarit;
        this.cost = cost;
    }

    /**
     * Seteaza campul gabarit al unui obiect de tip vehicul
     * @param gabarit valoarea gabaritului corespunzator obiectului de tip
     *                vehicul
     */
    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    /**
     * Seteaza campul cost al unui obiect de tip vehicul
     * @param cost valoarea costului corespunzator obiectului de tip
     *             vehicul
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Intoarce valoarea gabaritlui obiectului de tip vehicul
     * @return valoarea campului gabarit al obiectului de tip vehicul
     */
    public int getGabarit() {
        return gabarit;
    }

    /**
     * Intoarce valoarea costului obiectului de tip vehicul
     * @return valoarea campului cost al obiectului de tip vehicul
     */
    public int getCost() {
        return cost;
    }
}
