package src.classesObjetos;

import java.awt.Color;
import java.util.Date;
public class Passagem{
    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    private Date dataViagem;
    private String aeroportoSaida;
    private String escolaArtes;
    private Color corPulseira;

    public Passagem(String nome, String cpf, String email, Date dataNascimento, Date dataViagem, String aeroportoSaida, String escolaArtes, Color pulseira){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataViagem = dataViagem;
        this.aeroportoSaida = aeroportoSaida;
        this.escolaArtes = escolaArtes;
        this.corPulseira = pulseira;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public Date getDataViagem(){
        return dataViagem;
    }
    public void setDataViagem(Date dataViagem){
        this.dataViagem=dataViagem;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getAeroportoSaida() {
        return aeroportoSaida;
    }
    public void setAeroportoSaida(String aeroportoSaida) {
        this.aeroportoSaida = aeroportoSaida;
    }
    public String getEscolaArtes() {
        return escolaArtes;
    }
    public void setEscolaArtes(String escolaArtes) {
        this.escolaArtes = escolaArtes;
    }
    public Color getCorPulseira() {
        return corPulseira;
    }
    public void setCorPulseira(Color corPulseira) {
        this.corPulseira = corPulseira;
    }

    @Override
    public String toString() {
        return "Passagem {" +
                "Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Email='" + email + '\'' +
                ", Data de Nascimento=" + dataNascimento +
                ", Data de Viagem=" + dataViagem +
                ", Aeroporto de Saída='" + aeroportoSaida + '\'' +
                ", Escola de Artes='" + escolaArtes + '\'' +
                ", Cor da Pulseira= RGB(" + corPulseira.getRed() + ", " + corPulseira.getGreen() + ", " + corPulseira.getBlue() + ")" +
                '}';
    }
}
