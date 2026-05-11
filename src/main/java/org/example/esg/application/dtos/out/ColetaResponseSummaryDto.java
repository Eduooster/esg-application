package org.example.esg.application.dtos.out;

import org.example.esg.domain.entities.TipoMaterial;

public record ColetaResponseSummaryDto(
        Long Id,
        Integer quantidadeDepositada,
        TipoMaterial tipoMaterial

) {
}
