package day17;

import java.util.Random;

class RanNum {
	int num;
}

public class randomNumber {
	public static void main(String[] args) {
		Random ran = new Random();
		RanNum[] arr = new RanNum[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new RanNum();
			arr[i].num = ran.nextInt(5) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i].num == arr[j].num) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].num);
		}
	}
}
