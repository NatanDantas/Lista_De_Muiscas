package br.senac.tads.dsw.musicas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    
    default Musica findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException("Música não encontrada"));
    }

    default Musica saveAndFlushOrElseThrow(Musica musica) {
        return saveAndFlush(musica);
    }
    
    default Musica findAll (Musica musica) {
        return findAll(musica);
    }
}
