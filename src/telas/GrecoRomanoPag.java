package src.telas;

import javax.swing.*;

import src.classesObjetos.Passagem;
import src.componentes.StButton;
import src.componentes.StSlider;
import src.componentes.stArrayList;
import src.formularios.FormViagem;
import java.awt.*;
import java.util.Hashtable;

public class GrecoRomanoPag extends JPanel {
    private stArrayList<Passagem> listaDePassagens;
    public GrecoRomanoPag(stArrayList<Passagem> listaDePassagens) {
        this.listaDePassagens = listaDePassagens;

        setLayout(new BorderLayout());

        JPanel grecoPanel = new JPanel();
        grecoPanel.setLayout(new BoxLayout(grecoPanel, BoxLayout.PAGE_AXIS)); 
        grecoPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel title = new JLabel("Escultura, Pintura e Filosofia: A Arte Greco-Romana e Suas Escolas");
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
        grecoPanel.add(Box.createVerticalStrut(0));
        grecoPanel.add(escolaPanel());
        grecoPanel.add(Box.createVerticalStrut(30));


        add(grecoPanel, BorderLayout.NORTH);
    }
    private JPanel contentPanel(){
        JPanel gridContent = new JPanel(new GridLayout(1,3,20,10));
        gridContent.setOpaque(false );
        String influ1 = "<html><p style='text-align: justify'><b>A Influência Cultural da Arte Greco-romana</b>: A arte Greco-romana teve um impacto duradouro em muitas culturas e escolas artísticas subsequentes.</p></html>";
        String influ2 = "<html><p style='text-align: justify'><b>Influência Social: Além da estética</b>, a arte Greco-romana refletiu e até moldou os valores sociais da época.</p></html>";
        String influ3 = "<html><p style='text-align: justify'><b>Filosofia e Arte: A filosofia grega</b>, especialmente o neoplatonismo e o estoicismo, teve grande influência na arte da época.</p></html>";
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
            "Período Arcaico (750 a.C. - 480 a.C.)",
            "Período Clássico (480 a.C. - 323 a.C.)",
            "Período Helenístico (323 a.C. - 31 a.C.)",
            "Período Romano (31 a.C. - 476 d.C.)"
        };

        String[] DESCRIPTIONS = {
            "Surgimento das pólis, desenvolvimento da alfabetização grega, e obras de Homero e Hesíodo.",
            "Construção do Partenon, ascensão de Aristóteles e Sócrates, e a expansão do Império Macedônio sob Alexandre o Grande.",
            "Fragmentação do Império de Alexandre, surgimento de reinos helenísticos, e a influência cultural grega na Ásia e no Egito.",
            "Fundação do Império Romano por Augusto, construção do Coliseu, e a Pax Romana que trouxe estabilidade e prosperidade ao império."
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
        String imgDir = "imgs\\escolaGreco.jpeg";
        String escola = "Academia de Belas Artes de Atenas";
        String contexto = "A Academia de Belas Artes de Atenas é uma das instituições de " +
        "ensino superior mais antigas e respeitadas da Grécia. Funda em 1837 e localizada em " +
        "1 ElefTheriou Venizelou, 15778, Atenas, Grécia, tem uma longa tradição de formação de " +
        "artistas e acadêmicos. Oferecendo ampla gama de cursos que abrangem todas as áreas " +
        "das belas artes, com um forte foco na herança cultura e artística da Grécia Antiga.";
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
