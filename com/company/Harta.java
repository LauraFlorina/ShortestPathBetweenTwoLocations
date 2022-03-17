package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clasa Harta reprezinta modelarea unei harti a orasului, continand
 * o serie de puncte, si o serie de strazi intre unele din aceste puncte.
 * Contine ca atribut, o lista de obiecte de tip Strada.
 */
public class Harta {
    private ArrayList<Strada> listaStrazi = new ArrayList<>();

    /**
     * Creeaza un obiect de tip Harta
     */
    public Harta() {
    }

    /**
     * Adauga o strada, in lista strazilor continuta de obiectul de tip Harta
     * @param start punct de start
     * @param end punct destinatie
     * @param cost costul strazii
     * @param size gabaritul strazii
     */
    public void addStreet(String start, String end, int cost, int size) {
        Strada street = new Strada(start, end, cost, size);
        listaStrazi.add(street);
    }

    /**
     * Cauta strada dintre punctele "start" si "end" primite ca parametru,
     * in lista de strazi a hartii, si intoarce o referinta la strada, daca
     * aceasta exista, sau null in caz contrar
     * @param start punct de start al strazii
     * @param end punct destinatie al strazii
     * @return referinta catre strada sau null
     */
    public Strada findStreet(String start, String end) {
        for (Strada street : listaStrazi) {
            String streetStart = street.getStart();
            String streetEnd = street.getDestinatie();
            if (streetStart.equals(start) && streetEnd.equals(end)) {
                return street;
            }
        }
        return null;
    }

    /**
     * Cauta strada dintre punctele "start" si "end" primite ca parametru si
     * creeaza un nou obiect de tip ambuteiaj, avand un tip si un cost dat,
     * pe care il adauga in lista de ambuteiaje a strazii.
     * @param type tipul restrictiei
     * @param start punct start strada
     * @param end punct destinatie strada
     * @param cost cost restrictie
     */
    public void addRestriction(String type, String start, String end, int cost) {
        Strada street = findStreet(start, end);
        Ambuteiaj ambuteiajStrada = new Ambuteiaj(type, cost);
        street.getListaAmbuteiaje().add(ambuteiajStrada);
    }

    /**
     * Parcurge lista de strazi a hartii, si creeaza o lista ce contine
     * toate punctele din harta sub forma unei lista
     * @return lista punctelor din harta
     */
    public ArrayList<String> creeazaListaPuncte() {
        ArrayList<String> listaPuncte = new ArrayList<>();
        for (Strada street : listaStrazi) {
            if (!(listaPuncte.contains(street.getStart()))) {
                listaPuncte.add(street.getStart());
            }
            if (!(listaPuncte.contains(street.getDestinatie()))) {
                listaPuncte.add(street.getDestinatie());
            }
        }
        return listaPuncte;
    }

    /**
     * Calculeaza costul unui vehicul de a parcurge o strada. Se intoarce
     * un cost infinit, in cazul in care strada nu exista, sau vehiculul
     * nu poate parcurge respectiva strada, sau costul finit.
     * @param start punctul de start al strazii
     * @param end punctul destinatie al strazii
     * @param vehicul vehiculul condus
     * @return costul de parcurgere al strazii
     */
    public int costVehicul(String start, String end, Vehicul vehicul) {
        int costTotal = Integer.MAX_VALUE;
        Strada street = findStreet(start, end);
        if (street == null) {
            return costTotal;
        }
        if (vehicul.getGabarit() > street.getGabarit()) {
            return costTotal;
        }
        costTotal = 0;
        costTotal = street.getCost() * vehicul.getCost();
        // Se adauga la costul de parcurgere al strazii de catre vehicul,
        // costurile ambuteiajelor de pe strada
        for (Ambuteiaj ambuteiaj : street.getListaAmbuteiaje()) {
            costTotal += ambuteiaj.getCost();
        }
        return costTotal;
    }

    /**
     * Pornind din punctul primit ca parametru, se construieste calea punctelor
     * parcurse pana in punctul curent
     * @param punct nod din harta
     * @param anterior hashmap ce are drept cheie un punct, iar drept valoare
     *                 punctul precedent cheii
     * @return cale a punctelor parcurse pana in punctul primit ca parametru
     */
    public String creeazaCale(String punct, HashMap<String, String> anterior) {
        String cale = "" + punct; // se adauga punctul primit ca parametru
        while(anterior.containsKey(punct) == true) {
            // se introduce punctul anterior, in fata celorlalte puncte
            cale = anterior.get(punct) + " " + cale;
            punct = anterior.get(punct);
        }
        // se returneaza calea, eliminandu-se " " de la inceput
        return cale.substring(1);
    }

