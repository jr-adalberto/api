package med.voll.api.domain.usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String login,
        @NotBlank
        String senha
) {
}