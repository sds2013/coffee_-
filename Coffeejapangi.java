package java_24day;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coffeejapangi {
	public static void main(String[] args) {
		coffee c = new coffee();
	}
}
class coffee extends Frame implements ActionListener{
	private Image img;
	private Image img2;
	private Image img3;
	private Image img4; 
	private Image img5;
	private Image img6;
	private Image imgsel;
	
	String coffee[][] = new String[6][4];
	
	int btnmkcfcount = 0;
	int btnmkcfcount2 = 100;
	int btnamcfcount = 0;
	int btnamcfcount2 = 100;
	int btncfcount = 0;
	int btncfcount2 = 100;
	int btnorsmcount = 0;
	int btnorsmcount2 = 100;
	int btnicetcount = 0;
	int btnicetcount2 = 100;
	int btnibalcount = 0;
	int btnibalcount2 = 100;
	
	int tot = 0;
//	int tot2 = 0;
	int tot3 = 0;
	
	int mkcf = 0;
	int amcf = 0;
	int cf = 0;
	int orsm = 0;
	int ibal = 0;
	int icet = 0;
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font30 = new Font("SansSerif", Font.BOLD, 30);
	
	Label lbTitle = new Label("자판기");
	
	Label mkcf1 = new Label("수량");
	Label mkcf2 = new Label("100개");
	Button btnmkcf = new Button("모카커피");
	Label mkcf3 = new Label("2500원");
	
	Label amcf1 = new Label("수량");
	Label amcf2= new Label("100개");
	Button btnamcf = new Button("아메리카노");
	Label amcf3 = new Label("2000원");
	
	Label cf1 = new Label("수량");
	Label cf2= new Label("100개");
	Button btncf = new Button("카푸치노");
	Label cf3 = new Label("4000원");
	
	Label orsm1 = new Label("수량");
	Label orsm2= new Label("100개");
	Button btnorsm = new Button("오랜지스무디");
	Label orsm3 = new Label("4500원");
	
	Label icet1 = new Label("수량");
	Label icet2 = new Label("100개");
	Button btnicet = new Button("아이스티");
	Label icet3 = new Label("2000원");
	
	Label ibal1 = new Label("수량");
	Label ibal2 = new Label("100개");
	Button btnibal  = new Button("바닐라라떼");
	Label ibal3 = new Label("3000원");
	
	Label ch1 = new Label("선택상품");
	Label ch2 = new Label("");
	Label ch3 = new Label("수량");
	Label ch4 = new Label("0개");
	Label ch5 = new Label("0원");
	
	Label inmoney = new Label("투입금액");
	
	Label nowmy = new Label("현재금액:");
	Label nowmy2 = new Label(tot +"원",Label.RIGHT);
	Label paymy = new Label("결재금액:");
	Label paymy2 = new Label(tot3 + "원",Label.RIGHT);
	
