package com.example.cinetrailer.controller;
import com.example.cinetrailer.model.Genero;
import com.example.cinetrailer.model.Pelicula;
import com.example.cinetrailer.repo.GeneroR;
import com.example.cinetrailer.repo.PeliculaR;
import com.example.cinetrailer.service.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class  AdminController {
    @Autowired
    private PeliculaR peliculaRepository;
    @Autowired
    private GeneroR generoRepository;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;
    @GetMapping("")
    ModelAndView index(@PageableDefault(sort = "titulo", size = 5) Pageable pageable) {
        Page<Pelicula> peliculas = peliculaRepository.findAll(pageable);
        return new ModelAndView("admin/index")
                .addObject("peliculas", peliculas);
    }


}
