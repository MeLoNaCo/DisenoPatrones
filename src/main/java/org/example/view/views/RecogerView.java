package org.example.view.views;

import org.example.view.theme.AppTheme;
import javax.swing.*;
import java.awt.*;

public class RecogerView extends JPanel {

    public RecogerView() {
        setLayout(new BorderLayout());
        setBackground(AppTheme.BG_MAIN);

        JLabel title = new JLabel("Recoger");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_DARK);
        add(title, BorderLayout.NORTH);
    }
}
