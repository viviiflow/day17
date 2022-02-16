package day17;

import java.util.Scanner;

class Banks {
	String id;
	int money;
}

public class bankUsers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 100;
		int cnt = 0;
		Banks[] bank = new Banks[max];
		for (int i = 0; i < max; i++) {
			bank[i] = new Banks();
		}
		while (true) {
			System.out.println("1. 회원 가입");
			System.out.println("2. 탈퇴");
			System.out.println("3. 출력");
			int slt = sc.nextInt();
			if (slt == 1) {
				System.out.println("이름을 입력하세요");
				bank[cnt].id = sc.next();
				System.out.println("금액을 입력하세요");
				bank[cnt].money = sc.nextInt();
				cnt++;
			} else if (slt == 2) {
				System.out.println("인덱스를 입력하세요");
				int idx = sc.nextInt();
				for (int i = idx; i < cnt - 1; i++) {
					bank[i].id = bank[i + 1].id;
					bank[i].money = bank[i + 1].money;
				}
				bank[cnt-1].id = "";
				bank[cnt - 1].money = 0;
				cnt--;
			}else if(slt==3) {
				for (int i = 0; i < cnt; i++) {
					System.out.println(bank[i].id+" "+bank[i].money);
				}
			}
		}
	}
}
