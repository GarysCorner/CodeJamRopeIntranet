package net.garyscorner.codejamropeintranet;

//File:		CodeJamRopeIntranet.java
//Author:	Gary Bezet
//Date:		2016-06-14
//Desc:		Designed for google code jam practice problem "Rope Intranet" from round 1C in 2010
//Problem:	https://code.google.com/codejam/contest/619102/dashboard#s=p0
//Results:	  


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;



public class CodeJamRopeIntranet {

	//variables
	private long starttime; //time in ms program was started
	
	private String infileopt; //filename from commandline
	private String outfileopt;  //"
	
	private BufferedReader infile;  //infile reader
	private PrintStream outfile;  //outfile writer
	
	private int totalcases;
	private DataStructure[] testcases;  //test cases array
	
	
	public static void main(String[] args) {
		CodeJamRopeIntranet prog = new CodeJamRopeIntranet();
		prog.run(args);
		
	}
	
	//functions
	public void run(String[] args) {
		starttime = System.currentTimeMillis();  //set the start time
		
		initargs(args);  //get the initial args
		
		openFiles();  //open the input and output files
		
		loadData();  //load the data into data structure
		
	}

	//load all data from the infile
	private void loadData() {
		
		//try and get the number of cases
		try{
			totalcases = Integer.valueOf(readLine());
		}catch(NumberFormatException e) {
			System.err.printf("Could not parse testcase number from \"%1$s\"", infileopt);
			System.exit(4);
		}
		
		//initialize data structure
		testcases = new DataStructure[totalcases];
		
		//input all cases
		for(int i = 0; i < totalcases; i++ ) {
			testcases[i] = new DataStructure(i+1); //initialize data element with casenum
			
			//try and get the wirecount
			try{
				testcases[i].wirecount = Integer.valueOf(readLine());
			} catch(NumberFormatException e) {
				System.err.printf("Could not parse wirecount for case #%1$d", testcases[i].casenum);
				System.exit(5);
			}
			
			//for each wire input data
			for(int c=0; c < testcases[i].wirecount; c++) {
				String[] wireline = readLine().split(" ");
				
				if( wireline.length != 2) {  //if wirelength not correct
					System.err.printf("Bad wire offset(%1$d) case #%2$d", c, testcases[i].casenum);
					System.exit(6);
				}
				
				//try and parse the wireline into numbers
				try {
					
				}catch(NumberFormatException e) {
					System.err.printf("Could not parse wiremap (%1$d) case #%2$d", c, testcases[i].casenum);
					System.exit(7);
				}
				}
				
			}
		
			
			
		}
		
		
		
	}
	
	//reads line of file
	private String readLine() {
		String line = null;
		try {
			line = infile.readLine();
		} catch (IOException e) {
			System.err.printf("Error reading %1$s\n", infileopt);
			System.exit(4);
		}
		return line;
	}
	
	//gets the args from commandline
	private void initargs(String[] args) {
		
		if(  2 < args.length || args.length == 0 ) {
			System.err.println("Program requires 1 or 2 arguments.  First arg is infile name, 2nd arg is outfile name Stderr by default.");
			System.exit(1);  //exit the system if arguments not correct
		}
		
		infileopt = args[0];
		
		if( args.length == 2 ) {  //set the outfile if exists
			outfileopt = args[1];
		}
		
	}
	
	private void openFiles() {
		
		try {
			infile = new BufferedReader(new FileReader(infileopt));
		} catch (FileNotFoundException e) {
			System.err.printf("Could not open: %1$s\n", infileopt);
			System.exit(2);
		}
		
		if( outfileopt == null ) {  //set outfile to stdout if blank otherwise open file for writing
			outfileopt = new String("Stdout");
			outfile = System.out;
		} else {
			try {
				outfile = new PrintStream(new File(outfileopt));
			} catch (FileNotFoundException e) {
				System.err.printf("Couldn't open \"%1$s\" for writing!\n", outfileopt);
				System.exit(3);
			}
			
		}
		
	}
	
}
