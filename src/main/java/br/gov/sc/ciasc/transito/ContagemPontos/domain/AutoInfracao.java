package br.gov.sc.ciasc.transito.ContagemPontos.domain;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class AutoInfracao {

    @Id
    private Long id;
    private String codigoInfracao;
    private String placa;
    private String numeroAuto;
    private String pontos;
    private String situacao;
    private Long orgao;
    private LocalDate dataAutuacao;
    private String cpf;

    @JsonIgnore
    public int getNumeroDePontos() {
        if(getVerificarPadraoPontuacao()) {
            if(situacao.equals("Em recurso")){
                return 0;
            }
            String[] ponto = pontos.split("-");
            if (ponto[0].equals("3") || ponto[0].equals("4") || ponto[0].equals("5") || ponto[0].equals("7")) {
                return Integer.parseInt(ponto[0]);
            }
        }
        throw new IllegalArgumentException("Pontuação Inválida");
    }

    @JsonIgnore
    public boolean getVerificarPadraoPontuacao(){

        if(pontos.toUpperCase().equals("3-LEVE") ||pontos.toUpperCase().equals("4-MÉDIA")|| pontos.toUpperCase().equals("5-GRAVE")||pontos.toUpperCase().equals("7-GRAVÍSSIMA")){
            return true;
        }

        return false;
    }

    @JsonIgnore
    public boolean getVerificarSituacao(){
        if(situacao.equals("Ativo") || situacao.equals("Em recurso")){
            return true;
        }
        return false;
    }
}
