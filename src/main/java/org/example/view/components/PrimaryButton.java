package org.example.view.components;

import org.example.view.theme.AppTheme;
import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {
    private int cornerRadius = 8;

    public PrimaryButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(AppTheme.FONT_BOLD_BTN);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(10, 16, 10, 16));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(AppTheme.PRIMARY_HOVER.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(AppTheme.PRIMARY_HOVER);
        } else {
            g2.setColor(AppTheme.PRIMARY_ORANGE);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        super.paintComponent(g);
        g2.dispose();
    }
}
