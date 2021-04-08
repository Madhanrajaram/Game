package com.madhan;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class TicTacToe {
	static ArrayList<Integer> playerpos=new ArrayList<Integer>();
	static ArrayList<Integer> cpupos=new ArrayList<Integer>();
	public static void main(String[] args) {

	char[] [] game= {{' ','|',' ','|',' ','|'},{'-','+','-','+','-','+'},
			{' ','|',' ','|',' ','|'},{'-','+','-','+','-','+'},
			{' ','|',' ','|',' ','|'}};
	
	board(game); 
	while(true) {
		System.out.println();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a position:");
	int position=sc.nextInt();
	while(playerpos.contains(position)||cpupos.contains(position))
	{
		System.out.println("Already taken!Reenter another value");
		position=sc.nextInt();
	}
	place(game,position,"player");
	String result=victory();
	if(result.length()>0)
	{
		System.out.print(result);
		break;
	}
	System.out.println();
	Random r=new Random();
	int cpuposition =r.nextInt(9)+1;
	while(playerpos.contains(cpuposition)||cpupos.contains(cpuposition))
	{
		cpuposition=r.nextInt(9)+1;
	}
	place(game,cpuposition,"cpu");
	result=victory();
	if(result.length()>0)
	{
		System.out.print(result);
		break;
	}

	}
	
}
	public static void board(char[][] game)
	{
			for(char[]c:game)
			{
				for (char c1:c)
				{
					System.out.print(c1);
				}
				System.out.println();
			}
		}	
	public static void place(char[][] game,int position, String user)
	{
		char sign=' ';
		if(user.equalsIgnoreCase("player"))
		{
			sign='X';
			playerpos.add(position);
		}
		else if(user.equalsIgnoreCase("cpu"))
		{
			sign='O';
		cpupos.add(position);
		}
		switch(position)
		{
		case 1:
			game[0][0]=sign;
			break;
		case 2:
			game[0][2]=sign;
			break;
		case 3:
			game[0][4]=sign;
			break;
		case 4:
			game[2][0]=sign;
			break;
		case 5:
			game[2][2]=sign;
			break;
		case 6:
			game[2][4]=sign;
			break;
		case 7:
			game[4][0]=sign;
			break;
		case 8:
			game[4][2]=sign;
			break;
		case 9:
			game[4][4]=sign;
			break;
		default:
			break;
		}
		board(game); 
	}
	public static String victory() {
		List Top= Arrays.asList(1,2,3);
		List Middle= Arrays.asList(4,5,6);
		List Bottom= Arrays.asList(7,8,9);
		List TopRight= Arrays.asList(3,6,9);
		List TopLeft= Arrays.asList(1,4,7);
		List TopMiddle= Arrays.asList(2,5,8);
		List TopCrossRight= Arrays.asList(1,5,9);
		List TopCrossLeft= Arrays.asList(3,5,7);
		
		
		List<List> win=new ArrayList<List>();
		win.add(Top);
		win.add(Middle);
		win.add(Bottom);
		win.add(TopRight);
		win.add(TopLeft);
		win.add(TopMiddle);
		win.add(TopCrossRight);
		win.add(TopCrossLeft);
		
		for(List li:win)
		{
			if(playerpos.containsAll(li))
				return "Player Wins";
			else if(cpupos.containsAll(li))
				return "CPU wins.Better Luck Next Time!";
			else if(playerpos.size()+cpupos.size()==9)
			return"Match drawn";
		}
		return "";
}
}

