package program;
import java.math.BigDecimal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


abstract class Dodaj extends JFrame implements ActionListener
{
    protected Ramka wieksza_ramka;
    private JButton zapisz_przycisk;
    private JLabel info_sztuki;
    private JLabel info_metry_szesc;
    protected JTextField pole_sztuki;
    protected JTextField pole_metry_szesc;
    protected JComboBox<String> rok;
    protected JComboBox<String> miesiac;
    protected JComboBox<String> dzien;
    protected BigDecimal sztuki;
    protected BigDecimal metry_szesc;
    protected String cala_data;
    protected String wybrany_rok;
    protected String wybrany_miesiac;
    protected String wybrany_dzien;

    public Dodaj(Ramka glowna)
    {
        super("Dodaj");
        this.wieksza_ramka = glowna;
        setLayout(null);
        setLocation(350, 200);
        setSize(600, 500);
        setResizable(true);
        setVisible(false);
                    
        info_sztuki=new JLabel();
        info_sztuki.setText("Liczba sztuk: ");
        info_sztuki.setLocation(50,20);
        info_sztuki.setSize(300,60);
        info_sztuki.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(info_sztuki);
        
        pole_sztuki= new JTextField("");
        pole_sztuki.setLocation(320,20);
        pole_sztuki.setSize(200,60);
        pole_sztuki.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(pole_sztuki);
        
        info_metry_szesc=new JLabel();
        info_metry_szesc.setText("Metry sześcienne: ");
        info_metry_szesc.setLocation(50,100);
        info_metry_szesc.setSize(300,60);
        info_metry_szesc.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(info_metry_szesc);
        
        pole_metry_szesc= new JTextField("");
        pole_metry_szesc.setLocation(320,100);
        pole_metry_szesc.setSize(200,60);
        pole_metry_szesc.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(pole_metry_szesc);

        String[] lata = new String[] {"2018", "2019","2020", "2021", "2022", "2023", "2024", "2025", "2026","2027","2028","2029","2030"};
        rok = new JComboBox<>(lata);
        rok.setLocation(100,200);
        rok.setSize(100,60);
        rok.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(rok);

        String[] miesiace = new String[] {"01", "02","03", "04", "05", "06", "07", "08", "09","10","11","12"};
        miesiac = new JComboBox<>(miesiace);
        miesiac.setLocation(250,200);
        miesiac.setSize(100,60);
        miesiac.setFont(new Font("Verdana", Font.PLAIN, 20));     
        add(miesiac);

        String[] dni = new String[] {"01", "02","03", "04", "05", "06", "07", "08", "09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        dzien = new JComboBox<>(dni);
        dzien.setLocation(400,200);
        dzien.setSize(100,60);
        dzien.setFont(new Font("Verdana", Font.PLAIN, 20));
        add(dzien);

        zapisz_przycisk = new JButton("Zapisz");
        zapisz_przycisk.setLocation(200,300);
        zapisz_przycisk.setSize(200,60);
        zapisz_przycisk.setFont(new Font("Verdana", Font.PLAIN, 20));
        zapisz_przycisk.addActionListener(this);
        add(zapisz_przycisk);
        
        JLabel pomoc_label = new JLabel();
        pomoc_label.setText("Pamiętaj: używaj kropkek zamiast przecinków w liczbach");
        pomoc_label.setLocation(50, 360);
        pomoc_label.setSize(600, 100);
        pomoc_label.setFont(new Font("Verdana", Font.PLAIN, 12));
        add(pomoc_label);
    }
    
    @Override
     public void actionPerformed(ActionEvent e)
    {
        sztuki = new BigDecimal(pole_sztuki.getText());
        metry_szesc = new BigDecimal(pole_metry_szesc.getText());
        wybrany_rok = (String) rok.getSelectedItem();
        wybrany_miesiac = (String) miesiac.getSelectedItem();
        wybrany_dzien = (String) dzien.getSelectedItem();

        cala_data = new String("");
	StringBuilder pom = new StringBuilder(cala_data);
	pom.append(wybrany_rok);
        pom.append("-");
	pom.append(wybrany_miesiac);
        pom.append("-");
	pom.append(wybrany_dzien);
	cala_data = pom.toString();
        
        wywolaj_operacje(); //Wywołanie zakupu lub sprzedaży u potomnej klasy
        this.wieksza_ramka.info_sztuki.setText("Liczba sztuk: "+String.valueOf(this.wieksza_ramka.firma_ramka.get_sztuki()));
        this.wieksza_ramka.info_metry_szesc.setText("Metry sześcienne: "+String.valueOf(this.wieksza_ramka.firma_ramka.get_metry_szesc()));
        
        //Zapis stanu na koniec
        try 
        {
            this.wieksza_ramka.firma_ramka.zapis_stanu();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dodaj_zakup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }
     
    abstract void wywolaj_operacje();

}

