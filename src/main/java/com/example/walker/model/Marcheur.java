package com.example.walker.model;

import com.example.walker.model.carte.Carte;
import com.example.walker.model.carte.Lieu;
import java.util.List;

public record Marcheur(String name) {
  public Marche marcheSur(Carte carte, Lieu lieuDeDépart, Lieu destination) {
    return new Marche(List.of());
  }
}
