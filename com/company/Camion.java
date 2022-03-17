package com.company;

/**
 * Clasa Camion este o reprezentare a unui obiect camion.
 * Extinde clasa Vehicul, avand ca atribut suplimentar tipul sau.
 */
public class Camion extends Vehicul {
    private String tip;

    /**
     * Creeaza un obiect de tip Camion, avand setate gabaritul la 3,
     * costul la 6, si tipul la "Autoutilitar"
     */
    public Camion() {
        super(3, 6);
        this.tip = "Autoutilitar";
    }

    /**
     * Intoarce valoarea campului tip din cadrul unui obiect Camion
     * @return tipul unui obiect Camion
     */
    public String getTip() {
        return tip;
    }
}
