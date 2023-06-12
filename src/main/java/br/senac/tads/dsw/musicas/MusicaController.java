package br.senac.tads.dsw.musicas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/salvar")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;
   
    private void salvar(Musica musica) {
        musicaRepository.saveAndFlushOrElseThrow(musica);
    }

    private void listar(Model model) {
        List<Musica> musicas = musicaRepository.findAll();
        model.addAttribute("musicas", musicas);
    }

}
