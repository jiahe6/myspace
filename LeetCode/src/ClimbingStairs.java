

public class ClimbingStairs {
	public static int N = 1900;
	
	public static long climbStairs(int n){
		assert n > 0;
		if(n == 1)return 1;
		if(n == 2)return 2;
		long[] way = new long[n];
		way[0] = 1;
		way[1] = 2;
		for(int i = 2; i<N; i++){
			way[i] = way[i-1] + way[i-2];
		}
		return way[n-1];
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(climbStairs(N));
		long end = System.nanoTime();
		System.out.println("computeWay : " + (end-start)/10e3 + "us");
		System.out.println(String[].class);
	}

}
