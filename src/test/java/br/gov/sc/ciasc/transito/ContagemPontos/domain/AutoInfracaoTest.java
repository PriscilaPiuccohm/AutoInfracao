package br.gov.sc.ciasc.transito.ContagemPontos.domain;

import br.gov.sc.ciasc.transito.ContagemPontos.services.AutoInfracaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AutoInfracaoTest {
    @Test
    public void NumeroDePontos() {
        // assertEquals("7", AutoInfracao.numeroDePontos(pontos));

        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravíssima");
        ai.setSituacao("Ativo");
        assertEquals(7, ai.getNumeroDePontos());


    }
    @Test
    public void VerificarSituacao(){
        List<AutoInfracao> infracaoList = new ArrayList<>();

        AutoInfracao ai = new AutoInfracao();
        ai.setSituacao("Ativo");

        AutoInfracao ai2 = new AutoInfracao();
        ai2.setSituacao("Em recurso");

        infracaoList = Arrays.asList(ai, ai2);
        assertTrue(ai.getVerificarSituacao());
    }
    @Test
    public void VerificarSituacao2(){
        AutoInfracao ai = new AutoInfracao();
        ai.setSituacao("Em recurço");
        assertFalse(ai.getVerificarSituacao());
    }

    @Test
    public void VerificarPadraoPontuacao() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravivissima");
        ai.setSituacao("Ativo");
        assertFalse(ai.getVerificarPadraoPontuacao());
    }

    @Test
    public void VerificarPadraoPontuacaoMaiusculo() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-GRAVÍSSIMA");
        ai.setSituacao("Ativo");
        assertTrue(ai.getVerificarPadraoPontuacao());
    }

    @Test
    public void VerificarPadraoPontucao2() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("7-Gravíssima");
        ai.setSituacao("Ativo");
        assertTrue(ai.getVerificarPadraoPontuacao());
    }

    @Test
    public void SomarPontos() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("4-Média");
        ai.setSituacao("Ativo");

        AutoInfracao ai1 = new AutoInfracao();
        ai1.setPontos("5-Grave");
        ai1.setSituacao("Ativo");

        List<AutoInfracao> infracaolist = new ArrayList<>();
        infracaolist.add(ai);
        infracaolist.add(ai1);

        AutoInfracaoService ais = new AutoInfracaoService();
        //int contagemPontos = ais.somarPontos(infracaolist);
        assertEquals(9, ais.somarPontos(infracaolist));
    }

    //@Ignore
    @Test
    public void SomarPontosAnual() {
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("3-Leve");
        ai.setDataAutuacao(LocalDate.of(2018, 6, 24));
        ai.setSituacao("Ativo");

        AutoInfracao ai2 = new AutoInfracao();
        ai2.setPontos("4-Média");
        ai2.setDataAutuacao(LocalDate.of(2018, 12, 25));
        ai2.setSituacao("Ativo");

        AutoInfracao ai3 = new AutoInfracao();
        ai3.setPontos("7-Gravíssima");
        ai3.setDataAutuacao(LocalDate.of(2019, 5, 30));
        ai3.setSituacao("Ativo");

        AutoInfracao ai4 = new AutoInfracao();
        ai4.setPontos("5-Leve");
        ai4.setDataAutuacao(LocalDate.of(2019, 9, 1));
        ai4.setSituacao("Ativo");

        List<AutoInfracao> infracaoList = new ArrayList<>();
        infracaoList.add(ai);
        infracaoList.add(ai2);
        infracaoList.add(ai3);
        infracaoList.add(ai4);

        AutoInfracaoService ais = new AutoInfracaoService();
        assertEquals(11, ais.somarPontosAnual(infracaoList, LocalDate.of(2018, 7, 1)));
    }

 @Test
        public void VerificaPontuacao() {

     List<AutoInfracao> infracaoList = new ArrayList<>();

     AutoInfracao ai1 = new AutoInfracao();
     ai1.setPontos("7-Gravíssima");
     ai1.setDataAutuacao(LocalDate.of(2019, 5, 9));
     ai1.setSituacao("Ativo");

     AutoInfracao ai2 = new AutoInfracao();
     ai2.setPontos("7-Gravíssima");
     ai2.setDataAutuacao(LocalDate.of(2019, 6, 10));
     ai2.setSituacao("Ativo");

     AutoInfracao ai3 = new AutoInfracao();
     ai3.setPontos("7-Gravíssima");
     ai3.setDataAutuacao(LocalDate.of(2019, 7, 11));
     ai3.setSituacao("Ativo");

     infracaoList = Arrays.asList(ai1, ai2, ai3);

     AutoInfracaoService ais = new AutoInfracaoService();
     assertTrue(ais.VerificaCNHAnoAFrente(infracaoList, LocalDate.of(2019, 5, 8)));

 }
 @Test
    public void VerificaPontuacaoAtual(){
        List<AutoInfracao> infracaoList = new ArrayList<>();
        AutoInfracao ai1 = new AutoInfracao();
        ai1.setPontos("5-Grave");
        ai1.setDataAutuacao(LocalDate.of(2019,6,26));
        ai1.setSituacao("Ativo");

        AutoInfracao ai2 = new AutoInfracao();
        ai2.setPontos("3-Leve");
        ai2.setDataAutuacao(LocalDate.of(2018,6,25));
        ai2.setSituacao("Ativo");

        AutoInfracao ai3 = new AutoInfracao();
        ai3.setPontos("7-Gravíssima");
        ai3.setDataAutuacao(LocalDate.of(2019,2,5));
        ai3.setSituacao("Ativo");

        AutoInfracao ai4 = new AutoInfracao();
        ai4.setPontos("5-Grave");
        ai4.setDataAutuacao(LocalDate.of(2018,10,31));
        ai4.setSituacao("Ativo");

        infracaoList = Arrays.asList(ai1,ai2,ai3,ai4);
        AutoInfracaoService ais = new AutoInfracaoService();
        assertTrue(ais.VerificaCNHAnoAtras(infracaoList,LocalDate.of(2019,6,26)));
    }
 @Test
    public void PontuacaoUltimos5Anos(){
     List<AutoInfracao> infracaoList = new ArrayList<>();
     AutoInfracao ai = new AutoInfracao();
     ai.setPontos("4-Média");
     ai.setDataAutuacao(LocalDate.of(2014,11,28));
     ai.setSituacao("Ativo");

     AutoInfracao ai2 = new AutoInfracao();
     ai2.setPontos("4-Média");
     ai2.setDataAutuacao(LocalDate.of(2014, 12, 20));
     ai2.setSituacao("Ativo");

     AutoInfracao ai3 = new AutoInfracao();
     ai3.setPontos("3-Leve");
     ai3.setDataAutuacao(LocalDate.of(2015, 1, 22));
     ai3.setSituacao("Ativo");

     AutoInfracao ai4 = new AutoInfracao();
     ai4.setPontos("4-Média");
     ai4.setDataAutuacao(LocalDate.of(2015, 3,30));
     ai4.setSituacao("Ativo");

     AutoInfracao ai5 = new AutoInfracao();
     ai5.setPontos("4-Média");
     ai5.setDataAutuacao(LocalDate.of(2016, 7,4));
     ai5.setSituacao("Ativo");

     AutoInfracao ai6 = new AutoInfracao();
     ai6.setPontos("4-Média");
     ai6.setDataAutuacao(LocalDate.of(2016, 9,14));
     ai6.setSituacao("Ativo");

     AutoInfracao ai7 = new AutoInfracao();
     ai7.setPontos("4-Média");
     ai7.setDataAutuacao(LocalDate.of(2016, 12,26));
     ai7.setSituacao("Ativo");

     AutoInfracao ai8 = new AutoInfracao();
     ai8.setPontos("4-Média");
     ai8.setDataAutuacao(LocalDate.of(2017, 8,3));
     ai8.setSituacao("Ativo");


     AutoInfracao ai9 = new AutoInfracao();
     ai9.setPontos("5-Grave");
     ai9.setDataAutuacao(LocalDate.of(2018, 3,3));
     ai9.setSituacao("Ativo");


     infracaoList = Arrays.asList(ai, ai2, ai3,ai4,ai5,ai6,ai7,ai8,ai9);
     AutoInfracaoService ais = new AutoInfracaoService();

     assertEquals(32, ais.PontuacaoTotalUltimos5Anos(infracaoList, LocalDate.of(2014,12,03)));
    }

    @Test
    public void verificarPeriodo5Anos(){
        List<AutoInfracao> infracaoList = new ArrayList<>();
        AutoInfracao ai = new AutoInfracao();
        ai.setPontos("4-Média");
        ai.setDataAutuacao(LocalDate.of(2014,05,28));
        ai.setSituacao("Ativo");

        AutoInfracao ai2 = new AutoInfracao();
        ai2.setPontos("7-Gravíssima");
        ai2.setDataAutuacao(LocalDate.of(2014, 12, 20));
        ai2.setSituacao("Ativo");

        AutoInfracao ai3 = new AutoInfracao();
        ai3.setPontos("7-Gravíssima");
        ai3.setDataAutuacao(LocalDate.of(2015, 1, 22));
        ai3.setSituacao("Ativo");

        AutoInfracao ai4 = new AutoInfracao();
        ai4.setPontos("4-Média");
        ai4.setDataAutuacao(LocalDate.of(2015, 3,30));
        ai4.setSituacao("Ativo");

        AutoInfracao ai5 = new AutoInfracao();
        ai5.setPontos("5-Grave");
        ai5.setDataAutuacao(LocalDate.of(2016, 7,4));
        ai5.setSituacao("Ativo");

        AutoInfracao ai6 = new AutoInfracao();
        ai6.setPontos("4-Média");
        ai6.setDataAutuacao(LocalDate.of(2016, 9,14));
        ai6.setSituacao("Ativo");

        AutoInfracao ai7 = new AutoInfracao();
        ai7.setPontos("7-Gravíssima");
        ai7.setDataAutuacao(LocalDate.of(2016, 12,26));
        ai7.setSituacao("Ativo");

        AutoInfracao ai8 = new AutoInfracao();
        ai8.setPontos("7-Gravíssima");
        ai8.setDataAutuacao(LocalDate.of(2017, 8,3));
        ai8.setSituacao("Ativo");


        AutoInfracao ai9 = new AutoInfracao();
        ai9.setPontos("7-Gravíssima");
        ai9.setDataAutuacao(LocalDate.of(2017, 9,15));
        ai9.setSituacao("Ativo");

        infracaoList = Arrays.asList(ai, ai2, ai3,ai4,ai5,ai6,ai7,ai8,ai9);
        AutoInfracaoService ais = new AutoInfracaoService();
        assertEquals("Carteira Suspensa",ais.verifcaPontuacao5Anos(infracaoList,LocalDate.of(2019,6,27)));
    }
}
