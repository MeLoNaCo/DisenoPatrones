package org.example.view.views;

import org.example.view.components.PrimaryButton;
import org.example.view.dialogs.NuevoProductoDialog;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductosView extends JPanel {

    public ProductosView() {
        setLayout(new BorderLayout(16, 16));
        setBackground(AppTheme.BG_MAIN);
        setBorder(new EmptyBorder(16, 20, 16, 20));

        // Cabecera con botón + Nuevo Producto
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setOpaque(false);

        JLabel title = new JLabel("Mantenimiento de Catálogo: Productos");
        title.setFont(AppTheme.FONT_TITLE);
        topBar.add(title, BorderLayout.WEST);

        PrimaryButton btnNuevo = new PrimaryButton("+ Nuevo producto");
        btnNuevo.addActionListener(e -> {
            Frame topFrame = (Frame) SwingUtilities.getWindowAncestor(this);
            new NuevoProductoDialog(topFrame).setVisible(true);
        });
        topBar.add(btnNuevo, BorderLayout.EAST);
        add(topBar, BorderLayout.NORTH);

        // Tabla de Productos
        String[] columns = {"ID", "Nombre", "Categoría", "Precio", "Stock", "Estado"};
        Object[][] data = {
            {"#PRD-001", "Hamburguesa Clásica Artesanal", "Platos", "$14.00", "45 unid.", "Activo"},
            {"#PRD-002", "Tacos al Pastor x3", "Platos", "$12.50", "28 unid.", "Activo"},
            {"#PRD-003", "Limonada de Menta y Jengibre", "Bebidas", "$4.20", "90 unid.", "Activo"},
            {"#PRD-004", "Pizza Margarita Rústica", "Platos", "$16.50", "18 unid.", "Activo"},
            {"#PRD-005", "Tiramisú della Casa", "Postres", "$6.50", "12 unid. (Bajo)", "Poco Stock"},
            {"#PRD-006", "Ceviche Mixto Tradicional", "Entradas", "$15.20", "8 unid. (Bajo)", "Poco Stock"},
            {"#PRD-007", "Guacamole con Totopos", "Entradas", "$8.50", "35 unid.", "Inactivo"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setRowHeight(40);
        table.setFont(AppTheme.FONT_BODY);
        table.getTableHeader().setFont(AppTheme.FONT_SUBTITLE);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createLineBorder(AppTheme.BORDER_COLOR));
        add(scroll, BorderLayout.CENTER);
    }
}
