package org.example.view.views;

import org.example.view.components.PrimaryButton;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MesasView extends JPanel {

    public MesasView() {
        setLayout(new BorderLayout(16, 16));
        setBackground(AppTheme.BG_MAIN);
        setBorder(new EmptyBorder(16, 20, 16, 20));

        // 1. Grid Central de 12 Mesas
        JPanel gridPanel = new JPanel(new GridLayout(3, 4, 14, 14));
        gridPanel.setOpaque(false);

        for (int i = 1; i <= 12; i++) {
            boolean isOccupied = (i % 3 == 0 || i == 4);
            boolean isSelected = (i == 4);
            gridPanel.add(createTableCard(i, isOccupied, isSelected));
        }

        JScrollPane scrollGrid = new JScrollPane(gridPanel);
        scrollGrid.setBorder(null);
        scrollGrid.setOpaque(false);
        scrollGrid.getViewport().setOpaque(false);
        add(scrollGrid, BorderLayout.CENTER);

        // 2. Panel Lateral de Comanda (Mesa 4)
        JPanel rightOrderPanel = new JPanel();
        rightOrderPanel.setLayout(new BoxLayout(rightOrderPanel, BoxLayout.Y_AXIS));
        rightOrderPanel.setBackground(AppTheme.BG_CARD);
        rightOrderPanel.setPreferredSize(new Dimension(340, 0));
        rightOrderPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(AppTheme.BORDER_COLOR, 1, true),
            new EmptyBorder(16, 16, 16, 16)
        ));

        JLabel orderHeader = new JLabel("Mesa 4 · Salón (#1042)");
        orderHeader.setFont(AppTheme.FONT_TITLE);
        orderHeader.setForeground(AppTheme.TEXT_DARK);

        JLabel waiterLabel = new JLabel("Mesero: Carlos M. · 4 comensales");
        waiterLabel.setFont(AppTheme.FONT_SMALL);
        waiterLabel.setForeground(AppTheme.TEXT_MUTED);

        rightOrderPanel.add(orderHeader);
        rightOrderPanel.add(waiterLabel);
        rightOrderPanel.add(Box.createVerticalStrut(16));

        rightOrderPanel.add(createOrderItem("2 Hamburguesas Clásicas", "$28.00"));
        rightOrderPanel.add(createOrderItem("1 Tacos al Pastor x3", "$12.50"));
        rightOrderPanel.add(createOrderItem("2 Limonada Menta y Jengibre", "$8.40"));
        rightOrderPanel.add(Box.createVerticalGlue());

        JLabel totalLabel = new JLabel("Total a pagar: $60.94");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalLabel.setForeground(AppTheme.PRIMARY_ORANGE);
        rightOrderPanel.add(totalLabel);
        rightOrderPanel.add(Box.createVerticalStrut(12));

        PrimaryButton btnCobrar = new PrimaryButton("Cobrar mesa · $60.94");
        btnCobrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        rightOrderPanel.add(btnCobrar);

        add(rightOrderPanel, BorderLayout.EAST);
    }

    private JPanel createTableCard(int number, boolean occupied, boolean selected) {
        JPanel card = new JPanel(new BorderLayout(8, 8));
        card.setBackground(AppTheme.BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(selected ? AppTheme.PRIMARY_ORANGE : AppTheme.BORDER_COLOR, selected ? 2 : 1, true),
            new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel title = new JLabel("Mesa " + String.format("%02d", number));
        title.setFont(AppTheme.FONT_SUBTITLE);

        JLabel status = new JLabel(occupied ? "● Ocupada" : "● Libre");
        status.setFont(AppTheme.FONT_SMALL);
        status.setForeground(occupied ? AppTheme.STATE_ORANGE : AppTheme.STATE_GREEN);

        JLabel pax = new JLabel("👥 4 pax");
        pax.setFont(AppTheme.FONT_SMALL);
        pax.setForeground(AppTheme.TEXT_MUTED);

        card.add(title, BorderLayout.NORTH);
        card.add(status, BorderLayout.CENTER);
        card.add(pax, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createOrderItem(String name, String price) {
        JPanel item = new JPanel(new BorderLayout());
        item.setOpaque(false);
        item.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));

        JLabel lblName = new JLabel(name);
        lblName.setFont(AppTheme.FONT_BODY);

        JLabel lblPrice = new JLabel(price);
        lblPrice.setFont(AppTheme.FONT_SUBTITLE);

        item.add(lblName, BorderLayout.WEST);
        item.add(lblPrice, BorderLayout.EAST);
        return item;
    }
}
