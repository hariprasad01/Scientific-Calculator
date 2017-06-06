
public class Operation {

	public double operate(String A,char op, String B) throws CalculationException {
		double a = Double.parseDouble(A);
		double b = Double.parseDouble(B);
		switch(op) {
		case '+' : return a+b;
		case '-' : return a-b;
		case '*' : return a*b;
		case '/' : if(b==0) {
						throw new CalculationException("Floating Point Exception");
					}
					return a/b;			
		}
		return 0;
	}
	public double Sroot(String A) throws CalculationException {
		double a = Double.parseDouble(A);
		if(a<0) {
			throw new CalculationException("Negative Root");
		}
		else {
			return Math.sqrt(a);
		}
	}
	public double Log(String A) throws CalculationException {
		double a = Double.parseDouble(A);
		if(a<=0) {
			throw new CalculationException("Syntax error");
		}
		else {
			return Math.log(a);
		}
	}
	public double SIN(String A) {
		double a = Double.parseDouble(A);
			return Math.sin(a);
	}
	public double COS(String A) {
		double a = Double.parseDouble(A);
			return Math.cos(a);
	}
	public double TAN(String A) {
		double a = Double.parseDouble(A);
			return Math.tan(a);
	}
	public double Square(String A) {
		double a = Double.parseDouble(A);
			return Math.pow(a,2);
	}
	public double Cube(String A) {
		double a = Double.parseDouble(A);
			return Math.pow(a,3);
	}
	public double Exp(String A) {
		double a = Double.parseDouble(A);
			return Math.exp(a);
	}
	public long fact(String A)throws CalculationException {
		if(A.contains(".")) {
			throw new CalculationException("Syntax Error");
		}
		long a = Long.parseLong(A);
		if(a<0) {
			throw new CalculationException("negative number");
		}
		long i=2,r=1;
		while(i<=a) {
			r*=i;
			i++;
		}
		return r;	
	}
}

