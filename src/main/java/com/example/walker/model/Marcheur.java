package com.example.walker.model;

import com.example.walker.model.carte.Carte;
import com.example.walker.model.carte.Lieu;
import com.example.walker.model.carte.Rue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public record Marcheur(String name, Carte carte) {
  public List<Lieu> marcheEntre(Lieu lieuDeDépart, Lieu destination) {
    var générateurDeNombresAléatoires = new Random();
    List<Lieu> itinéraire = new ArrayList<>();
    Lieu position = lieuDeDépart;
    itinéraire.add(position);

    while (!position.equals(destination)) {
      List<Lieu> lieuxVoisins = détermineLesLieuxVoisins(position);
      position = prendUnLieuAléatoirement(lieuxVoisins, générateurDeNombresAléatoires);
      itinéraire.add(position);
    }

    return itinéraire;
  }

  private Lieu prendUnLieuAléatoirement(List<Lieu> lieux, Random générateurDeNombresAléatoires) {
    return lieux.get(générateurDeNombresAléatoires.nextInt(lieux.size()));
  }

  private List<Lieu> détermineLesLieuxVoisins(Lieu position) {
    Set<Rue> rues = carte.rues();
    return rues.stream()
        .filter(rue -> rue.getLieu1().equals(position) || rue.getLieu2().equals(position))
        .map(rue -> prendLeLieuSuivant(rue, position))
        .toList();
  }

  private Lieu prendLeLieuSuivant(Rue rue, Lieu position) {
    Lieu lieuSuivant = null;
    if (rue.getLieu1().equals(position)) lieuSuivant = rue.getLieu2();
    if (rue.getLieu2().equals(position)) lieuSuivant = rue.getLieu1();
    return lieuSuivant;
  }
}
