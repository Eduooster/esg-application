package org.example.esg.web.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.esg.application.dtos.in.ColetaRequestDto;
import org.example.esg.application.dtos.out.ColetaResponseDto;
import org.example.esg.application.dtos.out.ColetaResponseSummaryDto;
import org.example.esg.application.services.Coleta.ListarColetasUsuario;
import org.example.esg.application.services.Coleta.CriarColetaService;
import org.example.esg.domain.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/coleta")
@RequiredArgsConstructor

public class ColetaController {

    private final CriarColetaService criarColetaService;
    private final ListarColetasUsuario listarColetasUsuario;


    @PostMapping
    public ResponseEntity criar (@RequestBody @Valid ColetaRequestDto request, @AuthenticationPrincipal Usuario usuario,
                                 UriComponentsBuilder uriBuilder){

        ColetaResponseSummaryDto responseDto = criarColetaService.criarColeta(request,usuario);

        URI uri = uriBuilder.path("/ponto-coleta/")
                .buildAndExpand(responseDto.Id())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping
    public ResponseEntity<Page<ColetaResponseDto>> listarColetas (
            @AuthenticationPrincipal Usuario usuario,
            @PageableDefault(size = 10,sort = {"dataColeta"}) Pageable pageable

    ){
        return ResponseEntity.ok(listarColetasUsuario.listar(usuario.getId(),pageable));
    }


}
