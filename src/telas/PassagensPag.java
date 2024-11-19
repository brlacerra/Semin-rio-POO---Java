package src.telas;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import src.classesObjetos.Passagem;
import src.componentes.StJTable;
import src.componentes.stArrayList;

public class PassagensPag extends JPanel {
    public PassagensPag(stArrayList<Passagem> listaDePassagens) {
        setLayout(new BorderLayout());
        

        String[] colunas = {"Nome", "CPF", "Email", "Nascimento", "Viagem", "Aeroporto", "Escola de Artes", "Cor da Pulseira"};

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Object[][] dadosTabela = new Object[listaDePassagens.size()][colunas.length];
        
        for (int i = 0; i < listaDePassagens.size(); i++) {
            Passagem passagem = listaDePassagens.get(i);
            String nasFormatted = dateFormat.format(passagem.getDataNascimento());
            String viagemFormatted = dateFormat.format(passagem.getDataViagem());

            Color corPulseira = passagem.getCorPulseira();
            String rgbFormated = String.format("RBG(%d, %d, %d)", corPulseira.getRed(), corPulseira.getGreen(), corPulseira.getBlue());
            
            dadosTabela[i] = new Object[] {
                passagem.getNome(),
                passagem.getCpf(),
                passagem.getEmail(),
                nasFormatted,
                viagemFormatted,
                passagem.getAeroportoSaida(),
                passagem.getEscolaArtes(),
                rgbFormated
            };
        }


        StJTable tabela = new StJTable(dadosTabela, colunas);
        tabela.setFillsViewportHeight(true);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(250); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(195); 
        tabela.getColumnModel().getColumn(7).setPreferredWidth(150); 
  
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);


        JLabel label = new JLabel("Lista de Passagens", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        add(label, BorderLayout.NORTH);
    }
}
