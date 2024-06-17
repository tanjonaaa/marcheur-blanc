package com.example.walker.model.carte;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rue {
    private final String name;
    private final Lieu lieu1;
    private final Lieu lieu2;

    public Rue(Lieu lieu1, Lieu lieu2) {
        this.name = null;
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
    }
}
