package br.senac.tads.dsw.musicas;

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
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;
    
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("musica", new Musica());
        return "formulario-musica";
    }
    
    @PostMapping("/novo")
    public String adicionarMusica(@Valid @ModelAttribute("musica") Musica musica, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formulario-musica";
        }
        
        musicaRepository.save(musica);
        return "redirect:/musicas";
    }
}
