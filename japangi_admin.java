package java_24day;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class japangi_admin {

	public static void main(String[] args) {
		cfadmin ad = new cfadmin();
	}
}
class cfadmin extends Frame implements ActionListener {
	String coffee[][] = new String[6][4];
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("���Ǳ�-������ȭ��");
	
	Label item1 = new Label("��ǰ1");
	Label item1na = new Label("�̸�:");
	Label item1su = new Label("����:");
	Label item1tx = new Label("����:");
	TextField item1natf = new TextField();
	TextField item1sutf = new TextField();
	TextField item1txtf = new TextField();
	
	Label item2 = new Label("��ǰ2");
	Label item2na = new Label("�̸�:");
	Label item2su = new Label("����:");
	Label item2tx = new Label("����:");
	TextField item2natf = new TextField();
	TextField item2sutf = new TextField();
	TextField item2txtf = new TextField();
	
	Label item3 = new Label("��ǰ3");
	Label item3na = new Label("�̸�:");
	Label item3su = new Label("����:");
	Label item3tx = new Label("����:");
	TextField item3natf = new TextField();
	TextField item3sutf = new TextField();
	TextField item3txtf = new TextField();
	
	Label item4 = new Label("��ǰ4");
	Label item4na = new Label("�̸�:");
	Label item4su = new Label("����:");
	Label item4tx = new Label("����:");
	TextField item4natf = new TextField();
	TextField item4sutf = new TextField();
	TextField item4txtf = new TextField();
	
	Label item5 = new Label("��ǰ5");
	Label item5na = new Label("�̸�:");
	Label item5su = new Label("����:");
	Label item5tx = new Label("����:");
	TextField item5natf = new TextField();
	TextField item5sutf = new TextField();
	TextField item5txtf = new TextField();
	
	Label item6 = new Label("��ǰ6");
	Label item6na = new Label("�̸�:");
	Label item6su = new Label("����:");
	Label item6tx = new Label("����:");
	TextField item6natf = new TextField();
	TextField item6sutf = new TextField();
	TextField item6txtf = new TextField();
	
	Button item1btn = new Button("����");
	Button item2btn = new Button("����");
	Button item3btn = new Button("����");
	Button item4btn = new Button("����");
	Button item5btn = new Button("����");
	Button item6btn = new Button("����");
	
