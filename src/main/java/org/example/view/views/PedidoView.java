package org.example.view.views;

import org.example.view.components.PrimaryButton;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PedidoView extends JPanel {

    public PedidoView() {
        setLayout(new BorderLayout(16, 16));
        setBackground(AppTheme.BG_MAIN);
        setBorder(new EmptyBorder(16, 20, 16, 20));

        // 1. Centro: Buscador, Categorías y Catálogo
        JPanel centerPanel = new JPanel(new BorderLayout(12, 12));
        centerPanel.setOpaque(false);

        // Barra de búsqueda y categorías
        JPanel headerFilter = new JPanel(new BorderLayout(8, 8));
        headerFilter.setOpaque(false);

        JTextField searchField = new JTextField("Buscar productos...");
        searchField.setPreferredSize(new Dimension(0, 38));
        searchField.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(AppTheme.BORDER_COLOR, 1, true),
            new EmptyBorder(6, 12, 6, 12)
        ));
        headerFilter.add(searchField, BorderLayout.NORTH);

        JPanel catChips = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        catChips.setOpaque(false);
        String[] cats = {"Todos", "Hamburguesas", "Tacos", "Pizzas", "Bebidas", "Postres"};
        for (String cat : cats) {
            JButton chip = new JButton(cat);
            chip.setFont(AppTheme.FONT_SMALL);
            chip.setBackground(cat.equals("Todos") ? AppTheme.TEXT_DARK : Color.WHITE);
            chip.setForeground(cat.equals("Todos") ? Color.WHITE : AppTheme.TEXT_DARK);
            catChips.add(chip);
        }
        headerFilter.add(catChips, BorderLayout.SOUTH);
        centerPanel.add(headerFilter, BorderLayout.NORTH);

        // Cuadrícula de productos
        JPanel productGrid = new JPanel(new GridLayout(2, 3, 12, 12));
        productGrid.setOpaque(false);
        productGrid.add(createProductCard("Hamburguesa Clásica", "$14.00", "200g carne Angus"));
        productGrid.add(createProductCard("Tacos al Pastor x3", "$12.50", "Cerdo marinado con achiote"));
        productGrid.add(createProductCard("Limonada Menta", "$4.20", "Fruta natural 500ml"));
        productGrid.add(createProductCard("Pizza Margarita", "$16.50", "Mozzarella de búfala"));
        productGrid.add(createProductCard("Tiramisú de la Casa", "$6.50", "Café espresso y mascarpone"));
        productGrid.add(createProductCard("Ceviche Mixto", "$15.20", "Pescado fresco y calamar"));

        centerPanel.add(new JScrollPane(productGrid), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // 2. Lateral Derecho: Comanda
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setBackground(AppTheme.BG_CARD);
        orderPanel.setPreferredSize(new Dimension(360, 0));
        orderPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(AppTheme.BORDER_COLOR, 1, true),
            new EmptyBorder(16, 16, 16, 16)
        ));

        JLabel title = new JLabel("Orden #1042 · Mesa 4");
        title.setFont(AppTheme.FONT_TITLE);
        JLabel waiter = new JLabel("Mesero: Carlos M. · 4 personas");
        waiter.setFont(AppTheme.FONT_SMALL);
        waiter.setForeground(AppTheme.TEXT_MUTED);

        orderPanel.add(title);
        orderPanel.add(waiter);
        orderPanel.add(Box.createVerticalStrut(14));

        orderPanel.add(createCartItem("2x Hamburguesa Clásica", "$28.00"));
        orderPanel.add(createCartItem("1x Tacos al Pastor", "$12.50"));
        orderPanel.add(createCartItem("2x Limonada Menta", "$8.40"));
        orderPanel.add(Box.createVerticalGlue());

        JLabel total = new JLabel("Total: $60.94");
        total.setFont(new Font("SansSerif", Font.BOLD, 20));
        total.setForeground(AppTheme.PRIMARY_ORANGE);
        orderPanel.add(total);
        orderPanel.add(Box.createVerticalStrut(12));

        PrimaryButton btnSend = new PrimaryButton("Enviar a Cocina · $60.94");
        btnSend.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        orderPanel.add(btnSend);

        add(orderPanel, BorderLayout.EAST);
    }

    private JPanel createProductCard(String name, String price, String desc) {
        JPanel card = new JPanel(new BorderLayout(6, 6));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(AppTheme.BORDER_COLOR, 1, true),
            new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel lblName = new JLabel(name);
        lblName.setFont(AppTheme.FONT_SUBTITLE);

        JLabel lblDesc = new JLabel("<html><small>" + desc + "</small></html>");
        lblDesc.setForeground(AppTheme.TEXT_MUTED);

        JLabel lblPrice = new JLabel(price);
        lblPrice.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblPrice.setForeground(AppTheme.PRIMARY_ORANGE);

        card.add(lblName, BorderLayout.NORTH);
        card.add(lblDesc, BorderLayout.CENTER);
        card.add(lblPrice, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createCartItem(String name, String price) {
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
