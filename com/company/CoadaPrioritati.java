package com.company;

import java.util.HashMap;

/**
 * Clasa CoadaPrioritati simuleaza comportamentul unei cozi de prioritati.
 * Aceasta utilizeaza ca structura un HashMap, in care cheia este reprezentata
 * de un String, iar valoarea de un Integer. Prioritatea o va reprezenta
 * valoarea cea mai mica continuta in HashMap.
 */
public class CoadaPrioritati {
    private HashMap<String, Integer> dictionar = new HashMap<>();

    /**
     * Creeaza un obiect de tip CoadaPrioritati
     */
    public CoadaPrioritati() {
    }

    /**
     * Adauga in obiectul de tip CoadaPrioritati, un nou element, avand drept
     * cheie un punct, iar ca valoare costul asociat acelui punct
     * cost
     * @param punct cheia pentru HashMap
     * @param cost valoarea pentru cheie
     */
    public void adauga(String punct, int cost) {
        dictionar.put(punct, cost);
    }

    /**
     * Verifica daca coada de prioritati este vida
     * @return true sau false
     */
    public boolean coadaVida() {
        return dictionar.isEmpty();
    }

    /**
     * Extrage un element din coada de prioritati. Elementul extras
     * este si eliminat.
     * @return cheia elementului extras
     */
    public String extrage() {
        int costMin = Integer.MAX_VALUE;
        String cheieMin = new String();
        for (String punct : dictionar.keySet()) {
            if (dictionar.get(punct) < costMin) {
                costMin = dictionar.get(punct);
                cheieMin = punct;
            }
        }
        dictionar.remove(cheieMin);
        return cheieMin;
    }

    /**
     * Verifica daca exista in coada de prioritati un element, avand o cheie
     * data
     * @param cheie cheia pentru HashMap
     * @return true sau false
     */
    public boolean exista(String cheie) {
        return dictionar.containsKey(cheie);
    }




}
