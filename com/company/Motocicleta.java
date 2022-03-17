package com.company;

/**
 * Clasa Motocicleta este o reprezentare a unui obiect motocicleta.
 * Extinde clasa Vehicul, avand ca atribut suplimentar tipul sau.
 */
public class Motocicleta extends Vehicul {
    private String tip;

    /**
     * Creeaza un obiect de tip motocicleta, avand setate gabaritul la 1,
     * costul la 2, si tipul la "Moped"
     */
    public Motocicleta() {
        super(1, 2);
        this.tip = "Moped";
    }

    /**
     * Intoarce valoarea campului tip din cadrul unui obiect Motocicleta
     * @return tipul unui obiect Motocicleta
     */
    public String getTip() {
        return tip;
    }
}
