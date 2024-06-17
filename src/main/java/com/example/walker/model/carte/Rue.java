package com.example.walker.model.carte;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rue {
    private final String name;
    private final Set<Lieu> lieux;

    public Rue(Set<Lieu> lieux) {
        this.name = null;
        this.lieux = lieux;
    }
}