    /**
     * Primind o cale si un cost, intoarce un string obtinut prin concatenarea
     * acestora.
     * @param cale cale de puncte
     * @param cost costul
     * @return concatenare a punctelor cu costul
     */
    public String creeazaRezultat(String cale, int cost) {
        String rezultat = cale;
        if (cost == Integer.MAX_VALUE - 1) {
            rezultat = rezultat + " null";
        } else {
            rezultat = rezultat + " " + cost;
        }
        return rezultat;
    }

    /**
     * Metoda calculeaza cea mai scurta cale de a ajunge din start
     * la destinatie, conducand vehiculul primit ca parametru. Aceasta
     * returneaza succesiunea punctelor vizitate, impreuna cu costul de
     * parcurgere.
     * @param start punct de start al strazii
     * @param end punct destinatie al strazii
     * @param vehicul vehiculul condus
     * @return un string reprezentand succesiunea punctelor parcurse
     * impreuna cu costul de parcurgere
     */
    public String aplicareDijkstra(String start, String end, Vehicul vehicul) {
        String rezultat = null;
        ArrayList<String> puncteGraf = creeazaListaPuncte();
        HashMap<String, Integer> distanta = new HashMap<>();
        HashMap<String, String> anterior = new HashMap<>();
        CoadaPrioritati coadaPrioritati = new CoadaPrioritati();

        for (String punct : puncteGraf) {
            if (punct.equals(start)) {
                distanta.put(start, 0); // se seteaza costul 0 pentru start
            } else {
                // pentru celelalte puncte, costul initial este
                // Integer.MAX_VALUE - 1
                distanta.put(punct, Integer.MAX_VALUE - 1);
            }
            // initial niciun punct nu are un punct precedent
            anterior.put(punct, "");
            // se adauga punctul in coada de prioritati
            coadaPrioritati.adauga(punct, distanta.get(punct));
        }

        int distNoua = 0;
        while (!(coadaPrioritati.coadaVida())) {
            String nodCostMin = coadaPrioritati.extrage();
            int distNodCostMin = distanta.get(nodCostMin);

            for (String punct : puncteGraf) {
                // se verifica daca punctul exista in coada de prioritati
                if (!(coadaPrioritati.exista(punct))) {
                    continue;
                }
                // se calculeaza costul de a ajunge in punct, plecand din
                // punctul cu cost minim
                int costVehicul = costVehicul(nodCostMin, punct, vehicul);
                if (costVehicul == Integer.MAX_VALUE) {
                    continue;
                }
                // se calculeaza noua distanta, iar in cazul in care aceasta
                // este mai mica, se actualizeaza informatiile
                if (distNodCostMin == Integer.MAX_VALUE - 1) {
                    distNoua = Integer.MAX_VALUE - 1;
                } else {
                    distNoua = distNodCostMin + costVehicul;
                }
                if (distNoua < distanta.get(punct)) {
                    distanta.replace(punct, distNoua);
                    coadaPrioritati.adauga(punct, distNoua);
                    anterior.replace(punct, nodCostMin);
                }
            }
            // cand se ajunge la punctul destinatie, se intoarce rezultatul
            if (nodCostMin.equals(end)) {
                // daca punctul destinatie nu are niciun punct anterior
                // acesta este setat implicit ca fiind punctul de start
                if (anterior.get(nodCostMin).equals("")) {
                    anterior.replace(nodCostMin, start);
                }
                String cale = creeazaCale(end, anterior);
                rezultat = creeazaRezultat(cale, distanta.get(end));
                break;
            }
        }
        return rezultat;
    }

    /**
     * Metoda intorace cea mai scurta cale de a ajunge de la start la
     * destinatie, conducand un vehicul.
     * @param vehicle vehiculul condus
     * @param start punct de start
     * @param end punct destinatie
     * @return un string reprezentand succesiunea punctelor parcurse
     *      * impreuna cu costul de parcurgere
     */
    public String drive(String vehicle, String start, String end) {
        Vehicul vehiculCondus = null;
        if (vehicle.equals("b")) {
            vehiculCondus = new Bicicleta();
        }
        if (vehicle.equals("m")) {
            vehiculCondus = new Motocicleta();
        }
        if (vehicle.equals("a")) {
            vehiculCondus = new Autoturism();
        }
        if (vehicle.equals("c")){
            vehiculCondus = new Camion();
        }
        return aplicareDijkstra(start, end, vehiculCondus);
    }
}
