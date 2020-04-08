package firma;
import java.math.BigDecimal;
public class Sprzedaz extends Operacja 
{
    public Sprzedaz(BigDecimal sztuki, BigDecimal metry_szesc, String data)
    {
        this.set_sztuki(sztuki);
        this.set_metry_szesc(metry_szesc);
        this.set_data(data);
        this.set_nazwa("Sprzedaż");
    }
}
