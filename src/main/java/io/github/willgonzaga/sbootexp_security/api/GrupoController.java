package io.github.willgonzaga.sbootexp_security.api;

import io.github.willgonzaga.sbootexp_security.domain.entity.Grupo;
import io.github.willgonzaga.sbootexp_security.domain.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
public class GrupoController {
    private final GrupoRepository repository;

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Grupo> salvar(@RequestBody Grupo grupo) {
        repository.save(grupo);
        return ResponseEntity.ok(grupo);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Grupo>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }
}
