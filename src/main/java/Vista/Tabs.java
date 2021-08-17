package Vista;


import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class Tabs extends JPanel{
    JButton button = new JButton("Button");
    JTabbedPane tabPane = new JTabbedPane();

    public Tabs() throws SQLException{
        JFrame f = new JFrame("RETO 5 - MINTIC 2021");
        JTabbedPane jtp = new JTabbedPane();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Requerimiento1 table = new Requerimiento1();
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(table.tabla);
        jtp.add("Requerimiento 1", jsp);

        Requerimiento2 table2 = new Requerimiento2();
        JScrollPane jsp2 = new JScrollPane();
        jsp2.setViewportView(table2.tabla);
        jtp.add("Requerimiento 2", jsp2);

        Requerimiento3 table3 = new Requerimiento3();
        JScrollPane jsp3 = new JScrollPane();
        jsp3.setViewportView(table3.tabla);
        jtp.add("Requerimiento 3", jsp3);
        
        f.add(jtp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
