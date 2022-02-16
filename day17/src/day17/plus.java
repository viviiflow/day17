package day17;

import java.util.Scanner;
import java.util.Random;

class Add {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] midx = new int[3];
	int total = 0;

	void random(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a == midx) {
				System.out.print("인덱스" + (i + 1) + " 입력: ");
				a[i] = sc.nextInt();
			} else {
				a[i] = ran.nextInt(n) + 1;
			}
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					if (a == midx) {
						System.out.println("중복된 인덱스입니다.");
					}
					i--;
					break;
				}
			}
		}
	}

	int sum(int[] a, int[] n) {
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += a[n[i]];
		}
		return sum;
	}
}

public class plus {
	public static void main(String[] args) {

		Add a = new Add();
		a.random(a.game, 10);
		a.random(a.idx, 5);
		for (int i = 0; i < a.game.length; i++) {
			System.out.print(a.game[i] + " ");
		}
		System.out.println();
		a.total = a.sum(a.game, a.idx);
		System.out.println("total: " + a.total);
		while (true) {
			a.random(a.midx, 0);
			int my = a.sum(a.game, a.midx);
			System.out.println("my total: " + my);
			if (a.total == my) {
				System.out.println("성공");
				break;
			} else {
				System.out.println("다시");
			}
		}
	}
}
