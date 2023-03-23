import java.util.ArrayList;
import java.util.Scanner;

public class JobVacancy {

	Scanner scan = new Scanner(System.in);
	int choose;
	String name;
	String position;
	int age;
	String search;
	
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<String> positionList = new ArrayList<>();
	ArrayList<Integer> ageList = new ArrayList<>();
	
	public JobVacancy() {
		Menu();
	}

	public void Menu() {
		do {
			System.out.println("Job Vacancy");
			System.out.println("===========");
			System.out.println("1. Insert new staff");
			System.out.println("2. List of staff");
			System.out.println("3. Search staff");
			System.out.println("4. Exit");
			System.out.print("Choose: ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 404;
			} scan.nextLine();
		} while (choose < 1 || choose > 4);
		System.out.println();
		
		if (choose == 1) {
			Insert();
		} else if (choose == 2) {
			List();
		} else if (choose == 3) {
			Search();
		} else if (choose == 4) {
			System.exit(0);
		}
	}
	
	public void Insert() {
		
		do {
			System.out.print("Input staff's name [3-20]: ");
			name = scan.nextLine();
		} while (name.length() < 3 || name.length() > 20);
		nameList.add(name);
		
		do {
			System.out.print("Input staff's position [Manager | Analyst | Programmer]: ");
			position = scan.nextLine();
		} while (!(position.equalsIgnoreCase("Manager")) && !(position.equalsIgnoreCase("Analyst")) && !(position.equalsIgnoreCase("Programmer")));
		positionList.add(name);
		
		do {
			System.out.print("Input staff's age [larger than 17 years old]: ");
			try {
				age = scan.nextInt();
			} catch (Exception e) {
				age = 404;
			} scan.nextLine();
		} while (age <= 17);
		ageList.add(age);
		
		System.out.println("Data has been successfully inserted!");
		Menu();
	}
	
	public void List() {
		
		if (nameList.isEmpty()) {
			System.out.println("No Data!");
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println("Staff ID       : " + (i+1));
				System.out.println("====================");
				System.out.println("1. Name        : " + nameList.get(i));
				System.out.println("2. Position    : " + positionList.get(i));
				System.out.println("3. Age         : " + ageList.get(i));
				System.out.println();
			}
		}
		Menu();
	}
	
	public void Search() {
		
		do {
			System.out.println("Input staff's name [3-20]: ");
			search = scan.nextLine();
		} while (!nameList.contains(search));
		
		System.out.println("Staff ID       : " + (nameList.indexOf(search)));
		System.out.println("====================");
		System.out.println("1. Name        : " + nameList.get(nameList.indexOf(search)));
		System.out.println("2. Position    : " + positionList.get(nameList.indexOf(search)));
		System.out.println("3. Age         : " + ageList.get(nameList.indexOf(search)));
		System.out.println();
		Menu();
	}
	
	public static void main(String[] args) {
		new JobVacancy();

	}

}
