import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Board{

	int[][] b = new int[6][6];
	HashMap<Character, Integer> change = new HashMap<Character, Integer>();
	
	public Board(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				b[i][j] = 0;
			}
		}

		change.put('A', 0);
		change.put('B', 1);
		change.put('C', 2);
		change.put('D', 3);
		change.put('E', 4);
		change.put('F', 5);
	}

	public void add_block(char c, int i){
		b[change.get(c)][i-1] = -1;
	}

	public void print_board(){
		System.out.println("    1  2  3  4  5  6 ");
		for(int i = 0; i < 6; i++){
			if(i == 0) System.out.print(" A ");
			if(i == 1) System.out.print(" B ");
			if(i == 2) System.out.print(" C ");
			if(i == 3) System.out.print(" D ");
			if(i == 4) System.out.print(" E ");
			if(i == 5) System.out.print(" F ");
			for(int j = 0; j < 6; j++){
				if(b[i][j] == -1){
					System.out.print(" - ");
				}
				else{
					System.out.print(" " + b[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void fit_piece(Piece p){
		List<Integer> x = p.get_x();
		List<Integer> y = p.get_y();
		int fits = 0;
		int no_fit = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				boolean check = true;
				for(int k = 0; k < x.size(); k++){
					if((i+x.get(k) >= 6) || (i+x.get(k) < 0) || (j+y.get(k) >= 6) || (j+y.get(k) < 0) || b[i+x.get(k)][j+y.get(k)] == -1){
						check = false;
					}
				}
				if(check) fits++;
				if(!check) no_fit++;
			}
			System.out.println("Good: " + fits + "\nBad:  " + no_fit);
		}
		System.out.println("Good: " + fits + "\nBad:  " + no_fit);
	}
}
































