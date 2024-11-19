package src.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class StJTable extends JTable {
    public StJTable(Object[][] data, String[] columnNames){
        super(data, columnNames);
        setRowHeight(30);
        setFont(new Font("Serif", Font.PLAIN, 16));
        setGridColor(new Color(200, 200, 200));
        setShowGrid(true);
        setEnabled(false);
        
            JTableHeader header = getTableHeader();
            header.setFont(new Font("Serif", Font.BOLD, 18));
            header.setBackground(new Color(47, 79, 79)); 
            header.setForeground(Color.WHITE);

            setDefaultRenderer(Object.class, new EstiloCelula());
        }
        
            private static class EstiloCelula extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (row % 2 == 0) {
                c.setBackground(new Color(240, 240, 240));
            } else {
                c.setBackground(Color.WHITE);
            }

            if (isSelected) {
                c.setBackground(new Color(255, 215, 0));
                c.setForeground(Color.BLACK);
                setFont(new Font("Serif", Font.BOLD, 16));
            } else {
                c.setForeground(Color.BLACK);
                setFont(new Font("Serif", Font.PLAIN, 16));
            }


            setHorizontalAlignment(SwingConstants.CENTER);

            return c;
        }
    }
}
