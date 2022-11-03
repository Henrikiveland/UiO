import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.BorderLayout;

// En klasse for aa holde orden paa alle komponentene som skal vises i vinduet.
public class LabyrintBrett extends JPanel {
    JButton sluttknapp;
    JLabel statustekst;
    Labyrint lab;
    JLabel antallLosninger;
    JButton neste;
    int viserLosning = 0;
    int valgtKolonne;
    int valgtRad;
    JLabel jviserLosning;
    JLabel beskjed;
    JLabel mellomrom;
    JLabel mellomrom2;
    JPanel knapperTekst;

    LabyrintBrett(Labyrint l) {
        lab = l;
        lab.settBrett(this);
    }

    // En metode for aa velge ossen alt skal se ut grafisk.
    void initGUI () {
        // Setter layout til borderLayout for aa kunne velge hvor paa brettet ting skal vises.
        setLayout(new BorderLayout());
        knapperTekst = new JPanel();
        knapperTekst.setLayout(new BoxLayout(knapperTekst, BoxLayout.PAGE_AXIS));
        knapperTekst.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));

        // Oppretter diverse labels
        lab.initGUI();
        statustekst = new JLabel("Trykk paa en hvit rute.");
        antallLosninger = new JLabel("Antall losninger:  . ");
        jviserLosning = new JLabel("Viser losningnr:  . ");
        beskjed = new JLabel("");
        beskjed.setForeground(Color.RED);
        mellomrom = new JLabel(" ");
        mellomrom2 = new JLabel(" ");


        // Lager alle knappene
        sluttknapp = new JButton("Exit");
        class Stoppbehandler implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        }
        sluttknapp.addActionListener(new Stoppbehandler());


        neste = new JButton("Neste losning");
        class NesteLosning implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                // Denne knappen viser neste losning i losningslista 
                viserLosning++;
                lab.GUIfinnUtveiFra(valgtKolonne, valgtRad);
            }
        }
        neste.addActionListener(new NesteLosning());


        // Legger til alle kanapper og bekskjeder der jeg vil ha de.
        this.add(lab, BorderLayout.CENTER);
        this.add(statustekst, BorderLayout.PAGE_START);
        
        knapperTekst.add(mellomrom);
        knapperTekst.add(antallLosninger);
        knapperTekst.add(jviserLosning);
        knapperTekst.add(mellomrom2);
        knapperTekst.add(neste);
        knapperTekst.add(sluttknapp);
        knapperTekst.add(beskjed);
        
        this.add(knapperTekst, BorderLayout.LINE_END);

        

    }
}
    

