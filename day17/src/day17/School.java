package day17;

import java.util.Scanner;

class Subject {
	String name;
	int score;
}

class Student {
	Subject[] sub;
	String name;

	void run(Subject[] a, int n) {
		for (int i = 0; i < n; i++) {
			a[i] = new Subject();
		}
	}
}

public class School {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student[] st = new Student[3];
		for (int i = 0; i < 3; i++) {
			st[i] = new Student();
		}
		st[0].sub = new Subject[3];
		st[0].run(st[0].sub, 3);
		st[1].sub = new Subject[2];
		st[1].run(st[1].sub, 2);
		st[2].sub = new Subject[1];
		st[2].run(st[2].sub, 1);

		int cnt = 0, n1 = 0, n2 = 0, n3 = 0;
		while (true) {
			System.out.println("=============");
			for (int i = 0; i < st.length; i++) {
				if (st[i].name == null) {
					continue;
				} else {
					System.out.println("[" + (i + 1) + "]" + st[i].name + "�л�>>>");
					for (int j = 0; j < st[i].sub.length; j++) {
						if (st[i].sub[j].name == null) {
							continue;
						} else {
							System.out.println(
									"[" + (i + 1) + "-" + (j + 1) + "]" + st[i].sub[j].name + " " + st[i].sub[j].score);
						}
					}
				}
			}
			System.out.println("=============");
			System.out.println("[1]�л� �߰��ϱ�");
			System.out.println("[2]���� �߰��ϱ�");
			System.out.println("[3]���� �߰��ϱ�");
			int slt = sc.nextInt();
			if (slt == 0) {
				break;
			} else if (slt == 1) {
				if(cnt<3) {
					System.out.print("�̸� �Է�: ");
					st[cnt].name = sc.next();
					cnt++;
				}else {
					System.out.println("�� �̻� �߰��� �� �����ϴ�.");
				}
			} else if (slt == 2) {
				System.out.print("��ȣ �Է�: ");
				int idx = sc.nextInt();
				System.out.print("���� �Է�: ");
				for (int i = 0; i < st[idx - 1].sub.length; i++) {
					if (st[idx - 1].sub[i].name == null) {
						st[idx - 1].sub[i].name = sc.next();
						break;
					}
				}
				System.out.println();
			} else if (slt == 3) {
				System.out.print("��ȣ �Է�: ");
				int idx = sc.nextInt();
				System.out.print("���� �Է�: ");
				String s = sc.next();
				for (int i = 0; i < st[idx - 1].sub.length; i++) {
					if (st[idx - 1].sub[i].name.equals(s)) {
						System.out.print("���� �Է�: ");
						st[idx - 1].sub[i].score = sc.nextInt();
						break;
					}
				}
				System.out.println();
			}
		}
	}
}
