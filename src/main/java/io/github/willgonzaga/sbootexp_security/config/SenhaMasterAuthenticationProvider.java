package io.github.willgonzaga.sbootexp_security.config;

import io.github.willgonzaga.sbootexp_security.domain.security.CustomAuthentication;
import io.github.willgonzaga.sbootexp_security.domain.security.IdentificacaoUsuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

@Configuration
public class SenhaMasterAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var login = authentication.getName();
        var senha = (String) authentication.getCredentials();

        String loginMaster = "master";
        String senhaMaster = "@321";

        if(loginMaster.equals(login) && senhaMaster.equals(senha)) {
            IdentificacaoUsuario identificacaoUsuario = new IdentificacaoUsuario(
                    "Sou Master",
                    "Master",
                    loginMaster,
                    List.of("ADMIN"));
            return new CustomAuthentication(identificacaoUsuario);
        }


        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
