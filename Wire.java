package net.garyscorner.codejamropeintranet;

//File:		Wire.java
//Author:	Gary Bezet
//Date:		2016-06-14
//Desc:		Designed for google code jam practice problem "Rope Intranet" from round 1C in 2010
//Problem:	https://code.google.com/codejam/contest/619102/dashboard#s=p0
//Results:	Small problem:  40ms	Large Problem:379ms


public class Wire {

	public int leftwindow;
	public int rightwindow;
	public int wirenum;
	
	Wire(int wirenumin, int leftwindowin, int rightwindowin) {
		leftwindow = leftwindowin;
		rightwindow = rightwindowin;
		wirenum = wirenumin;
	}
	
	public boolean doesCross(Wire otherwire) {
		boolean leftisabove, rightisabove; 
		
		leftisabove = leftwindow > otherwire.leftwindow;
		rightisabove = rightwindow > otherwire.rightwindow;
		
		return !(rightisabove == leftisabove);  //should return true if they cross and false if they dont
		
	}
	
}
