import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class UsersOfShop {
    private LinkedList<Customers> customers;
    private LinkedList<Worker> workers;
    private HashMap<Integer , Product> merchandiseHashMap;

    public UsersOfShop() {
        this.customers = new LinkedList<>();
        this.workers = new LinkedList<>();
        this.merchandiseHashMap = new HashMap<>();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        int userShop;
        do {
            System.out.println("Which user would you like to open?  click 1 - for customer user click 2 - for worker user");
            userShop = scanner.nextInt();
        } while (userShop != 1 && userShop != 2);
        String firstName = null;
        int i;
        int check = 1;
        while (check != 0) {
            System.out.println("Enter your name :");
            firstName = scanner.nextLine();
            for (i = 0; i < firstName.length(); i++) {
                if (Character.isDigit(firstName.charAt(i))) {
                    System.out.println("Try again only words!");
                    break;
                }
                if (i == (firstName.length() - 1)) {
                    if (Character.isDigit(firstName.charAt(i))) {
                        System.out.println("Try again only words!");
                        break;
                    } else {
                        check = 0;
                    }
                }
            }
        }
        String lastName = null;
        int j;
        int check1 = 1;
        while (check1 != 0) {
            System.out.println("Enter your lastname :");
            lastName = scanner.nextLine();
            for (j = 0; j < lastName.length(); j++) {
                if (Character.isDigit(lastName.charAt(j))) {
                    System.out.println("Try again only words!");
                    break;
                }
                if (j == (lastName.length() - 1)) {
                    if (Character.isDigit(lastName.charAt(j))) {
                        System.out.println("Try again only words!");
                        break;
                    } else {
                        check1 = 0;
                    }
                }
            }
        }
        boolean usernameTaken = false;
        String username = null;
        do {
            System.out.println("Enter username:");
            username = scanner.nextLine();
            usernameTaken = this.doesUserNameExist(username);
        } while (usernameTaken);
        boolean strongPassword = false;
        String password = null;
        do {
            System.out.println("Enter a strong password: ");
            password = scanner.nextLine();
            strongPassword = this.checkIfStrongPassword(password);
        } while (!strongPassword);
        if (userShop == 1) {
            String answer;
            boolean clubMember = false;
            do {
                System.out.println("Are you a club member? yes/no");
                answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    clubMember = true;
                }
            }while (!answer.equals("yes") && !answer.equals("no"));
            Customers customers = new Customers(firstName , lastName , username , password , clubMember );
            this.customers.add(customers);
            System.out.println("User was added!");
        }else {
            int workerType;
            boolean clubMember1 = false;
            do {
                System.out.println("What is your rank? click 1 - Regular worker ," +
                        " 2 - Manager , 3 - Member in manager team ");
                workerType = scanner.nextInt();
            }while ( workerType != 1 &&  workerType != 2 &&  workerType != 3);
            RankType rankType;
            if (workerType == 1){
                rankType = RankType.REGULAR_WORKER;
            }else if (workerType == 2){
                rankType = RankType.MANAGER;
            }else
                rankType = RankType.MEMBER_IN_MANAGER_TEAM;
            Worker worker = new Worker(firstName , lastName , username , password , clubMember1, rankType);
            this.workers.add(worker);
            System.out.println("User was added!");
        }
    }
    private boolean doesUserNameExist(String usernameToCheck) {
        boolean exits = false;
        for (Customers currentUser : this.customers) {
            if (currentUser.getUsers().equals(usernameToCheck)) {
                exits = true;
                System.out.println("Username is already exist");
                break;
            }
        }
        if (!exits) {
            for (Worker currentWorker : this.workers) {
                if (currentWorker.getUsers().equals(usernameToCheck)) {
                    exits = true;
                    System.out.println("Username is already exist");
                    break;
                }
            }
        }
        return exits;
    }

    private boolean checkIfStrongPassword(String password) {
        boolean strong = false;
        if (password.length() >= 6) {
            strong = true;
        }
        return strong;
    }
    public User loginCustomer (){
        ShoppingCart shoppingCart = new ShoppingCart();
        Customers customers = new Customers();
        boolean clubMember = false;
        Customers found = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (Customers currentCustomers : this.customers) {
            if (currentCustomers.getUsers().equals(username) && currentCustomers.getPassword().equals(password)) {
                found = currentCustomers;
                System.out.print("Hello! {" + currentCustomers.getFirstName() + "} {" + currentCustomers.getLastName() );
                System.out.print(currentCustomers.isClubMember() ? " }(VIP)!": "}!");
                if (merchandiseHashMap.isEmpty()) {
                    System.out.println("There is no merchandise in our store");
                }else
                    currentCustomers.setAmountOfPurchase((int) shoppingCart.priceForUser(merchandiseHashMap, currentCustomers));
                break;
            }
        }
        return found;
    }

    public User loginWorker(){
        Worker found = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (Worker currentWorker : this.workers) {
            if (currentWorker.getUsers().equals(username) && currentWorker.getPassword().equals(password)) {
                found = currentWorker;
                System.out.print("Hello! {" + currentWorker.getFirstName() + "} {" + currentWorker.getLastName() + "}");
                if (currentWorker.getRankType() == RankType.REGULAR_WORKER){
                    System.out.println(" { Regular worker } ");
                } else if (currentWorker.getRankType() == RankType.MANAGER){
                    System.out.print(" { Manager } ");
                }else System.out.println(" { Member in manager team } ");
                System.out.print(" ! ");
                int managerChoice = 0;
                do {
                    System.out.println("This is your option menu;");
                    System.out.println(" 1 - Customer list \n" +
                            " 2 - List of customers club member \n" +
                            " 3 - List of customers who have made one or more purchase \n" +
                            " 4 - The customers who made the most highest purchase \n" +
                            " 5 - Adding a new product to the store \n" +
                            " 6 - Change inventory status for product \n" +
                            " 7 - Making a purchase \n" +
                            " 8 - Exit");
                    System.out.println("Choose your action:");
                    managerChoice = scanner.nextInt();
                    switch (managerChoice) {
                        case 1:
                            if (customers.isEmpty()) {
                                System.out.println("There is no customer in our store");
                            } else System.out.println(customers.toString());
                            break;
                        case 2:
                            boolean customersVIP = false;
                            if (!customersVIP) {
                                System.out.println("There is no VIP customers");
                            } else
                                for (Customers currentCustomers : this.customers) {
                                    if (currentCustomers.isClubMember()) {
                                        System.out.println(currentCustomers.toString());
                                        customersVIP = true;
                                    }
                                }
                            break;
                        case 3:
                            boolean customerPurchase = false;
                            if (!customerPurchase) {
                                System.out.println("There is no purchase in this store right now");
                            } else
                                for (Customers currentCustomers : this.customers) {
                                    if (currentCustomers.getAmountOfPurchase() > 0) {
                                        System.out.println(currentCustomers.toString());
                                        customerPurchase = true;
                                    }
                                }
                            break;
                        case 4:
                            Customers customerHighestPurchase = customers.get(0);
                            if (customers.isEmpty()) {
                                System.out.println("There is no customers in our store");
                            } else
                                for (Customers currentCustomers : this.customers) {
                                    if (currentCustomers.getAmountOfPurchase() > customerHighestPurchase.getAmountOfPurchase()) {
                                        customerHighestPurchase = currentCustomers;
                                    }
                                }
                            break;
                        case 5:
                            String productName;
                            int discountPercentages;
                            boolean isInStock = false;
                            double price;
                            int amountOfProduct;
                            String productDescription;
                            System.out.println("Enter the product name:");
                            productName = scanner.nextLine();
                            System.out.println("Enter the description of the product you would like to purchase:");
                            productDescription = scanner.nextLine();
                            System.out.println("Enter the price of the product:");
                            price = scanner.nextDouble();
                            System.out.println("Enter the discount percentages for club member:");
                            discountPercentages = scanner.nextInt();
                            do {
                                System.out.println("Enter the quantity of product:");
                                amountOfProduct = scanner.nextInt();
                                System.out.println("The product is in stock");
                            } while (amountOfProduct < 0);
                            String inStock;
                            do {
                                System.out.println("Is the product in stock? yes/no ");
                                inStock = scanner.nextLine();
                            } while (inStock.equals("yes") && inStock.equals("no"));
                            if (inStock.equals("yes")) ;
                            isInStock = true;
                            Product product = new Product(productName, discountPercentages, isInStock, (int) price, amountOfProduct, productDescription);
                            break;
                        case 6:
                            int outOfStock;
                            if (merchandiseHashMap.isEmpty()) {
                                System.out.println("There is no any product in store");
                            }
                            do {
                                System.out.println("What is the product number that is out of stock: ");
                                outOfStock = scanner.nextInt();
                            } while (merchandiseHashMap.get(outOfStock) == null);
                            merchandiseHashMap.get(outOfStock).setExistProduct();
                            break;
                        case 7:
                            double purchasePrice = 0;
                            for (Worker currentWorkers : this.workers) {
                                purchasePrice = ShoppingCart.priceForUser(merchandiseHashMap, currentWorkers);
                                if (currentWorker.getRankType() == RankType.REGULAR_WORKER) {
                                    purchasePrice *= 0.90;
                                } else if (currentWorker.getRankType() == RankType.MANAGER) {
                                    purchasePrice *= 0.80;
                                } else purchasePrice *= 0.70;
                            }
                            System.out.println("The cost of your shopping cart after the discount is:" + purchasePrice);
                            currentWorker.setSumOfPrice(purchasePrice);
                            break;
                        case 8:
                            System.out.println("Bye!");
                            break;

                    } }while (managerChoice != 8);
                break;
            }
        }
        return found;
    }
}
