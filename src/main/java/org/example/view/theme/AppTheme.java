package org.example.view.theme;

import java.awt.Color;
import java.awt.Font;

public class AppTheme {
    // Fondos y Superficies
    public static final Color BG_MAIN = new Color(248, 249, 255);       // #f8f9ff
    public static final Color BG_CARD = Color.WHITE;                     // #ffffff
    public static final Color BG_SUBTLE = new Color(241, 245, 249);     // #f1f5f9
    public static final Color BORDER_COLOR = new Color(226, 232, 240);  // #e2e8f0

    // Colores de Acento y Marca
    public static final Color PRIMARY_ORANGE = new Color(234, 88, 12);  // #ea580c (Naranja RestoApp)
    public static final Color PRIMARY_HOVER = new Color(194, 65, 12);   // #c2410c

    // Textos
    public static final Color TEXT_DARK = new Color(15, 23, 42);        // #0f172a (Títulos / Bold)
    public static final Color TEXT_MUTED = new Color(100, 116, 139);    // #64748b (Subtítulos / Metadata)

    // Estados
    public static final Color STATE_GREEN = new Color(22, 163, 74);     // Libre / Completado
    public static final Color STATE_ORANGE = new Color(217, 119, 6);    // En preparación / Ocupado
    public static final Color STATE_RED = new Color(220, 38, 38);       // Demora / Por cobrar

    // Tipografías
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 18);
    public static final Font FONT_SUBTITLE = new Font("SansSerif", Font.BOLD, 14);
    public static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 13);
    public static final Font FONT_SMALL = new Font("SansSerif", Font.PLAIN, 11);
    public static final Font FONT_BOLD_BTN = new Font("SansSerif", Font.BOLD, 13);
}
