package main.builder;

import main.model.Class;

/**
 * Builder pro vytváření tříd
 */
public class ClassBuilder {
    private String name;

    public ClassBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Class build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Název třídy nesmí být prázdný");
        }

        return new Class(name);
    }
}