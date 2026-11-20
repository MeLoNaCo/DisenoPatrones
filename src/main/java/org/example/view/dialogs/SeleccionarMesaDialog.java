package org.example.view.dialogs;

import org.example.view.components.PrimaryButton;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SeleccionarMesaDialog extends JDialog {
    private int selectedMesa = -1;

    public SeleccionarMesaDialog(Frame owner) {
        super(owner, "Seleccionar Mesa", true);
        setSize(540, 480);
        setLocationRelativeTo(owner);
        getContentPane().setBackground(AppTheme.BG_CARD);
        setLayout(new BorderLayout(16, 16));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

        // Encabezado
        JLabel title = new JLabel("Seleccionar Mesa");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_DARK);
        add(title, BorderLayout.NORTH);

        // Grid 3x4
        JPanel grid = new JPanel(new GridLayout(3, 4, 10, 10));
        grid.setOpaque(false);

        for (int i = 1; i <= 12; i++) {
            final int mesaNum = i;
            boolean isFree = (i % 2 != 0);
            JButton btn = new JButton("Mesa " + i + (isFree ? " (Libre)" : " (Ocupada)"));
            btn.setFont(AppTheme.FONT_BODY);
            btn.setEnabled(isFree);
            if (isFree) {
                btn.setBackground(Color.WHITE);
                btn.setForeground(AppTheme.STATE_GREEN);
                btn.addActionListener(e -> selectedMesa = mesaNum);
            }
            grid.add(btn);
        }
        add(grid, BorderLayout.CENTER);

        // Botones inferiores
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        footer.setOpaque(false);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setFont(AppTheme.FONT_BODY);
        btnCancel.addActionListener(e -> dispose());

        PrimaryButton btnConfirm = new PrimaryButton("Confirmar mesa");
        btnConfirm.addActionListener(e -> {
            if (selectedMesa != -1) {
                JOptionPane.showMessageDialog(this, "Mesa " + selectedMesa + " seleccionada con éxito.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor selecciona una mesa libre.");
            }
        });

        footer.add(btnCancel);
        footer.add(btnConfirm);
        add(footer, BorderLayout.SOUTH);
    }
}
