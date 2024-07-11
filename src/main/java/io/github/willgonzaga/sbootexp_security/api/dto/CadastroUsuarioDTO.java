package io.github.willgonzaga.sbootexp_security.api.dto;

import io.github.willgonzaga.sbootexp_security.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {
    private Usuario usuario;
    private List<String> permissoes;

}
