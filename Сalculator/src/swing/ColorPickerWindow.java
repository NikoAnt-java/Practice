package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Николай
 */
public class ColorPickerWindow extends JFrame {

    public static ColorPickerWindow colorPickerWindow = null;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    private static ColorBox colorBox = null;
    private static RightPanel rightPanel = null;
    private static int colorRed = 125;
    private static int colorGreen = 125;
    private static int colorBlue = 125;

    static ColorPickerWindow getInstance() {
        if (colorPickerWindow == null) {
            return new ColorPickerWindow();
        }else{
        return colorPickerWindow;
    }
    }

    public ColorPickerWindow() {
        colorPickerWindow = this;
        setTitle("Color Picker");
        setSize(new Dimension(WIDTH, HEIGHT));
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLocationRelativeTo(null);
        setLocationByPlatform(true);

        this.setLayout(new GridLayout(1,2)); // делим окно на две части
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorBox = new ColorBox();
        Color color = new Color(colorRed, colorGreen, colorBlue);
        colorBox.setBackground(color);
        colorBox.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new Color(240,240,240)));

        rightPanel= new RightPanel();
        rightPanel.setBackground(new Color(240,240,240));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        add(colorBox);
        add(rightPanel);
                 
        setVisible(true);
    }

    private static class ColorBox extends JPanel {
    }

    public class RightPanel extends JPanel {

        public RightPanel() {
            JPanel panelRed = new JPanel();
            formPanel(panelRed, "Red");

            JPanel panelGreen = new JPanel();
            formPanel(panelGreen, "Green");

            JPanel panelBlue = new JPanel();
            formPanel(panelBlue, "Blue");

            setLayout(new BorderLayout());
            add(panelRed, BorderLayout.NORTH);
            add(panelGreen, BorderLayout.CENTER);
            add(panelBlue, BorderLayout.SOUTH);

        }
    }
    public void formPanel(JPanel panel, String description){


        JSlider slider = new JSlider(0,255,125);
        slider.setName(description);
        slider.setMajorTickSpacing(125);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel(description + ":"),BorderLayout.WEST);
        panel.add(slider, BorderLayout.CENTER);

    }
    public class LabelSlider extends JPanel {

    JLabel labelRed = new JLabel("Red:");
    JLabel labelGreen = new JLabel("Green:");
    JLabel labelBlue= new JLabel("Blue:");

}
    }
