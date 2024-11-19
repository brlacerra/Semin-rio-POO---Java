package src;

import src.classesObjetos.Passagem;
import src.componentes.stArrayList;
import src.telas.InicialPag;

public class Main {
    public static void main(String[] args) {
        String nomearq = "passagens.bin";
        stArrayList<Passagem> listaDePassagens = new stArrayList<>();
        listaDePassagens.clear();

        new InicialPag(listaDePassagens, nomearq);
    }
}
