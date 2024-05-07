package com.example.cinetrailer.repo;

import com.example.cinetrailer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaR extends JpaRepository<Pelicula, Integer> {
}
