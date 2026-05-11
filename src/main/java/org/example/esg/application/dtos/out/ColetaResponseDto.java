package org.example.esg.application.dtos.out;

import org.example.esg.domain.entities.TipoMaterial;

import java.time.LocalDateTime;

public record ColetaResponseDto(
        Long id,

        Long pontoColetaId,
        String pontoColetaNome,

        Long usuarioId,


        TipoMaterial tipoMaterial,

        Integer quantidade,

        LocalDateTime dataColeta
){

}