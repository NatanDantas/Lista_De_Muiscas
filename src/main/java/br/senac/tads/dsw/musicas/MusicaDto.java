package br.senac.tads.dsw.musicas;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record MusicaDto(

    @NotBlank(message = "O campo Título é obrigatório.")
    @Size(max = 100)
    String titulo,

    @NotBlank(message = "O campo Artista é obrigatório.")
    @Size(max = 100)
    String artista,

    @PastOrPresent
    LocalDate dataLancamento
    
    ) {

}