	Button btn1000 = new Button("1000원");
	Button btn5000 = new Button("5000원");
	Button btn10000 = new Button("10000원");
	Button btnpay = new Button("결제하기");
	
	
	coffee()
	{
		super("Coffee");
		this.setSize(800,700);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
		this.getData();
//		this.reset();
	}
	void start() {
		btnmkcf.addActionListener(this);
		btnamcf.addActionListener(this);
		btncf.addActionListener(this);
		btnorsm.addActionListener(this);
		btnicet.addActionListener(this);
		btnibal.addActionListener(this);
		btn1000.addActionListener(this);
		btn5000.addActionListener(this);
		btn10000.addActionListener(this);
		btnpay.addActionListener(this);
		
		this.setLocation(xpos, ypos);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void init() {
		this.setLayout(null);
		
		this.add(lbTitle); lbTitle.setFont(font30); 
		lbTitle.setBounds(300, 60, 100, 30);
		
		this.add(mkcf1); mkcf1.setFont(font20); 
		mkcf1.setBounds(40, 200, 50, 30);
		
		this.add(mkcf2); mkcf2.setFont(font20); 
		mkcf2.setBounds(90, 200, 100, 30);
		
		this.add(btnmkcf); btnmkcf.setFont(font20); 
		btnmkcf.setBounds(40, 230, 100, 30);
		
		this.add(mkcf3); mkcf3.setFont(font20); 
		mkcf3.setBounds(40, 260, 100, 30);
		
		this.add(amcf1); amcf1.setFont(font20); 
		amcf1.setBounds(190, 200, 40, 30);
		
		this.add(amcf2); amcf2.setFont(font20); 
		amcf2.setBounds(250, 200, 60, 30);
		
		this.add(btnamcf); btnamcf.setFont(font20); 
		btnamcf.setBounds(190, 230, 130, 30);
		
		this.add(amcf3); amcf3.setFont(font20); 
		amcf3.setBounds(190, 260, 100, 30);
		
		this.add(cf1); cf1.setFont(font20); 
		cf1.setBounds(340, 200, 50, 30);
		
		this.add(cf2); cf2.setFont(font20); 
		cf2.setBounds(400, 200, 60, 30);
		
		this.add(btncf); btncf.setFont(font20); 
		btncf.setBounds(340, 230, 100, 30);
		
		this.add(cf3); cf3.setFont(font20); 
		cf3.setBounds(340, 260, 100, 30);
		
		this.add(orsm1); orsm1.setFont(font20); 
		orsm1.setBounds(40, 400, 50, 30);
		
		this.add(orsm2); orsm2.setFont(font20); 
		orsm2.setBounds(100, 400, 60, 30);
		
		this.add(btnorsm); btnorsm.setFont(font20); 
		btnorsm.setBounds(40, 430, 130, 30);
		
		this.add(orsm3); orsm3.setFont(font20); 
		orsm3.setBounds(40, 460, 100, 30);
		
		this.add(icet1); icet1.setFont(font20); 
		icet1.setBounds(190, 400, 50, 30);
		
		this.add(icet2); icet2.setFont(font20); 
		icet2.setBounds(250, 400, 60, 30);
		
		this.add(btnicet); btnicet.setFont(font20); 
		btnicet.setBounds(190, 430, 100, 30);
		
		this.add(icet3); icet3.setFont(font20); 
		icet3.setBounds(190, 460, 100, 30);
		
		this.add(ibal1); ibal1.setFont(font20); 
		ibal1.setBounds(340, 400, 50, 30);
		
		this.add(ibal2); ibal2.setFont(font20); 
		ibal2.setBounds(400, 400, 60, 30);
		
		this.add(btnibal); btnibal.setFont(font20); 
		btnibal.setBounds(340, 430, 120, 30);
		
		this.add(ibal3); ibal3.setFont(font20); 
		ibal3.setBounds(340, 460, 100, 30);
		
		this.add(ch1); ch1.setFont(font30); 
		ch1.setBounds(550, 150, 130, 30);
		
		this.add(ch2); ch2.setFont(font20); 
		ch2.setBounds(550, 350, 200, 30);
		
		this.add(ch3); ch3.setFont(font20); 
		ch3.setBounds(550, 380, 100, 30);
		
		this.add(ch4); ch4.setFont(font20); 
		ch4.setBounds(650, 380, 50, 30);
		
		this.add(ch5); ch5.setFont(font20); 
		ch5.setBounds(550, 410, 100, 30);
		
		this.add(inmoney); inmoney.setFont(font20); 
		inmoney.setBounds(20, 500, 100, 30);
		
		this.add(btn1000); btn1000.setFont(font20); 
		btn1000.setBounds(20, 530, 120, 30);
		
		this.add(btn5000); btn5000.setFont(font20); 
		btn5000.setBounds(150, 530, 120, 30);
		
		this.add(btn10000); btn10000.setFont(font20); 
		btn10000.setBounds(280, 530, 120, 30);
		
		this.add(btnpay); btnpay.setFont(font20); 
		btnpay.setBounds(410, 530, 120, 30);
		
		this.add(nowmy); nowmy.setFont(font30); 
		nowmy.setBounds(40, 600, 150, 30);
		
		this.add(nowmy2); nowmy2.setFont(font30); 
		nowmy2.setBounds(250, 600, 150, 30);
		
		this.add(paymy); paymy.setFont(font30); 
		paymy.setBounds(400, 600, 140, 30);
		
		this.add(paymy2); paymy2.setFont(font30); 
		paymy2.setBounds(630, 600, 120, 30);
		
		img =  Toolkit.getDefaultToolkit().getImage("mkcoffee.jpg");
		img2 =  Toolkit.getDefaultToolkit().getImage("amcf.jpg");
		img3 =  Toolkit.getDefaultToolkit().getImage("cf.jpg");
		img4 =  Toolkit.getDefaultToolkit().getImage("orsm.jpg");
		img5 =  Toolkit.getDefaultToolkit().getImage("icet.jpg");
		img6 =  Toolkit.getDefaultToolkit().getImage("ibal.jpg");
		imgsel = Toolkit.getDefaultToolkit().getImage("coffee.jpg");
		
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
		if(e.getSource() == btnmkcf) {
			btnmkcfcount++;
			btnmkcfcount2--;
			mkcf = mkcf + 2500;
			tot3+= 2500;
			mkcf2.setText(btnmkcfcount2 + "개");
			ch2.setText("모카커피");
			ch4.setText(btnmkcfcount + "개");
			ch5.setText(mkcf + "원");
			paymy2.setText(mkcf + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("mkcoffee.jpg");
			this.repaint();
			
		}
		else if(e.getSource() == btnamcf) {
			btnamcfcount++;
			btnamcfcount2--;
			amcf = amcf + 2000;
			tot3+= 2000;
			amcf2.setText(btnamcfcount2 + "개");
			ch2.setText("아메리카노");
			ch4.setText(btnamcfcount + "개");
			ch5.setText(amcf + "원");
			paymy2.setText(amcf + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("amcf.jpg");
			this.repaint();
		}
		else if(e.getSource() == btncf) {
			btncfcount++;
			btncfcount2--;
			cf = cf + 4000;
			tot3 += 4000;
			cf2.setText(btncfcount2 + "개");
			ch2.setText("카푸치노");
			ch4.setText(btncfcount + "개");
			ch5.setText(cf + "원");
			paymy2.setText(cf + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("cf.jpg");
			this.repaint();
		}
		else if(e.getSource() == btnorsm) {
			btnorsmcount++;
			btnorsmcount2--;
			orsm = orsm + 4500;
			tot3 += 4500;
			orsm2.setText(btnorsmcount2 + "개");
			ch2.setText("오랜지스무디");
			ch4.setText(btnorsmcount + "개");
			ch5.setText(orsm + "원");
			paymy2.setText(orsm + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("orsm.jpg");
			this.repaint();
		}
		else if(e.getSource() == btnibal) {
			btnibalcount++;
			btnibalcount2--;
			ibal = ibal + 3000;
			tot3 += 3000;
			ibal2.setText(btnibalcount2 + "개");
			ch2.setText("바닐라라떼");
			ch4.setText(btnibalcount + "개");
			ch5.setText(ibal + "원");
			paymy2.setText(ibal + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("ibal.jpg");
			this.repaint();
			
		}
		else if(e.getSource() == btnicet) {
			btnicetcount++;
			btnicetcount2--;
			icet = icet + 2000;
			tot3 += 2000;
			icet2.setText(btnicetcount2 + "개");
			ch2.setText("아이스티");
			ch4.setText(btnicetcount + "개");
			ch5.setText(icet + "원");
			paymy2.setText(icet + "원");
			imgsel =  Toolkit.getDefaultToolkit().getImage("icet.jpg");
			this.repaint();
			
		}
		else if(e.getSource() == btn1000) {
			tot += 1000;
			nowmy2.setText(tot + "원");
		}
		else if(e.getSource() == btn5000) {
			tot += 5000;
			nowmy2.setText(tot + "원");
		}
		else if(e.getSource() == btn10000) {
			tot += 10000;
			nowmy2.setText(tot + "원");
		} 
		else if(e.getSource() == btnpay) {
			if( tot < 2000) {
				msg("최소 2000원 이상 넣어주세요");
			}
			if(tot == 0 ) {
				msg("커피를 선택하라");
			}
			tot-=tot3;
			nowmy2.setText( tot + "원");
		}
		
	}
	
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(450, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	public void paint(Graphics g) {
		g.drawImage(img,  40, 90, 100, 100, this);
		g.drawImage(img2, 190, 90, 100, 100, this);
		g.drawImage(img3, 340, 90, 100, 100, this);
		g.drawImage(img4, 40, 300, 100, 100, this);
		g.drawImage(img5, 190, 300, 100, 100, this);
		g.drawImage(img6, 340, 300, 100, 100, this);
		g.drawImage(imgsel, 550, 200, 100, 100, this);
		}
	void getData(){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
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
				coffee[count][1] = rs.getString("이름");
				coffee[count][2] = rs.getString("수량");
				coffee[count][3] = rs.getString("가격");				
				count++;
			}
			//화면에 뿌리기...노가다..					
					btncf.setLabel(coffee[0][1]);
					mkcf2.setText(coffee[0][2]);
					mkcf3.setText(coffee[0][3]);
					
					btnamcf.setLabel(coffee[1][1]);
					amcf2.setText(coffee[1][2]);
					amcf3.setText(coffee[1][3]);
					
					btncf.setLabel(coffee[2][1]);
					cf2.setText(coffee[2][2]);
					cf3.setText(coffee[2][3]);
					
					btnicet.setLabel(coffee[4][1]);
					icet2.setText(coffee[4][2]);
					icet3.setText(coffee[4][3]);
					
					btnorsm.setLabel(coffee[3][1]);
					orsm2.setText(coffee[3][2]);
					orsm3.setText(coffee[3][3]);
					
					btnibal.setLabel(coffee[5][1]);
					ibal2.setText(coffee[5][2]);
					ibal3.setText(coffee[5][3]);
			
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
}