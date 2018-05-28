package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField tf_ip;
	private JTextField tf_port;
	private JTextField tf_room;
	private JTextField tf_temp;
	private JTextField tf_lux;
	
    public static final int PORT = 8888;

    private Socket m_Socket;
    
    private PrintWriter printWriter;
    private BufferedReader reader;
    
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(10, 11, 46, 14);
		contentPane.add(lblServerIp);
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setBounds(10, 36, 66, 14);
		contentPane.add(lblServerPort);
		
		tf_ip = new JTextField();
		tf_ip.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_ip.setText("localhost");
		tf_ip.setBounds(99, 8, 152, 20);
		contentPane.add(tf_ip);
		tf_ip.setColumns(10);
		
		tf_port = new JTextField();
		tf_port.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_port.setText("8888");
		tf_port.setBounds(99, 33, 152, 20);
		contentPane.add(tf_port);
		tf_port.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 241, 2);
		contentPane.add(separator);
		
		JLabel lblRaum = new JLabel("Raum");
		lblRaum.setBounds(10, 74, 46, 14);
		contentPane.add(lblRaum);
		
		tf_room = new JTextField();
		tf_room.setText("Bad");
		tf_room.setBounds(99, 71, 152, 20);
		contentPane.add(tf_room);
		tf_room.setColumns(10);
		
		JLabel lblTemperatur = new JLabel("Temperatur");
		lblTemperatur.setBounds(10, 99, 66, 14);
		contentPane.add(lblTemperatur);
		
		JLabel lblNewLabel = new JLabel("Belaeuchtungsstaerke");
		lblNewLabel.setBounds(10, 127, 129, 14);
		contentPane.add(lblNewLabel);
		
		tf_temp = new JTextField();
		tf_temp.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_temp.setText("42");
		tf_temp.setBounds(132, 96, 86, 20);
		contentPane.add(tf_temp);
		tf_temp.setColumns(10);
		
		tf_lux = new JTextField();
		tf_lux.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_lux.setText("420");
		tf_lux.setBounds(132, 124, 86, 20);
		contentPane.add(tf_lux);
		tf_lux.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u00B0C");
		lblNewLabel_1.setBounds(228, 99, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLux = new JLabel("Lux");
		lblLux.setBounds(228, 127, 46, 14);
		contentPane.add(lblLux);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 155, 241, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
                printWriter.println("ADD " + tf_room.getText() + " " + tf_lux.getText() + " LUX " + time);
                printWriter.flush();
                
				
				
			}
		});
		btnNewButton.setBounds(10, 165, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					m_Socket = new Socket(tf_ip.getText(), Integer.valueOf(tf_port.getText()));

		            InputStream in = m_Socket.getInputStream();
		            OutputStream out = m_Socket.getOutputStream();

		            printWriter = new PrintWriter(out);
		            reader = new BufferedReader(new InputStreamReader(in));	
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}

			}	
		});
		btnConnect.setBounds(161, 165, 89, 23);
		contentPane.add(btnConnect);
	}
}
