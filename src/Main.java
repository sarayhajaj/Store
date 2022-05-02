import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersOfShop usersOfShop = new UsersOfShop();
        int userChoice;
        do {
            System.out.println("Welcome to our store please choose your action: ");
            System.out.println("1 - Sing up");
            System.out.println("2 - Sing in");
            System.out.println("3 - Exit");
            userChoice = scanner.nextInt();
            switch (userChoice){
                case 1:
                    usersOfShop.createUser();
                    break;
                case 2:
                    int userChoice1;
                    do {
                        System.out.println("\"Which user would you like to login?" +
                                " click 1 - for customer user click 2 - for worker user");
                        userChoice = scanner.nextInt();
                    }while (userChoice != 1 && userChoice != 2);
                    if (userChoice == 1){
                        User user = usersOfShop.loginCustomer();
                        if (user == null){
                            System.out.println("Wrong credentials! pleas try again");
                        }
                    } else if (userChoice == 2) {
                        User user = usersOfShop.loginWorker();
                        if (user == null) {
                            System.out.println("Wrong credentials! pleas try again");
                        }
                    }
                    break;
                case  3:
                    break;
            }
        }while (userChoice != 3);

    }
}