	 cfadmin()
	{
		super("cfadmin");
		this.setSize(1000,600);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
		getData();//��񿡼� �����ؼ� ���� ����Ÿ �����ͼ� ���̱�
	}
	void init() {
		this.setLayout(null);
		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(350, 60, 300, 30);
		
		this.add(item1); item1.setFont(font30); 
		item1.setBounds(40, 130, 90, 30);
		this.add(item1na); item1na.setFont(font30); 
		item1na.setBounds(130, 130, 100, 30);
		this.add(item1su); item1su.setFont(font30); 
		item1su.setBounds(350, 130, 100, 30);
		this.add(item1tx); item1tx.setFont(font30); 
		item1tx.setBounds(560, 130, 100, 30);
		this.add(item1natf); item1natf.setFont(font30); 
		item1natf.setBounds(230, 130, 200, 30);
		this.add(item1sutf); item1sutf.setFont(font30); 
		item1sutf.setBounds(450, 130, 150, 30);
		this.add(item1txtf); item1txtf.setFont(font30); 
		item1txtf.setBounds(660, 130, 100, 30);
		this.add(item1btn); item1btn.setFont(font30); 
		item1btn.setBounds(800, 130, 100, 30);
		
		this.add(item2); item2.setFont(font30); 
		item2.setBounds(40, 200, 90, 30);
		this.add(item2na); item2na.setFont(font30); 
		item2na.setBounds(130, 200, 100, 30);
		this.add(item2su); item2su.setFont(font30); 
		item2su.setBounds(350, 200, 100, 30);
		this.add(item2tx); item2tx.setFont(font30); 
		item2tx.setBounds(560, 200, 100, 30);
		this.add(item2natf); item2natf.setFont(font30); 
		item2natf.setBounds(230, 200, 200, 30);
		this.add(item2sutf); item2sutf.setFont(font30); 
		item2sutf.setBounds(450, 200, 100, 30);
		this.add(item2txtf); item2txtf.setFont(font30); 
		item2txtf.setBounds(660, 200, 100, 30);
		this.add(item2btn); item2btn.setFont(font30); 
		item2btn.setBounds(800, 200, 100, 30);
		
		this.add(item3); item3.setFont(font30); 
		item3.setBounds(40, 270, 90, 30);
		this.add(item3na); item3na.setFont(font30); 
		item3na.setBounds(130, 270, 100, 30);
		this.add(item3su); item3su.setFont(font30); 
		item3su.setBounds(350, 270, 100, 30);
		this.add(item3tx); item3tx.setFont(font30); 
		item3tx.setBounds(560, 270, 100, 30);
		this.add(item3natf); item3natf.setFont(font30); 
		item3natf.setBounds(230, 270, 200, 30);
		this.add(item3sutf); item3sutf.setFont(font30); 
		item3sutf.setBounds(450, 270, 100, 30);
		this.add(item3txtf); item3txtf.setFont(font30); 
		item3txtf.setBounds(660, 270, 100, 30);
		this.add(item3btn); item3btn.setFont(font30); 
		item3btn.setBounds(800, 270, 100, 30);
		
		this.add(item4); item4.setFont(font30); 
		item4.setBounds(40, 340, 90, 30);
		this.add(item4na); item4na.setFont(font30); 
		item4na.setBounds(130, 340, 100, 30);
		this.add(item4su); item4su.setFont(font30); 
		item4su.setBounds(350, 340, 100, 30);
		this.add(item4tx); item4tx.setFont(font30); 
		item4tx.setBounds(560, 340, 100, 30);
		this.add(item4natf); item4natf.setFont(font30); 
		item4natf.setBounds(230, 340, 200, 30);
		this.add(item4sutf); item4sutf.setFont(font30); 
		item4sutf.setBounds(450, 340, 100, 30);
		this.add(item4txtf); item4txtf.setFont(font30); 
		item4txtf.setBounds(660, 340, 100, 30);
		this.add(item4btn); item4btn.setFont(font30); 
		item4btn.setBounds(800, 340, 100, 30);
		
		this.add(item5); item5.setFont(font30); 
		item5.setBounds(40, 410, 90, 30);
		this.add(item5na); item5na.setFont(font30); 
		item5na.setBounds(130, 410, 100, 30);
		this.add(item5su); item5su.setFont(font30); 
		item5su.setBounds(350, 410, 100, 30);
		this.add(item5tx); item5tx.setFont(font30); 
		item5tx.setBounds(560, 410, 100, 30);
		this.add(item5natf); item5natf.setFont(font30); 
		item5natf.setBounds(230, 410, 200, 30);
		this.add(item5sutf); item5sutf.setFont(font30); 
		item5sutf.setBounds(450, 410, 100, 30);
		this.add(item5txtf); item5txtf.setFont(font30); 
		item5txtf.setBounds(660, 410, 100, 30);
		this.add(item5btn); item5btn.setFont(font30); 
		item5btn.setBounds(800, 410, 100, 30);
		
		this.add(item6); item6.setFont(font30); 
		item6.setBounds(40, 480, 90, 30);
		this.add(item6na); item6na.setFont(font30); 
		item6na.setBounds(130, 480, 100, 30);
		this.add(item6su); item6su.setFont(font30); 
		item6su.setBounds(350, 480, 100, 30);
		this.add(item6tx); item6tx.setFont(font30); 
		item6tx.setBounds(560, 480, 100, 30);
		this.add(item6natf); item6natf.setFont(font30); 
		item6natf.setBounds(230, 480, 200, 30);
		this.add(item6sutf); item6sutf.setFont(font30); 
		item6sutf.setBounds(450, 480, 100, 30);
		this.add(item6txtf); item6txtf.setFont(font30); 
		item6txtf.setBounds(660, 480, 100, 30);
		this.add(item6btn); item6btn.setFont(font30); 
		item6btn.setBounds(800, 480, 100, 30);
		
		
	 }
	void start() {
		item1btn.addActionListener(this);
		item2btn.addActionListener(this);
		item3btn.addActionListener(this);
		item4btn.addActionListener(this);
		item5btn.addActionListener(this);
		item6btn.addActionListener(this);
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String item1na = item1natf.getText();
		String item2na = item2natf.getText();
		String item3na = item3natf.getText();
		String item4na = item4natf.getText();
		String item5na = item5natf.getText();
		String item6na = item6natf.getText();
		
		String item1su = item1sutf.getText();
		String item2su = item2sutf.getText();
		String item3su = item3sutf.getText();
		String item4su = item4sutf.getText();
		String item5su = item5sutf.getText();
		String item6su = item6sutf.getText();
		
		String item1tx = item1txtf.getText();
		String item2tx = item2txtf.getText();
		String item3tx = item3txtf.getText();
		String item4tx = item4txtf.getText();
		String item5tx = item5txtf.getText();
		String item6tx = item6txtf.getText();
		
		if(e.getSource() == item1btn) {
			if(spaceCheak(item1na, item1su, item1tx)) {
				return;
			}
			else {
				update(1,item1na, item1su, item1tx);
			}
		}
		else if(e.getSource() == item2btn) {
			if(spaceCheak(item2na, item2su, item2tx)) {
				return;
			}
			else {
				update(2,item2na, item2su, item2tx);
			}
		}
		else if(e.getSource() == item3btn) {
			if(spaceCheak(item3na, item3su, item3tx)) {
				return;
			}
			else {
				update(3,item3na, item3su, item3tx);
			}
		}
		else if(e.getSource() == item4btn) {
			if(spaceCheak(item4na, item4su, item4tx)) {
				return;
			}
			else {
				update(4,item4na, item4su, item4tx);
			}
		}
		else if(e.getSource() == item5btn) {
			if(spaceCheak(item5na, item5su, item5tx)) {
				return;
			}
			else {
				update(5,item5na, item5su, item5tx);
			}
		}
		else if(e.getSource() == item6btn) {
			if(spaceCheak(item6na, item6su, item6tx)) {
				return;
			}
			else {
				update(6,item6na, item6su, item6tx);
			}
		}
	}
	boolean update(int idx, String name, String cnt, String price)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/coffee?"
				+ "useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update coffeeadmin set �̸� = ?, ���� = ?, ���� = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, cnt);
			pstmt.setString(3, price);
			pstmt.setInt(4, idx);			
			pstmt.executeUpdate();
			pstmt.close();
			msg("���������Ϸ�!");
		} catch (SQLException ee) {
			System.err.println("�������� ����!!:"+ee.getMessage());
			return false;
		}
		return true;
	}
	boolean spaceCheak(String name, String cnt, String price) {
		if(name.equals("")) {msg("Ŀ�Ǹ��� �����ּ���."); return true;}
		if(cnt.equals("")) {msg("������ �����ּ���.");   return true;}
		if(price.equals("")) {msg("������ �����ּ���."); return true;}
		//������� �Դٴ°� ������ �ƴ϶� false
		return false;
	}
	void msg(String msg){
		final Dialog dlg = new Dialog(this, "�˸� �޼���â", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(500, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	void search(String name){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/coffee?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from coffeeadmin";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getString(4).equals(name))
				{

				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void getData(){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/coffee?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from coffeeadmin";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			int count=0;
			
			while (rs.next()) {
				coffee[count][0] = rs.getInt("idx")+"";
				coffee[count][1] = rs.getString("�̸�");
				coffee[count][2] = rs.getString("����");
				coffee[count][3] = rs.getString("����");				
				count++;
			}
			//ȭ�鿡 �Ѹ���...�밡��..					
					item1natf.setText(coffee[0][1]);
					item1sutf.setText(coffee[0][2]);
					item1txtf.setText(coffee[0][3]);
					
					item2natf.setText(coffee[1][1]);
					item2sutf.setText(coffee[1][2]);
					item2txtf.setText(coffee[1][3]);
					
					item3natf.setText(coffee[2][1]);
					item3sutf.setText(coffee[2][2]);
					item3txtf.setText(coffee[2][3]);
					
					item4natf.setText(coffee[3][1]);
					item4sutf.setText(coffee[3][2]);
					item4txtf.setText(coffee[3][3]);
					
					item5natf.setText(coffee[4][1]);
					item5sutf.setText(coffee[4][2]);
					item5txtf.setText(coffee[4][3]);
					
					item6natf.setText(coffee[5][1]);
					item6sutf.setText(coffee[5][2]);
					item6txtf.setText(coffee[5][3]);
			
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
}