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
			System.out.println("계좌번호\t비밀번호\t계좌잔액");
			System.out.println("----------------------");
			System.out.println(a.name);
			System.out.println("----------------------");
			try {
				System.out.println("상태: " + a.acc[a.nc] + " 로그인");
			} catch (Exception e) {
				System.out.println("상태: 로그아웃");
			}
			System.out.println("----------------------");
			System.out.println("[NH Bank]");
			System.out
					.println("[1] 회원가입\n[2] 회원탈퇴\n[3] 로그인\n[4] 로그아웃\n[5] 입금하기\n[6] 이체하기\n[7] 잔액조회\n[0] 종료하기\n메뉴 선택 : ");
			int slt = sc.nextInt();

			if (slt == 0) { // 종료
				System.out.println("종료합니다.");
				break;
			} else if ((slt == 1) && (a.nc == -1)) {// 가입
				while (true) {
					if (a.cnt == 5) {
						System.out.println("가입 인원 초과");
						break;
					} else {
						System.out.println("[가입] 계좌번호 입력");
						String uacc = sc.next();
						ox = a.idx(a.acc, uacc);
						// System.out.println(ox);
						if (ox != -1) {
							System.out.println("이미 가입된 계좌입니다.");
						} else {
							System.out.println("[가입] 비밀번호 입력");
							String upw = sc.next();
							a.acc[a.cnt] = uacc;
							a.pw[a.cnt] = upw;
							a.money[a.cnt] += 1000;
							a.cnt++;
							break;
						}
					}
				}
			} else if ((slt == 2) && (a.nc != -1)) {// 탈퇴
				while (true) {
					System.out.println("[로그인] 계좌번호 입력");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[로그인] 비밀번호 입력");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox != ox2) || (ox != a.nc)) {
						System.out.println("아이디 혹은 비밀번호가 틀립니다.");
					} else {
						a.sort(a.acc);
						a.sort(a.pw);
						a.sort2(a.money);
						a.nc=-1;
						System.out.println("탈퇴가 완료되었습니다.");
						a.cnt--;
						break;
					}
				}
			} else if ((slt == 3) && (a.nc == -1)) {// 로그인
				while (true) {
					System.out.println("[로그인] 계좌번호 입력");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[로그인] 비밀번호 입력");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox == -1) || (ox != ox2)) {
						System.out.println("아이디 혹은 비밀번호가 틀립니다.");
					} else {
						a.nc = ox;
						System.out.println("로그인이 완료되었습니다.");
						break;
					}
				}
			} else if ((slt == 4) && (a.nc != -1)) {// 로그아웃
				while (true) {
					System.out.println("[로그아웃] 계좌번호 입력");
					String uacc = sc.next();
					ox = a.idx(a.acc, uacc);
					System.out.println("[로그아웃] 비밀번호 입력");
					String upw = sc.next();
					int ox2 = a.idx(a.pw, upw);
					if ((ox != a.nc) || (ox != ox2)) {
						System.out.println("아이디 혹은 비밀번호가 틀립니다.");
					} else {
						a.nc = -1;
						System.out.println("로그아웃이 완료되었습니다.");
						break;
					}
				}
			} else if ((slt == 5) && (a.nc != -1)) {// 입금
				while (true) {
					System.out.println("[입금] 비밀번호 입력");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						System.out.print("금액 입력: ");
						int n = sc.nextInt();
						a.money[a.nc] += n;
						System.out.println("입금이 완료되었습니다.");
						break;
					} else {
						System.out.println("비밀번호를 다시 입력해주시길 바랍니다.");
					}
				}
			} else if ((slt == 6) && (a.nc != -1)) {// 이체
				while (true) {
					System.out.println("[이체] 비밀번호 입력");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						while (true) {
							System.out.println("[이체] 받는 사람 계좌 입력");
							String snd = sc.next();
							ox = a.idx(a.acc, snd);
							if ((ox == -1) || (ox == a.nc)) {
								System.out.println("해당 계좌가 존재하지 않습니다.");
							} else {
								while (true) {
									System.out.print("금액 입력: ");
									int n = sc.nextInt();
									if (n > a.money[a.nc]) {
										System.out.println("잔고 초과");
									} else {
										a.money[ox] += n;
										a.money[a.nc] -= n;
										System.out.println("이체가 완료되었습니다.");
										break;
									}
								}
								break;
							}
						}
						break;
					} else {
						System.out.println("비밀번호를 다시 입력해주시길 바랍니다.");
					}
				}
			} else if ((slt == 7) && (a.nc != -1)) {// 잔액조회
				while (true) {
					System.out.println("[조회] 비밀번호 입력");
					String upw = sc.next();
					ox = a.idx(a.pw, upw);
					if (ox == a.nc) {
						System.out.println(a.acc[a.nc] + "님의 통장 잔고는 " + a.money[a.nc] + "원입니다.");
						break;
					} else {
						System.out.println("비밀번호를 다시 입력해주시길 바랍니다.");
					}
				}
			} else if (a.nc != -1) {
				System.out.println("로그아웃 후 이용하여 주시길 바랍니다.");
			} else {
				System.out.println("로그인 후 이용하여 주시길 바랍니다.");
			}
		}
	}
}
