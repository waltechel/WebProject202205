import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// 주요 명령어
	// 1. 세로쓰기 : shift + A + alt
	// 2. 줄 맞추기 : ctrl + shift + F
	// 3. constructor, getter, setter : shift + S + alt

	public static void main(String[] args) {
		System.out.println("동물농장에 오신 것을 환영합니다!");
		System.out.println("1을 입력하면 추가, 2를 입력하면 조회, 3을 입력하면 수정, 4를 입력하면 삭제 입니다. : ");
		Scanner sc = new Scanner(System.in);
		int command = sc.nextInt();
		Farm<Pig> pigFarm = new Farm<>();
		Farm<Chicken> chickenFarm = new Farm<>();

		if (command == 1) {

		} else if (command == 2) {
			System.out.println("조회할 동물의 종류를 말씀해주세요(1 : 닭, 2 : 돼지)");
			int species = sc.nextInt();
			if (species == 1) {
				System.out.println("해당 동물의 재고는 "
						+ chickenFarm.list.stream()
								.filter(chicken -> chicken.isAlive() == true)
								.count()
						+ "입니다.");
			} else {
				System.out.println("해당 동물의 재고는 "
						+ pigFarm.list.stream().filter(a -> a.isAlive() == true).count()
						+ "입니다.");
			}
		} else if (command == 3) {

		} else if (command == 4) {

		}

	}

	private static class Farm<T> {
		ArrayList<T> list;

		public Farm(ArrayList<T> list) {
			super();
			this.list = list;
		}

		public Farm() {
			super();
			this.list = new ArrayList<>();
		}

	}

	private static class Animal {
		private String name;
		private int age;
		private boolean isAlive;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public boolean isAlive() {
			return isAlive;
		}

		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}

		// allArgsConstructor
		public Animal(String name, int age, boolean isAlive) {
			super();
			this.name = name;
			this.age = age;
			this.isAlive = isAlive;
		}

		// noArgsConstructor
		public Animal() {
			this.name = "";
			this.age = 0;
			this.isAlive = false;
		}

	}

	private static class Chicken extends Animal {
	}

	private static class Pig extends Animal {
	}

}
