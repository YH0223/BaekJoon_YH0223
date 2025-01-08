package q10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String settings=br.readLine();
		int[] set = Arrays.stream(settings.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		String nums=br.readLine();
		int[] numArray = Arrays.stream(nums.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
		int[] res;
		if(numArray.length>set[0]) {
			System.out.println("error00");
		}
		for(int i=0;i<numArray.length;i++) {
			if(numArray[i]<set[1]) {
				System.out.print(numArray[i]+" ");
			}
		}
		
		br.close();
		
	}

}
