package main.java;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import main.java.rmi.McDonaldsRmiInterface;

public class Main extends JFrame {

	private static final URL FIG_WHITE_JPG = Main.class.getResource("white.jpg");
	private static final URL MCFISH_FIG = Main.class.getResource("mcfish.jpg");
	private static final URL MCCHICKEN_FIG = Main.class.getResource("mcchicken.jpg");
	private static final URL BIGMAC_FIG = Main.class.getResource("bigmac.jpg");
	
	private static final String MCFISH = "mcfish";
	private static final String MCCHICKEN = "mcchicken";
	private static final String BIGMAC = "bigmac";
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		String[] choices = { "corba", "rmi" };
		final int choice = JOptionPane.showOptionDialog(null // Center in window.
				, "Qual mecanismo para comunicação RPC deseja utilizar?" // Message
				, "Escolha da camada de comunicação" // Title in titlebar
				, JOptionPane.YES_NO_OPTION // Option type
				, JOptionPane.PLAIN_MESSAGE // messageType
				, null // Icon (none)
				, choices // Button text as above.
				, "rmi" // Default button's label
		);
		
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
				try {
					initLabels();
					
					McDonaldsRmiInterface engine = Server.runServer(choice);
					ThreadEvent t = new ThreadEvent(engine);
	        		t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
            }
        });
        
       
    }

    public Main() {
        
        initComponents();
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                              (screenSize.height - frameSize.width) / 2));
        setResizable(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        label_chicken5 = new javax.swing.JLabel();
        label_chicken2 = new javax.swing.JLabel();
        label_chicken3 = new javax.swing.JLabel();
        label_chicken4 = new javax.swing.JLabel();
        label_chicken6 = new javax.swing.JLabel();
        label_chicken7 = new javax.swing.JLabel();
        label_chicken8 = new javax.swing.JLabel();
        label_chicken9 = new javax.swing.JLabel();
        label_chicken10 = new javax.swing.JLabel();
        label_chicken1 = new javax.swing.JLabel();
        label_fish2 = new javax.swing.JLabel();
        label_fish10 = new javax.swing.JLabel();
        label_bigmac10 = new javax.swing.JLabel();
        label_fish3 = new javax.swing.JLabel();
        label_fish4 = new javax.swing.JLabel();
        label_fish5 = new javax.swing.JLabel();
        label_fish6 = new javax.swing.JLabel();
        label_fish7 = new javax.swing.JLabel();
        label_fish8 = new javax.swing.JLabel();
        label_fish9 = new javax.swing.JLabel();
        label_fish1 = new javax.swing.JLabel();
        label_bigmac1 = new javax.swing.JLabel();
        label_bigmac2 = new javax.swing.JLabel();
        label_bigmac3 = new javax.swing.JLabel();
        label_bigmac4 = new javax.swing.JLabel();
        label_bigmac5 = new javax.swing.JLabel();
        label_bigmac6 = new javax.swing.JLabel();
        label_bigmac7 = new javax.swing.JLabel();
        label_bigmac8 = new javax.swing.JLabel();
        label_bigmac9 = new javax.swing.JLabel();
        jLabel_all_bigmac = new javax.swing.JLabel();
        jLabel_all_mcchicken = new javax.swing.JLabel();
        jLabel_all_Mcfish = new javax.swing.JLabel();
        jLabel_waiting_chicken = new javax.swing.JLabel();
        jTextField_waiting_chicken = new javax.swing.JTextField();
        jLabel_sand_chapa_chicken = new javax.swing.JLabel();
        jTextField_sand_chapa_chicken = new javax.swing.JTextField();
        jLabel_waiting_fish = new javax.swing.JLabel();
        jTextField_waiting_fish = new javax.swing.JTextField();
        jLabel_sand_chapa_fish = new javax.swing.JLabel();
        jTextField_sand_chapa_fish = new javax.swing.JTextField();
        jLabel_waiting_bigmac = new javax.swing.JLabel();
        jTextField_waiting_bigmac = new javax.swing.JTextField();
        jLabel_sand_chapa_bigmac = new javax.swing.JLabel();
        jTextField_sand_chapa_bigmac = new javax.swing.JTextField();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("Anagrams");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_chicken5.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        label_chicken2.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        label_chicken3.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        label_chicken4.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        label_chicken6.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        label_chicken7.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        label_chicken8.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        label_chicken9.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        label_chicken10.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, -1, -1));

        label_chicken1.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_chicken1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_chicken1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        label_fish2.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        label_fish10.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        label_bigmac10.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, -1, -1));

        label_fish3.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        label_fish4.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

        label_fish5.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        label_fish6.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        label_fish7.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        label_fish8.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        label_fish9.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        label_fish1.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_fish1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_fish1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        label_bigmac1.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        label_bigmac2.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        label_bigmac3.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        label_bigmac4.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        label_bigmac5.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        label_bigmac6.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        label_bigmac7.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, -1, -1));

        label_bigmac8.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));

        label_bigmac9.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG)); // NOI18N
        label_bigmac9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonsPanel.add(label_bigmac9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, -1, -1));

        jLabel_all_bigmac.setText("BigMac");
        jLabel_all_bigmac.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        buttonsPanel.add(jLabel_all_bigmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 830, 130));

        jLabel_all_mcchicken.setText("McChicken");
        jLabel_all_mcchicken.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        buttonsPanel.add(jLabel_all_mcchicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 130));

        jLabel_all_Mcfish.setText("McFish");
        jLabel_all_Mcfish.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue, java.awt.Color.blue));
        buttonsPanel.add(jLabel_all_Mcfish, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 830, 130));

        jLabel_waiting_chicken.setText("Consumidores esperando");
        buttonsPanel.add(jLabel_waiting_chicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 190, 20));

        jTextField_waiting_chicken.setEditable(false);
        jTextField_waiting_chicken.setColumns(4);
        jTextField_waiting_chicken.setText("0");
        buttonsPanel.add(jTextField_waiting_chicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 22));

        jLabel_sand_chapa_chicken.setText("Sanduíches na chapa");
        buttonsPanel.add(jLabel_sand_chapa_chicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 190, 20));

        jTextField_sand_chapa_chicken.setEditable(false);
        jTextField_sand_chapa_chicken.setColumns(4);
        jTextField_sand_chapa_chicken.setText("0");
        buttonsPanel.add(jTextField_sand_chapa_chicken, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, 22));

        jLabel_waiting_fish.setText("Consumidores esperando");
        buttonsPanel.add(jLabel_waiting_fish, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 190, 20));

        jTextField_waiting_fish.setEditable(false);
        jTextField_waiting_fish.setColumns(4);
        jTextField_waiting_fish.setText("0");
        buttonsPanel.add(jTextField_waiting_fish, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, 22));

        jLabel_sand_chapa_fish.setText("Sanduíches na chapa");
        buttonsPanel.add(jLabel_sand_chapa_fish, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 190, 20));

        jTextField_sand_chapa_fish.setEditable(false);
        jTextField_sand_chapa_fish.setColumns(4);
        jTextField_sand_chapa_fish.setText("0");
        buttonsPanel.add(jTextField_sand_chapa_fish, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, 22));

        jLabel_waiting_bigmac.setText("Consumidores esperando");
        buttonsPanel.add(jLabel_waiting_bigmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 190, 20));

        jTextField_waiting_bigmac.setEditable(false);
        jTextField_waiting_bigmac.setColumns(4);
        jTextField_waiting_bigmac.setText("0");
        buttonsPanel.add(jTextField_waiting_bigmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, 22));

        jLabel_sand_chapa_bigmac.setText("Sanduíches na chapa");
        buttonsPanel.add(jLabel_sand_chapa_bigmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 190, 20));

        jTextField_sand_chapa_bigmac.setEditable(false);
        jTextField_sand_chapa_bigmac.setColumns(4);
        jTextField_sand_chapa_bigmac.setText("0");
        buttonsPanel.add(jTextField_sand_chapa_bigmac, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, -1, 22));

        mainPanel.add(buttonsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 550));

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Quit Team, Quit!");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenu.add(fileMenu);

        setJMenuBar(mainMenu);
    }// </editor-fold>                         

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    static Map<String, List<JLabel>> labelsMap = new HashMap<String, List<JLabel>>();
    
    private static void initLabels(){
    	List<JLabel> bigmacs = new ArrayList<JLabel>();
    	bigmacs.add(label_bigmac1);
    	bigmacs.add(label_bigmac2);
    	bigmacs.add(label_bigmac3);
    	bigmacs.add(label_bigmac4);
    	bigmacs.add(label_bigmac5);
    	bigmacs.add(label_bigmac6);
    	bigmacs.add(label_bigmac7);
    	bigmacs.add(label_bigmac8);
    	bigmacs.add(label_bigmac9);
    	bigmacs.add(label_bigmac10);
    	
    	List<JLabel> mcchickens = new ArrayList<JLabel>();
    	mcchickens.add(label_chicken1);
    	mcchickens.add(label_chicken2);
    	mcchickens.add(label_chicken3);
    	mcchickens.add(label_chicken4);
    	mcchickens.add(label_chicken5);
    	mcchickens.add(label_chicken6);
    	mcchickens.add(label_chicken7);
    	mcchickens.add(label_chicken8);
    	mcchickens.add(label_chicken9);
    	mcchickens.add(label_chicken10);
    	
    	List<JLabel> mcfishs= new ArrayList<JLabel>();
    	mcfishs.add(label_fish1);
    	mcfishs.add(label_fish2);
    	mcfishs.add(label_fish3);
    	mcfishs.add(label_fish4);
    	mcfishs.add(label_fish5);
    	mcfishs.add(label_fish6);
    	mcfishs.add(label_fish7);
    	mcfishs.add(label_fish8);
    	mcfishs.add(label_fish9);
    	mcfishs.add(label_fish10);
    	
    	labelsMap.put(BIGMAC, bigmacs);
    	labelsMap.put(MCCHICKEN, mcchickens);
    	labelsMap.put(MCFISH, mcfishs);
    	
    }
    
    private static class ThreadEvent extends Thread{
		McDonaldsRmiInterface engine;
    	
    	public ThreadEvent(McDonaldsRmiInterface engine) {
			this.engine = engine;
		}

		@Override
    	public void run() {
			try {
    		while(true){
				int qtdBigMac = engine.getQtdBigMac();
				int qtdBigMacProducers = engine.getQtdBigMacProducers();
				int qtdBigMacConsumers = engine.getQtdBigMacConsumers();
				printMcDonaldsIcon(BIGMAC, qtdBigMac, BIGMAC_FIG);
				jTextField_sand_chapa_bigmac.setText("" +qtdBigMacProducers);
				jTextField_waiting_bigmac.setText(""+qtdBigMacConsumers);
				
				int qtdMcChicken = engine.getQtdMcChicken();
				int qtdMcChickenProducers = engine.getQtdMcChickenProducers();
				int qtdMcChickenConsumers = engine.getQtdMcChickenConsumers();
				printMcDonaldsIcon(MCCHICKEN, qtdMcChicken, MCCHICKEN_FIG);
				jTextField_sand_chapa_chicken.setText(""+qtdMcChickenProducers);
				jTextField_waiting_chicken.setText(""+qtdMcChickenConsumers);
				
				int qtdMcFish = engine.getQtdMcFish();
				int qtdMcFishProducers = engine.getQtdMcFishProducers();
				int qtdMcFishConsumers = engine.getQtdMcFishConsumers();
				printMcDonaldsIcon(MCFISH, qtdMcFish, MCFISH_FIG);
				jTextField_sand_chapa_fish.setText(""+qtdMcFishProducers);
				jTextField_waiting_fish.setText(""+qtdMcFishConsumers);
				
				Thread.sleep(1000);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
    	}
    }

    private static void printMcDonaldsIcon(String key, int qtd, URL url){
    	List<JLabel> list = labelsMap.get(key);
    	
    	for(JLabel label: list){
    		label.setIcon(new javax.swing.ImageIcon(FIG_WHITE_JPG));
    	}
    	
    	for(int i = 0; i < qtd; i++){
    		JLabel label = list.get(i);
    		label.setIcon(new javax.swing.ImageIcon(url));
    	}
    }
    
    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }                         

    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel_all_Mcfish;
    private javax.swing.JLabel jLabel_all_bigmac;
    private javax.swing.JLabel jLabel_all_mcchicken;
    private javax.swing.JLabel jLabel_sand_chapa_bigmac;
    private javax.swing.JLabel jLabel_sand_chapa_chicken;
    private javax.swing.JLabel jLabel_sand_chapa_fish;
    private javax.swing.JLabel jLabel_waiting_bigmac;
    private javax.swing.JLabel jLabel_waiting_chicken;
    private javax.swing.JLabel jLabel_waiting_fish;
    private static javax.swing.JTextField jTextField_sand_chapa_bigmac;
    private static javax.swing.JTextField jTextField_sand_chapa_chicken;
    private static javax.swing.JTextField jTextField_sand_chapa_fish;
    private static javax.swing.JTextField jTextField_waiting_bigmac;
    private static javax.swing.JTextField jTextField_waiting_chicken;
    private static javax.swing.JTextField jTextField_waiting_fish;
    private static javax.swing.JLabel label_bigmac1;
    private static javax.swing.JLabel label_bigmac10;
    private static javax.swing.JLabel label_bigmac2;
    private static javax.swing.JLabel label_bigmac3;
    private static javax.swing.JLabel label_bigmac4;
    private static javax.swing.JLabel label_bigmac5;
    private static javax.swing.JLabel label_bigmac6;
    private static javax.swing.JLabel label_bigmac7;
    private static javax.swing.JLabel label_bigmac8;
    private static javax.swing.JLabel label_bigmac9;
    private static javax.swing.JLabel label_chicken1;
    private static javax.swing.JLabel label_chicken10;
    private static javax.swing.JLabel label_chicken2;
    private static javax.swing.JLabel label_chicken3;
    private static javax.swing.JLabel label_chicken4;
    private static javax.swing.JLabel label_chicken5;
    private static javax.swing.JLabel label_chicken6;
    private static javax.swing.JLabel label_chicken7;
    private static javax.swing.JLabel label_chicken8;
    private static javax.swing.JLabel label_chicken9;
    private static javax.swing.JLabel label_fish1;
    private static javax.swing.JLabel label_fish10;
    private static javax.swing.JLabel label_fish2;
    private static javax.swing.JLabel label_fish3;
    private static javax.swing.JLabel label_fish4;
    private static javax.swing.JLabel label_fish5;
    private static javax.swing.JLabel label_fish6;
    private static javax.swing.JLabel label_fish7;
    private static javax.swing.JLabel label_fish8;
    private static javax.swing.JLabel label_fish9;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
}
