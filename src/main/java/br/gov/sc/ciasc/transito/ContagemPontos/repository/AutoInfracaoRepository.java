package br.gov.sc.ciasc.transito.ContagemPontos.repository;

import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoInfracaoRepository extends JpaRepository<AutoInfracao,Integer> {

    List<AutoInfracao> findByCpf(String cpf);
}
