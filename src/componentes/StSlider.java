package src.componentes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class StSlider extends JSlider {

    public StSlider(int min, int max, int value) {
        super(min, max, value);

        setMajorTickSpacing(1);
        setPaintTicks(true);
        setPaintLabels(true);
        setSnapToTicks(true);

        setUI(new BasicSliderUI(this) {
            @Override
            public void paintTrack(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                int thumbPos = thumbRect.x + (thumbRect.width / 2);
                int trackY = trackRect.y + (trackRect.height / 2) - 2;
                int trackHeight = 5;
                

                g2.setColor(new Color(212, 175, 55));
                g2.fillRect(trackRect.x, trackY, thumbPos - trackRect.x, trackHeight);


                g2.setColor(new Color(47, 79, 79));
                g2.fillRect(thumbPos, trackY, trackRect.width - (thumbPos - trackRect.x), trackHeight);
            }


            @Override
            public void paintLabels(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                super.paintLabels(g2);
            }

            @Override
            public void paintTicks(Graphics g) {
                g.setColor(Color.DARK_GRAY);
                super.paintTicks(g);
            }
        });
    }
}

