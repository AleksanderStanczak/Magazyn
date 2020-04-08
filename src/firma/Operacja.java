package firma;
import java.math.BigDecimal;

public abstract class Operacja {
    protected String nazwa;
    protected BigDecimal sztuki;
    protected BigDecimal metry_szesc;
    private String data;	

    public String get_nazwa()
    {
        return this.nazwa;
    }
    public BigDecimal get_sztuki()
    {
        return this.sztuki;
    }
    public BigDecimal get_metry_szesc()
    {
        return this.metry_szesc;
    }
    public String get_data()
    {
        return this.data;
    }
    public void set_nazwa(String nazwa)
    {
        this.nazwa = nazwa;
    }
    public void set_sztuki(BigDecimal sztuki)
    {
        this.sztuki = sztuki;
    }
    public void set_metry_szesc(BigDecimal metry_szesc)
    {
        this.metry_szesc = metry_szesc;
    }
    public void set_data(String data)
    {
        this.data = data;
    }        
}