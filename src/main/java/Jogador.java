import java.io.Serializable;

public class Jogador implements Serializable {

    private String nickname;
    private Integer ataque;
    private Integer defesa;
    private Integer vida;
    private Boolean primeiroJogador;
    private Boolean minhaVez;

    public Jogador(String nickname, Integer ataque, Integer defesa, Integer vida, Boolean primeiroJogador) {
        this.nickname = nickname;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.primeiroJogador = primeiroJogador;
        this.minhaVez = primeiroJogador;
    }

    public Boolean getMinhaVez() {
        return minhaVez;
    }

    public void setMinhaVez(Boolean minhaVez) {
        this.minhaVez = minhaVez;
    }

    public Boolean getPrimeiroJogador() {
        return primeiroJogador;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }
}
