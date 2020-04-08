package firma;
import program.Ramka;
import java.io.*;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Firma {
    private Ramka ramka;
    protected BigDecimal sztuki;
    protected BigDecimal metry_szesc;
    protected Zbior_operacji zbior_operacji = new Zbior_operacji();
    private static final String zrodlo_pliku = "historia.txt";

    public Firma()
    {
        sztuki= new BigDecimal("0.0");
        metry_szesc= new BigDecimal("0.0");
        try {
            this.wczytaj_stan();
        } catch (IOException ex) {
            Logger.getLogger(Firma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BigDecimal get_sztuki()
    {
        return this.sztuki;
    }
    public BigDecimal get_metry_szesc()
    {
        return this.metry_szesc;
    }
    public Zbior_operacji get_zbior_operacji()
    {
        return this.zbior_operacji;
    }
    public void set_sztuki(BigDecimal of)
    {
        this.sztuki = of;
    }
    public void set_metry_szesc(BigDecimal metry_szesc)
    {
        this.metry_szesc = metry_szesc;
    }
    public Ramka get_ramka()
    {
        return this.ramka;
    }
    public void set_ramka(Ramka ramka)
    {
        this.ramka=ramka;
    }
    
    public void zapis_stanu() throws IOException
    {
        PrintWriter plik = new PrintWriter(Firma.zrodlo_pliku);
        plik.println(this.sztuki);
        plik.println(this.metry_szesc);

        for(Operacja operacja : this.get_zbior_operacji().zbior_operacji )
        {
            plik.println(operacja.get_nazwa());
            plik.println(operacja.get_sztuki());
            plik.println(operacja.get_metry_szesc());
            plik.println(operacja.get_data());                       
        }
        plik.close();
    }
    
    public void wczytaj_stan() throws IOException
    {
        FileReader plik = new FileReader(this.zrodlo_pliku);
        BufferedReader reader = new BufferedReader(plik);   
        this.sztuki = new BigDecimal(reader.readLine());
        this.metry_szesc = new BigDecimal(reader.readLine());        
        String data;
        BigDecimal sztuki, metry_szesc;	
        Operacja nowa;
        
        //Wczytywanie operacji dopóki nie ma nulla w linijce
        String linia = reader.readLine();
        while (linia != null) 
        {  
            sztuki = new BigDecimal(reader.readLine());
            metry_szesc = new BigDecimal(reader.readLine());
            data = reader.readLine();
            switch(linia)
            {
                case "Sprzedaż":
                nowa = new Sprzedaz(sztuki, metry_szesc, data);
                this.get_zbior_operacji().dodaj_do_zbioru(nowa);
                break;
                    
                case "Zakup":
                nowa = new Zakup(sztuki, metry_szesc, data);
                this.get_zbior_operacji().dodaj_do_zbioru(nowa);
                break;
            }
            linia = reader.readLine();
        }
        plik.close();
    }
    
    public void wyczysc_stan() throws IOException
    {
        PrintWriter plik = new PrintWriter(this.zrodlo_pliku);
        plik.println(0.0);
        plik.println(0.0);
        plik.close();
    }

}




