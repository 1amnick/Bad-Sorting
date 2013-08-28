public class Method {
	
	static int[] num;
	public static int[] run(int[] numbers) {

		num = numbers;
		int[] sorted = new int[num.length];
		int randMax = findLarge(num);
		boolean sortedBool = false;
		do
		{
			magic(num, sorted, randMax);
			sortedBool = isSorted(sorted);
			if(sortedBool == true){
				sortedBool = false;
				//check if we have all the numbers
				sortedBool = check(num, sorted);

			}
		}
		while(sortedBool == false);




		return sorted;
	}

	private static boolean check(int[] num, int[] sorted) {
		int[] count = new int[num.length];
		for(int j = 0; j< sorted.length; j++){
			for(int i = 0; i< sorted.length; i++){
				if(sorted[i] == num[j]){
					count[j]++;	
				}

			}
		}
		if(checkCount(count) == true){
			return true;
		}
		return false;
	}

	private static boolean checkCount(int[] count) {
		for(int i = 0; i< count.length; i++){
			if(count[i] != 1){
				return false;
			}
		}
		return true;
	}

	private static boolean isSorted(int[] sorted) {
		for(int i = 0; i< sorted.length-1; i++){
			if(sorted[i] > sorted[i+1]){
				return false;
			}
		}
		return true;
	}

	public static void magic(int[] num, int[] sorted, int randMax) {
		for(int i = 0; i< num.length; i++){
			sorted[i] = (int) (Math.random() * randMax + 1);
		}
	}

	private static int findLarge(int[] num) {
		int max = num[0];
		for(int i = 0; i< num.length; i++){
			if(num[i] > max){
				max = num[i];
			}

		}
		System.out.println("The largest value found is: " + max);
		return max;
	}

}
