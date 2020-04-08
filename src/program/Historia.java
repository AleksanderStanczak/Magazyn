package program;
import firma.Firma;
import firma.Operacja;
import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

class Historia extends JFrame implements ActionListener
{
    protected Ramka wieksza_ramka;
    protected Firma firma_ramka;
    private JTable tabelka;
    private JPopupMenu menu;
    private JMenuItem menu_usun;
    private DefaultTableModel tableModel;
    
    public Historia(Ramka glowna)
    {
        
        this.wieksza_ramka = glowna;   
        String[] nazwy_kolumn = new String[] {
            "Typ operacji", "Liczba sztuk", "Metry sześcienne", "Data"
        };
        Object historia[][];
        historia = new Object[10000][4];
        int i = 0;
        for(Operacja operacja : this.wieksza_ramka.firma_ramka.get_zbior_operacji().zbior_operacji)
        {
            historia[i][0]=operacja.get_nazwa();
            historia[i][1]=operacja.get_sztuki();
            historia[i][2]=operacja.get_metry_szesc();
            historia[i][3]=operacja.get_data(); 
            i++;
        }
        tableModel = new DefaultTableModel(historia, nazwy_kolumn);
        tabelka = new JTable(tableModel)
        {
            public boolean isCellEditable(int rowIndex, int colIndex)   //blokowanie edycji komórek
            {
                return false;
            }
        };;

        menu = new JPopupMenu();
        menu_usun = new JMenuItem("Usuń");
        menu_usun.addActionListener(this);
        menu.add(menu_usun); 
        tabelka.setComponentPopupMenu(menu);
        tabelka.addMouseListener(new TableMouseListener(tabelka));
        
        this.add(new JScrollPane(tabelka));        
        tabelka.setRowHeight(30);
        this.setTitle("Historia");
        this.setLocation(150, 200);
        this.setSize(900, 600);
        tabelka.setFont(new Font("Verdana", Font.PLAIN, 20));
        tabelka.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 20));
    }
     
    public class TableMouseListener extends MouseAdapter 
    {  
        private JTable tabelka;  
        public TableMouseListener(JTable tabelka) 
        {
            this.tabelka = tabelka;
        }
     
        @Override
        public void mousePressed(MouseEvent event) 
        {
            // selects the row at which point the mouse is clicked
            Point point = event.getPoint();
            int currentRow = tabelka.rowAtPoint(point);
            tabelka.setRowSelectionInterval(currentRow, currentRow);
        }
    }
    
    @Override
     public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == menu_usun) 
        {
            usun();
        } 
    }
     
    private void usun() 
    { 
        int wybrany_wiersz = tabelka.getSelectedRow();
        this.wieksza_ramka.firma_ramka.get_zbior_operacji().usun_ze_zbioru(wybrany_wiersz,this.wieksza_ramka.firma_ramka);
        this.wieksza_ramka.info_sztuki.setText("Liczba sztuk: "+String.valueOf(this.wieksza_ramka.firma_ramka.get_sztuki()));
        this.wieksza_ramka.info_metry_szesc.setText("Metry sześcienne: "+String.valueOf(this.wieksza_ramka.firma_ramka.get_metry_szesc()));
        try 
        {
            this.wieksza_ramka.firma_ramka.zapis_stanu();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Historia.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((DefaultTableModel)tabelka.getModel()).removeRow(wybrany_wiersz);
    }
}

