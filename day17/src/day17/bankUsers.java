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
			System.out.println("1. ȸ�� ����");
			System.out.println("2. Ż��");
			System.out.println("3. ���");
			int slt = sc.nextInt();
			if (slt == 1) {
				System.out.println("�̸��� �Է��ϼ���");
				bank[cnt].id = sc.next();
				System.out.println("�ݾ��� �Է��ϼ���");
				bank[cnt].money = sc.nextInt();
				cnt++;
			} else if (slt == 2) {
				System.out.println("�ε����� �Է��ϼ���");
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
