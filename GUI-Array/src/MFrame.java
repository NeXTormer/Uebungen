/**
 * Created by Iris on 14-Sep-16.
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class MFrame extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblFieldSize;
    private JLabel lblBits;
    private JLabel lblDirection;
    private JLabel lblOffset;
    private JTextField tF_FieldSize;
    private JTextField tF_Bits;
    private JTextField tF_Offset;
    private JRadioButton rdbtnRight;
    private JRadioButton rdbtnLeft;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JLabel lblRandomizedField;
    private JLabel lblShiftedField;
    private JLabel lblRotatedField;
    private JLabel lblSortedField;
    private JTextField tF_RandField;
    private JTextField tF_ShiftedField;
    private JTextField tF_RotatedField;
    private JTextField tF_SortedField;
    private JButton btnRandomize;
    private JButton btnShift;
    private JButton btnRotate;
    private JButton btnSort;
    private JSeparator separator;

    private int[] randomized;

    private Random r;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MFrame frame = new MFrame();
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
    public MFrame() {
        initComponents();
        r = new Random();
    }
    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 414, 289);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(10, 11, 378, 234);
        contentPane.add(panel);
        panel.setLayout(null);

        lblFieldSize = new JLabel("Field Size");
        lblFieldSize.setBounds(10, 11, 63, 14);
        panel.add(lblFieldSize);

        lblBits = new JLabel("Bits");
        lblBits.setBounds(10, 36, 46, 14);
        panel.add(lblBits);

        lblDirection = new JLabel("Direction");
        lblDirection.setBounds(192, 11, 57, 14);
        panel.add(lblDirection);

        lblOffset = new JLabel("Offset");
        lblOffset.setBounds(192, 36, 46, 14);
        panel.add(lblOffset);

        tF_FieldSize = new JTextField();
        tF_FieldSize.setText("8");
        tF_FieldSize.setBounds(123, 8, 46, 20);
        panel.add(tF_FieldSize);
        tF_FieldSize.setColumns(10);

        tF_Bits = new JTextField();
        tF_Bits.setText("4");
        tF_Bits.setBounds(123, 33, 46, 20);
        panel.add(tF_Bits);
        tF_Bits.setColumns(10);

        tF_Offset = new JTextField();
        tF_Offset.setText("2");
        tF_Offset.setBounds(248, 33, 46, 20);
        panel.add(tF_Offset);
        tF_Offset.setColumns(10);

        rdbtnRight = new JRadioButton("Right");
        buttonGroup.add(rdbtnRight);
        rdbtnRight.setBounds(300, 7, 70, 23);
        panel.add(rdbtnRight);

        rdbtnLeft = new JRadioButton("Left");
        rdbtnLeft.setSelected(true);
        buttonGroup.add(rdbtnLeft);
        rdbtnLeft.setBounds(248, 7, 50, 23);
        panel.add(rdbtnLeft);

        lblRandomizedField = new JLabel("Randomized Field");
        lblRandomizedField.setBounds(10, 103, 83, 14);
        panel.add(lblRandomizedField);

        lblShiftedField = new JLabel("Shifted Field");
        lblShiftedField.setBounds(10, 128, 83, 14);
        panel.add(lblShiftedField);

        lblRotatedField = new JLabel("Rotated Field");
        lblRotatedField.setBounds(10, 153, 83, 14);
        panel.add(lblRotatedField);

        lblSortedField = new JLabel("Sorted Field");
        lblSortedField.setBounds(10, 178, 83, 14);
        panel.add(lblSortedField);

        tF_RandField = new JTextField();
        tF_RandField.setEditable(false);
        tF_RandField.setBounds(123, 100, 247, 20);
        panel.add(tF_RandField);
        tF_RandField.setColumns(10);

        tF_ShiftedField = new JTextField();
        tF_ShiftedField.setEditable(false);
        tF_ShiftedField.setColumns(10);
        tF_ShiftedField.setBounds(123, 125, 247, 20);
        panel.add(tF_ShiftedField);

        tF_RotatedField = new JTextField();
        tF_RotatedField.setEditable(false);
        tF_RotatedField.setColumns(10);
        tF_RotatedField.setBounds(123, 150, 247, 20);
        panel.add(tF_RotatedField);

        tF_SortedField = new JTextField();
        tF_SortedField.setEditable(false);
        tF_SortedField.setColumns(10);
        tF_SortedField.setBounds(123, 175, 247, 20);
        panel.add(tF_SortedField);

        btnRandomize = new JButton("Randomize");
        btnRandomize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnRandomizeActionPerformed(arg0);
            }
        });
        btnRandomize.setBounds(10, 203, 85, 23);
        panel.add(btnRandomize);

        btnShift = new JButton("Shift");
        btnShift.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnShiftActionPerformed(e);
            }
        });
        btnShift.setBounds(103, 203, 85, 23);
        panel.add(btnShift);

        btnRotate = new JButton("Rotate");
        btnRotate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnRotateActionPerformed(e);
            }
        });
        btnRotate.setBounds(195, 203, 85, 23);
        panel.add(btnRotate);

        btnSort = new JButton("Sort");
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSortActionPerformed(e);
            }
        });
        btnSort.setBounds(285, 203, 85, 23);
        panel.add(btnSort);

        separator = new JSeparator();
        separator.setBounds(10, 74, 360, 2);
        panel.add(separator);
    }

    private int getValue(JTextField tf) {
        return Integer.valueOf(tf.getText());
    }




    protected void btnShiftActionPerformed(ActionEvent e) {
        boolean right = rdbtnRight.isSelected() ? true : false;

        int offset = getValue(tF_Offset);
        int[] copy = new int[randomized.length];

        for(int i = 0; i < randomized.length; i++) {
            if(i + offset >= randomized.length) continue;
            copy[i + offset] = randomized[i];
        }

        tF_ShiftedField.setText(Arrays.toString(copy));


    }
    protected void btnRotateActionPerformed(ActionEvent e) {
    }
    protected void btnSortActionPerformed(ActionEvent e) {
    }

    protected void btnRandomizeActionPerformed(ActionEvent e) {
        int length = getValue(tF_FieldSize);
        randomized = new int[length];
        int bits = getValue(tF_Bits);
        for(int i = 0; i < length; i++) {
            randomized[i] = (int) Math.pow(2, r.nextInt(bits + 1));
        }

        tF_RandField.setText(Arrays.toString(randomized));
    }
}