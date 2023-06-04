package br.senac.tads.dsw.musicas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    // Aqui você pode adicionar métodos personalizados de consulta, se necessário
}
