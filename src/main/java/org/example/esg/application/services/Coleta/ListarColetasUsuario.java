package org.example.esg.application.services.Coleta;

import lombok.Builder;
import org.example.esg.application.dtos.out.ColetaResponseDto;
import org.example.esg.application.dtos.out.ColetaResponseSummaryDto;
import org.example.esg.domain.entities.Coleta;
import org.example.esg.infra.persistence.ColetaRepository;
import org.example.esg.infra.persistence.NotificacaoRepository;
import org.example.esg.infra.persistence.PontoColetaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class ListarColetasUsuario {



    private  final ColetaRepository coletaRepository;

    public Page<ColetaResponseDto> listar(Long idUsuario, Pageable pageable){


        return coletaRepository.findByUsuarioId(idUsuario,pageable).map(
                coleta -> new ColetaResponseDto(
                        coleta.getId(),
                        coleta.getPontoColeta().getId(),
                        coleta.getPontoColeta().getNome(),
                        idUsuario,
                        coleta.getTipoMaterial(),
                        coleta.getQuantidade(),
                        coleta.getDataColeta()
                ));

    }

}
