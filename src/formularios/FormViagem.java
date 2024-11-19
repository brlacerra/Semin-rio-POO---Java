package src.formularios;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import src.classesObjetos.Passagem;
import src.componentes.StButton;
import src.componentes.stArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormViagem extends JFrame {
    private JTextField nomeField;
    private JTextField CPFField;
    private JTextField emailField;
    private JSpinner dataNascimentoField;
    private JSpinner dataViagemField;
    private JTextField aeroportoField;
    private JToggleButton escolaToggleButton;
    private Color selectedColor = new Color(0, 0, 0);


    public FormViagem(stArrayList<Passagem> listaDePassagens) {
        setTitle("Cadrastro de passagem");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        String placeholderNome = "Digite seu nome";
        nomeField.setText(placeholderNome);
        placeholderField(nomeField, placeholderNome);
        formPanel.add(nomeField);

        formPanel.add(new JLabel("CPF:"));
        CPFField = new JTextField();
        String placeholderCPF = "xxx.xxx.xxx-xx";
        CPFField.setText(placeholderCPF);
        placeholderField(CPFField, placeholderCPF);
        formPanel.add(CPFField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        String placeholderEmail = "Digite seu email";
        emailField.setText(placeholderEmail);
        placeholderField(emailField, placeholderEmail);
        formPanel.add(emailField);

        formPanel.add(new JLabel("Data de Nascimento: "));
        SpinnerDateModel date1 = new SpinnerDateModel();
        dataNascimentoField = new JSpinner(date1);
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(dataNascimentoField, "dd/MM/yyyy");
        dataNascimentoField.setEditor(editor1);
        formPanel.add(dataNascimentoField);

        formPanel.add(new JLabel("Data de viagem: "));
        SpinnerDateModel date2 = new SpinnerDateModel();
        dataViagemField = new JSpinner(date2);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(dataViagemField, "dd/MM/yyyy");
        dataViagemField.setEditor(editor2);
        formPanel.add(dataViagemField);

        formPanel.add(new JLabel("Aeroporto de Saída:"));
        String placeholderAeroporto = "Digite o Aeroporto de Saída";
        aeroportoField = new JTextField();
        aeroportoField.setText(placeholderAeroporto);
        placeholderField(aeroportoField, placeholderAeroporto);
        formPanel.add(aeroportoField);

        formPanel.add(new JLabel("Escola de Artes: "));
        escolaToggleButton = new JToggleButton("Escola de Artes de Atenas");
        escolaToggleButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                if(escolaToggleButton.isSelected()){
                    escolaToggleButton.setText("Escola de Artes de Viena");
                }else{
                    escolaToggleButton.setText("Escola de Artes de Atenas");
                }
            }
        });
        formPanel.add(escolaToggleButton);


        
        JLabel corLabel= new JLabel();
        corLabel.setOpaque(true);
        corLabel.setBackground(selectedColor);
        StButton escolheCor = new StButton("Escolher Cor", new Dimension());
        escolheCor.addActionListener(e -> {
            selectedColor=JColorChooser.showDialog(null, "Escolha uma Cor", selectedColor);
            if(selectedColor!=null){
                corLabel.setBackground(selectedColor);
                corLabel.setText("COR SELECIONADA");
                corLabel.setHorizontalAlignment(SwingConstants.CENTER);
            }
        });

        formPanel.add(escolheCor);
        formPanel.add(corLabel);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton reservaButton = new JButton("Enviar");
        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String nome = nomeField.getText();
                    String cpf = CPFField.getText();
                    String email = emailField.getText();
                    Date dataNascimento = (Date) dataNascimentoField.getValue();
                    Date dataViagem = (Date) dataViagemField.getValue();
                    String aeroporto = aeroportoField.getText();
                    String escola = escolaToggleButton.getText();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String nasFormatted = dateFormat.format(dataNascimento);
                    String viagemFormatted = dateFormat.format(dataViagem);

                    if(nome.equals(placeholderNome) || cpf.equals(placeholderCPF) || email.equals(placeholderEmail) || aeroporto.equals(placeholderAeroporto)){
                        throw new IllegalArgumentException("Todos os campos devem ser preenchidos!");
                    }
                    Calendar cal = Calendar.getInstance();
                    @SuppressWarnings("deprecation")
                    int idade = cal.get(Calendar.YEAR) - dataNascimento.getYear() - 1900;

                    if(idade < 18){
                        throw new IllegalArgumentException("Voce deve ter mais de 18 anos para reservar uma passagem!");
                    }
                    if(selectedColor.equals(Color.black)){
                        throw new IllegalArgumentException("A cor da Pulseira não pode ser preta!");
                    }
                    if(cpf.length()!=14){
                        throw new IllegalArgumentException("CPF inserido inválido!");
                    }
                        JPanel panel = new JPanel(new GridLayout(15, 1));
                        panel.add(new JLabel("Passagem Reservada com Sucesso!"));
                        panel.add(new JLabel("Nome: " + nome));
                        panel.add(new JLabel("CPF: " + cpf));
                        panel.add(new JLabel("Email: " + email));
                        panel.add(new JLabel("Data de Nascimento: " + nasFormatted));
                        panel.add(new JLabel("Data de Viagem: " + viagemFormatted));
                        panel.add(new JLabel("Aeroporto de Saída: " + aeroporto));
                        panel.add(new JLabel("Escola de Artes: " + escola));

                        JPanel corPanel = new JPanel();
                        corPanel.add(new JLabel("Cor da pulseria"));
                        corLabel.setPreferredSize(new Dimension(20, 20));
                        corLabel.setOpaque(true);
                        corLabel.setBackground(selectedColor);
                        corLabel.setText("");
                        corPanel.add(corLabel);
                        panel.add(corPanel);

                        Passagem novaPassagem = new Passagem(
                            nome,
                            cpf,
                            email,
                            dataNascimento,
                            dataViagem,
                            aeroporto,
                            escola,
                            selectedColor
                        );

                        listaDePassagens.add(novaPassagem);


                        System.out.println(listaDePassagens.toString());
                        JOptionPane.showMessageDialog(null, panel, "Passagem Reservada", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro, cadastro não foi realizado de maneira correta", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(reservaButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);


        StForm(formPanel);
    }

    private void placeholderField(JTextField text, String placeholder){
        text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e){
                if(text.getText().equals(placeholder)){
                    text.setText("");
                    text.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(text.getText().isEmpty()){
                    text.setText(placeholder);
                    text.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
    }

    private void StForm(JPanel formPanel) {
        formPanel.setBackground(Color.WHITE);
    
        for (Component comp : formPanel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                label.setFont(new Font("Serif", Font.BOLD, 14));
                label.setForeground(Color.DARK_GRAY);          
            } else if (comp instanceof JTextField || comp instanceof JSpinner) {
                comp.setFont(new Font("Arial", Font.PLAIN, 14)); 
                comp.setBackground(new Color(245, 245, 245)); 
                comp.setForeground(Color.BLACK);  
                comp.setPreferredSize(new Dimension(200, 30));
                if (comp instanceof JTextField) {
                    ((JTextField) comp).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); 
                }
            } else if (comp instanceof JToggleButton) {
                JToggleButton toggleButton = (JToggleButton) comp;
                toggleButton.setFont(new Font("Serif", Font.BOLD, 14));
                toggleButton.setBackground(new Color(173, 216, 230));
                toggleButton.setForeground(Color.BLACK);
                toggleButton.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
                toggleButton.setFocusPainted(false);
            }
        }
    }
}
