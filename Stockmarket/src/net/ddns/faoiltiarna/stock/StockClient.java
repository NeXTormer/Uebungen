package net.ddns.faoiltiarna.stock;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class StockClient extends JFrame {

	private JPanel contentPane;
	
	private Socket socket;
	private JTextField tfHostname;
	private JTextField tfPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockClient frame = new StockClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StockClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnActions = new JMenu("Actions");
		menuBar.add(mnActions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelMarket = new JPanel();
		tabbedPane.addTab("Market", null, panelMarket, null);
		
		JPanel panelSettings = new JPanel();
		tabbedPane.addTab("Settings", null, panelSettings, null);
		SpringLayout sl_panelSettings = new SpringLayout();
		panelSettings.setLayout(sl_panelSettings);
		
		JLabel lblNewLabel = new JLabel("Hostname");
		lblNewLabel.setFont(new Font("TahoHostnamema", Font.PLAIN, 16));
		sl_panelSettings.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panelSettings);
		sl_panelSettings.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panelSettings);
		panelSettings.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port");
		sl_panelSettings.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 26, SpringLayout.SOUTH, lblNewLabel);
		sl_panelSettings.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSettings.add(lblNewLabel_1);
		
		tfHostname = new JTextField();
		tfHostname.setText("localhost");
		sl_panelSettings.putConstraint(SpringLayout.NORTH, tfHostname, 2, SpringLayout.NORTH, lblNewLabel);
		sl_panelSettings.putConstraint(SpringLayout.WEST, tfHostname, 119, SpringLayout.EAST, lblNewLabel);
		sl_panelSettings.putConstraint(SpringLayout.EAST, tfHostname, -10, SpringLayout.EAST, panelSettings);
		panelSettings.add(tfHostname);
		tfHostname.setColumns(10);
		
		tfPort = new JTextField();
		sl_panelSettings.putConstraint(SpringLayout.NORTH, tfPort, 24, SpringLayout.SOUTH, tfHostname);
		sl_panelSettings.putConstraint(SpringLayout.WEST, tfPort, 0, SpringLayout.WEST, tfHostname);
		sl_panelSettings.putConstraint(SpringLayout.EAST, tfPort, 0, SpringLayout.EAST, tfHostname);
		panelSettings.add(tfPort);
		tfPort.setColumns(10);
		tfPort.setText(StockConstants.PORT + "");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblConnection = new JLabel("Connection: ");
		panel.add(lblConnection);
		
		JLabel lblConnectionState = new JLabel("Not connected");
		panel.add(lblConnectionState);
		
		JMenuItem mntmConnect = new JMenuItem("Connect");
		mntmConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					socket = new Socket(tfHostname.getText(), Integer.valueOf(tfPort.getText()));
					lblConnectionState.setText("Connected");
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			
			}
		});
		mnFile.add(mntmConnect);
		
	}
}
