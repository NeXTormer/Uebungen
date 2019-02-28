import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SkiClient extends JFrame {

	private JPanel contentPane;
	private JTextField tf_height;
	private JTextField tf_date;
	private JTable table;
	private JComboBox box_resorts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkiClient frame = new SkiClient();
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
	public SkiClient() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSkiresort = new JLabel("Ski-Resort:");
		lblSkiresort.setBounds(10, 11, 77, 14);
		panel.add(lblSkiresort);
		
		JLabel lblNewLabel = new JLabel("Snow Depth:");
		lblNewLabel.setBounds(10, 48, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 86, 46, 14);
		panel.add(lblDate);

		try {
            Socket s = new Socket("localhost", 5555);

            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            PrintWriter printWriter = new PrintWriter(out);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            printWriter.println("INIT");
    		String[] resortitems = reader.readLine().split("\n");
    		
    		box_resorts = new JComboBox(resortitems);
    		box_resorts.setBounds(123, 8, 291, 20);
    		panel.add(box_resorts);
    			
		} catch (IOException ex) {
            ex.printStackTrace();
        }

		tf_height = new JTextField();
		tf_height.setBounds(123, 45, 46, 20);
		panel.add(tf_height);
		tf_height.setColumns(10);
		
		JLabel lblCm = new JLabel("cm");
		lblCm.setBounds(179, 48, 46, 14);
		panel.add(lblCm);
		
		tf_date = new JTextField();
		tf_date.setBounds(123, 83, 86, 20);
		panel.add(tf_date);
		tf_date.setColumns(10);
		
		JLabel lblYyyymmdd = new JLabel("YYYY:MM:DD");
		lblYyyymmdd.setBounds(219, 86, 69, 14);
		panel.add(lblYyyymmdd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
		            Socket s = new Socket("localhost", 5555);

		            InputStream in = s.getInputStream();
		            OutputStream out = s.getOutputStream();

		            PrintWriter printWriter = new PrintWriter(out);
		            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		            printWriter.println("ADD*" + box_resorts.getSelectedItem() + "*" + tf_height.getText() + "*" + tf_date.getText());
		            System.out.println(reader.readLine());
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnSubmit.setBounds(325, 82, 89, 23);
		panel.add(btnSubmit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 127, 404, 14);
		panel.add(separator);

		
		table = new JTable();
		table.setBounds(10, 159, 404, 155);
		panel.add(table);
		
		JLabel lblSkiresortOverview = new JLabel("Ski-Resort Overview");
		lblSkiresortOverview.setBounds(10, 137, 123, 14);
		panel.add(lblSkiresortOverview);
	}
}
