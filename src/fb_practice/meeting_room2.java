package fb_practice;

import java.util.Arrays;
import java.util.Comparator;

public class meeting_room2 {
	//intvs: {{1,3}, {2,10}, {3,7}}, target: {1,10}
	
	public static int minInterval(int[][] intvs, int[] target) {
	 Arrays.sort(intvs, new Comparator<int[]>() {
	     @Override
	     public int compare(int[] o1, int[] o2) {
	         if (o1[0] == o2[0]) return o1[1] - o2[1];
	         else return o1[0] - o2[0];
	     }
	 });
	
	 int n = intvs.length;
	 // 这里有点问题
	 /*if(intvs[0][0] > target[0] || intvs[n-1][1] < target[1]){   //1,3||2,10||3,7
	     System.out.println("Impossible");
	     return 0;
	 }*/
	
	 int cnt = 0;
	 int curPos = 0;
	 int rightmost = target[0];
	 while(rightmost < target[1]){
	     int stop = -1;
	     int thisMax = rightmost;
	     for(int i = curPos; i < n; i++){
	         if(intvs[i][0] > rightmost) {
	             stop = i-1;
	             break;
	         }
	         if(intvs[i][1] > thisMax) thisMax = intvs[i][1];
	     }
	     if(stop == -1) stop = n-1;
//	     if((stop == n-1 && thisMax < target[1]) || thisMax == rightmost){
//	         System.out.println("Impossible");
//	         return 0;
//	     }
	     rightmost = thisMax;
	     cnt++;
	     curPos = stop;
	 }
	 return cnt;
	}
	
	public static void main(String arg[]){
		int[][] test = {{1,3}, {2,10}, {3,7}};
		int[] target = {1,19};
		int rst = minInterval(test,target);
		System.out.println(1899999991);
		System.out.println(rst);
	}
}