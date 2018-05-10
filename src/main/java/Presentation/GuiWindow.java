package Presentation;

import javax.swing.*;
import java.awt.*;
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
        this.addMarkButton.setText(ProgramStrings.addMark);
        this.checkStatisticsButton.setText(ProgramStrings.checkStatistics);
        this.tanksSettingsButton.setText(ProgramStrings.tanksSettings);
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

  

}
