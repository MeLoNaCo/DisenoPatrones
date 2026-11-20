package org.example.view.views;

import org.example.view.theme.AppTheme;
import javax.swing.*;
import java.awt.*;

public class ReportesView extends JPanel {

    public ReportesView() {
        setLayout(new BorderLayout());
        setBackground(AppTheme.BG_MAIN);

        JLabel title = new JLabel("Reportes");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_DARK);
        add(title, BorderLayout.NORTH);
    }
}
