package program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Wyczysc extends JFrame
{
    protected Ramka wieksza_ramka;
    private JButton takPrzycisk;
    private JButton niePrzycisk;
    private JLabel pytanie;
    
    public Wyczysc(Ramka glowna)
    {
        super("Wyczyść stan");
        this.wieksza_ramka = glowna;
        setLayout(null);
        setLocation(350, 200);
        setSize(600, 400);
        setResizable(true);
        setVisible(false);
                    
        pytanie=new JLabel();
        pytanie.setText("Czy na pewno chcesz wyczyścić stan magazynu?");
        pytanie.setLocation(50,20);
        pytanie.setSize(580,100);
        pytanie.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(pytanie);
        
        takPrzycisk = new JButton("Tak");
        takPrzycisk.setLocation(70,200);
        takPrzycisk.setSize(200,60);
        takPrzycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        takPrzycisk.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                try 
                {
                    wieksza_ramka.firma_ramka.wyczysc_stan();
                } 
                catch (IOException ex)
                {
                    Logger.getLogger(Wyczysc.class.getName()).log(Level.SEVERE, null, ex);
                }
                wieksza_ramka.ramka_wyczysc.dispose();
                wieksza_ramka.dispose();
                System.exit(0);
            }
        });
        add(takPrzycisk);
        
        niePrzycisk = new JButton("Nie");
        niePrzycisk.setLocation(320,200);
        niePrzycisk.setSize(200,60);
        niePrzycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        niePrzycisk.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e)
            {              
                wieksza_ramka.ramka_wyczysc.dispose();
            }
        });
        add(niePrzycisk);
    }
}

