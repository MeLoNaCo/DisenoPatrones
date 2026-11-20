package org.example.view.dialogs;

import org.example.view.components.PrimaryButton;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NuevoProductoDialog extends JDialog {

    public NuevoProductoDialog(Frame owner) {
        super(owner, "Nuevo Producto", true);
        setSize(480, 520);
        setLocationRelativeTo(owner);
        getContentPane().setBackground(AppTheme.BG_CARD);
        setLayout(new BorderLayout(16, 16));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Nuevo Producto");
        title.setFont(AppTheme.FONT_TITLE);
        add(title, BorderLayout.NORTH);

        // Formulario
        JPanel form = new JPanel(new GridLayout(6, 2, 8, 12));
        form.setOpaque(false);

        form.add(new JLabel("Nombre del producto:"));
        JTextField txtNombre = new JTextField();
        form.add(txtNombre);

        form.add(new JLabel("Categoría:"));
        JComboBox<String> cmbCat = new JComboBox<>(new String[]{"Hamburguesas", "Tacos", "Pizzas", "Bebidas", "Postres", "Entradas"});
        form.add(cmbCat);

        form.add(new JLabel("Precio base ($):"));
        JTextField txtPrecio = new JTextField("14.50");
        form.add(txtPrecio);

        form.add(new JLabel("Stock inicial:"));
        JTextField txtStock = new JTextField("50");
        form.add(txtStock);

        form.add(new JLabel("Estado:"));
        JCheckBox chkActivo = new JCheckBox("Activo en el menú", true);
        form.add(chkActivo);

        form.add(new JLabel("Descripción:"));
        JTextField txtDesc = new JTextField();
        form.add(txtDesc);

        add(form, BorderLayout.CENTER);

        // Botones
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        footer.setOpaque(false);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setFont(AppTheme.FONT_BODY);
        btnCancel.addActionListener(e -> dispose());

        PrimaryButton btnGuardar = new PrimaryButton("Guardar producto");
        btnGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Producto '" + txtNombre.getText() + "' guardado.");
            dispose();
        });

        footer.add(btnCancel);
        footer.add(btnGuardar);
        add(footer, BorderLayout.SOUTH);
    }
}
