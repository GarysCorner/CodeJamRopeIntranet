package net.garyscorner.codejamropeintranet;

//File:		DataStructure.java
//Author:	Gary Bezet
//Date:		2016-06-14
//Desc:		Designed for google code jam practice problem "Rope Intranet" from round 1C in 2010
//Problem:	https://code.google.com/codejam/contest/619102/dashboard#s=p0
//Results:


public class DataStructure {
	
	//variables
	public int casenum;
	
	public int wirecount; //number of wires total
	
	public Wire[] wiremap;
	
	public int solution;
	
	public long solvetime;
	
	//functions
	DataStructure(int newcasenum) {
		super();
		casenum = newcasenum;
		solution = 0;
	}
	
	public void solve() {
		long starttime = System.currentTimeMillis();  //set the start time
		
		//solve for each wire
		for( int i = 0; i < wirecount; i++) {
			
			//compare each wire to the wires bellow it
			for( int c = i + 1; c < wirecount; c++) {
				if( wiremap[i].doesCross(wiremap[c]) ) {
					solution++;
				}
			}
			
		}
		
		solvetime = System.currentTimeMillis() - starttime;  //get the start time
	}
	
}
