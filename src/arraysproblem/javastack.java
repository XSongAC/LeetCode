package arraysproblem;
import java.util.*;

public class javastack {
	public static void main(String a[]){
		Integer[] intArr = {1,2,3,4};
		Stack<Integer> stack = new Stack<>();
		for(Integer i:intArr) {
			stack.push(i);
		}
		stack.pop();
		System.out.println("Non-Empty stack : search() Operation : " + stack.search(1));
		System.out.println("Non-Empty stack : " + stack);
	}

}
