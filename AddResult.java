package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.Results;
import com.connection.ResultsUtil;

/**
 * Servlet implementation class AddResult
 */
@WebServlet("/AddResult")
public class AddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] sub=new String[9];
		String[]marks=new String[9];
		double[] marks2=new double[9];
		
		String Studentid=request.getParameter("stid");
		
		//method to save the data
		sub[0]=request.getParameter("subject01");
		marks[0]=request.getParameter("mark1");
		
		sub[1]=request.getParameter("subject02");
		marks[1]=request.getParameter("mark2");
		
		sub[2]=request.getParameter("subject03");
		marks[2]=request.getParameter("mark3");
		
		sub[3]=request.getParameter("subject04");
		marks[3]=request.getParameter("mark4");
		
		sub[4]=request.getParameter("subject05");
		marks[4]=request.getParameter("mark5");
		
		sub[5]=request.getParameter("subject06");
		marks[5]=request.getParameter("mark6");
		
		sub[6]=request.getParameter("subject07");
		marks[6]=request.getParameter("mark7");
		
		
		sub[7]=request.getParameter("subject08");
		marks[7]=request.getParameter("mark8");
		
		sub[8]=request.getParameter("subject09");
		marks[8]=request.getParameter("mark9");
		
		int id=0;
		Results r1=new Results();
		boolean isTrue=false;
		for(int i=0;i<9;i++) {
				marks2[i]=Double.parseDouble(marks[i]);
				isTrue=ResultsUtil.insertSubject(id,Studentid, sub[i], marks2[i]);
				
		}
		
		boolean isTrue1;
		double total=r1.Findtotal(marks2);
		double avg=r1.FindAvg(marks2);
		String status;
		status=r1.Setstatus(total);
		
		    isTrue1=ResultsUtil.insertProgress(id,total,avg,Studentid,status);
		    
		    if(isTrue==true && isTrue1==true) {
				//navigate to jsp the path
				RequestDispatcher dis = request.getRequestDispatcher("success.jsp");//pass control to view 
				
				dis.forward(request, response);
			}else {
			
					RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
					dis2.forward(request, response);
				
				
			}
			
		
		
		}
		
		
	
		
	}


