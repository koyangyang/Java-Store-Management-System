package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import people.AdminService;
import people.Bianhao;
import people.Costumer;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text_statute;
	private JTextField text_user;
	private JTextField text_pwd;
	private JTextField text_id;
	private JTextField text_id2;
	private JTextField text_num;
	private JTextField text_num2;
	private JTextField text_price;
	private JTextField text_name;
	private JTextField text_bianhao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
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
	public MainJFrame() {
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("商城.png"));
		setTitle("购物管理系统");
		AdminService ad=new AdminService();
		Costumer co=new Costumer();
		Bianhao bh=new Bianhao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 450);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem1 = new JMenuItem("Adminer");
		menuBar.add(mntmNewMenuItem1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Costumer");
		menuBar.add(mntmNewMenuItem2);
		//
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Adminer界面
		JPanel Pane1 = new JPanel();
		Pane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		Pane1.setLayout(new GridLayout(2, 1));
		JPanel Pane1_1 = new JPanel();
		JPanel Pane1_2 = new JPanel();
		Pane1.add(Pane1_1);
		Pane1.add(Pane1_2);
		Pane1_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pane1_1_1 = new JPanel();
		Pane1_1.add(pane1_1_1);
		pane1_1_1.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u767B\u9646\u72B6\u6001");
		pane1_1_1.add(lblNewLabel);
		
		text_statute = new JTextField();
		text_statute.setText("\u672A\u767B\u5F55");
		pane1_1_1.add(text_statute);
		text_statute.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		pane1_1_1.add(lblNewLabel_1);
		
		text_user = new JTextField();
		pane1_1_1.add(text_user);
		text_user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		pane1_1_1.add(lblNewLabel_2);
		
		text_pwd = new JTextField();
		pane1_1_1.add(text_pwd);
		text_pwd.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8D27\u7269id");
		pane1_1_1.add(lblNewLabel_3);
		
		text_id = new JTextField();
		pane1_1_1.add(text_id);
		text_id.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8D27\u7269\u6570\u91CF");
		pane1_1_1.add(lblNewLabel_4);
		
		text_num = new JTextField();
		pane1_1_1.add(text_num);
		text_num.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u8D27\u7269\u4EF7\u683C");
		pane1_1_1.add(lblNewLabel_5);
		
		text_price = new JTextField();
		pane1_1_1.add(text_price);
		text_price.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8D27\u7269\u540D\u5B57");
		pane1_1_1.add(lblNewLabel_6);
		
		text_name = new JTextField();
		pane1_1_1.add(text_name);
		text_name.setColumns(10);
		
		JPanel pane1_1_2 = new JPanel();
		Pane1_1.add(pane1_1_2);
		pane1_1_2.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton bt_login = new JButton("\u767B\u5F55\u8D26\u53F7");
		pane1_1_2.add(bt_login);
		
		JButton bt_select = new JButton("\u67E5\u770B\u4ED3\u5E93");
		pane1_1_2.add(bt_select);
		
		JButton bt_insert = new JButton("\u6DFB\u52A0\u5546\u54C1");
		pane1_1_2.add(bt_insert);
		
		JButton bt_update = new JButton("\u66F4\u65B0\u8D27\u7269");
		pane1_1_2.add(bt_update);
		Pane1_2.setLayout(new GridLayout(1, 4, 0, 0));
		
		JTextArea textArea = new JTextArea();
		Pane1_2.add(textArea);
		bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="";
				try {
					str=ad.login(text_user.getText(),text_pwd.getText());
					text_statute.setText(str);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt_insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				String tag=text_statute.getText();
				if(tag.equals("未登录")) {
					textArea.setText("你不是管理员");
				}else {
				String id=text_id.getText();
				String name=text_name.getText();
				double price=Double.parseDouble(text_price.getText());
				int num=Integer.parseInt(text_num.getText());
				try {
					String str=ad.insert_good(id, name, price, num);
					textArea.setText(str);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}			
			}
		});
		bt_select.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tag=text_statute.getText();
				if(tag.equals("未登录")) {
					textArea.setText("你不是管理员");
				}else {
					String str=ad.show();
					textArea.setText(str);
				}
			}
		});
		bt_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tag=text_statute.getText();
				if(tag.equals("未登录")) {
					textArea.setText("你不是管理员");
				}else {
					String id=text_id.getText();
					String name=text_name.getText();
					double price=Double.parseDouble(text_price.getText());
					int num=Integer.parseInt(text_num.getText());
					try {
						String str=ad.update_good(id, name, price, num);
						textArea.setText(str);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Costumer界面
		JPanel Pane2 = new JPanel();
		Pane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		Pane2.setLayout(new GridLayout(2, 1));
		JPanel Pane2_1 = new JPanel();
		JPanel Pane2_2 = new JPanel();
		Pane2.add(Pane2_1);
		Pane2.add(Pane2_2);
		Pane2_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pane2_1_1 = new JPanel();
		Pane2_1.add(pane2_1_1);
		pane2_1_1.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel2 = new JLabel("\u767B\u9646\u72B6\u6001");
		pane2_1_1.add(lblNewLabel2);
		
		JLabel lblNewLabel_7 = new JLabel("\u987E\u5BA2");
		pane2_1_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u8BA2\u5355\u7F16\u53F7");
		pane2_1_1.add(lblNewLabel_8);
		
		text_bianhao = new JTextField();
		pane2_1_1.add(text_bianhao);
		text_bianhao.setColumns(10);
		
		JLabel lblNewLabel2_3 = new JLabel("\u8D27\u7269id");
		pane2_1_1.add(lblNewLabel2_3);
		
		text_id2 = new JTextField();
		pane2_1_1.add(text_id2);
		text_id2.setColumns(10);
		
		JLabel lblNewLabel2_4 = new JLabel("\u8D27\u7269\u6570\u91CF");
		pane2_1_1.add(lblNewLabel2_4);
		
		text_num2 = new JTextField();
		pane2_1_1.add(text_num2);
		text_num2.setColumns(10);
		
		JPanel pane2_1_2 = new JPanel();
		Pane2_1.add(pane2_1_2);
		pane2_1_2.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btn_dindan = new JButton("\u8BA2\u5355\u67E5\u8BE2");
		pane2_1_2.add(btn_dindan);
		
		JButton bt_select2 = new JButton("\u67E5\u770B\u5546\u54C1");
		pane2_1_2.add(bt_select2);
		
		JButton bt_bug = new JButton("\u8D2D\u4E70\u5546\u54C1");
		pane2_1_2.add(bt_bug);
		
		JButton bt_update2 = new JButton("\u9000\u8D27");
		pane2_1_2.add(bt_update2);
		Pane2_2.setLayout(new GridLayout(1, 4, 0, 0));
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBackground(Color.WHITE);
		Pane2_2.add(textArea2);
		
		bt_select2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=ad.show();
				textArea2.setText(str);
			}
		});
		
		bt_bug.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int bianhao=0;
				String fstr="";
				try {
					bianhao=bh.chilckbh();
					text_bianhao.setText(""+bianhao);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String str=co.bug()+"\n";
				String str1=str;
				try {
					fstr=str+bh.insetbh(bianhao,str1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea2.setText(fstr);
			}
		});
		
		bt_update2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str="";
				try {
					str=co.update_good(text_id2.getText(), Integer.parseInt(text_num2.getText()));
					textArea2.setText(str);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_dindan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					textArea2.setText(co.bianhao(Integer.parseInt(text_bianhao.getText())));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//页面布局切换Admin和Costmer
		getContentPane().add(Pane1);
		getContentPane().add(Pane2);
		mntmNewMenuItem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
		        contentPane.add(Pane2);
		        contentPane.validate();
		        contentPane.repaint();
			}
		});
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
		        contentPane.add(Pane1);
		        contentPane.validate();
		        contentPane.repaint();
			}
		});
		
	}

}
