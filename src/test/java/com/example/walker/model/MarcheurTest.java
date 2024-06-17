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

    var rue1 = new Rue(Set.of(marais, sekolintsika));
    var rue2 = new Rue(Set.of(sekolintsika, hei));
    var andiantsihoarana = new Rue(Set.of(hei, pullman));
    var rue3 = new Rue(Set.of(hei, balançoire));
    var ranaivo = new Rue(Set.of(pullman, balançoire));
    var rue4 = new Rue(Set.of(balançoire, esti));
    var rue5 = new Rue(Set.of(balançoire, boulevardDelEurope));
    var rue6 = new Rue(Set.of(esti, boulevardDelEurope));
    var rue7 = new Rue(Set.of(pullman, nexta));

    var carteDeTana =
        new Carte(Set.of(rue1, rue2, andiantsihoarana, rue3, ranaivo, rue4, rue5, rue6, rue7));

    var bjarni = new Marcheur("Bjarni");

    var marcheDeBjarni = bjarni.marcheSur(carteDeTana, hei, esti);

    var actualLieuDeDépart = marcheDeBjarni.getLieux().getFirst();
    var actualLieuDArrivée = marcheDeBjarni.getLieux().getLast();
    var longueurDeLaMarche = marcheDeBjarni.getLieux().size();

    assertEquals(hei, actualLieuDeDépart);
    assertEquals(esti, actualLieuDArrivée);
    assertTrue(longueurDeLaMarche >= 3);
  }
}
