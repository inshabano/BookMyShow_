package com.insha.Bookmyshow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

    @Entity
    @Getter
    @Setter
    public class Actor extends BaseModel{
        private String name;
        @ManyToMany
        private List<Movie> movies;
    }

