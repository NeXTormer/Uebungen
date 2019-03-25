package at.htlklu.network;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SkiResortClient extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel lblSkiResort;
	private JLabel lblSnowDepth;
	private JTextField textFieldSnow;
	private JLabel lblCm;
	private JLabel lblDate;
	private JTextField textFieldDate;
	private JLabel lblYyyymmdd;
	private JButton btnSendValue;
	private JLabel lblSkiResort_1;
	private JSeparator separator;
	private JButton btnRefresh;
	private JTable table;

	private PrintWriter out;
	private BufferedReader in;
	private Socket socket = null;
	private String line1;
	private String[] temp2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkiResortClient frame = new SkiResortClient();
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
	public SkiResortClient() {
		initComponents();
	}
	private void initComponents() {
		setTitle("SnowMonitor Client 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(115, 25, 164, 20);
		contentPane.add(comboBox);
		
		lblSkiResort = new JLabel("Ski Resort:");
		lblSkiResort.setBounds(10, 28, 68, 14);
		contentPane.add(lblSkiResort);
		
		lblSnowDepth = new JLabel("Snow Depth:");
		lblSnowDepth.setBounds(10, 64, 86, 14);
		contentPane.add(lblSnowDepth);
		
		textFieldSnow = new JTextField();
		textFieldSnow.setText("150");
		textFieldSnow.setBounds(115, 61, 42, 20);
		contentPane.add(textFieldSnow);
		textFieldSnow.setColumns(10);
		
		lblCm = new JLabel("cm");
		lblCm.setBounds(167, 64, 46, 14);
		contentPane.add(lblCm);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 98, 46, 14);
		contentPane.add(lblDate);
		
		textFieldDate = new JTextField();
		textFieldDate.setText("2019:02:12");
		textFieldDate.setBounds(115, 95, 86, 20);
		contentPane.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		lblYyyymmdd = new JLabel("YYYY:MM:DD");
		lblYyyymmdd.setBounds(213, 95, 86, 14);
		contentPane.add(lblYyyymmdd);
		
		btnSendValue = new JButton("Send Value");
		btnSendValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String depth = textFieldSnow.getText();
				String date = textFieldDate.getText();
				String resort = comboBox.getSelectedItem().toString();
				String temp3 = "ADD*"+resort+"*"+depth+"*"+date; 
				out.println(temp3);
				out.flush();
				System.out.println(temp3);
//				String line;
//				line = in.readLine();
//				String[] temp = line.split("\\*");
//				comboBox.setModel(new DefaultComboBoxModel(temp));
			}
		});
		btnSendValue.setBounds(311, 91, 109, 23);
		contentPane.add(btnSendValue);
		
		lblSkiResort_1 = new JLabel("Ski Resort Overview:");
		lblSkiResort_1.setBounds(10, 137, 130, 14);
		contentPane.add(lblSkiResort_1);
		
		separator = new JSeparator();
		separator.setBounds(10, 126, 410, 2);
		contentPane.add(separator);
		
		String col[] = {"resort","depth","date"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);                                        
		JTable table = new JTable(tableModel);
		table.setBounds(10, 162, 410, 92);
		contentPane.add(table);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    dm.removeRow(i);
				}
				
				out.println("GET");
				out.flush();
				try {
					outerloop:
					while((line1 = in.readLine())!=null)
					{
						if(line1.equals("..."))
						{
							break outerloop;
						}
						System.out.println(line1);
						temp2 = line1.split("\\*");
				
						Object[] objs = {temp2[0], temp2[1], temp2[2]};
						tableModel.addRow(objs);
						
						
//						table.setModel(new DefaultTableModel(
//								new Object[][] {
//									{temp[0], temp[1], temp[2]},
//								},
//								new String[] {
//										"name", "depth", "date"
//								}
//								));
//						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(331, 265, 89, 23);
		contentPane.add(btnRefresh);
		
		
	if (socket == null) {
			
			try {
				socket = new Socket("127.0.0.1", 6969);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "No valid port", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (UnknownHostException e1) {
				JOptionPane.showMessageDialog(this, "Server unknown", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "Connection error", "Error", JOptionPane.ERROR_MESSAGE);
			}	
		}
		
		try {
			out = new PrintWriter(socket.getOutputStream());
			in =  new  BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println("init");
			out.flush();
			String line;
			line = in.readLine();
			String[] temp = line.split("\\*");
			comboBox.setModel(new DefaultComboBoxModel(temp));
//		    for(int i = 0; i<temp.length; i++)
//		    {
//		    	textFieldInfo.append(temp[i]+"\n");
//		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
