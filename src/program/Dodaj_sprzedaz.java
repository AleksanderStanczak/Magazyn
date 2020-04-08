package program;
import firma.Sprzedaz;
import java.math.BigDecimal;

class Dodaj_sprzedaz extends Dodaj
{
    public Dodaj_sprzedaz(Ramka glowna) 
    {
        super(glowna);
    }
    
    @Override
    void wywolaj_operacje()
    {
        Sprzedaz nowa;
        nowa=new Sprzedaz(sztuki, metry_szesc, cala_data);
        this.wieksza_ramka.firma_ramka.get_zbior_operacji().dodaj_do_zbioru(nowa);
        BigDecimal nowa_sztuki, nowa_metry_szesc;
        nowa_sztuki = this.wieksza_ramka.firma_ramka.get_sztuki().subtract(sztuki);
        nowa_metry_szesc = this.wieksza_ramka.firma_ramka.get_metry_szesc().subtract(metry_szesc);
        this.wieksza_ramka.firma_ramka.set_sztuki(nowa_sztuki);
        this.wieksza_ramka.firma_ramka.set_metry_szesc(nowa_metry_szesc);
    } 
}

