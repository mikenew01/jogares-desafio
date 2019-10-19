import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ResultadoJogo implements Serializable {

    private Jogador jogadorVencedor;
    private Jogador jogadorPerdedor;
    private List<String> logBatalha = new LinkedList<>();

    public ResultadoJogo() {}

    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public void setJogadorVencedor(Jogador jogadorVencedor) {
        this.jogadorVencedor = jogadorVencedor;
    }

    public Jogador getJogadorPerdedor() {
        return jogadorPerdedor;
    }

    public void setJogadorPerdedor(Jogador jogadorPerdedor) {
        this.jogadorPerdedor = jogadorPerdedor;
    }

    public List<String> getLogBatalha() {
        return logBatalha;
    }

    public void setLogBatalha(List<String> logBatalha) {
        this.logBatalha = logBatalha;
    }
}
