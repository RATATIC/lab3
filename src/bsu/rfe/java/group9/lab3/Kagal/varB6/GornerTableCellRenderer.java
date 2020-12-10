package bsu.rfe.java.group9.lab3.Kagal.varB6;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer
{
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    
    
    private String needle = null;
    private DecimalFormat formatter =
            (DecimalFormat)NumberFormat.getInstance();

    private boolean isCoincideFractionalAndIntegerPartsOfNumber(String number) 
    {
        String[] str = number.split("\\.");
        if (str.length == 2) {
            if (str[0].compareTo(str[1]) == 0) {
                return true;
            }
        }
        return false;
    }
    public GornerTableCellRenderer() {

        formatter.setMaximumFractionDigits(9);

        formatter.setGroupingUsed(false);

        DecimalFormatSymbols dottedDouble =
                formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        String formattedType = formatter.format(value);

        label.setText(formattedType);
        if (col==1 && needle!=null && needle.equals(formattedType)) {

            panel.setBackground(Color.RED);
        } else if (col==1 && isCoincideFractionalAndIntegerPartsOfNumber(formattedType)) {
            panel.setBackground(Color.GREEN);
        } else {

            panel.setBackground(Color.WHITE);
        }
        return panel;
    }
    public void setNeedle(String needle) {
        this.needle = needle;
    }
}

