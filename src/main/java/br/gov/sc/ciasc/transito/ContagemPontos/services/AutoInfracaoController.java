package br.gov.sc.ciasc.transito.ContagemPontos.services;
import br.gov.sc.ciasc.transito.ContagemPontos.domain.AutoInfracao;
import br.gov.sc.ciasc.transito.ContagemPontos.repository.AutoInfracaoRepository;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/{cpf}")
public class AutoInfracaoController {

    @Autowired
    private AutoInfracaoService autoInfracaoService;

    @GetMapping("/infracoes")
    public List<AutoInfracao> listarInfracoes(@PathVariable String cpf) {
        return autoInfracaoService.buscarPorCpf(cpf);
    }

    @GetMapping("/pontuacao")
    public int pontuacao(@PathVariable String cpf){
        return autoInfracaoService.buscarPontuacaoTotalPorCpf(cpf);
    }

    @GetMapping("/suspenso")
    public String VerificarSeCNHSuspensa(@PathVariable String cpf){
        return autoInfracaoService.verificarCarteiraSuspensaPorCpf(cpf);
    }

    @GetMapping("/arquivo")
    public AutoInfracao[] leituraArquivo(@PathVariable String cpf) throws IOException {
        String fileName = "infracoes.json";

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

//File is found
        System.out.println("File Found : " + file.exists());

        Gson gson = new Gson();
        AutoInfracao[] autoInfracaos = gson.fromJson(new String(Files.readAllBytes(file.toPath())), AutoInfracao[].class);
//Read File Content
        return autoInfracaos;

    }
}
