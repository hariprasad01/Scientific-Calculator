import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.*;
public class ClickActivity extends JFrame implements ActionListener{
	public JTextField tField;
	int z=0,o=0,fsep=0,x=0,y=0,x1=0,y1=0;
	double m=0;
	int k=0;
	StringBuilder X,Y;
	char operator = '0';
	Operation AO = new Operation();
	Fraction FO = new Fraction();
	public ClickActivity() {
		tField = new JTextField(25);
		tField.setHorizontalAlignment(SwingConstants.RIGHT);
		tField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent keyevent) {
				char c = keyevent.getKeyChar();
				if (c >= '0' && c <= '9') {
					
				}
				else if(c=='/'||c=='*'||c=='-'||c=='+') {
					
				}
				else {
					keyevent.consume();
				}
			}
		});
		X=new StringBuilder("");
		Y=new StringBuilder("");
	}
	public void clearAll(){
		tField.setText("");
		x = 0;
		y = 0;
		z = 0;
		o = 0;
		x1 = 0;
		y1 = 0;
		fsep = 0;
		X=new StringBuilder("");
		Y=new StringBuilder("");
		operator='0';
	}
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		if(Character.isDigit(s.charAt(0))) {
			if (z != 0) {
				clearAll();
			}	
			if(o==0) {
				if(y==1)
					y=2;
				X.append(Character.toString(s.charAt(0)));
				tField.setText(X.toString());
				
			}
			else {
				if(o==1)
					o++;
				if(y==1)
					y=2;
				Y.append(Character.toString(s.charAt(0)));
				tField.setText(Y.toString());
			}
		}
		if (s.equals("AC")) {
			clearAll();
		}
		if (s.equals("+/-")) {
			if(fsep==0) {
				if (x == 0) {	
					x = 1;
					if(o==0) {
						X.insert(0,'-');
						tField.setText(X.toString());
					}
					else {
						Y.insert(0,'-');
						tField.setText(Y.toString());
					}
				}
				else {
					if(o==0) {
						X.deleteCharAt(0);
						tField.setText(X.toString());
					}
					else {
						Y.deleteCharAt(0);
						tField.setText(Y.toString());
					}
					x=0;	 
				}
			}
			else {
				if (x == 0) {	
					x = 1;
					if(o==0) {
						if(x1==0)
							X.insert(0,'-');
						else
							X.insert(X.indexOf("/")+1, '-');
						tField.setText(X.toString());
					}
					else {
						if(y1==0)
							Y.insert(0,'-');
						else
							Y.insert(Y.indexOf("/")+1, '-');
						tField.setText(Y.toString());
					}
				}
				else {
					if(o==0) {
						if(x1==0)
							X.deleteCharAt(0);
						else
							X.deleteCharAt(X.indexOf("/")+1);
						tField.setText(X.toString());
					}
					else {
						if(y1==0)
							Y.deleteCharAt(0);
						else
							Y.insert(Y.indexOf("/")+1, '-');
						tField.setText(Y.toString());
					}
					x=0;	 
				}	
			}		
		}
		if (s.equals(".")) {
			if(fsep==1) {
				y=0;
			}
			else if(y==2) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if (y == 0) {
				if(o==0) {
					X.append(Character.toString(s.charAt(0)));
					tField.setText(X.toString());
				}
				else {
					Y.append(Character.toString(s.charAt(0)));
					tField.setText(Y.toString());
				}
				y = 1;
			} 
			else {
				if(o==0) {
					X.deleteCharAt(X.indexOf("."));
					tField.setText(X.toString());
				}
				else {
					Y.deleteCharAt(Y.indexOf("."));
					tField.setText(Y.toString());
				}
				y=0;
			}
		}
		if (s.equals("+")) {
			if (X.toString().equals("")||fsep==1) {
				clearAll();
				tField.setText("Syntax Error");
			} 
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("+");
				operator = '+';
				y = 0;
				x = 0;
				o++;
			}
			//tField.requestFocus();
		}
		if (s.equals("-")) {
			if (X.toString().equals("")||fsep==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("-");
				operator = '-';
				y = 0;
				x = 0;
				o++;
			}
			//tField.requestFocus();
		}
		if (s.equals("*")) {
			if (X.toString().equals("")||fsep==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("*");
				operator = '*';
				y = 0;
				x = 0;
				o++;
			}
			//tField.requestFocus();
		}
		if (s.equals("/")) {
			if (X.toString().equals("")||fsep==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("/");
				operator = '/';
				y = 0;
				x = 0;
				o++;
			}
			//tField.requestFocus();
		}
		if (s.equals("=")) {
			if (o==0) {
				clearAll();
			}
			else if(o==1) {
				clearAll();
			}
			else {
				z = 1;
				int f=0;
				if(fsep==0) {
					double result=0;
					try {
						result = AO.operate(X.toString(),operator,Y.toString());
					}
					catch(CalculationException ae) {
						f=1;
						clearAll();
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						clearAll();
						tField.setText(Double.toString(result));
					}
				}
				else {
					String result="";
					try {
						result = FO.operate(X.toString(), operator, Y.toString());
					}
					catch(CalculationException ae) {
						f=1;
						clearAll();
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						clearAll();
						tField.setText(result);
					}
				}		
			}
		}
		if(s.equals("clr")) {
			if(o==0) {
				clearAll();
				tField.setText("");
			}
			else if(o==1) {
				operator='0';
				o--;
				tField.setText("");
			}
			else {
				Y=new StringBuilder("");
				o--;
				x=0;
				y=0;
				y1=0;
				tField.setText("");
			}
		}
		if(s.equals("a/b")) {
			if(y==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				fsep=1;
				if(o==0) {
					X.append("/");
					x1=1;
					x=0;
					y=0;
					tField.setText(X.toString());
				}
				else if(o==1) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else {
					Y.append("/");
					y1=1;
					x=0;
					y=0;
					tField.setText(Y.toString());
				}		
			}
		}
		if(s.equals("Add")) {
			if(fsep==0) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("+");
				y=0;
				x=0;
				o++;
				operator='+';
			}
		}
		if(s.equals("Sub")) {
			if(fsep==0) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("-");
				y=0;
				x=0;
				o++;
				operator='-';
			}
		}
		if(s.equals("Mul")) {
			if(fsep==0) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("*");
				y=0;
				x=0;
				o++;
				operator='*';
			}
		}
		if(s.equals("Div")) {
			if(fsep==0) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else if(o>=1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				tField.setText("+");
				y=0;
				x=0;
				o++;
				operator='/';
			}
		}
		if(s.equals("x^-1")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
						X = new StringBuilder(Double.toString(AO.operate("1", '/', X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(FO.greciprocal(X.toString()));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(X.toString());
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
					Y = new StringBuilder(Double.toString(AO.operate("1", '/', Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(FO.greciprocal(Y.toString()));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(Y.toString());
			    }
			}	
		}
		if(s.equals("Sqrt")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
						X = new StringBuilder(Double.toString(AO.Sroot(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.Sroot(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
						Y = new StringBuilder(Double.toString(AO.Sroot(Y.toString())));	
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.Sroot(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("log")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
						X = new StringBuilder(Double.toString(AO.Log(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.Log(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
					try {
						Y = new StringBuilder(Double.toString(AO.Log(Y.toString())));	
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.Log(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("SIN")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.SIN(X.toString())));
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.SIN(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.SIN(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.SIN(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("COS")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.COS(X.toString())));
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.COS(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.COS(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.COS(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("TAN")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.TAN(X.toString())));
					if(f==0)
						tField.setText(X.toString());
					if(X.toString().equals("NaN")) {
						clearAll();
						tField.setText("nan");
					}	
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.TAN(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}
					if(X.toString().equals("NaN")) {
						clearAll();
						tField.setText("nan");
					}
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.TAN(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
					if(Y.toString().equals("NaN")) {
						clearAll();
						tField.setText("nan");
					}
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.TAN(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}
					if(Y.toString().equals("NaN")) {
						clearAll();
						tField.setText("nan");
					}
			    }
			}	
		}
		if(s.equals("x^2")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.Square(X.toString())));
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.Square(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.Square(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.Square(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("x^3")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.Cube(X.toString())));
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.Cube(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.Cube(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.Cube(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("Exp")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						X = new StringBuilder(Double.toString(AO.Exp(X.toString())));
					if(f==0)
						tField.setText(X.toString());
				}
				else {
					try {
						X = new StringBuilder(Double.toString(FO.Exp(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0) {
						Y = new StringBuilder(Double.toString(AO.Exp(Y.toString())));	
					if(f==0)
						tField.setText(Y.toString());
				}
				else {
					try {
						Y = new StringBuilder(Double.toString(FO.Exp(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
			}	
		}
		if(s.equals("n!")) {
			int f=0;
			if(o==0) {
				if(X.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0){
					try {
						X = new StringBuilder(Double.toString(AO.fact(X.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(X.toString());
					}	
			    }
				else {
					clearAll();
					tField.setText("Syntax error");
				}
			}
			else if(o==1) {
				clearAll();
				tField.setText("Syntax Error");
			}
			else {
				if(Y.toString().equals("")) {
					clearAll();
					tField.setText("Syntax Error");
				}
				else if(fsep==0){
					try {
						Y = new StringBuilder(Double.toString(AO.fact(Y.toString())));
					}
					catch(CalculationException ae) {
						clearAll();
						f=1;
						tField.setText(ae.getMessage());
					}
					if(f==0) {
						fsep=0;
						tField.setText(Y.toString());
					}	
			    }
				else {
					clearAll();
					tField.setText("Syntax error");
				}
			}	
		}
		if(s.equals("MC")) {
			m=0;k=0;
		}
		if(s.equals("MR")) {
			clearAll();
			tField.setText(Double.toString(m));
		}
		if(s.equals("M+")) {
			if(fsep==1) {
			}
			else if(o==1) {
			}
			else {
				if(k==0)
					m=0;
				m=m+Double.parseDouble(tField.getText());
				k=1;
			}
		}
		if(s.equals("M-")) {
			if(fsep==1) {
			}
			else if(o==1) {
			}
			else {
				if(k==0)
					m=0;
				m=m-Double.parseDouble(tField.getText());
				k=1;
			}
		}
	}
}

