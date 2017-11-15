import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import at.htlklu.schnittstellen.CharacterEvent;
import at.htlklu.schnittstellen.CharacterListener;
import at.htlklu.schnittstellen.SerielleSchnittstelle;
import at.htlklu.schnittstellen.StringListener;
import at.htlklu.schnittstellen.StringEvent;
import java.awt.Font;

public class Frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5210981605498319290L;

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=26,359
	 */
	private final SerielleSchnittstelle serielleSchnittstelle = new SerielleSchnittstelle();
	private Timer timer;
	
	private JComboBox comboBox_unit;
	private JTextField textField_pollingrate;
	private JProgressBar progressBar;
	private JLabel lblVoltage;
	
	private int receivedData = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		timer = new Timer(1000, this);
		timer.start();
		
		serielleSchnittstelle.setPortName("COM3");
		
		serielleSchnittstelle.addStringListener(new StringListener() {
			public void stringReceived(StringEvent arg0) {
				receivedString(arg0.getStringReceived());
			}
		});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 299);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPeter = new JMenu("File");
		menuBar.add(mnPeter);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				serielleSchnittstelle.disconnect();
				System.exit(0);
			}
		});
		mnPeter.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
		);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(1023);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		textField_pollingrate = new JTextField();
		textField_pollingrate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				updatePollingRate();
			}
		});
		textField_pollingrate.setText("1");
		textField_pollingrate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Polling interval");
		
		comboBox_unit = new JComboBox();
		comboBox_unit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePollingRate();
			}
		});
		
		comboBox_unit.setModel(new DefaultComboBoxModel(new String[] {"s", "ms", "us"}));
		comboBox_unit.setSelectedIndex(1);
		
		lblVoltage = new JLabel("     0 V");
		lblVoltage.setFont(new Font("Tahoma", Font.PLAIN, 27));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblVoltage, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_pollingrate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_unit, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblVoltage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(textField_pollingrate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_unit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		updatePollingRate();
	}
	
	private void updatePollingRate()
	{
		String unit = comboBox_unit.getSelectedItem().toString();
		String valueText = textField_pollingrate.getText();
		if(valueText == "") valueText = "1";
		
		float value = Float.parseFloat(valueText);
		float multiplier = 0;
		
		switch(unit)
		{
		case "s":
			multiplier = 1000;
			break;
		case "ms":
			multiplier = 1;
			break;
		case "us":
			multiplier = .001f;
			break;
		}
		
		int delay = (int) (value * multiplier);
		timer.setDelay(delay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		serielleSchnittstelle.sendString("R");
	}
	
	private void receivedString(String in)
	{
		if(in == null) return;
		receivedData = Integer.parseInt(in);
		
		progressBar.setValue(receivedData);
	
		float voltage = receivedData * (5.0f / 1023.0f);
		
		if(voltage < 1.0f)
		{
			float mv = voltage * 1000;
			System.err.println(mv);
			lblVoltage.setText(String.format("%.1f", mv) + " mV");
		}
		else
		{
			lblVoltage.setText(String.format("%.3f", voltage) + " V");
		}
		
	}
}
