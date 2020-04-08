package firma;
import java.math.BigDecimal;
public class Zakup extends Operacja 
{
    public Zakup(BigDecimal sztuki, BigDecimal metry_szesc, String data)
    {
        this.set_sztuki(sztuki);
        this.set_metry_szesc(metry_szesc);
        this.set_data(data);
        this.set_nazwa("Zakup");
    }
}
