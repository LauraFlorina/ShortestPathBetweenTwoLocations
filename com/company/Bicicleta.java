package com.company;

/**
 * Clasa Bicicleta este o reprezentare a unui obiect bicicleta.
 * Extinde clasa Vehicul, avand ca atribut suplimentar tipul sau.
 */
public class Bicicleta extends Vehicul {
    private String tip;

    /**
     * Creeaza un obiect de tip bicicleta, avand setate gabaritul la 1,
     * costul la 1, si tipul la "Bicicleta"
     */
    public Bicicleta() {
        super(1, 1);
        this.tip = "Bicicleta";
    }

    /**
     * Intoarce valoarea campului tip din cadrul unui obiect Bicicleta
     * @return tipul unui obiect Bicicleta
     */
    public String getTip() {
        return tip;
    }
}
