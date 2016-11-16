package com.chemplace.view;

public class DemoSS {
	
	
	public static void main(String args[])
	{
		String var="9873036790,5646561545220255";
		
		String aarr[]=var.split(",");
		
		int length=aarr.length;
		for(int i=0;i<length;i++)
		{
		if(aarr[i].length()==10)
		{
		System.out.println(aarr[i].length()+"length is valid");	
		}
		else
		{
			System.out.println(aarr[i].length()+"length is not valid");	
		}
		
		}
		//System.out.println("length ="+length);
		
		//double dVal = 290.1261343455;
		
		
		//System.out.println("round of value="+Math.round (dVal * 10000.0) / 10000.0);
		
		
	}
	

}
