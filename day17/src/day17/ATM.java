package day17;

import java.util.Scanner;

class bank {
	String name = "";
	String[] acc = { "1111", "2222", "3333", "", "" };
	String[] pw = { "1234", "2345", "3456", "", "" };
	int[] money = { 87000, 34000, 17500, 0, 0 };
	int cnt = 3;
	int nc = -1;

	int idx(String[] a, String b) {
		int n = -1;
		for (int i = 0; i < cnt; i++) {
			if (b.equals(a[i])) {
				n = i;
			}
		}
		return n;
	}

	void sort(String[] a) {
		for (int i = nc; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[4] = "";
	}

	void sort2(int[] a) {
		for (int i = nc; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[4] = 0;
	}
}

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		bank a = new bank();
		int ox = -1;
		while (true) {
			a.name = "";
			for (int i = 0; i < a.cnt; i++) {
				a.name += a.acc[i] + "\t" + a.pw[i] + "\t" + a.money[i] + "\n";
			}
			a.name = a.name.substring(0, a.name.length() - 1);
			System.out.println("----------------------");
			System.out.println("���¹�ȣ\t��й�ȣ\t�����ܾ�");
			System.out.println("----------------------");
			System.out.println(a.name);
			System.out.println("----------------------");
			try {
				System.out.println("����: " + a.acc[a.nc] + " �α���");
			} catch (Exception e) {
				System.out.println("����: �α׾ƿ�");
			}
			System.out.println("----------------------");
			System.out.println("[NH Bank]");
			System.out
					.println("[1] ȸ������\n[2] ȸ��Ż��\n[3] �α���\n[4] �α׾ƿ�\n[5] �Ա��ϱ�\n[6] ��ü�ϱ�\n[7] �ܾ���ȸ\n[0] �����ϱ�\n�޴� ���� : ");
			int slt = sc.nextInt();

			if (slt == 0) { // ����
				System.out.println("�����մϴ�.");
				break;
			} else if ((slt == 1) && (a.nc == -1)) {// ����
				while (true) {
					if (a.cnt == 5) {
						System.out.println("���� �ο� �ʰ�");
						break;
					} else {
						System.out.println("[����] ���¹�ȣ �Է�");
						String uacc = sc.next();
						ox = a.idx(a.acc, uacc);
						// System.out.println(ox);
						if (ox != -1) {
							System.out.println("�̹� ���Ե� �����Դϴ�.");
						} else {
							System.out.println("[����] ��й�ȣ �Է�");
							String upw = sc.next();
							a.acc[a.cnt] = uacc;
							a.pw[a.cnt] = upw;
							a.money[a.cnt] += 1000;
							a.cnt++;
							break;
						}
					}
				}
			} else if ((slt == 2) && (a.nc != -1)) {// Ż��
				while (true) {
					System.out.println("[�α���] ���¹�ȣ �Է�");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[�α���] ��й�ȣ �Է�");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox != ox2) || (ox != a.nc)) {
						System.out.println("���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
					} else {
						a.sort(a.acc);
						a.sort(a.pw);
						a.sort2(a.money);
						a.nc=-1;
						System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
						a.cnt--;
						break;
					}
				}
			} else if ((slt == 3) && (a.nc == -1)) {// �α���
				while (true) {
					System.out.println("[�α���] ���¹�ȣ �Է�");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[�α���] ��й�ȣ �Է�");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox == -1) || (ox != ox2)) {
						System.out.println("���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
					} else {
						a.nc = ox;
						System.out.println("�α����� �Ϸ�Ǿ����ϴ�.");
						break;
					}
				}
			} else if ((slt == 4) && (a.nc != -1)) {// �α׾ƿ�
				while (true) {
					System.out.println("[�α׾ƿ�] ���¹�ȣ �Է�");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[�α׾ƿ�] ��й�ȣ �Է�");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox != a.nc) || (ox != ox2)) {
						System.out.println("���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
					} else {
						a.nc = -1;
						System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�.");
						break;
					}
				}
			} else if ((slt == 5) && (a.nc != -1)) {// �Ա�
				while (true) {
					System.out.println("[�Ա�] ��й�ȣ �Է�");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						System.out.print("�ݾ� �Է�: ");
						int n = sc.nextInt();
						a.money[a.nc] += n;
						System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
						break;
					} else {
						System.out.println("��й�ȣ�� �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
					}
				}
			} else if ((slt == 6) && (a.nc != -1)) {// ��ü
				while (true) {
					System.out.println("[��ü] ��й�ȣ �Է�");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						while (true) {
							System.out.println("[��ü] �޴� ��� ���� �Է�");
							String snd = sc.next();
							ox = a.idx(a.acc, snd);
							if ((ox == -1) || (ox == a.nc)) {
								System.out.println("�ش� ���°� �������� �ʽ��ϴ�.");
							} else {
								while (true) {
									System.out.print("�ݾ� �Է�: ");
									int n = sc.nextInt();
									if (n > a.money[a.nc]) {
										System.out.println("�ܰ� �ʰ�");
									} else {
										a.money[ox] += n;
										a.money[a.nc] -= n;
										System.out.println("��ü�� �Ϸ�Ǿ����ϴ�.");
										break;
									}
								}
								break;
							}
						}
						break;
					} else {
						System.out.println("��й�ȣ�� �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
					}
				}
			} else if ((slt == 7) && (a.nc != -1)) {// �ܾ���ȸ
				while (true) {
					System.out.println("[��ȸ] ��й�ȣ �Է�");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						System.out.println(a.acc[a.nc] + "���� ���� �ܰ�� " + a.money[a.nc] + "���Դϴ�.");
						break;
					} else {
						System.out.println("��й�ȣ�� �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
					}
				}
			} else if (a.nc != -1) {
				System.out.println("�α׾ƿ� �� �̿��Ͽ� �ֽñ� �ٶ��ϴ�.");
			} else {
				System.out.println("�α��� �� �̿��Ͽ� �ֽñ� �ٶ��ϴ�.");
			}
		}
	}
}
