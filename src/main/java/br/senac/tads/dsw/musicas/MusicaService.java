package br.senac.tads.dsw.musicas;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.senac.tads.dsw.musicas.*;

@Service
public class MusicaService {
    
    @Autowired
    private MusicaRepository musicaRepository;

    private MusicaDto buildDto(Musica entity) {
        return new MusicaDto(entity.getTitulo(), entity.getArtista(), entity.getDataLancamento());
    }

    private Musica buildEntity(MusicaDto musicaDto) {
        Musica musica = new Musica();
        musica.setTitulo(musicaDto.titulo());
        musica.setArtista(musicaDto.artista());
        musica.setDataLancamento(musicaDto.dataLancamento());
        return musica;
    }

     @Transactional(readOnly = true)
    public List<MusicaDto> findAll() {
        List<Musica> entities = musicaRepository.findAll();
        List<MusicaDto> dtos = new ArrayList<>();
        for (Musica entity : entities) {
            MusicaDto dto = buildDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }


    @Transactional
    public MusicaDto addNew(MusicaDto musicaDto) {
        Musica musica = buildEntity(musicaDto);
        musicaRepository.save(musica);
        return buildDto(musica);
    }
}
