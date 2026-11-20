package org.example.view.components;

import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class NavbarPanel extends JPanel {

    public interface NavListener {
        void onTabSelected(String tabName);
    }

    private ButtonGroup tabGroup = new ButtonGroup();
    private JPanel tabsContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
    private NavListener listener;

    public NavbarPanel(NavListener listener, String activeTab) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(1280, 56));
        setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0, 0, 1, 0, AppTheme.BORDER_COLOR),
            new EmptyBorder(8, 20, 8, 20)
        ));

        // 1. Logo + Tabs
        JPanel leftSection = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 0));
        leftSection.setOpaque(false);

        // Logo RestoApp (28x28 naranja)
        JPanel logoBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(AppTheme.PRIMARY_ORANGE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(10, 7, 10, 20);
                g2.drawLine(8, 7, 12, 7);
                g2.drawLine(18, 7, 18, 20);
                g2.dispose();
            }
        };
        logoBox.setPreferredSize(new Dimension(28, 28));

        JLabel brandLabel = new JLabel("RestoApp");
        brandLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        brandLabel.setForeground(AppTheme.TEXT_DARK);

        JPanel brandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        brandPanel.setOpaque(false);
        brandPanel.add(logoBox);
        brandPanel.add(brandLabel);

        leftSection.add(brandPanel);

        // Pestañas
        tabsContainer.setOpaque(false);
        String[] tabs = {"Pedido", "Mesas", "Cocina", "Recoger", "Reportes", "Mantenimiento"};
        for (String tab : tabs) {
            addTabButton(tab, tab.equalsIgnoreCase(activeTab));
        }
        leftSection.add(tabsContainer);

        add(leftSection, BorderLayout.WEST);

        // 2. Info Derecha: Sucursal y Supervisor
        JPanel rightSection = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 4));
        rightSection.setOpaque(false);

        JLabel branchLabel = new JLabel("🏪 Sucursal Centro ▾");
        branchLabel.setFont(AppTheme.FONT_BODY);
        branchLabel.setForeground(AppTheme.TEXT_DARK);

        JLabel userLabel = new JLabel("👤 Carlos M. (Supervisor)");
        userLabel.setFont(AppTheme.FONT_BODY);
        userLabel.setForeground(AppTheme.TEXT_DARK);

        rightSection.add(branchLabel);
        rightSection.add(new JSeparator(SwingConstants.VERTICAL));
        rightSection.add(userLabel);

        add(rightSection, BorderLayout.EAST);
    }

    private void addTabButton(String name, boolean isSelected) {
        JToggleButton btn = new JToggleButton(name);
        btn.setFont(AppTheme.FONT_BODY);
        btn.setFocusPainted(false);
        btn.setBorder(new EmptyBorder(6, 12, 6, 12));
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if (isSelected) {
            btn.setBackground(AppTheme.TEXT_DARK);
            btn.setForeground(Color.WHITE);
            btn.setSelected(true);
        } else {
            btn.setBackground(Color.WHITE);
            btn.setForeground(AppTheme.TEXT_MUTED);
        }

        btn.addActionListener(e -> {
            for (Component c : tabsContainer.getComponents()) {
                if (c instanceof JToggleButton) {
                    JToggleButton tb = (JToggleButton) c;
                    tb.setBackground(Color.WHITE);
                    tb.setForeground(AppTheme.TEXT_MUTED);
                }
            }
            btn.setBackground(AppTheme.TEXT_DARK);
            btn.setForeground(Color.WHITE);
            if (listener != null) listener.onTabSelected(name);
        });

        tabGroup.add(btn);
        tabsContainer.add(btn);
    }
}
