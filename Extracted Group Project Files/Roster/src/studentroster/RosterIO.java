package studentroster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RosterIO {
	
	protected ArrayList<String> rosterTxtFiles=new ArrayList<>();

	public static String writeRosterFile(String fileName, Roster r) {
		try {
			if(!fileName.contains(".txt")) {
				fileName +=".txt";
			}
			File outFile = new File(fileName);
			PrintWriter writer = new PrintWriter(outFile);
			for(int i=0; i<r.getRosterSize();i++) {
				Student s = r.getStudentAt(i);
				writer.print(s.getId()+" "+s.getLastName()+" "+s.getFirstName()+" "+s.getClassification()+" "+ s.getGrade()+" "+s.getAcademicProgress());
				writer.println();
			}
			writer.close();
			System.out.print("File \""+outFile.getName()+"\" written.");
			System.out.println();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static String writeStudentsFromUser(String fileName, ArrayList<Student> students) {
		try {
			if(!fileName.contains(".txt")) {
				fileName += ".txt";
			}
			File out = new File(fileName);
			PrintWriter writer = new PrintWriter(out);
			for(Student s: students) {
				writer.print(s.getId()+" "+s.getLastName()+" "+s.getFirstName()+" "+s.getClassification()+" "+ s.getGrade()+" "+s.getAcademicProgress());
				writer.println();
			}
			writer.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Error writing file.");
			e.printStackTrace();
		}
		return fileName;
	}

	public static Roster readRosterFile(String fileName) {
		Roster roster = new Roster();
		if(!fileName.contains(".txt")) {
			fileName +=".txt";
		}
		File inFile = new File(fileName);
		try {
			Scanner in = new Scanner(inFile);
			
			while(in.hasNext()) {
				String line = in.nextLine();
				String[] tokens = line.split("\\s");
				if(isStudent(tokens)) {
					int id = Integer.parseInt(tokens[0]);
					double grade = Double.parseDouble(tokens[4]);
					double acadPro = Double.parseDouble(tokens[5]);
					Student s = new Student(id, tokens[1], tokens[2], tokens[3], grade, acadPro);
					roster.addStudent(s);
				}
			}
			in.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getCause());
		}
		return roster;
	}
	
	public static ArrayList<Student> readStudentsFile(String fileName) {
		ArrayList<Student> draft = new ArrayList<>();
		File inFile = new File(fileName);
		try {
			Scanner in = new Scanner(inFile);
			
			while(in.hasNext()) {
				String line = in.nextLine();
				String[] tokens = line.split("\\s");
				if(isStudent(tokens)) {
					int id = Integer.parseInt(tokens[0]);
					double grade = Double.parseDouble(tokens[4]);
					double acadPro = Double.parseDouble(tokens[5]);
					Student s = new Student(id, tokens[1], tokens[2], tokens[3], grade, acadPro);
					draft.add(s);
				}
			}
			in.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getCause());
		}
		return draft;
	}
	
	public static Student createStudent(Roster r) {
		Scanner userInput = new Scanner(System.in);
		//ID
		System.out.print("Enter a number 100-999: ");
		int id = userInput.nextInt();

		System.out.print("Enter student's first name: ");
		String fName = userInput.next();

		System.out.print("Enter student's last name: ");
		String lName = userInput.next();

		System.out.print("Options: Freshman, Sophomore, Junior, Senior\nEnter student's classification: ");
		String c = userInput.next();

		System.out.print("Enter student's grade for the class: ");
		double grade = userInput.nextDouble();

		System.out.print("Enter student's academic progress: ");
		double acadPro = userInput.nextDouble();

		//Creating student
		Student s = new Student(id,lName,fName,c,grade,acadPro);
		System.out.print("Student created:\n"+s);
		System.out.println();
		System.out.print("Do you wish to add the student you created(Yes/Y or No/N): ");
		String answer = userInput.next();
		if(yes(answer)) {
			r.addStudent(s);
		}
		userInput.close();
		return s;
	}
	
	public static void removeStudentByID(Roster r) {
		Scanner user = new Scanner(System.in);
		System.out.println("What is the ID of the student you wish to remove? ");
		int key=user.nextInt();
		Student found = r.getStudentWithID(key);
		if(found==null) {
			System.out.println("There's no student with id '"+key+"'. Here's the roster: \n"+r.toString()+"\nChoose an id that exists in the roster: ");
			int key2 = user.nextInt();
			Student found2 = r.getStudentWithID(key2);
			System.out.println("Student that you wish delete: "+found2);
			System.out.println();
			String answer=confirmation(user, "remove");
			if(yes(answer)) {
				r.removeStudent(key2);
				System.out.println();
			}
		}
		System.out.println("Student that you wish delete: "+found);
		System.out.println();
		String answer=confirmation(user, "remove");
		if(yes(answer)) {
			r.removeStudent(key);
			System.out.println();
		}
	}
	
	public static void removeStudentByName(Roster r) {
		Scanner user = new Scanner(System.in);
		System.out.println("What is the name of the student you wish to remove? ");
		String name=user.next();
		Student found=r.removeStudent(name);
		if(found==null) {
			System.out.println("There's no student with that name. Here's the roster: \n"+r.toString()+"\nChoose a name that exists in the roster: ");
			String name2=user.next();
			r.removeStudent(name2);
			System.out.println();
		}
	}
	
	public static void remove(Roster r) {
		Scanner user = new Scanner(System.in);
		System.out.print("How would you like to remove the student? Name or Id? ");
		String answer=user.next().toLowerCase();
		if(answer.equals("name")) {
			removeStudentByName(r);
		}
		else if(answer.equals("id")) {
			removeStudentByID(r);
		}
	}
	
	public void createStudentsManually(Roster r){
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Student> draft = new ArrayList<>();
		Scanner user = new Scanner(System.in);
		//Get the number of students the user wants to create
		System.out.print("How many students do you want to create? ");
		int num=user.nextInt();
		String ids="";
		for(int i=0;i<num;i++) {
			//ID
			System.out.print("IDs that were already used: "+ids+"\nEnter a number 100-999: ");
			int id = user.nextInt();
			//firstName
			System.out.print("Enter student's first name: ");
			String fName = user.next();
			//lastName
			System.out.print("Enter student's last name: ");
			String lName = user.next();
			//Classification
			System.out.print("Options: Freshman, Sophomore, Junior, Senior\nEnter student's classification: ");
			String c = user.next();
			//Grade
			System.out.print("Enter student's grade for the class: ");
			double grade = user.nextDouble();
			//Academic Progress
			System.out.print("Enter student's academic progress: ");
			double acadPro = user.nextDouble();
			
			//Creating student
			Student s = new Student(id,lName,fName,c,grade,acadPro);
			System.out.print("Student created:\n"+s);
			System.out.println();
			System.out.print("Do you wish to add the student you created(Yes/Y or No/N): ");
			String answer = user.next();
			if(yes(answer)) {
				students.add(s);
				ids+=s.getId()+" ";
			}
			else {
				if(!yes(answer)) {
					System.out.print("Do you wish to add the student to draft? ");
					String answerD = user.next();
					if(!yes(answerD)) {
						String answerC=confirmation(user,"add");
						if(!yes(answerC)) {
							ids+=s.getId()+" ";
							draft.add(s);
						}
					}
					ids+=s.getId()+" ";
					draft.add(s);
				}
			}
		}
		int draftnum=draft.size();
		if(draftnum>0) {
			addFromDraft(draftnum,draft,students,user);
			String answer=confirmation(user, "addm");
			if(yes(answer)) {
				draft.clear();
			}
			int draftnum2 = draft.size();
			addFromDraft(draftnum2,draft,students,user);
		}
		for(Student s: students) {
			r.addStudent(s);
		}
		loadRosterIntoTxtFile(r);
	}
	
	public void createStudentsViaText(Roster r) {
		Scanner user = new Scanner(System.in);
		System.out.println("Format for a text file of Students: ID LastName FirstName Classification Grade AcademicProgress\nDo you already have a text file of students (in the format above) created?(Yes/Y or No/N) ");
		String answer = user.next();
		if(yes(answer)) {
			System.out.print("Enter the text file name with the path: ");
			String fileName=user.next();
			createFromUserTxtFile(fileName,user,r);
		}
		else {
			createViaProvidedTxtFile(user,r);
		}
		loadRosterIntoTxtFile(r);
	}
	
	public void createStudents(Roster r) {
		Scanner user=new Scanner(System.in);
		System.out.print("Options for creating students for a roster\n------------------------------\n1.) Manually\n2.) Via Text File\n\nEnter the option's number: ");
		int num=user.nextInt();
		if(num==1) {
			String answer=confirmation(user, "createm");
			if(yes(answer)) {
				createStudentsManually(r);
			}
			createStudentsViaText(r);
		}
		else if(num==2) {
			createStudentsViaText(r);
		}
		
	}
	
	public String loadRosterFromTxtFile() {
		if(rosterTxtFiles.size()>0) {
			String txtFiles="Rosters text file(s):\n-------------------";
			for(int i=0;i<rosterTxtFiles.size();i++) {
				txtFiles+="\n"+(i+1)+".) "+rosterTxtFiles.get(i);
			}
			Scanner user=new Scanner(System.in);
			System.out.print(txtFiles+"\nEnter the number of the roster you would like to load: ");
			int num=user.nextInt()-1;
			String txtName=rosterTxtFiles.get(num);
			return txtName;
		}
		return null;
	}
	
	public String loadRosterIntoTxtFile(Roster r) {
		int size = rosterTxtFiles.size();
		String fileName="src/studentroster/roster"+(size+1)+".txt";
		String file=writeRosterFile(fileName,r);
		ArrayList<Student> fileTxt=readStudentsFile(fileName);
		String print="\n"+printDraft(fileTxt);
		rosterTxtFiles.add(fileName);
		return print;
	}
	
	public static void updateRosterTxtFile(Roster r, String txtName) {
		writeRosterFile(txtName,r);
	}
	
	public static void displayStudents(Roster r) {
		Scanner user=new Scanner(System.in);
		int num=displayOptions(user);
		r.sortRoster(displayOptions.get(num));
		System.out.print(r);
	}
	
	public static void displayStudentsBetween(Roster r) {
		Scanner user=new Scanner(System.in);
		System.out.print("Do you want to the student between grades or academics? ");
		String answer=user.next().toLowerCase();
		if(answer.contains("grade")) {
			System.out.print("Enter a grade percent: ");
			double grade1=user.nextDouble();
			System.out.print("Enter a second percent: ");
			double grade2=user.nextDouble();
			System.out.print("Student(s) between "+Math.min(grade1, grade2)+"-"+Math.max(grade1, grade2)+"\n-------------------------------\n");
			r.studentsBetween("grade", grade1, grade2).printOut();
		}
		else if(answer.contains("academic")) {
			System.out.print("Enter a percent: ");
			double acad1=user.nextDouble();
			System.out.print("Enter a second percent: ");
			double acad2=user.nextDouble();
			System.out.print("Student(s) between "+Math.min(acad1, acad2)+"-"+Math.max(acad1, acad2)+"\n-------------------------------\n");
			r.studentsBetween("academic", acad1, acad2).printOut();
		}
	}
	
	public static String confirmation(Scanner user,String type) {
		String t = type.toLowerCase();
		switch(t) {
		case "add":
			System.out.print("The student created will be deleted if Yes/Y. Are you sure that you do not wish to add student?");
			String answer = user.next();
			return answer;
		case "remove":
			System.out.print("Are you sure that you want to remove student above? ");
		    answer=user.next();
			return answer;
		case "addm":
			System.out.print("The student(s) in the draft will be deleted if Yes/Y. Are you sure that you do not wish to add student(s)?");
			answer=user.next();
			return answer;
		case "createm":
			System.out.print("This procress will be longer than creating students via text file.\nAre you sure that you want create students manually? ");
			answer=user.next();
			return answer;
		case "discard":
			System.out.print("The students will be deleted if Yes/Y. Are you sure that you wish to discard them? ");
			answer=user.next();
			return answer;
		}
		return null;
	}
	
	
	///------------------------------
	// Helper Methods
	//-------------------------------
	private static boolean isStudent(String[] tokens) {
		if(tokens.length==6&&isAnInteger(tokens[0])&&isAClassification(tokens[3])&&isADouble(tokens[4])&&isADouble(tokens[5])) {
			return true;
		}
		return false;
	}

	private static boolean isAnInteger(String token) {
		try {
			int val = Integer.parseInt(token);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}

	private static boolean isADouble(String token) {
		try {
			double val = Double.parseDouble(token);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}

	private static boolean isAClassification(String token) {
		String newToken = token.toLowerCase();
		ArrayList<String> c = new ArrayList<>(Arrays.asList("freshman","sophomore","junior","senior"));
		if(c.contains(newToken)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void printFile(String fileName) {
		Scanner input;
		try {
			input=new Scanner(new File(fileName));
			int i=1;
			while(input.hasNext()) {
				System.out.println(i+".) "+input.nextLine());
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getCause());
		}
		catch(RuntimeException rt) {
			System.out.println("Error reading written file. Incorrect format.");
		}
	}
	
	private static String printDraft(ArrayList<Student> draft) {
		String print="";
		for(int i=0;i<draft.size();i++) {
			Student s = draft.get(i);
			print+=(i+1)+".) "+s.getId()+" "+s.getLastName()+" "+s.getFirstName()+" "+s.getClassification()+" "+s.getGrade()+" "+s.getAcademicProgress()+"\n";
		}
		return print;
	}

	private static void createViaProvidedTxtFile(Scanner user, Roster r) {
		File userFile=new File("src/studentroster/studentsFromUser.txt");
		System.out.print("Go to text file \""+userFile.getName()+"\" , follow the format in the top line \nthen type enter once you placed the students in a text file.");
		String enter=user.next().toLowerCase();
		if(enter.equals("enter")) {
			ArrayList<Student> textFile=readStudentsFile("src/studentroster/studentsFromUser.txt");
			System.out.print(printDraft(textFile)+"\nHow many students do you want to add from the list? ");
			int num=user.nextInt();
			if(0<num&&num<textFile.size()) {
				for(int i=0;i<num;i++) {
					System.out.print("What is the id of the student you wish to add? ");
					int id=user.nextInt();
					findAddRemove(r,textFile,id);
				}
			}
			else if(num>textFile.size()){
				int diff=num-textFile.size();
				System.out.print("The number you input is "+diff+" numbers larger than the number of students on file.\nNote: if another number larger than the number of students on file is entered, the entire program will terminate. Enter a smaller number: ");
				int num2=user.nextInt();
				if(num2>textFile.size()) {
					System.exit(0);
				}
			}
			else if(num==textFile.size()) {
				for(Student s: textFile) {
					r.addStudent(s);
				}
				textFile.clear();
			}
			else {
				if(textFile.size()>0) {
					System.out.print(printDraft(textFile)+"\nThere are "+textFile.size()+" number of students that have not been added to the roster. Do you wish to discard them? ");
					String answerc=confirmation(user,"discard");
					if(yes(answerc)) {
						textFile.clear();
					}
					else {
						add(textFile, user, r);
					}
				}
			}
		}
	}
	
	private static void createFromUserTxtFile(String fileName, Scanner user, Roster r) {
		try {
			ArrayList<Student> textFile=readStudentsFile(fileName);
			if(textFile.size()>0) {
				System.out.print(printDraft(textFile)+"\nHow many students do you want to add from the list? ");
				int num=user.nextInt();
				if(0<num&&num<textFile.size()) {
					for(int i=0;i<num;i++) {
						System.out.print("What is the id of the student you wish to add? ");
						int id=user.nextInt();
						findAddRemove(r,textFile,id);
					}
					int newSize=textFile.size();
					if(newSize>0) {
						String confirm=confirmation(user,"discard");
						if(yes(confirm)) {
							textFile.clear();
						}
						System.out.print(printDraft(textFile)+"\nHow many students do you want to add from the list? ");
						int num2=user.nextInt();
						for(int i=0;i<num2;i++) {
							System.out.print("What is the id of the student you wish to add? ");
							int id=user.nextInt();
							findAddRemove(r,textFile,id);
						}
					}
					else if(num>textFile.size()){
						int diff=num-textFile.size();
						System.out.print("The number you input is "+diff+" numbers larger than the number of students on file.\nNote: if another number larger than the number of students on file is entered, the entire program will terminate. Enter a smaller number: ");
						int num2=user.nextInt();
						if(num2>textFile.size()) {
							System.exit(0);
						}
					}
					else if(num==textFile.size()) {
						for(Student s: textFile) {
							r.addStudent(s);
						}
						textFile.clear();
					}
					else {
						if(textFile.size()>0) {
							System.out.print(printDraft(textFile)+"\nThere are "+textFile.size()+" number of students that have not been added to the roster. Do you wish to discard them? ");
							String answerc=confirmation(user,"discard");
							if(yes(answerc)) {
								textFile.clear();
							}
							else {
								add(textFile, user, r);
							}
						}
					}
				}
			}
		}
		catch(NullPointerException e) {
		    e.printStackTrace();
		    System.out.println("Check the path or file name");
		}
	}
	
	
	private static void addFromDraft(int draftnum, ArrayList<Student> draft, ArrayList<Student> students,Scanner user) {
		if(draftnum>0) {
			System.out.print("\nYou have "+draftnum+" students in the draft file.\n"+printDraft(draft)+" Are there any students from here that you want to add? ");
			String userA = user.next().toLowerCase();
			if(userA.equals("y")||userA.equals("yes")) {
				System.out.print("How many student(s) do you wish to add? ");
				int number = user.nextInt();
				for(int j=0;j<number;j++) {
					printDraft(draft);
					System.out.println("What is the id of the student you wish to add? ");
					int draftID = user.nextInt();

					//**
					//Locates the wanted student to adds to students then removes student from draft
					//**
					Student key = new Student(draftID);
					int pos=draft.indexOf(key);
					key=draft.get(pos);
					students.add(key);
					draft.remove(key);
					System.out.println("Student from draft added: "+key);

				}
			}
		}
	}
	
	private static boolean yes(String answer) {
		String lanswer=answer.toLowerCase();
		ArrayList<String> yes = new ArrayList<>(Arrays.asList("y","yes"));
		if(yes.contains(lanswer)) {
			return true;
		}
		return false;
	}
	
	private static void findAddRemove(Roster r, ArrayList<Student> students, int id) {
		//**
		//Locates the wanted student to adds to students then removes student from draft
		//**
		Student key = new Student(id);
		int pos=students.indexOf(key);
		key=students.get(pos);
		r.addStudent(key);
		students.remove(key);
		System.out.println("Student from text file added: "+key);

	}
	
	private static void add(ArrayList<Student> textFile, Scanner user, Roster r) {
		int oversize=textFile.size()+1;
		System.out.print(printDraft(textFile)+"\nHow many students do you want to add from the list? \nNote: If 0 or "+oversize+" is entered, the students will be discarded.");
		int num=user.nextInt();
		if(0<num&&num<textFile.size()) {
			for(int i=0;i<num;i++) {
				System.out.print("What is the id of the student you wish to add? ");
				int id=user.nextInt();
				findAddRemove(r,textFile,id);
			}
		}
		else {
			String deleted = printDraft(textFile);
			textFile.clear();
			user.close();
			System.out.println("The students that weren't added to the roster have been deleted.\nStudents deleted are below: \n"+deleted);
		}
	}
	
	private static int displayOptions(Scanner user) {
		System.out.print("Display Options:\n--------------------\n1.) Grades(Increasing Order)\n2.) Grades(Decreasing Order)\n3.) Academic Progress(Increasing Order)\n4.) Academic Progress(Decreasing Order)\n5.) Class(Increasing Order)\n6.) Class(Decreasing Order)\n7.) Id(Increasing Order)\n8.) Id(Decreasing Order)\n9.) Name(Increasing Order)\n10.) Name(Decreasing Order)\nEnter the number that represents the way you wish for the students to be displayed: ");
		int num=user.nextInt()-1;
		return num;
	}
	
	private static ArrayList<String> displayOptions= new ArrayList<>(Arrays.asList("gradei","graded","academici","academicd","classi","classd","idi","idd","namei","named"));
	
	public void run() {
		Scanner user=new Scanner(System.in);
		boolean running=true;
		while(running) {
			if(rosterTxtFiles.size()==0) {
				Roster r=new Roster();
				createStudents(r);
//				continue;
			}
			else if(rosterTxtFiles.size()>0){
				System.out.println();
				System.out.print("1.) Load roster\n2.) Create new Roster\n3.) Exit \nWhat action would you like to do? ");
				int num=user.nextInt();
				if(num==1) {
					String txtname=loadRosterFromTxtFile();
					Roster r=readRosterFile(txtname);
					System.out.print("1.) Remove student \n2.) Add students \n3.) Display Students \n4.) Display Student between\nEnter an Option number: ");
					int num2=user.nextInt();
					if(num2==1) {
						remove(r);
					}
					else if(num2==2) {
						createStudents(r);
					}
					else if(num2==3) {
						displayStudents(r);
					}
					else if(num2==4) {
						displayStudentsBetween(r);
					}
				}
				else if(num==2) {
					Roster r=new Roster();
					createStudents(r);
				}
				else if(num==3) {
					running=false;
					break;
				}
			}
		}
//		running=true;
	}
	
}
