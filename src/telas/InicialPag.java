package src.telas;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import src.classesObjetos.Passagem;
import src.componentes.NavBar;
import src.componentes.StFooter;
import src.componentes.StJTable;
import src.componentes.stArrayList;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;


public class InicialPag extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private stArrayList<Passagem> listaDePassagens;
    public InicialPag(stArrayList<Passagem> listaDePassagens, String nomeArq) {
        this.listaDePassagens = listaDePassagens;
        lerArrayList(this.listaDePassagens, nomeArq);
        setTitle("Escola de Artes POO");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                salvarArrayList(listaDePassagens, nomeArq);
                dispose();
            }
        });


        NavBar navBar = new NavBar(this);
        getContentPane().add(navBar.getNavBarPanel(), BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        if(listaDePassagens.size()>0){
            mainPanel.add(new PassagensPag(listaDePassagens), "PassagensPag");  
        }
        mainPanel.add(createHomePanel(), "InicialPag");
        mainPanel.add(new GrecoRomanoPag(listaDePassagens), "GrecoRomanoPag");
        mainPanel.add(new NeoClassicoPag(listaDePassagens), "NeoClassicoPag");
        listaDePassagens.setListChangeListener(new stArrayList.ListChangeListener() {
            @Override
            public void onListChanged() {
                System.out.println("Tamanho da lista mudou");
                mainPanel.add(new PassagensPag(listaDePassagens), "PassagensPag");  
            }
        });
        


        getContentPane().add(mainPanel, BorderLayout.CENTER);
        StFooter footer = new StFooter();
        getContentPane().add(footer.getStFooter(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel(new BorderLayout());
        JLabel tituloPrincipal = new JLabel("Entre Dois Mundos: A Arte Greco-Romana e o Neoclassicismo");
        tituloPrincipal.setFont(new Font("Georgia", Font.BOLD, 24));
        tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        homePanel.add(tituloPrincipal, BorderLayout.NORTH);

        JPanel gridContents = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;

        JPanel grecoPanel = createGreco();
        grecoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        grecoPanel.setBackground(new Color(211, 211, 211));
        JPanel dividerPanel = createDivider();
        JPanel neoPanel = createNeo();
        neoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gbc.gridx = 0;
        gbc.weightx = 0.6;
        gbc.weighty = 0;
        gridContents.add(grecoPanel, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gridContents.add(dividerPanel, gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gridContents.add(neoPanel, gbc);
        
        homePanel.add(gridContents);
        return homePanel;
    }

    private JPanel createGreco() {
        JPanel grecoPanel = new JPanel();
        grecoPanel.setLayout(new BoxLayout(grecoPanel, BoxLayout.Y_AXIS));
        JLabel grecoTitle = new JLabel("O Fascínio do Mundo Antigo");
        grecoTitle.setHorizontalAlignment(SwingConstants.CENTER);
        grecoTitle.setFont(new Font("Serif", Font.BOLD, 20));
        
        String grecoTextContent = "<html><p style='text-align: justify'>Grécia romana é o período da História da Grécia após a vitória romana sobre os coríntios, na Batalha de Corinto, em 146 a.C., até o restabelecimento da cidade de Bizâncio e sua nomeação pelo imperador Constantino como a capital do Império Romano (nomeada Nova Roma, posteriormente Constantinopla) em 330 d.C.</p></html>";
        String[] columnNames = {"Aspecto", "Descrição"};
        Object[][] data = {
            {"Arquitetura", "Uso de colunas e simetria perfeita."},
            {"Escultura", "Representação detalhada do corpo humano."},
            {"Pintura", "Cenas mitológicas e históricas."},
            {"Influência", "Bases para a arte renascentista."}
        };
        StJTable grecoTable = new StJTable(data, columnNames);
        TableColumnModel columnModel = grecoTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }

        grecoTable.repaint(); 

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(grecoTable.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(grecoTable, BorderLayout.CENTER);

        JLabel grecoText = new JLabel(grecoTextContent);
        grecoText.setFont(new Font("Serif", Font.PLAIN, 18));

        JPanel imagem = createImageWithTextPanel("imgs\\\\grecoromano.jpg", "Partenon", "A influencia da cultura grega no mundo é vista até os dias atuais. As maiores contribuições estão no campo da filosofia e das artes. O período considerado de maior produção cultural greco ficou conhecido como Período Helenístico, foi também o momento de transição da forte cultura grega para o desenvolvimento da cultura romana.");

        grecoPanel.add(grecoTitle);
        grecoPanel.add(Box.createVerticalStrut(10));
        grecoPanel.add(grecoText);
        grecoPanel.add(Box.createVerticalStrut(10));
        grecoPanel.add(tablePanel);
        grecoPanel.add(Box.createVerticalStrut(10));
        grecoPanel.add(imagem);
        
        return grecoPanel;
    }
    private JPanel createImageWithTextPanel(String Diretorio, String Titulo, String Texto){
        JPanel panel = new JPanel(new SpringLayout());
        panel.setOpaque(false);
        ImageIcon originalImageIcon = new ImageIcon(Diretorio);
        Image originalImage = originalImageIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(300, 150, Image.SCALE_SMOOTH); 
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage); 
        JLabel imageLabel = new JLabel(resizedImageIcon);

        JLabel textLabel = new JLabel("<html><b>" + Titulo + "</b><p style='text-align: justify'>" + Texto + "</p></html>");
        textLabel.setPreferredSize(new Dimension(250, 150));
        panel.add(imageLabel);
        panel.add(textLabel);

        SpringLayout layout = (SpringLayout) panel.getLayout();
        layout.putConstraint(SpringLayout.WEST, imageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, imageLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, textLabel, 10, SpringLayout.EAST, imageLabel);
        layout.putConstraint(SpringLayout.NORTH, textLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, textLabel, -10, SpringLayout.EAST, panel); 

        panel.setPreferredSize(new Dimension(600, 200));
        
        return panel;
    }
    private JPanel createNeo(){
        JPanel neoPanel = new JPanel();
        neoPanel.setLayout(new BoxLayout(neoPanel, BoxLayout.Y_AXIS));
        JLabel neoTitle = new JLabel("A Elegância do Renascimento Clássico");
        neoTitle.setHorizontalAlignment(SwingConstants.CENTER);
        neoTitle.setFont(new Font("Serif", Font.BOLD, 20));
        
        String neoTextContent = "<html><p style='text-align: justify'>No final do século XVIII, o Neoclassicismo reviveu os ideais da antiguidade. Inspirado pela ordem, clareza e simplicidade, este movimento celebrou a razão e os princípios estéticos da era clássica, adaptados ao Iluminismo e à modernidade emergente. Nessa época surgiram como Jean Auguste Ingres, Jacques-Louis David, entre outros.</p></html>";
        String[] columnNames = {"Aspecto", "Descrição"};
        Object[][] data = {
            {"Arquitetura", "Simetria, colunas e simplicidade."},
            {"Escultura", "Retratos e figuras com inspiração clássica."},
            {"Pintura", "Temas mitológicos e históricos."},
            {"Influência", "Base para movimentos artísticos do século XIX."}
        };
        StJTable neoTable = new StJTable(data, columnNames);
        TableColumnModel columnModel = neoTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }

        neoTable.repaint(); 

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(neoTable.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(neoTable, BorderLayout.CENTER);

        JLabel grecoText = new JLabel(neoTextContent);
        grecoText.setFont(new Font("Serif", Font.PLAIN, 18));

        JPanel imagem = createImageWithTextPanel("imgs\\\\neoclassico.jpg", "Panteção de Paris", "O movimento artístico neoclassicismo surgiu no século XVIII, século conhecido como Século das Luzes, Idade da Razão, devido à influência do Iluminismo, movimento filosófico racionalista. O próprio nome do movimento, neoclássico, pressupõe um “novo clássico”, um novo olhar ao clássico.");


        neoPanel.add(neoTitle);
        neoPanel.add(Box.createVerticalStrut(10));
        neoPanel.add(grecoText);
        neoPanel.add(Box.createVerticalStrut(10));
        neoPanel.add(tablePanel);
        neoPanel.add(Box.createVerticalStrut(10));
        neoPanel.add(imagem);
    
        return neoPanel;
    }
    private JPanel createDivider(){
        JPanel dividerPanel = new JPanel();
        dividerPanel.setPreferredSize(new Dimension(10, 0));
        dividerPanel.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 3));
        dividerPanel.setBackground(new Color(200, 200, 200));
        return dividerPanel;
    }
    public void showPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    public void salvarArrayList(stArrayList<Passagem> lista, String nomeArq){
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(nomeArq))){
            for (Passagem p : lista) {
                out.writeUTF(p.getNome());
                out.writeUTF(p.getCpf());
                out.writeUTF(p.getEmail());
                out.writeLong(p.getDataNascimento().getTime());
                out.writeLong(p.getDataViagem().getTime());
                out.writeUTF(p.getAeroportoSaida());
                out.writeUTF(p.getEscolaArtes());
                out.writeInt(p.getCorPulseira().getRGB());
            }
            System.out.println("Dados salvos em binário.");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void lerArrayList(stArrayList<Passagem> lista, String nomeArq){
        try (DataInputStream in = new DataInputStream(new FileInputStream(nomeArq))) {
        while (in.available() > 0) {
            String nome = in.readUTF();
            String cpf = in.readUTF();
            String email = in.readUTF();
            long dataNascimento = in.readLong();
            long dataViagem = in.readLong();
            String aeroportoSaida = in.readUTF();
            String escolaArtes = in.readUTF();
            int cor = in.readInt();
            
            Passagem p = new Passagem(nome, cpf, email, new Date(dataNascimento), new Date(dataViagem), aeroportoSaida, escolaArtes, new Color(cor));
            lista.add(p);
        }
        System.out.println("Dados lidos de binário.");
    } catch (IOException e){
            e.printStackTrace();
        }
    }
}