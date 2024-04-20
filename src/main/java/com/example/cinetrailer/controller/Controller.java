package com.example.cinetrailer.controller;

import com.example.cinetrailer.model.Pelicula;
import com.example.cinetrailer.repo.PeliculaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {

    @Autowired
    private PeliculaR peliculaRepository;

    @GetMapping("")
    ModelAndView index() {
        List<Pelicula> ultimasPeliculas = peliculaRepository
                .findAll(PageRequest.of(0, 4, Sort.by("fechaEstreno").descending()))
                .toList();

        return new ModelAndView("index")
                .addObject("ultimasPeliculas", ultimasPeliculas);
    }

    @GetMapping("/peliculas")
    ModelAndView listaPeliculas(@PageableDefault(sort = "fechaEstreno", direction = Sort.Direction.DESC)
                                        Pageable pageable) {
        Page<Pelicula> peliculas = peliculaRepository.findAll(pageable);
        return new ModelAndView("peliculas")
                .addObject("peliculas", peliculas);
    }

    @GetMapping("/peliculas/{id}")
    ModelAndView detallesPelicula(@PathVariable Integer id) {
        Pelicula pelicula = peliculaRepository.getOne(id);
        return new ModelAndView("pelicula")
                .addObject("pelicula", pelicula);
    }

}
