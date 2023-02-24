package br.ulbra.threads1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {
    
    @GetMapping
    public String semThread() throws InterruptedException {
        TarefaDemorada tarefa = new TarefaDemorada();
        tarefa.processar();

        return "Executou...";
    }

    @GetMapping("thread")
    public String comThread() throws InterruptedException {
        Runnable tarefa = new TarefaDemorada2();
        Thread minhaThread = new Thread(tarefa);
        minhaThread.start();

        return "Executou...";
    }
}
