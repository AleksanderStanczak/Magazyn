package firma;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Zbior_operacji {
    public ArrayList<Operacja> zbior_operacji = new ArrayList<>();
    public void dodaj_do_zbioru(Operacja nowa_operacja)
    {
        this.zbior_operacji.add(nowa_operacja);
    }
    
    public void usun_ze_zbioru(int indeks, Firma firma)
    {
        BigDecimal nowa_sztuki, nowa_metry_szesc;
        Operacja usuwana = this.zbior_operacji.get(indeks); 
        if (usuwana.nazwa == "Zakup")
        {
            nowa_sztuki = firma.get_sztuki().subtract(usuwana.sztuki);
            nowa_metry_szesc = firma.get_metry_szesc().subtract(usuwana.metry_szesc);
        }
        else
        {
            nowa_sztuki = firma.get_sztuki().add(usuwana.sztuki);
            nowa_metry_szesc = firma.get_metry_szesc().add(usuwana.metry_szesc);
        }
        firma.set_sztuki(nowa_sztuki);
        firma.set_metry_szesc(nowa_metry_szesc);
        this.zbior_operacji.remove(indeks);
    }  
}
