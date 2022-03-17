package com.company;

/**
 * Clasa Autoturism este o reprezentare a unui obiect autoturism.
 * Extinde clasa Vehicul, avand ca atribut suplimentar tipul sau.
 */
public class Autoturism extends Vehicul {
    private String tip;

    /**
     * Creeaza un obiect de tip Autoturism, avand setate gabaritul la 2,
     * costul la 4, si tipul la "Autovehicul"
     */
    public Autoturism() {
        super(2, 4);
        this.tip = "Autovehicul";
    }

    /**
     * Intoarce valoarea campului tip din cadrul unui obiect Autoturism
     * @return tipul unui obiect Autoturism
     */
    public String getTip() {
        return tip;
    }
}
