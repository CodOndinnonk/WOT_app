package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Resources.ProgramStrings;



public class GuiWindow extends JFrame implements FrameWindowInterface {
    private JPanel mainPanel;
    private JComboBox selectTankBox;
    private JButton addTankButton;
    private JButton addMarkButton;
    private JTextField addMarkField;
    private JButton checkStatisticsButton;
    private JButton tanksSettingsButton;
    private JLabel selectTankLabel;
    private JLabel addMarkLabel;

    public GuiWindow(){
        setProperties();
        setTexts();
    }

    private void setProperties() {
        //Узнаем разрешение экрана устройства
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // задаем размер
        this.setSize(screenSize.width/2, screenSize.height/2);
        this.setContentPane(this.mainPanel);
        //завершение программы по закрытию главного окна
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void setTexts(){
        this.addTankButton.setText(ProgramStrings.plus);
        this.addTankButton.addKeyListener(onAddTankClick);
        this.addMarkButton.setText(ProgramStrings.addMark);
        this.addMarkButton.addKeyListener(onAddMarkClick);
        this.checkStatisticsButton.setText(ProgramStrings.checkStatistics);
        this.checkStatisticsButton.addKeyListener(onCheckStatisticsClick);
        this.tanksSettingsButton.setText(ProgramStrings.tanksSettings);
        this.tanksSettingsButton.addKeyListener(onSettingsClick);
        this.selectTankLabel.setText(ProgramStrings.selectTank);
        this.addMarkLabel.setText(ProgramStrings.addMark);
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


    KeyListener onAddTankClick = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };

    KeyListener onAddMarkClick = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };

    KeyListener onCheckStatisticsClick = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };

    KeyListener onSettingsClick = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    };



}
