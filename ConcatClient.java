import java.rmi.Naming;
import java.util.Scanner;
public class ConcatClient {
public static void main(String[] args) {
try {
ConcatService service = (ConcatService)
Naming.lookup("rmi://localhost/ConcatService");
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("Menu:");
System.out.println("1. Concatenate Strings");
System.out.println("2. Exit");
System.out.print("Enter choice: ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
if (choice == 1) {
System.out.print("Enter first string: ");
String str1 = scanner.nextLine();
System.out.print("Enter second string: ");
String str2 = scanner.nextLine();
String result = service.concatenate(str1, str2);
System.out.println("Concatenated Result: " + result);
} else if (choice == 2) {
System.out.println("Exiting...");
break;
} else {
System.out.println("Invalid choice. Please try again.");
}
}
scanner.close();
} catch (Exception e) {
System.err.println("Client exception: " + e.getMessage());
e.printStackTrace();
}
}
}