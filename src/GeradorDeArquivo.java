import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorDeArquivo {
    private static final String nomeArquivo = "historicoConversões.txt";

    public void registrarConversao(String registro) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String horario = LocalDateTime.now().format(dtf);

        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);
            PrintWriter printWriter = new PrintWriter(fileWriter); {
                printWriter.println(horario + " - " + registro);
                printWriter.flush();
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }
}