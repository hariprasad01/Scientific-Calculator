import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
public class ScientificCalculator extends JFrame {
	
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp,
	fac, plus, min, div, log, rec, mul, eq, addSub, dot, mr, mc, mp,
	mm, sqrt, sin, cos, tan, AC, frac, Add, Sub, Mul, Div;
	Container mainCont;
	JPanel textPanel, buttonpanel1, buttonpanel2, buttonpanel3,buttonpanel4;
	ClickActivity B = new ClickActivity();
	ScientificCalculator() {
		mainCont=getContentPane();
		mainCont.setLayout(new BorderLayout());
		
		
		textPanel = new JPanel();
		textPanel.add(B.tField);
		mainCont.add("North", textPanel);
		buttonpanel1 = new JPanel();
		buttonpanel1.setLayout(new GridLayout(3,2,4,4));
		buttonpanel1.setBorder(new EmptyBorder(4,4,4,4));

		AC = new JButton("AutoC");
		buttonpanel1.add(AC);
		AC.setBackground(Color.RED);
		AC.addActionListener(B);
		frac = new JButton("a/b");
		frac.setToolTipText("In order to input fraction, first click the numerator then this button and then the denominator.");
		buttonpanel1.add(frac);
		frac.setBackground(Color.YELLOW);
		frac.addActionListener(B);
		Add = new JButton("ADD");
		buttonpanel1.add(Add);
		Add.setBackground(Color.YELLOW);
		Add.setToolTipText("For fraction addition.");
		Add.addActionListener(B);
		Sub = new JButton("SUB");
		buttonpanel1.add(Sub);
		Sub.setBackground(Color.YELLOW);
		Sub.setToolTipText("For fraction substraction.");
		Sub.addActionListener(B);
		Mul = new JButton("MUL");
		buttonpanel1.add(Mul);
		Mul.setBackground(Color.YELLOW);
		Mul.setToolTipText("For fraction multiplication.");
		Mul.addActionListener(B);
		Div = new JButton("DIV");
		buttonpanel1.add(Div);
		Div.setToolTipText("For fraction division.");
		Div.setBackground(Color.YELLOW);
		Div.addActionListener(B);
		mainCont.add("West",buttonpanel1);
		
		
		buttonpanel2 = new JPanel();
		buttonpanel2.setLayout(new GridLayout(4,3,4,4));
		buttonpanel2.setBorder(new EmptyBorder(4,4,4,4));
		b1 = new JButton("7");
		buttonpanel2.add(b1);
		b1.addActionListener(B);
		b2 = new JButton("8");
		buttonpanel2.add(b2);
		b2.addActionListener(B);
		b3 = new JButton("9");
		buttonpanel2.add(b3);
		b3.addActionListener(B);
		b4 = new JButton("4");
		buttonpanel2.add(b4);
		b4.addActionListener(B);
		b5 = new JButton("5");
		buttonpanel2.add(b5);
		b5.addActionListener(B);
		b6 = new JButton("6");
		buttonpanel2.add(b6);
		b6.addActionListener(B);
		b7 = new JButton("1");
		buttonpanel2.add(b7);
		b7.addActionListener(B);
		b8 = new JButton("2");
		buttonpanel2.add(b8);
		b8.addActionListener(B);
		b9 = new JButton("3");
		buttonpanel2.add(b9);
		b9.addActionListener(B);
		addSub = new JButton("+/-");
		buttonpanel2.add(addSub);
		addSub.addActionListener(B);
		zero = new JButton("0");
		buttonpanel2.add(zero);
		zero.addActionListener(B);
		dot = new JButton(".");
		buttonpanel2.add(dot);
		dot.addActionListener(B);
		mainCont.add("South",buttonpanel2);
		
		
		buttonpanel3 = new JPanel();
		buttonpanel3.setLayout(new GridLayout(5,2,4,4));
		buttonpanel3.setBorder(new EmptyBorder(4,4,4,4));
		rec = new JButton("x^-1");
		buttonpanel3.add(rec);
		rec.addActionListener(B);
		sqrt = new JButton("Sqrt");
		buttonpanel3.add(sqrt);
		sqrt.addActionListener(B);
		log = new JButton("log");
		buttonpanel3.add(log);
		log.addActionListener(B);
		sin = new JButton("SIN");
		buttonpanel3.add(sin);
		sin.addActionListener(B);
		cos = new JButton("COS");
		buttonpanel3.add(cos);
		cos.addActionListener(B);
		tan = new JButton("TAN");
		buttonpanel3.add(tan);
		tan.addActionListener(B);
		pow2 = new JButton("x^2");
		buttonpanel3.add(pow2);
		pow2.addActionListener(B);
		pow3 = new JButton("x^3");
		buttonpanel3.add(pow3);
		pow3.addActionListener(B);
		exp = new JButton("Exp");
		exp.addActionListener(B);
		buttonpanel3.add(exp);
		fac = new JButton("n!");
		fac.addActionListener(B);
		buttonpanel3.add(fac);
		mainCont.add("Center",buttonpanel3);
		
		
		buttonpanel4=new JPanel();
		buttonpanel4.setLayout(new GridLayout(5,2,4,4));
		buttonpanel4.setBorder(new EmptyBorder(4,4,4,4));
		plus = new JButton("+");
		buttonpanel4.add(plus);
		plus.addActionListener(B);
		min = new JButton("-");
		buttonpanel4.add(min);
		min.addActionListener(B);
		mul = new JButton("*");
		buttonpanel4.add(mul);
		mul.addActionListener(B);
		div = new JButton("/");
		div.addActionListener(B);
		buttonpanel4.add(div);
		clr = new JButton("C");
		buttonpanel4.add(clr);
		clr.addActionListener(B);
		mr = new JButton("MR");
		buttonpanel4.add(mr);
		mr.addActionListener(B);
		mc = new JButton("MC");
		buttonpanel4.add(mc);
		mc.addActionListener(B);
		mp = new JButton("M+");
		buttonpanel4.add(mp);
		mp.addActionListener(B);
		mm = new JButton("M-");
		buttonpanel4.add(mm);
		mm.addActionListener(B);
		eq = new JButton("=");
		buttonpanel4.add(eq);
		eq.addActionListener(B);
		eq.setBackground(Color.GREEN);
		mainCont.add("East",buttonpanel4);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		
		ScientificCalculator f = new ScientificCalculator();
		f.setTitle("ScientificCalculator");
		f.pack();
		f.setVisible(true);
	}
}

