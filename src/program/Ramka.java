package program;
import firma.Firma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ramka extends JFrame
{
    protected Firma firma_ramka;
    protected Ramka wieksza_ramka;
    protected Dodaj_sprzedaz ramka_sprzedaz;
    protected Dodaj_zakup ramka_zakup;
    protected Historia ramka_historia;
    protected Wyczysc ramka_wyczysc;
    private JButton zakup_przycisk;
    private JButton sprzedaz_przycisk;
    private JButton historia_przycisk;
    private JButton wyczysc_przycisk;
    protected JLabel info_metry_szesc;
    protected JLabel info_sztuki;
    int rozmiar_przycisku=200;
        
    public Ramka(Firma firma)
    {
        super("Magazyn");
        //Ogólne ustawienia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(300, 150);
        setSize(760, 500);
        setResizable(true);
        setVisible(true);   
        wieksza_ramka = this;
        
        //Dodanie zakupu
        zakup_przycisk = new JButton("Dodaj zakup");
        zakup_przycisk.setLocation(500,75);
        zakup_przycisk.setSize(rozmiar_przycisku,60);
        zakup_przycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        zakup_przycisk.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ramka_zakup = new Dodaj_zakup(wieksza_ramka);
                ramka_zakup.hasFocus();
                ramka_zakup.setVisible(true);    
            }
        });
        add(zakup_przycisk);

        //Dodanie sprzedaży   
        sprzedaz_przycisk = new JButton("Dodaj sprzedaż");
        sprzedaz_przycisk.setLocation(500, 150);
        sprzedaz_przycisk.setSize(rozmiar_przycisku,60);
        sprzedaz_przycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        sprzedaz_przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              ramka_sprzedaz = new Dodaj_sprzedaz(wieksza_ramka);
              ramka_sprzedaz.hasFocus();
              ramka_sprzedaz.setVisible(true);
            }
        });
        add(sprzedaz_przycisk);
        
        //Wejście w historie
        historia_przycisk = new JButton("Historia");
        historia_przycisk.setLocation(500, 225);
        historia_przycisk.setSize(rozmiar_przycisku,60);
        historia_przycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        historia_przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              ramka_historia = new Historia(wieksza_ramka);  
              ramka_historia.hasFocus();
              ramka_historia.setVisible(true);
            }
        });
        add(historia_przycisk);
        
        //Wyczyszczenie stanu       
        wyczysc_przycisk = new JButton("Wyczyść stan");
        wyczysc_przycisk.setLocation(500, 300);
        wyczysc_przycisk.setSize(rozmiar_przycisku,60);
        wyczysc_przycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        wyczysc_przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              ramka_wyczysc = new Wyczysc(wieksza_ramka);
              ramka_wyczysc.hasFocus();
              ramka_wyczysc.setVisible(true);
            }
        });
        add(wyczysc_przycisk);
        
        this.firma_ramka = firma;
        //Info o stanie magazynu
        info_sztuki=new JLabel();
        info_sztuki.setText("Liczba sztuk: "+String.valueOf(firma_ramka.get_sztuki()));
        info_sztuki.setLocation(50, 80);
        info_sztuki.setSize(400, 100);
        info_sztuki.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(info_sztuki);

        info_metry_szesc=new JLabel();
        info_metry_szesc.setText("Metry sześcienne: "+String.valueOf(firma_ramka.get_metry_szesc()));
        info_metry_szesc.setLocation(50, 180);
        info_metry_szesc.setSize(400, 100);
        info_metry_szesc.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(info_metry_szesc);

        JLabel pomoc_label = new JLabel();
        pomoc_label.setText("Pamiętaj: każdą operacje możesz usunąć kilkając prawy przycisk w historii i wybierając \"usuń\"");
        pomoc_label.setLocation(50, 350);
        pomoc_label.setSize(600, 100);
        pomoc_label.setFont(new Font("Verdana", Font.PLAIN, 12));
        add(pomoc_label);
    }
}