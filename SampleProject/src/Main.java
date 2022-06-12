import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	// 주요 명령어
	// 1. 세로쓰기 : shift + A + alt
	// 2. 줄 맞추기 : ctrl + shift + F
	// 3. constructor, getter, setter : shift + S + alt

	public static void main(String[] args) {
		System.out.println("=================================");
		System.out.println("동물농장에 오신 것을 환영합니다!");
		System.out.println("=================================");
		Farm<Pig> pigFarm = new Farm<>();
		Farm<Chicken> chickenFarm = new Farm<>();

		while (true) {
			System.out.println();
			System.out.println("1을 입력하면 추가, 2를 입력하면 조회, 3을 입력하면 수정, 4를 입력하면 삭제 입니다. : ");
			Scanner sc = new Scanner(System.in);
			int command = sc.nextInt();

			if (command == 1) {
				System.out.println("추가할 동물의 종류를 말씀해주세요!(1 : 닭, 2 : 돼지)");
				int species = Integer.parseInt(sc.next());
				// 닭
				if (species == 1) {
					System.out.println("닭의 이름과 나이를 말씀해주세요(양식 : 꼬꼬,4)");
					// 한 줄 입력을 받겠다는 뜻
					String input = sc.next();
					StringTokenizer st = new StringTokenizer(input, ",");
					String name = st.nextToken();
					int age = Integer.parseInt(st.nextToken());
					chickenFarm.list.add(new Chicken(name, age, true));
				} else {// 돼지
					System.out.println("돼지의 이름과 나이를 말씀해주세요(양식 : 꿀꿀,4)");
					// 한 줄 입력을 받겠다는 뜻
					String input = sc.next();
					StringTokenizer st = new StringTokenizer(input, ",");
					String name = st.nextToken();
					int age = Integer.parseInt(st.nextToken());
					pigFarm.list.add(new Pig(name, age, true));
				}

			} else if (command == 2) {
				System.out.println("조회할 동물의 종류를 말씀해주세요(1 : 닭, 2 : 돼지)");
				int species = sc.nextInt();
				if (species == 1) {
					System.out.println("해당 동물의 재고는 "
							+ chickenFarm.list.stream()
									.filter(chicken -> chicken.isAlive() == true).count()
							+ "입니다.");
					System.out.println("===================");
					System.out.println("◇ 해당 동물 리스트 ◇");
					for (Chicken chicken : chickenFarm.list) {
						System.out.println(chicken.toString());
					}
					System.out.println("===================");
				} else {
					System.out
							.println("해당 동물의 재고는 "
									+ pigFarm.list.stream()
											.filter(a -> a.isAlive() == true).count()
									+ "입니다.");
				}
			} else if (command == 3) {
				System.out.println("수정할 동물의 종류를 말씀해주세요(1 : 닭, 2 : 돼지)");
				int species = Integer.parseInt(sc.next());
				if (species == 1) {
					System.out.println("수정할 동물의 이름과 나이를 말씀해주세요(양식 : 꼬꼬,2)");
					StringTokenizer st = new StringTokenizer(sc.next(), ",");
					String name = st.nextToken();
					int newAge = Integer.parseInt(st.nextToken());
					for (Chicken chicken : chickenFarm.list) {
						if (name.equals(chicken.getName())) {
							chicken.setAge(newAge);
						}
					}
					System.out.println("닭이 수정되었습니다.");
				} else {
					System.out.println("수정할 동물의 이름과 나이를 말씀해주세요(양식 : 뚱땡,1)");
					StringTokenizer st = new StringTokenizer(sc.next(), ",");
					String name = st.nextToken();
					int newAge = Integer.parseInt(st.nextToken());
					for (Pig pig : pigFarm.list) {
						if (name.equals(pig.getName())) {
							pig.setAge(newAge);
						}
					}
					System.out.println("돼지가 수정되었습니다.");
				}

			} else if (command == 4) {
				System.out.println("삭제할 동물의 종류를 말씀해주세요(1 : 닭, 2 : 돼지)");
				int species = Integer.parseInt(sc.next());
				if (species == 1) {
					System.out.println("삭제할 동물의 이름을 말씀해주세요.");
					String name = sc.next();
					for (Chicken chicken : chickenFarm.list) {
						if (name.equals(chicken.getName())) {
							chicken.setAlive(false);
						}
					}
					System.out.println("닭이 삭제되었습니다.");
				} else {
					System.out.println("삭제할 동물의 이름을 말씀해주세요.");
					String name = sc.next();
					for (Pig pig : pigFarm.list) {
						if (name.equals(pig.getName())) {
							pig.setAlive(false);
						}
					}
					System.out.println("돼지가 삭제되었습니다.");
				}

			}
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
		String name;
		int age;
		boolean isAlive;

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

		@Override
		public String toString() {
			return "이름은 " + this.name + "이고, 나이는 " + this.age;
		}

	}

	private static class Chicken extends Animal {

		public Chicken(String name, int age, boolean isAlive) {
			this.name = name;
			this.age = age;
			this.isAlive = isAlive;
		}

		public Chicken() {
			super();
		}

		@Override
		public String toString() {
			return super.toString();
		}
	}

	private static class Pig extends Animal {

		public Pig(String name, int age, boolean isAlive) {
			super(name, age, isAlive);
		}

		public Pig() {
			super();
		}

		@Override
		public String toString() {
			return super.toString();
		}
	}

}
