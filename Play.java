import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Play{
	
	public static void main(String[] args){

		Boolean exit = false;
		Scanner s = new Scanner(System.in);
		Board b = new Board();
		Piece one_block = new Piece("1x1 square", false, false, new ArrayList<Integer>(Arrays.asList(0)), new ArrayList<Integer>(Arrays.asList(0)));
		Piece two_block = new Piece("1x2 rectangle", false, true, new ArrayList<Integer>(Arrays.asList(0,1)), new ArrayList<Integer>(Arrays.asList(0,0)));
		Piece three_block = new Piece("1x3 rectangle", false, true, new ArrayList<Integer>(Arrays.asList(0,1,2)), new ArrayList<Integer>(Arrays.asList(0,1,2)));
		Piece four_block = new Piece("1x4 rectangle", false, true, new ArrayList<Integer>(Arrays.asList(0,1,2,3)), new ArrayList<Integer>(Arrays.asList(0,0,0,0)));
		Piece two_square = new Piece("2x2 square", false, false, new ArrayList<Integer>(Arrays.asList(0,0,1,1)), new ArrayList<Integer>(Arrays.asList(0,1,0,1)));
		Piece two_l_block = new Piece("2x2 L-shape", false, true, new ArrayList<Integer>(Arrays.asList(0,0,1)), new ArrayList<Integer>(Arrays.asList(0,1,0)));
		Piece three_l_block = new Piece("2x3 L-shape", true, true, new ArrayList<Integer>(Arrays.asList(0,0,1,2)), new ArrayList<Integer>(Arrays.asList(0,1,0,0)));
		Piece z_block = new Piece("Z shape", true, true, new ArrayList<Integer>(Arrays.asList(0,1,1,2)), new ArrayList<Integer>(Arrays.asList(0,0,1,1)));
		Piece t_block = new Piece("T shape", true, true, new ArrayList<Integer>(Arrays.asList(0,0,0,1)), new ArrayList<Integer>(Arrays.asList(0,1,-1,0)));
		
		while(!exit){
			System.out.println("Enter 7 spaces in the format [A-F][1-6] separated by spaces and ignore the [] (or type quit): ");
			String input = s.nextLine();
			if(input.equals("quit")){
				exit = true;
			}
			else{
				String[] spl = input.split("\\s+");
				System.out.println(spl.length);
				if(spl.length == 7){
					Boolean check = true;
					for(String a : spl){
						if(a.length() == 2 && Character.isLetter(a.charAt(0)) && Character.isDigit(a.charAt(1))){
							char first = (("" + a.charAt(0)).toUpperCase()).charAt(0);
							int second = Integer.parseInt("" + a.charAt(1));
							if("ABCDEF".contains("" + first) && second >= 1 && second <= 6){
								System.out.println("" + first + second);
								b.add_block(first, second);
							}
							else{
								System.out.println("Wrong - " + first + second);
							}
						}
						else{
							System.out.println("1 - Not a valid input, try again.");
						}
					}
				}
				else{
					System.out.println("2 - Not a valid input, try again.");
				}
			}
			if(!exit){
				b.print_board();
				b.fit_piece(four_block);
			}
		}

	}

}