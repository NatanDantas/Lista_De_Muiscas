package br.senac.tads.dsw.musicas;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    Optional<Musica> findByTitulo(String titulo);

    Optional<Musica> findByArtista(String artista);

    Optional<Musica> findByTituloAndArtista(String titulo, String artista);

    boolean existsByTitulo(String titulo);

    boolean existsByArtista(String artista);

    boolean existsByTituloAndArtista(String titulo, String artista);

}
