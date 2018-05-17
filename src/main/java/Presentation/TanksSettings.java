package Presentation;

import Resources.ProgramStrings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TanksSettings extends JFrame implements FrameWindowInterface {
    private JPanel mainPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JScrollPane scrollField;

    public TanksSettings(){
        setProperties();
        setTexts();
    }

    @Override
    public int showWindow() {
        this.setVisible(true);

        if (this.isVisible()) {
            return 1;
        } else {
            return -1;
        }
    }

    private void setProperties() {
        //Узнаем разрешение экрана устройства
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // задаем размер
        this.setSize(screenSize.width/2, screenSize.height/2);
        this.setContentPane(this.mainPanel);
    }

    private void setTexts(){
        this.addButton.setText(ProgramStrings.plus);
        this.addButton.addKeyListener(onAddTankClick);
        this.deleteButton.setText(ProgramStrings.delete);
        this.deleteButton.addKeyListener(onDeleteTankAdd);
    }

    KeyListener onAddTankClick = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };

    KeyListener onDeleteTankAdd = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };


}
