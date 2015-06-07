package com.ogaworldexplosion.ogaheater.ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Toolkit;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -8424734531682214227L;
    private static final String AppName = "OgaHeater";
    private static final String Version = " v1.0.1";
    private JPanel contentPane;

    private int maxCoreCount = Runtime.getRuntime().availableProcessors();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {

        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
          //e.printStackTrace();
        }

        setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/ogaworldexplosion/ogaheater/images/img_fire_on.png")));
        setTitle(AppName + Version);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 100, 100);
        contentPane = new JPanel(new FlowLayout());
        setContentPane(contentPane);

        int tmpCoreCount = Runtime.getRuntime().availableProcessors();
        if(tmpCoreCount == 1){
            maxCoreCount = tmpCoreCount;
        }else{
            maxCoreCount = tmpCoreCount-1;
        }

        for(int i=0;i<maxCoreCount;i++){
            contentPane.add(new FireButton());
        }

        FireButton sizeTmp = new FireButton();
        int fireButtonHeight = (int)Math.floor(sizeTmp.getPreferredSize().getHeight());
        int fireButtonWidth = (int)Math.floor(sizeTmp.getPreferredSize().getWidth());

        setSize(35+fireButtonWidth*this.maxCoreCount,45+fireButtonHeight);
    }
}
