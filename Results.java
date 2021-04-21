package com.classes;

public class Results {
	
	
	private double average;
	private double total;
	
	private String status;
	private double mark;
	private String subject;
	
	private String stid;


	public Results(String stid,double mark,String Subject) {
		super();
		this.mark = mark;
		this.stid = stid;
	}



	public String getStid() {
		return stid;
	}






	public Results(String subject,double mark) {
		super();
		this.mark = mark;
		this.subject = subject;
	}



	public double getMark() {
		return mark;
	}



	


	public String getSubject() {
		return subject;
	}



	



	public Results() {
		super();
	}

	

	public  double Findtotal(double[] marks) {
		total=0;
		for(int i=0;i<marks.length;i++) {
			total=total+marks[i];
		}
		return total;
		
	}

	public  double FindAvg(double[] marks) {
		
			return average=total/marks.length;
		
	}
	
	public String Setstatus(double total) {
		if(total>=450) {
			status="Pass";
		}
		else {
			status="Fail";
		}
		return status;
	}

	

}
