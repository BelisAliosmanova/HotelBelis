import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    static String[] arrRooms = new String[10];
    static int[] safeStartDaysArr = new int[10];
    static int[] safeStartMonthsArr = new int[10];
    static int[] safeStartYearsArr = new int[10];
    static int[] safeEndDaysArr = new int[10];
    static int[] safeEndMonthsArr = new int[10];
    static int[] safeEndYearsArr = new int[10];
    static int[] numberOfBedsArr = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
    static int roomNumberReserve;

    static String [] additionalServices = new String [10];
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

    public static boolean askIfTheUserWantsToContinue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to continue the program(true or false)? ");
        boolean continueTheProgram;
        continueTheProgram = scan.nextBoolean();
        if (continueTheProgram == false) {
            System.out.println("Goodbye! :)");
            System.exit(0);
        }
        return continueTheProgram;
    }

    public static void makeAnEmptyRoom(String[] arrRooms) {
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
        roomNumberReserve = scan.nextInt();
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
            default -> {
                System.out.println("-----------------------------------------------------");
                System.out.println("INVALID INPUT! THERE ISN'T A ROOM WITH WHIT NUMBER!");
                System.out.println("Now enter the information again!");
                System.out.println("-----------------------------------------------------");
                makeAReservation(arrRooms);
            }
        }
        makeAReservationDate(arrRooms);
    }

    public static void makeAReservationDate(String[] arrRooms) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please write the start of the reservation! ");
        System.out.print("Enter the start day: ");
        int startDate = scan.nextInt();
        System.out.print("Enter the month: ");
        int startMonth = scan.nextInt();
        if (startMonth < 1 || startMonth > 12) {
            System.out.print("INVALID MONTH INPUT! Now enter the month again!");
            startMonth = scan.nextInt();
        }
        System.out.print("Enter the year: ");
        int startYear = scan.nextInt();
        System.out.println("Please write the end of the reservation! ");
        System.out.print("Enter the end day: ");
        int endDate = scan.nextInt();
        System.out.print("Enter the month: ");
        int endMonth = scan.nextInt();
        System.out.print("Enter the year: ");
        int endYear = scan.nextInt();
        if ((startYear > endYear) || (startYear == endYear && startMonth > endMonth) || (startYear == endYear && startMonth == endMonth && startDate > endDate)) {
            System.out.println("----------------------------");
            System.out.println("INVALID DATE INPUT!");
            System.out.println("----------------------------");
            System.out.println("Now enter the dates again: ");
            makeAReservationDate(arrRooms);
        } else {
            safeStartDaysArr[roomNumberReserve - 1] = startDate;
            safeStartMonthsArr[roomNumberReserve - 1] = startMonth;
            safeStartYearsArr[roomNumberReserve - 1] = startYear;
            safeEndDaysArr[roomNumberReserve - 1] = endDate;
            safeEndMonthsArr[roomNumberReserve - 1] = endMonth;
            safeEndYearsArr[roomNumberReserve - 1] = endYear;
            System.out.println("The start day is: " + startDate + "/" + startMonth + "/" + startYear + "   12:00h.");
            System.out.println("The end day is: " + endDate + "/" + endMonth + "/" + endYear + "   12:00h.");
            System.out.println("Enter some information about the user: ");
            String information = scan.nextLine();
            information = scan.nextLine();
            System.out.println("Room No:" + roomNumberReserve + " is successfully " + arrRooms[roomNumberReserve - 1]);
        }
    }

    public static void cancelAReservation(String[] arrRooms) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please write the number of the room whose reservation you want to cancel: ");
        int roomNumberCancel = scan.nextInt();
        if (arrRooms[roomNumberCancel - 1] == "reserved") {
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
            System.out.println("Room No:" + roomNumberCancel + " is " + arrRooms[roomNumberCancel - 1] + " now.");
        } else {
            System.out.println("This room is already empty!!!");
            System.out.println("Do you still want to cancel a reservation?(Type true for yes or false for no!)");
            boolean continueWithCanceling = scan.nextBoolean();
            if (continueWithCanceling == true) {
                System.out.println("OK! Now enter the information again!");
                cancelAReservation(arrRooms);
            }
        }
    }

    public static void printStats(int[] safeStartDaysArr) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the start day: ");
        int startDateCheck = scan.nextInt();
        System.out.print("Enter the start month: ");
        int startMonthCheck = scan.nextInt();
        System.out.print("Enter the start year: ");
        int startYearCheck = scan.nextInt();
        System.out.print("Enter the end day: ");
        int endDateCheck = scan.nextInt();
        System.out.print("Enter the end month: ");
        int endMonthCheck = scan.nextInt();
        System.out.print("Enter the end year: ");
        int endYearCheck = scan.nextInt();
        Date d1 = null;
        Date d2 = null;
        Date d1Check = null;
        Date d2Check = null;
        long diff = 0;
        long diffDays = 0;
        System.out.println("---------------------------------------------");
        System.out.println("                  STATS                      ");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < safeStartDaysArr.length; i++) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            d1 = format.parse(safeStartDaysArr[i] + "/" + safeStartMonthsArr[i] + "/" + safeStartYearsArr[i]);
            d2 = format.parse(safeEndDaysArr[i] + "/" + safeEndMonthsArr[i] + "/" + safeEndYearsArr[i]);
            d1Check = format.parse(startDateCheck + "/" + startMonthCheck + "/" + startYearCheck);
            d2Check = format.parse(endDateCheck + "/" + endMonthCheck + "/" + endYearCheck);
            if (safeStartDaysArr[i] == 0) {
                System.out.println("Room No: " + (i + 1) + " is not used in this period");
            } else if (d1Check.compareTo(d1) <= 0 && d2Check.compareTo(d2) >= 0) {
                diff = d2.getTime() - d1.getTime();
                diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays > 0) {
                    System.out.println("Room No: " + (i + 1) + " is used for " + (diffDays + 1) + " days in this period.");
                } else {
                    System.out.println("Room No: " + (i + 1) + " is not used in this period");
                }
            } else if (d1Check.compareTo(d1) >= 0 && d2Check.compareTo(d2) <= 0) {
                diff = d2Check.getTime() - d1Check.getTime();
                diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays > 0) {
                    System.out.println("Room No: " + (i + 1) + " is used for " + (diffDays + 1) + " days in this period.");
                } else {
                    System.out.println("Room No: " + (i + 1) + " is not used in this period");
                }
            } else if (d1.compareTo(d1Check) <= 0 && d2.compareTo(d2Check) <= 0) {
                diff = d2.getTime() - d1Check.getTime();
                diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays > 0) {
                    System.out.println("Room No: " + (i + 1) + " is used for " + (diffDays + 1) + " days in this period.");
                } else {
                    System.out.println("Room No: " + (i + 1) + " is not used in this period");
                }
            } else if (d1Check.compareTo(d1) <= 0 && d2Check.compareTo(d2) <= 0) {
                diff = d2Check.getTime() - d1.getTime();
                diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays > 0) {
                    System.out.println("Room No: " + (i + 1) + " is used for " + (diffDays + 1) + " days in this period.");
                } else {
                    System.out.println("Room No: " + (i + 1) + " is not used in this period");
                }
            }
        }
    }

    public static void findARoom() throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of beds(1-3): ");
        byte beds = scan.nextByte();
        System.out.print("Enter start date: ");
        int startDate = scan.nextInt();
        System.out.print("Enter the start month: ");
        int startMonth = scan.nextInt();
        System.out.print("Enter the start year: ");
        int startYear = scan.nextInt();
        System.out.print("Enter the end day: ");
        int endDate = scan.nextInt();
        System.out.print("Enter the end month: ");
        int endMonth = scan.nextInt();
        System.out.print("Enter the end year: ");
        int endYear = scan.nextInt();
        Date d1 = null;
        Date d2 = null;
        Date d1Check = null;
        Date d2Check = null;
        long diff = 0;
        long diffDays = 0;
        System.out.println("--------------------------------");
        System.out.println("AVAILABLE ROOMS WITH "+ beds + " BED/S");
        System.out.println("--------------------------------");
        for (int i = 0; i < numberOfBedsArr.length; i++) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            d1 = format.parse(safeStartDaysArr[i] + "/" + safeStartMonthsArr[i] + "/" + safeStartYearsArr[i]);
            d2 = format.parse(safeEndDaysArr[i] + "/" + safeEndMonthsArr[i] + "/" + safeEndYearsArr[i]);
            d1Check = format.parse(startDate + "/" + startMonth + "/" + startYear);
            d2Check = format.parse(endDate + "/" + endMonth + "/" + endYear);
            if (beds == numberOfBedsArr[i]) {
                if (safeStartDaysArr[i] == 0) {
                    System.out.println("Room No " + (i + 1));
                } else if (d1Check.compareTo(d1) <= 0 && d2Check.compareTo(d2) >= 0) {
                    diff = d2.getTime() - d1.getTime();
                    diffDays = diff / (24 * 60 * 60 * 1000);
                    if (diffDays < 0) {
                        System.out.println("Room No " + (i + 1));
                    }
                } else if (d1Check.compareTo(d1) >= 0 && d2Check.compareTo(d2) <= 0) {
                    diff = d2Check.getTime() - d1Check.getTime();
                    diffDays = diff / (24 * 60 * 60 * 1000);
                    if (diffDays < 0) {
                        System.out.println("Room No " + (i + 1));
                    }
                } else if (d1.compareTo(d1Check) <= 0 && d2.compareTo(d2Check) <= 0) {
                    diff = d2.getTime() - d1Check.getTime();
                    diffDays = diff / (24 * 60 * 60 * 1000);
                    if (diffDays < 0) {
                        System.out.println("Room No " + (i + 1));
                    }
                } else if (d1Check.compareTo(d1) <= 0 && d2Check.compareTo(d2) <= 0) {
                    diff = d2Check.getTime() - d1.getTime();
                    diffDays = diff / (24 * 60 * 60 * 1000);
                    if (diffDays < 0) {
                        System.out.println("Room No " + (i + 1));
                    }
                }
            }
        }
    }
    public static void updateARoom (){
        Scanner scan = new Scanner(System.in);
        System.out.println("THESE ARE THE ADDITIONAL SERVICES OFFERED BY OUR HOTEL");
        System.out.println("1. Baby cot");
        System.out.println("2. With breakfast");
        System.out.println("3. Three-meal courses");
        System.out.println("4. Overlooking the sea");
        System.out.println("5. Overlooking the mountain");
        System.out.println("6. Overlooking the courtyard");
        System.out.print("Please, enter your choice here-> ");
        byte addChoice = scan.nextByte();
        switch (addChoice){
            case 1 -> {
                System.out.println("YOU CHOSE -> BABY COT");
                System.out.println("Now you can make the reservation");
                makeAReservation(arrRooms);
                additionalServices[roomNumberReserve-1] = "baby cot";
            }
            case 2 ->{
                System.out.println("YOU CHOSE -> RESERVATION WITH BREAKFAST");
                System.out.println("Now you can make the reservation");
                makeAReservation(arrRooms);
                additionalServices[roomNumberReserve-1] = "with breakfast";
            }
            case 3 ->{
                System.out.println("YOU CHOSE -> RESERVATION WITH THREE-MEAL COURSES");
                System.out.println("Now you can make the reservation");
                makeAReservation(arrRooms);
                additionalServices[roomNumberReserve-1] = "with three meal courses";
            }
            case 4 ->{
                System.out.println("YOU CHOSE -> RESERVATION OVERLOOKING THE SEA");
                System.out.println("Now you can make the reservation");
                makeAReservation(arrRooms);
                additionalServices[roomNumberReserve-1] = "overlooking the sea";
            }
            case 5 ->{
                System.out.println("YOU CHOSE -> RESERVATION OVERLOOKING THE MOUNTAIN");
                System.out.println("Now you can make the reservation");
                makeAReservation(arrRooms);
                additionalServices[roomNumberReserve-1] = "overlooking the mountain";
            }
            case 6 ->{
                    System.out.println("YOU CHOSE -> RESERVATION OVERLOOKING THE COURTYARD");
                    System.out.println("Now you can make the reservation");
                    makeAReservation(arrRooms);
                    additionalServices[roomNumberReserve-1] = "overlooking the courtyard";
            }
            default -> {
                System.out.println("INVALID INPUT!");
                System.out.println("Now enter the information again!");
                updateARoom();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
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
                case 5 -> findARoom();
                case 6 -> updateARoom();
                default -> {
                    System.out.println("----------------------------------");
                    System.out.println("INVALID SELECTION INPUT!");
                    System.out.println("Now enter your selection again!");
                    System.out.println("----------------------------------");
                }
            }
            askIfTheUserWantsToContinue = askIfTheUserWantsToContinue();
        } while (askIfTheUserWantsToContinue == true);
    }
}