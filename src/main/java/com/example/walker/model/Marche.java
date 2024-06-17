package com.example.walker.model;

import com.example.walker.model.carte.Lieu;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Marche {
  private final List<Lieu> lieux;

  public Marche(List<Lieu> lieux) {
    this.lieux = new ArrayList<>();
  }
}
