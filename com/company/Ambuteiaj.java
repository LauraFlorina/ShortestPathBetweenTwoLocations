package com.company;

/**
 * Clasa Ambuteiaj, modeleaza un ambuteiaj ce poate avea loc pe o strada,
 * avand drept campuri tipul acestuia si costul produs de ambuteiaj
 */
public class Ambuteiaj {
    private String tip;
    private int cost;

    /**
     * Creeaza un obiect de tip Ambuteiaj
     */
    public Ambuteiaj() {
    }

    /**
     * Creeaza un obiect de tip Ambuteiaj, initializand campurile tip si cost
     * cu valorile primite drept parametru
     * @param tip tipul ambuteiajului
     * @param cost costul ambuteiajului
     */
    public Ambuteiaj(String tip, int cost) {
        this.tip = tip;
        this.cost = cost;
    }

    /**
     * Seteaza campul tip pentru un obiect de tip Ambuteiaj
     * @param tip tipul ambuteiajului
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    /**
     * Seteaza costul pentru un obiect de tip Ambuteiaj
     * @param cost costul ambuteiejului
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Returneaza tipul unui ambuteiaj
     * @return tip ambuteiaj
     */
    public String getTip() {
        return tip;
    }

    /**
     * Returneaza costul unui obiect de tip Ambuteiaj
     * @return cost ambuteiaj
     */
    public int getCost() {
        return cost;
    }
}
