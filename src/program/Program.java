package program;
import firma.Firma;
import java.awt.*;

public class Program {
    public static void main(String[] args) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Firma firma = new Firma();
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
               firma.set_ramka(new Ramka(firma));
            }
        });
    }   
}
