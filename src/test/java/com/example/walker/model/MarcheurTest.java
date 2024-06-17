package com.example.walker.model;

import static org.junit.jupiter.api.Assertions.*;

import com.example.walker.model.carte.Carte;
import com.example.walker.model.carte.Lieu;
import com.example.walker.model.carte.Rue;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MarcheurTest {

  @Test
  void bjarni_marche_sur_tana_de_hei_vers_esti() {
    var marais = new Lieu("Marais");
    var sekolintsika = new Lieu("Sekolintsika");
    var hei = new Lieu("HEI");
    var pullman = new Lieu("Pullman");
    var balançoire = new Lieu("Balançoire");
    var boulevardDelEurope = new Lieu("Boulevard de l'Europe");
    var nexta = new Lieu("Nexta");
    var esti = new Lieu("ESTI");

    var rue1 = new Rue(marais, sekolintsika);
    var rue2 = new Rue(sekolintsika, hei);
    var andiantsihoarana = new Rue("Rue Andriantsihoarana", hei, pullman);
    var rue3 = new Rue(hei, balançoire);
    var ranaivo = new Rue("Rue Ranaivo", pullman, balançoire);
    var rue4 = new Rue(balançoire, esti);
    var rue5 = new Rue(balançoire, boulevardDelEurope);
    var rue6 = new Rue(esti, boulevardDelEurope);
    var rue7 = new Rue(pullman, nexta);

    var carteDeTana =
        new Carte(Set.of(rue1, rue2, andiantsihoarana, rue3, ranaivo, rue4, rue5, rue6, rue7));

    var bjarni = new Marcheur("Bjarni", carteDeTana);

    var itinéraireDeBjarni = bjarni.marcheEntre(hei, esti);

    var actualLieuDeDépart = itinéraireDeBjarni.getFirst();
    var actualLieuDArrivée = itinéraireDeBjarni.getLast();
    var longueurDeLaMarche = itinéraireDeBjarni.size();

    assertEquals(hei, actualLieuDeDépart, "La marche commence à" + hei.name());
    assertEquals(esti, actualLieuDArrivée, "La marche se termine à " + esti.name());
    assertTrue(
        longueurDeLaMarche >= 3,
        "La marche de " + hei.name() + " vers " + esti.name() + " contient au moins 03 étapes");
  }
}
