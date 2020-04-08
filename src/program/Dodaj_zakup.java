package program;
import firma.Zakup;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Dodaj_zakup extends Dodaj
{
    public Dodaj_zakup(Ramka glowna) 
    {
        super(glowna);
    }

    @Override
    void wywolaj_operacje()
    {
        Zakup nowa;
        nowa=new Zakup(sztuki, metry_szesc, cala_data);
        this.wieksza_ramka.firma_ramka.get_zbior_operacji().dodaj_do_zbioru(nowa);
        BigDecimal nowa_sztuki, nowa_metry_szesc;
        nowa_sztuki = this.wieksza_ramka.firma_ramka.get_sztuki().add(sztuki);
        nowa_metry_szesc = this.wieksza_ramka.firma_ramka.get_metry_szesc().add(metry_szesc);
        this.wieksza_ramka.firma_ramka.set_sztuki(nowa_sztuki);
        this.wieksza_ramka.firma_ramka.set_metry_szesc(nowa_metry_szesc);
    } 
}

