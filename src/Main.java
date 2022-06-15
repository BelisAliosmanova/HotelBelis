import java.util.Scanner;

public class Main {
    static int [] safeStartDaysArr = new int [10];
    static int [] safeStartMonthsArr = new int [10];
    static int [] safeStartYearsArr = new int [10];
    static int [] safeEndDaysArr = new int [10];
    static int [] safeEndMonthsArr = new int [10];
    static int [] safeEndYearsArr = new int [10];
    public static void printWelcomeMessage() {
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("                                       WELCOME TO HAPPY HOTEL!");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public static void printTheSections() {
        System.out.println("Please select what you want to do(1-6): ");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("1. Make a reservation.");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("2. Free list rooms.");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("3. Checkout room.");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("4. Stats.");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("5. Find a room.");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("6. Update a room.");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public static boolean askIfTheUserWantsToContinue(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to continue the program(true or false)? ");
        boolean continueTheProgram;
        continueTheProgram = scan.nextBoolean();
        if(continueTheProgram==false){
            System.out.println("Goodbye! :)");
            System.exit(0);
        }
        return continueTheProgram;
    }

    public static void makeAnEmptyRoom(String[]arrRooms){
        for (int i = 0; i < arrRooms.length; i++) {
            arrRooms[i] = "empty";
        }
    }

    public static void checkForEmptyRooms(String[] arrRooms) {
        for (int i = 0; i < arrRooms.length; i++) {
            if (arrRooms[i].equals("empty")) {
                System.out.println("Room No:" + (i + 1) + " is " + arrRooms[i]);
            }
        }
    }

    public static void makeAReservation(String[] arrRooms) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please write the room's number you want to reserve: ");
        int roomNumberReserve = scan.nextInt();
        switch (roomNumberReserve) {
            case 1 -> arrRooms[0] = "reserved";
            case 2 -> arrRooms[1] = "reserved";
            case 3 -> arrRooms[2] = "reserved";
            case 4 -> arrRooms[3] = "reserved";
            case 5 -> arrRooms[4] = "reserved";
            case 6 -> arrRooms[5] = "reserved";
            case 7 -> arrRooms[6] = "reserved";
            case 8 -> arrRooms[7] = "reserved";
            case 9 -> arrRooms[8] = "reserved";
            case 10 -> arrRooms[9] = "reserved";
        }
        makeAReservationDate(roomNumberReserve);
        System.out.println("Room No:" + roomNumberReserve + " is successfully " + arrRooms[roomNumberReserve - 1]);
    }

    public static void makeAReservationDate(int roomNumberReserve) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write the start of the reservation! ");
        System.out.print("Enter the start day: ");
        int startDate = scan.nextInt();
        safeStartDaysArr[roomNumberReserve-1]=startDate;
        System.out.print("Enter the month: ");
        int startMonth = scan.nextInt();
        safeStartMonthsArr[roomNumberReserve-1]=startMonth;
        System.out.print("Enter the year: ");
        int startYear = scan.nextInt();
        safeStartYearsArr[roomNumberReserve-1]=startYear;
        System.out.println("Please write the end of the reservation! ");
        System.out.print("Enter the end day: ");
        int endDate = scan.nextInt();
        System.out.print("Enter the month: ");
        int endMonth = scan.nextInt();
        System.out.print("Enter the year: ");
        int endYear = scan.nextInt();
        if ((startYear > endYear) || (startYear == endYear && startMonth > endMonth) || (startYear == endYear && startMonth == endMonth && startDate > endDate)) {
            System.out.println("----------------------------");
            System.out.println("INVALID INPUT!");
            System.out.println("----------------------------");
            System.out.println("Now enter the dates again: ");
            makeAReservationDate(roomNumberReserve);
        } else {
            System.out.println("The start day is: " + startDate + "/" + startMonth + "/" + startYear + "   12:00h.");
            System.out.println("The end day is: " + endDate + "/" + endMonth + "/" + endYear + "   12:00h.");
            System.out.println("Enter some information about the user: ");
            String information = scan.nextLine();
            information = scan.nextLine();
        }
    }

    public static void cancelAReservation(String[] arrRooms){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please write the number of the room whose reservation you want to cancel: ");
        int roomNumberCancel = scan.nextInt();
        if(arrRooms[roomNumberCancel-1]=="reserved") {
            switch (roomNumberCancel) {
                case 1 -> arrRooms[0] = "empty";
                case 2 -> arrRooms[1] = "empty";
                case 3 -> arrRooms[2] = "empty";
                case 4 -> arrRooms[3] = "empty";
                case 5 -> arrRooms[4] = "empty";
                case 6 -> arrRooms[5] = "empty";
                case 7 -> arrRooms[6] = "empty";
                case 8 -> arrRooms[7] = "empty";
                case 9 -> arrRooms[8] = "empty";
                case 10 -> arrRooms[9] = "empty";
            }
            System.out.println("Room No:" + roomNumberCancel + " is " + arrRooms[roomNumberCancel - 1]+" now.");
        } else{
            System.out.println("This room is already empty!!!");
            System.out.println("Do you still want to cancel a reservation?(Type true for yes or false for no!)");
            boolean continueWithCanceling = scan.nextBoolean();
            if(continueWithCanceling==true) {
                System.out.println("OK! Now enter the information again!");
                cancelAReservation(arrRooms);
            }
        }
    }

    public static void printStats(int [] safeStartDaysArr){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the start day: ");
        int startDateCheck = scan.nextInt();
        System.out.print("Enter the month: ");
        int startMonthCheck = scan.nextInt();
        System.out.print("Enter the year: ");
        int startYearCheck = scan.nextInt();
        System.out.print("Enter the end day: ");
        int endDateCheck = scan.nextInt();
        System.out.print("Enter the month: ");
        int endMonthCheck = scan.nextInt();
        System.out.print("Enter the year: ");
        int endYearCheck = scan.nextInt();

        for(int i = 0; i< safeStartDaysArr.length; i++){
            while(safeStartDaysArr[i]!=0) {
                if ((startDateCheck <= safeStartDaysArr[i] && startMonthCheck <= safeStartMonthsArr[i] &&
                        startYearCheck <= safeStartYearsArr[i])){
                    System.out.println("Room No: " + (i + 1) + " is used.");
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arrRooms = new String[10];
        printWelcomeMessage();
        makeAnEmptyRoom(arrRooms);
        boolean askIfTheUserWantsToContinue;
        do {
            printTheSections();
            System.out.print("Enter your selection here: ");
            int selection = scan.nextInt();
            switch (selection) {
                case 1 -> makeAReservation(arrRooms);
                case 2 -> checkForEmptyRooms(arrRooms);
                case 3 -> cancelAReservation(arrRooms);
                case 4 -> printStats(safeStartDaysArr);
            }
            askIfTheUserWantsToContinue = askIfTheUserWantsToContinue();
        } while (askIfTheUserWantsToContinue == true);
    }
}