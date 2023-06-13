package br.senac.tads.dsw.musicas;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/musica")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public List<Musica> findAll() {
        return musicaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addNew(@RequestBody @Valid Musica musica) {
        musicaRepository.save(musica);
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(musica.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
