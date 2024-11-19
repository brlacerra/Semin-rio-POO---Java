package src.componentes;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StButton extends JButton {
    private boolean isActive = false;
    public StButton(String text, Dimension size) {
        super(text);
        setMaximumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        createStButton();
    }

    private void createStButton() {
        setInactiveStyle();
        setFont(new Font("Times New Roman", Font.BOLD, 14));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setFocusPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isActive) { 
                    setBackground(new Color(218, 165, 32)); 
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isActive) { 
                    setInactiveStyle();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!isActive) { 
                    setBackground(new Color(184, 134, 11)); 
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (getModel().isRollover()) {
                    setBackground(new Color(218, 165, 32)); 
                } else {
                    setInactiveStyle();
                }
            }
        });
    }

    public void setActiveStyle() {
        setBackground(Color.YELLOW);
        setForeground(Color.DARK_GRAY); 
        setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 3));
        isActive = true;
    }


    public void setInactiveStyle() {
        setBackground(new Color(47, 79, 79));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
