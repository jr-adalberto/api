package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String uf = "MG";
    private String cidade = "XPTO";
    private String logradouro = "teste";
    private String bairro = "teste";
    private String cep = "3840100";
    private String complemento = "teste";
    private Integer numero = 123;
    //@Embedded
    //private Endereco endereco;
    private Boolean ativo = Boolean.TRUE;

    public Paciente convertToPaciente(DadosCadastroPaciente dados) {
        Paciente paciente = new Paciente();
        paciente.setNome(dados.nome());
        paciente.setEmail(dados.email());
        paciente.setCpf(dados.cpf());
        paciente.setTelefone(dados.telefone());
        paciente.setAtivo(Boolean.TRUE);

        paciente.setUf(dados.endereco() != null ? dados.endereco().uf() : "");
        paciente.setCidade(dados.endereco() != null ? dados.endereco().cidade() : "");
        paciente.setLogradouro(dados.endereco() != null ? dados.endereco().logradouro() : "");

        return paciente;
    }

    public Endereco obtemEndereco() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        endereco.setCep(this.cep);
        endereco.setNumero(String.valueOf(this.numero));
        endereco.setComplemento(this.complemento);
        endereco.setCidade(this.cidade);
        endereco.setUf(this.uf);
        return endereco;
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        //if (dados.endereco() != null)
            //endereco.atualizarInformacoes(dados.endereco());
    }

    public void inativar() {
        this.ativo = false;
    }
}