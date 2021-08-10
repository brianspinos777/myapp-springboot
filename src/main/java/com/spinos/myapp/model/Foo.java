package com.spinos.myapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

// no @Entity ?
// use UUID ?
public class Foo {

    private final UUID id;
    private final String name;

    // @NotBlank - search for validations
    private final String description;

    public Foo(@JsonProperty("id") UUID id, // for POST request to send id and props ?
               @JsonProperty("name") String name,
               @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
