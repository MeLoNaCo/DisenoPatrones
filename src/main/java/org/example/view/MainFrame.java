package org.example.view;

import org.example.view.components.NavbarPanel;
import org.example.view.theme.AppTheme;
import org.example.view.views.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel contentPanel = new JPanel(cardLayout);

    public MainFrame() {
        setTitle("RestoApp - Sistema POS y Gestión de Restaurante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 768);
        setMinimumSize(new Dimension(1024, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(AppTheme.BG_MAIN);

        // Barra superior
        NavbarPanel navbar = new NavbarPanel(tabName -> {
            cardLayout.show(contentPanel, tabName);
        }, "Pedido");

        add(navbar, BorderLayout.NORTH);

        // Vistas principales registradas en CardLayout
        contentPanel.add(new PedidoView(), "Pedido");
        contentPanel.add(new MesasView(), "Mesas");
        contentPanel.add(new CocinaView(), "Cocina");
        contentPanel.add(new RecogerView(), "Recoger");
        contentPanel.add(new ReportesView(), "Reportes");
        contentPanel.add(new ProductosView(), "Mantenimiento");

        add(contentPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
