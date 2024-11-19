package src.componentes;

import javax.swing.*;
import java.awt.*;
import src.telas.InicialPag;

import java.util.ArrayList;
import java.util.List;

public class NavBar {
    private JPanel navBarPanel;
    private List<StButton> buttons;
    private StButton activeButton;

    public NavBar(InicialPag mainFrame) {
        this.buttons = new ArrayList<>();
        navBarPanel = new JPanel(new BorderLayout());
        navBarPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(184, 134, 11)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        navBarPanel.setBackground(new Color(211, 211, 211));

        JLabel titulo = new JLabel("CAMINHO DA ARTE CLÁSSICA - POO1");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titulo.setForeground(new Color(139, 69, 19));
        navBarPanel.add(titulo, BorderLayout.WEST);

        JPanel botoes = new JPanel();
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
        Dimension buttonsize = new Dimension(150, 40);

        StButton homepageButton = new StButton("Homepage", buttonsize);
        homepageButton.addActionListener(e -> {
            mainFrame.showPage("InicialPag");
            setActiveButton(homepageButton);
        });

        StButton grecoButton = new StButton("Greco-Romana", buttonsize);
        grecoButton.addActionListener(e -> {
            mainFrame.showPage("GrecoRomanoPag");
            setActiveButton(grecoButton);
        });

        StButton neoButton = new StButton("Neoclássico", buttonsize);
        neoButton.addActionListener(e -> {
            mainFrame.showPage("NeoClassicoPag");
            setActiveButton(neoButton);
        });
        StButton passagemButton = new StButton("Passagens", buttonsize);
        passagemButton.addActionListener(e -> {
            mainFrame.showPage("PassagensPag");
            setActiveButton(passagemButton);
        });

        buttons.add(homepageButton);
        buttons.add(grecoButton);
        buttons.add(neoButton);
        buttons.add(passagemButton);

        botoes.add(homepageButton);
        botoes.add(grecoButton);
        botoes.add(neoButton);
        botoes.add(passagemButton);


        navBarPanel.add(botoes, BorderLayout.EAST);
        setActiveButton(homepageButton);
    }

    public JPanel getNavBarPanel() {
        return navBarPanel;
    }

    private void setActiveButton(StButton button){
        if(activeButton != null){
            activeButton.setInactiveStyle();
        }
        activeButton = button;
        activeButton.setActiveStyle();
    }
}
