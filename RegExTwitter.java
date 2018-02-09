package com.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTwitter {

	public static void main(String args[]) {
	String basicInput = "E: Piyushdeshmukh@gmail.com P:(333)456-7890 P:+1 (333) 456-7890" ;
	String [] basicInputArray = basicInput.split("P:");
	String emailId = basicInputArray[0]; 
    StringBuilder sbOutput = new StringBuilder();    
	String [] values = emailId.split("E:");
	String checkEmail = "";
	String [] checkPh = new String[basicInputArray.length-1];
	String output = "";
	if(values[1]!=null) {
		checkEmail = values[1].trim(); 
	}
	
	for(int i=1 ; i < basicInputArray.length ; i++){
		if(basicInputArray[i] != null) {
		checkPh[i-1] =  basicInputArray[i].trim();
		}
	}
	
	 
final String EMAIL_PATTERN = 			"[a-zA-Z0-9]([a-zA-Z0-9.]+)[a-zA-Z0-9]";
	Pattern p = Pattern.compile(EMAIL_PATTERN);
	Matcher matcher; 
	matcher = p.matcher(checkEmail);
	if(matcher.find()){
		output = matcher.replaceFirst("*****");
	}
	String first = checkEmail.substring(0, 1);
	String last = checkEmail.substring(checkEmail.split("@")[0].length()-1).substring(0,1);
	output = output.replace("@", last+"@");
	output = first + output ;
	
    sbOutput.append("E:").append(output).append("\n");
	
	StringBuilder sb = new StringBuilder();
	String phPattern = "^(\\+?[-(]?(\\d{1,3})?)[-)]?\\s*[-(]?(\\d{3})[-)]?\\s*(\\d{3})[-]?(\\d{4})" ;
	Pattern p1 = Pattern.compile(phPattern);
	Matcher matcher1; 
    
   
    for(int j=0;j<checkPh.length; j++) {
	matcher1 = p1.matcher(checkPh[j]);
	
	if(matcher1.find()){
		sb.append("P:");
		for(int i=0;i<checkPh[j].length()-4; i++) {
			//System.out.println("checkPh[1].charAt(i)" + checkPh[1].charAt(i));
			if((String.valueOf(checkPh[j].charAt(i)).equals("+") )) {
				sb.append("+");
			} else if (String.valueOf(checkPh[j].charAt(i)).equals("-") ) {
				sb.append("-");
			} else if (String.valueOf(checkPh[j].charAt(i)).equals(" ") ) {
				sb.append("");
			} else if (String.valueOf(checkPh[j].charAt(i)).equals("(") && i !=0 ) {
				sb.append("-");
			} else if (String.valueOf(checkPh[j].charAt(i)).equals("(") && i ==0 ) {
				sb.append("");
			} else if (String.valueOf(checkPh[j].charAt(i)).equals(")") ) {
				sb.append("-");
			}else {
			sb.append("*");
		}
		}	}
	
	sb.append(checkPh[j].substring(checkPh[j].length()-4, checkPh[j].length()));
	sb.append("\n"); 
    
    }
    sbOutput.append(sb.toString()).append("\n");
    System.out.println(sbOutput.toString());
	}
                                          
        
}
