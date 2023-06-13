package br.senac.tads.dsw.musicas;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_MUSICA")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    @NotBlank(message = "O campo Título é obrigatório.")
    private String titulo;

    @Column(name = "artista", nullable = false)
    @NotBlank(message = "O campo Artista é obrigatório.")
    private String artista;

    private LocalDate dataLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Musica() {
    }

    public Musica(Long id, @NotBlank(message = "O campo Título é obrigatório.") String titulo,
            @NotBlank(message = "O campo Artista é obrigatório.") String artista, LocalDate dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.dataLancamento = dataLancamento;
    }
}

