package src.telas;

import javax.swing.*;

import src.classesObjetos.Passagem;
import src.componentes.StButton;
import src.componentes.StSlider;
import src.componentes.stArrayList;
import src.formularios.FormViagem;

import java.awt.*;
import java.util.Hashtable;

public class NeoClassicoPag extends JPanel {
    private stArrayList<Passagem> listaDePassagens;
    public NeoClassicoPag(stArrayList<Passagem> listaDePassagens) {
        this.listaDePassagens = listaDePassagens;
        setLayout(new BorderLayout());

        JPanel grecoPanel = new JPanel();
        grecoPanel.setLayout(new BoxLayout(grecoPanel, BoxLayout.PAGE_AXIS)); 
        grecoPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel title = new JLabel("O Renascimento do Clássico: Estética, Sociedade e Arte no Neoclassicismo");
        title.setFont(new Font("Georgia", Font.BOLD, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subTitle1 = new JLabel("Influência Cultural e Social");
        subTitle1.setFont(new Font("Georgia", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        grecoPanel.add(title);
        grecoPanel.add(Box.createVerticalStrut(10));
        grecoPanel.add(subTitle1);
        grecoPanel.add(Box.createVerticalStrut(10));
        grecoPanel.add(contentPanel());
        grecoPanel.add(Box.createVerticalStrut(20));
        grecoPanel.add(sliderPanel());
        grecoPanel.add(Box.createVerticalStrut(-20));
        grecoPanel.add(escolaPanel());
        grecoPanel.add(Box.createVerticalStrut(30));


        add(grecoPanel, BorderLayout.NORTH);
    }
    private JPanel contentPanel(){
        JPanel gridContent = new JPanel(new GridLayout(1,3,20,10));
        gridContent.setOpaque(false );
        String influ1 = "<html><p style='text-align: justify'><b>Influência Cultural:</b> Foi profundamente influenciado pela redescoberta das civilizações antigas, promovendo uma volta aos valores da Grécia e Roma.</p></html>";
        String influ2 = "<html><p style='text-align: justify'><b>Influência Social:</b> A arte Neoclássica refletiu os ideais do Iluminismo, exaltando a razão, a moralidade e a busca pelo progresso humano</p></html>";
        String influ3 = "<html><p style='text-align: justify'><b>Impacto na Sociedade:</b> Movimentos como a Revolução Francesa, encontraram na arte Neoclássica uma expressão de seus valores cívicos e democráticos.</p></html>";
        JLabel label1 = new JLabel(influ1);
        JLabel label2 = new JLabel(influ2); 
        JLabel label3 = new JLabel(influ3);
        JLabel[] labels = {label1, label2, label3}; 
        Font font = new Font("Serif", Font.PLAIN, 18); 
        for (JLabel label : labels) { 
            label.setFont(font); 
        }
        gridContent.add(label1);
        gridContent.add(label2);
        gridContent.add(label3);
        gridContent.setOpaque(false );
        return gridContent;
    }
    private JPanel sliderPanel() {
        String[] EPOCHS = {
            "Início do Neoclassicismo (1760 - 1780)",
            "Neoclassicismo na Revolução Francesa (1780 - 1815)",
            "Neoclassicismo na Era Napoleônica (1815 - 1830)",
            "Neoclassicismo na Era Pós-Napoleônica (1830 - 1850)"
        };
        
        String[] DESCRIPTIONS = {
            "Primeiras manifestações do Neoclassicismo, inspiradas pelas descobertas arqueológicas de Herculano e Pompeia e pelos escritos de Johann Joachim Winckelmann.",
            "O Neoclassicismo se torna a expressão artística oficial durante a Revolução Francesa, simbolizando a virtude cívica e o espírito republicano.",
            "A Era Napoleônica vê a expansão do Neoclassicismo pela Europa, com Napoleão promovendo a arte clássica como símbolo de poder e legitimidade.",
            "Após a queda de Napoleão, o Neoclassicismo continua a influenciar a arquitetura e as artes, particularmente em projetos de monumentos e edifícios públicos."
        };
        

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        sliderPanel.setOpaque(false);

        JLabel epoca = new JLabel(EPOCHS[0]);
        epoca.setFont(new Font("Georgia", Font.BOLD, 24));
        epoca.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel label1 = new JLabel("<html><p style='text-align:left'>"+DESCRIPTIONS[0]+"</p></html>");
        JLabel label2 = new JLabel("<html><p style='text-align:center'>"+DESCRIPTIONS[1]+"</p></html>");
        JLabel label3 = new JLabel("<html><p style='text-align:center'>"+DESCRIPTIONS[2]+"</p></html>");
        JLabel label4 = new JLabel("<html><p style='text-align:right'>"+DESCRIPTIONS[3]+"</p></html>");
        JLabel[] labels = {label1, label2, label3, label4}; 
        for (JLabel label : labels) { 
            label.setFont(new Font("Serif", Font.PLAIN, 18)); 
            label.setForeground(Color.LIGHT_GRAY);
        }
        label1.setBackground(Color.BLACK);


        JPanel gridContent = new JPanel(new GridLayout(1,4,20,10));
        gridContent.add(label1);
        gridContent.add(label2);
        gridContent.add(label3);
        gridContent.add(label4);
        gridContent.setOpaque(false );

        JTextArea descriptionArea = new JTextArea(DESCRIPTIONS[0]);
        StSlider slider = new StSlider(0, EPOCHS.length - 1, 0);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);


        Hashtable<Integer, JLabel> labelTable = new Hashtable<>(); 
        for (int i = 0; i < EPOCHS.length; i++) { 
            labelTable.put(i, new JLabel(EPOCHS[i])); 
        } 
        slider.setLabelTable(labelTable);
        slider.addChangeListener(e -> {
            int index = slider.getValue();
            epoca.setText(EPOCHS[index]);
            descriptionArea.setText(DESCRIPTIONS[index]);
            if(slider.getValue()==0){
                label1.setForeground(Color.BLACK);
                label2.setForeground(Color.LIGHT_GRAY);
                label3.setForeground(Color.LIGHT_GRAY);
                label4.setForeground(Color.LIGHT_GRAY);
            }else if(slider.getValue()==1){
                label1.setForeground(Color.LIGHT_GRAY);
                label2.setForeground(Color.BLACK);
                label3.setForeground(Color.LIGHT_GRAY);
                label4.setForeground(Color.LIGHT_GRAY);
            }else if(slider.getValue()==2){
                label1.setForeground(Color.LIGHT_GRAY);
                label2.setForeground(Color.LIGHT_GRAY);
                label3.setForeground(Color.BLACK);
                label4.setForeground(Color.LIGHT_GRAY);
            }else{
                label1.setForeground(Color.LIGHT_GRAY);
                label2.setForeground(Color.LIGHT_GRAY);
                label3.setForeground(Color.LIGHT_GRAY);
                label4.setForeground(Color.BLACK);
            }
        });

        sliderPanel.add(epoca, BorderLayout.NORTH);
        sliderPanel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(gridContent, BorderLayout.SOUTH);

        return sliderPanel;
    }
    private JPanel escolaPanel(){
        String imgDir = "imgs\\\\\\\\escolaNeo.jpg";
        String escola = "Academia de Belas Artes de Viena";
        String contexto = "A Academia de Belas Artes de Viena é uma das mais antigas e prestigiadas academias de arte da Europa. " +
        "Fundada em 1692 e localizada em Schillerplatz, 3, 1010 Viena, Áustria, tem uma longa tradição de formação de " +
        "artistas e acadêmicos. Durante o período do Neoclassicismo, a academia desempenhou um papel crucial na promoção dos " +
        "ideais clássicos e na formação de artistas que buscavam imitar a arte grega e romana. A academia continua a ser um " +
        "centro de excelência na educação artística, oferecendo programas abrangentes em diversas áreas das belas artes.";
        StButton reservar = new StButton("Reservar Passagem", new Dimension(100, 50));
        reservar.addActionListener(e -> openForm());
        JPanel imagem = createImageWithTextPanel(imgDir, escola, contexto, reservar);
        return imagem;
    }
    private void openForm(){
        FormViagem form = new FormViagem(listaDePassagens);
        form.setVisible(true);
    }
    private JPanel createImageWithTextPanel(String Diretorio, String Titulo, String Texto, StButton reservaButton){
        JPanel panel = new JPanel(new SpringLayout());
        panel.setOpaque(false);
        ImageIcon originalImageIcon = new ImageIcon(Diretorio);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH); 
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage); 
        JLabel imageLabel = new JLabel(resizedImageIcon);

        JLabel textLabel = new JLabel("<html><h2>" + Titulo + "</h2><p style='text-align: justify'>" + Texto + "</p></html>");
        textLabel.setPreferredSize(new Dimension(700, 150));
        panel.add(imageLabel);
        panel.add(textLabel);
        panel.add(reservaButton);

        SpringLayout layout = (SpringLayout) panel.getLayout();
        layout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, imageLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, textLabel, 10, SpringLayout.EAST, imageLabel);
        layout.putConstraint(SpringLayout.NORTH, textLabel, 10, SpringLayout.NORTH, panel);
 

        layout.putConstraint(SpringLayout.WEST, reservaButton, 10, SpringLayout.EAST, textLabel);
        layout.putConstraint(SpringLayout.NORTH, reservaButton, 10, SpringLayout.VERTICAL_CENTER, panel);
        layout.putConstraint(SpringLayout.EAST, reservaButton, -5, SpringLayout.EAST, panel); 

        panel.setPreferredSize(new Dimension(600, 200));
        
        return panel;
    }
}
