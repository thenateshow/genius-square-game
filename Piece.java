import java.util.List;
import java.util.ArrayList;

public class Piece{
	
	String description;
	boolean flip;
	boolean rotate;
	List<Integer> x;
	List<Integer> y;

	public Piece(String d, boolean f, boolean r, ArrayList<Integer> x_l, ArrayList<Integer> y_l){
		description = d;
		flip = f;
		rotate = r;
		x = x_l;
		y = y_l;
	}

	public void print_description(){
		System.out.println(description);
	}

	public List<Integer> get_x(){
		return x;
	}

	public List<Integer> get_y(){
		return y;
	}

}