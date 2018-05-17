package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        this.addTankButton.addActionListener(onAddTankClick);
        this.addMarkButton.setText(ProgramStrings.addMark);
        this.addMarkButton.addActionListener(onAddMarkClick);
        this.checkStatisticsButton.setText(ProgramStrings.checkStatistics);
        this.checkStatisticsButton.addActionListener(onCheckStatisticsClick);
        this.tanksSettingsButton.setText(ProgramStrings.tanksSettings);
        this.tanksSettingsButton.addActionListener(onSettingsClick);
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

    ActionListener onAddTankClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TanksSettings tanksSettings = new TanksSettings();
            tanksSettings.showWindow();
        }
    };

    ActionListener onAddMarkClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TanksSettings tanksSettings = new TanksSettings();
            tanksSettings.showWindow();
        }
    };

    ActionListener onCheckStatisticsClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TanksSettings tanksSettings = new TanksSettings();
            tanksSettings.showWindow();
        }
    };

    ActionListener onSettingsClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TanksSettings tanksSettings = new TanksSettings();
            tanksSettings.showWindow();
        }
    };


}
