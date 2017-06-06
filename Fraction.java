public class Fraction{
	protected int numerator;
	protected int denominator;
	private int temp;
	private int divident;
	private int divisor;
	private int remm;
	private int tempNume;
	private int tempDenome;
  
 	Fraction(){
		this.numerator=1;
		this.denominator=1;
	}
	/*Fraction(int n){
		this.numerator=n;
		this.denominator=1;
	}

	Fraction(int n, int d){
		this.numerator=n;
		this.denominator=d;
	}*/
	public Fraction(String frac) throws CalculationException {
		String numer="",denome="";int f=0;
		try {
		numer=frac.substring(0,frac.indexOf('/'));
		}
		catch(StringIndexOutOfBoundsException se) {
			f=1;
			numer=frac;
			denome="1";
		}
		if(f==0) {	
			if(frac.indexOf('/')!=(frac.length()-1))
				denome=frac.substring(frac.indexOf('/')+1,frac.length());
			else
				denome="1";
		}	
		int n=1,d=1;
		numerator=Integer.parseInt(numer);
		denominator=Integer.parseInt(denome);
		if(denominator==0) {
			throw new CalculationException("Denominator Cannot be Zero");
		}
		if(numerator<0) {
			numerator=-numerator;
			n=0;
		}
		if(denominator<0) {
			denominator=-denominator;
			d=0;
		}
		if(n!=d)
			numerator=-numerator;	
	}
	public void reciprocal() throws CalculationException {
		int temp;
		temp=numerator;
		numerator=denominator;
		denominator=temp;
		if(denominator<0) {
			denominator=-denominator;
			numerator=-numerator;
		}
		if(denominator==0) {
			throw new CalculationException("Floating point exception");
		}
	}
 	public String toString() {
		if(numerator==0||denominator==0)
			return "0";
		StringBuilder r= new StringBuilder("");
		r.append(Integer.toString(numerator));
		r.append("/");
		r.append(Integer.toString(denominator));
		return r.toString();
	}
 public void setNumerator(int n){
 	this.numerator = n;
 }
 public void setDenominator(int d)throws ZeroDenominatorException{
 if(d!=0)
 	this.denominator = d;
 else
	throw new ZeroDenominatorException("Denominator Cannot be Zero");
 }
 public int getNumerator(){
  return this.numerator;
 }
 public int getDenominator(){
  return this.denominator;
 }
 public void print(){
	if(this.denominator==1){
	System.out.println("The fraction is "+this.numerator);
	}
	else{
	System.out.println("The fraction is "+this.numerator+"/"+this.denominator);
	}	
    
  }
 public void inverse(){
	this.temp=this.numerator;
	this.numerator=this.denominator;
	this.denominator=this.temp;	
 }
 public String reduce(){
	this.tempNume=this.numerator;this.tempDenome = this.denominator;
	if(this.numerator>this.denominator){
		this.divident = this.tempNume;
		this.divisor = this.tempDenome;
		remm = divident%divisor;
		while(remm!=0){
			this.divident = this.divisor;
			this.divisor = this.remm;
			remm = divident%divisor;
		}
	}
	else{
		this.divident = this.tempNume;
		this.divisor = this.tempDenome;
		remm = divident%divisor;
		while(remm!=0){
			this.divident = this.divisor;
			this.divisor = this.remm;
			remm = divident%divisor;
		}
	}

	tempNume=tempNume/divisor;
	tempDenome=tempDenome/divisor;
	/*System.out.println("The reduced fraction is "+this.tempNume+"/"+this.tempDenome);*/
	/*System.out.println(askn+"\n"+askd);*/
	if(tempDenome==1){
	String askn = Integer.toString(tempNume);
	return askn;
	}
	else{
	String askn = Integer.toString(tempNume);
	String askd = Integer.toString(tempDenome);
	return askn+"/"+askd;
	}		
 }
 public boolean isProper(){
	if(numerator<denominator){
		return true;
	}
	else{
		return false;
	}
 }
 /*public Fraction computeInverse(){
	Fraction inv= new Fraction(denominator,numerator);
	return inv;
 }
	/** This method adds 2 fractions and returns the sum*/
 /*public Fraction add(Fraction frac){
	int numerSum;
	if(this.denominator==frac.getDenominator()){
		numerSum= this.numerator+frac.getNumerator();
		Fraction sum= new Fraction(numerSum,this.getDenominator());
		return sum;
	}
	else{
		return null;
	}
 }*/
public String operate(String A, char op, String B) throws CalculationException {
		Fraction X,Y,R;int f=0;
		R=new Fraction();
		String res="";
		try {
			X = new Fraction(A);
		}
		catch(CalculationException ae) {
			f=1;
			throw ae;
		}
		try {
			Y = new Fraction(B);
		}
		catch(CalculationException ae) {
			f=1;
			throw ae;
		}
		if(f==1)
			return res;
		switch(op) {
		case '+' : R.denominator=X.denominator*Y.denominator;
				   R.numerator=X.numerator*Y.denominator+Y.numerator*X.denominator;	
				   break;
		case '-' : R.denominator=X.denominator*Y.denominator;
		   		   R.numerator=X.numerator*Y.denominator-Y.numerator*X.denominator;	
		   		   break;
		case '*' : R.numerator=X.numerator*Y.numerator;
				   R.denominator=X.denominator*Y.denominator;
				   break;
		case '/' : 
			       try {
			    	   Y.reciprocal();
			       }
			       catch(CalculationException ae) {
						f=1;
						throw ae;
				   }
		 		   R.numerator=X.numerator*Y.numerator;
		 		   R.denominator=X.denominator*Y.denominator;	
		 		   break;
		}
		if(f==1)
			return res;
		else {
			
			res=R.reduce().toString();
			return res;
		}
	}
	public String greciprocal(String A) throws CalculationException {
		Fraction R; 
		try {
			R = new Fraction(A);
		}
		catch(CalculationException ae) {
			throw ae;
		}
		try {
			R.reciprocal();
		}
		catch(CalculationException ae) {
			throw ae;
		}
		return R.toString();
	}
	public double toDouble(String A) throws CalculationException {
		Fraction R;
		try {
			R = new Fraction(A);
		}
		catch(CalculationException ae) {
			throw ae;
		}
		double a;
		a = (1.0*R.numerator)/R.denominator;
		return a;
	}
	public double Sroot(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
		if(a<0) {
			throw new CalculationException("Negative root");
		}
		else {
			return Math.sqrt(a);
		}
	}
	public double Log(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
		if(a<=0) {
			throw new CalculationException("Syntax error");
		}
		else {
			return Math.log(a);
		}
	}
	public double SIN(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.sin(a);
	}
	public double COS(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.cos(a);
	}
	public double TAN(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.tan(a);
	}
	public double Square(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.pow(a,2);
	}
	public double Cube(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.pow(a,3);
	}
	public double Exp(String A) throws CalculationException {
		double a;
		try {
			a = toDouble(A); 
		}
		catch(CalculationException ae) {
			throw ae;
		}
			return Math.exp(a);
	}
}
