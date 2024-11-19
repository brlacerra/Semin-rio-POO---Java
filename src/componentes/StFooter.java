package src.componentes;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StFooter {
        private JPanel footerPanel;
    public StFooter() {
        footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBackground(Color.DARK_GRAY);
        footerPanel.setMinimumSize(new Dimension(0, 60));
    
        JLabel copyrightLabel = new JLabel("© 2024 Escola de Artes POO - UFUBSIMC. Todos os direitos reservados.", SwingConstants.CENTER);
        copyrightLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        copyrightLabel.setForeground(Color.WHITE);
        
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        linkPanel.setBackground(Color.DARK_GRAY); 
        linkPanel.setFont(new Font("Serif", Font.PLAIN, 14));
    
        JLabel aboutLink = createFooterLink("Participantes", "<html><h3>Participantes do projeto</h3><p>Bruno Ferrari Lacerra - 32311BSI017</p><p>Pedro Henrique Salles dos Santos - 32311BSI024</p><p>João Pedro Araújo de Magalhães - 32311BSI035</p></html>");
        JLabel referencesLink = createFooterLink("Referências", "<html><h3>REFERÊNCIAS</h3><p>ORACLE CORPORATION Java™ Platform, Standard Edition 8 API Specification Disponível em: https://docs.oracle.com/javase/8/docs/api/ Acesso em: 15 nov. 2024</p>" + 
                        "<p>ORACLE CORPORATION The Java™ Tutorials - Layouts Disponível em: https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html Acesso em: 15 nov. 2024</p>" + 
                        "<p>ORACLE CORPORATION Java™ Platform, Standard Edition 8 API Specification Disponível em: https://docs.oracle.com/javase/8/docs/api/javax/swing/ImageIcon.html Acesso em: 15 nov. 2024</p>" + 
                        "<p>ORACLE CORPORATION Java™ Platform, Standard Edition 8 API Specification Disponível em: https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html#setIconImage(java.awt.Image) Acesso em: 15 nov. 2024</p></html>");
    
        linkPanel.add(aboutLink);
        linkPanel.add(new JLabel("|"));
        linkPanel.add(referencesLink);
    
       
        footerPanel.add(copyrightLabel, BorderLayout.NORTH);
        footerPanel.add(linkPanel, BorderLayout.CENTER);
    }
    private JLabel createFooterLink(String text, String content) {
        JLabel linkLabel = new JLabel(text);
        linkLabel.setFont(new Font("Serif", Font.BOLD, 12));
        linkLabel.setForeground(Color.CYAN);
        linkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
        
        linkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(null, content, text, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return linkLabel;
    }
    public JPanel getStFooter(){
        return footerPanel;
    }
}
