package org.example.view.views;

import org.example.view.components.PrimaryButton;
import org.example.view.theme.AppTheme;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CocinaView extends JPanel {

    public CocinaView() {
        setLayout(new GridLayout(1, 3, 16, 0));
        setBackground(AppTheme.BG_MAIN);
        setBorder(new EmptyBorder(16, 20, 16, 20));

        // 3 Columnas Kanban
        add(createKanbanColumn("Pendiente (3)", AppTheme.TEXT_DARK,
            createKdsCard("#1048", "Mesa 7 · Salón", "Hamburguesa Clásica x2\nPapas rústicas x1", "Hace 4 min", AppTheme.STATE_GREEN, "Iniciar preparación")));
        
        add(createKanbanColumn("En preparación (3)", AppTheme.PRIMARY_ORANGE,
            createKdsCard("#1045", "Mesa 2 · Terraza", "Hamburguesa Doble x1\nTiramisú x2", "14 min", AppTheme.STATE_ORANGE, "Marcar como listo")));
        
        add(createKanbanColumn("Listo para entrega (2)", AppTheme.STATE_GREEN,
            createKdsCard("#1041", "Para llevar · Mostrador", "Pizza Margarita x2", "Listo hace 28 min", AppTheme.STATE_GREEN, "Entregar a garzón")));
    }

    private JPanel createKanbanColumn(String title, Color badgeColor, JPanel card) {
        JPanel col = new JPanel(new BorderLayout(10, 10));
        col.setOpaque(false);

        JLabel header = new JLabel(title);
        header.setFont(AppTheme.FONT_SUBTITLE);
        header.setForeground(badgeColor);
        col.add(header, BorderLayout.NORTH);

        JPanel cardsContainer = new JPanel();
        cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
        cardsContainer.setOpaque(false);
        cardsContainer.add(card);
        cardsContainer.add(Box.createVerticalGlue());

        col.add(cardsContainer, BorderLayout.CENTER);
        return col;
    }

    private JPanel createKdsCard(String id, String dest, String items, String timer, Color timerColor, String actionText) {
        JPanel card = new JPanel(new BorderLayout(8, 8));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(AppTheme.BORDER_COLOR, 1, true),
            new EmptyBorder(14, 14, 14, 14)
        ));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        JLabel lblId = new JLabel(id + " · " + dest);
        lblId.setFont(AppTheme.FONT_SUBTITLE);

        JLabel lblTimer = new JLabel("● " + timer);
        lblTimer.setFont(AppTheme.FONT_SMALL);
        lblTimer.setForeground(timerColor);

        top.add(lblId, BorderLayout.WEST);
        top.add(lblTimer, BorderLayout.EAST);
        card.add(top, BorderLayout.NORTH);

        JTextArea txtItems = new JTextArea(items);
        txtItems.setEditable(false);
        txtItems.setFont(AppTheme.FONT_BODY);
        txtItems.setOpaque(false);
        card.add(txtItems, BorderLayout.CENTER);

        PrimaryButton btnAction = new PrimaryButton(actionText);
        btnAction.setPreferredSize(new Dimension(0, 36));
        card.add(btnAction, BorderLayout.SOUTH);

        return card;
    }
}
