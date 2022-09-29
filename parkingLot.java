import java.time.Clock;
import  java.util.Scanner;

class Main{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
         int check = 0; /// first time entry checker
        String s="";
        while ( !s.equalsIgnoreCase("close")) {    ///     continuous  loop for customer entry until system is "closed".

            parking_entry_exit paymentone = new parking_entry_exit();
             if(check==0){
                 System.out.println("----------   WELCOME TO INORBIT MALL   ----------");
                 System.out.println("YOU HAVE ENTERED IN TO THE PARKING AREA.");
                 System.out.println("PLEASE FOLLOW THE BELOW PROCESS.");
                 check++;
            paymentone.entry(1);}
             else{
                 System.out.println("WOULD YOU LIKE TO ENTER OR EXIT?");
                String Ask = input.next();
                boolean status = false;
                if (Ask.equalsIgnoreCase("entry")) {   // entry function access


                    paymentone.entry(1);
                } else {  // exit function access

                    paymentone.exit(3);
                }
            }
            System.out.println(" Do you wanna close?");
            s = input.next();

        }
    }



    interface Land{  // used land at an abstract level which is implemented by floor
        boolean isFull(int a, int slots);

        //void DisplayBoards();
    }

    static  class Floor implements Land{
        private static int TotalFloors = 4; // defined by developer
        static boolean[][] layout = new boolean[TotalFloors][70];   // to store empty and alloted spaces
        static String[][] CustomerName = new String [TotalFloors][70];  // to store customers' name
        static boolean[][] IsPaid = new boolean[TotalFloors][70];  // to check whether the particular customer at a parking slot paid or not
        static double[][] EntryTime = new double[TotalFloors][70];  // to store entry time of the customer and used in calculation of fee.
        static double[][] ExitTime = new double[TotalFloors][70];   // to store exit time of the customer and used in calculation of fee.
        private int exitPoint;
        private int EntryPoint;
        int FloorNumber;
        int counterEV;  // counts number of EV vehicles alloted
        int counterPwD;  // counts number of PwD vehicles alloted
        int counter;
        private static int slots;
        private int maxEV; // maximum # EV's can be alloted    //  declared as private to hide data
        private int maxPwD; // maximum # PwD's can be alloted


//        FirstFloor ff_floor = new FirstFloor();




        public  boolean isFull(int floor, int slots){  // check whether a particular floor's and type of slot(like  PwD, Ev) is full

            for(int j=0;j<slots;j++){
                if(layout[floor][slots] == false){
                    return false;
                }
            }
            return true;
        }

        static public class GroundFLoor {  // ground floor inner class

            static Floor gf = new Floor();
            public GroundFLoor() {

                gf.FloorNumber = 1;
                gf.slots = 60;
                gf.maxEV = 5; // one place for both pwd and ev
                gf.maxPwD = 9;
                gf.layout[0] = new boolean[slots];
                gf.IsPaid[0] = new boolean[slots];
                gf.EntryTime[0] = new double[slots];
                gf.ExitTime[0] = new double[slots];
                gf.counterEV  = 0; // more veicles types can be allocated if required.
                gf.counterPwD  = 5;
                gf.counter  = 10;
            }

        }


        public static class FirstFloor {  // first floor inner class



            static Floor ff = new Floor();





            public FirstFloor() {

                ff.FloorNumber = 2;
                ff.slots = 30;
                ff.maxEV = 3; // one place for both pwd and ev
                ff.maxPwD = 6;
                ff.layout[0] = new boolean[slots];
                ff.IsPaid[0] = new boolean[slots];
                ff.EntryTime[0] = new double[slots];
                ff.ExitTime[0] = new double[slots];
                ff.counterEV  = 0; // more vehicles types can be allocated if required.
                ff.counterPwD  = 3;
                ff.counter  = 7;
            }

        }





        public static class SecondFloor{  // second floor inner class
            static Floor sf = new Floor();
            public SecondFloor() {
//                sf.exitPoint = exitPoint;





                sf.FloorNumber = 3;
                sf.slots = 20;atom://teletype/portal/0af6f5a1-fbd8-4e65-b4e9-afd88965935d
                sf.maxEV = 2; // one place for both pwd and ev
                sf.maxPwD = 4;
                sf.layout[0] = new boolean[slots];
                sf.IsPaid[0] = new boolean[slots];
                sf.EntryTime[0] = new double[slots];
                sf.ExitTime[0] = new double[slots];
                sf.counterEV  = 0; // more veicles types can be allocated if required.
                sf.counterPwD  = 3;
                sf.counter  = 5;
            }

        }


    }

    static class Payment extends Floor // payment class takes care of all payment related activities
    {


         static class customer extends Floor{   ///      customer  inner class takes care of all customer details

            Floor.GroundFLoor obj1 = new Floor.GroundFLoor();
            Floor.FirstFloor obj2 = new Floor.FirstFloor();
            Floor.SecondFloor obj3 = new Floor.SecondFloor();
            static String[][] customerName = new String[300][300];

            static String PhoneNumber [][] = new String[300][300];


            static void  customerDetails( int fn, int i)
            {
                System.out.println("Please Provide us Your name");
                customerName[fn][i] = input.next();
                System.out.println("Please provide your phone number");
                PhoneNumber[fn][i]= input.next();


            }

            // this is for just storing data

        }
        public static  class Vehicles extends customer  {   ///      vehicle  inner class takes care of all vehicle details
            private String VehicleType; // compactcar|bike|truck
            private int VehicleSpot;


            static String[][] vehicleNumber = new String[300][300];
            static String VehicleMode[][] = new String[300][300];


            static void  vehiclesDetails( int fn, int i)
            {
                System.out.println("Please provide the vehicle number");
                vehicleNumber[fn][i] = input.next();
                System.out.println("Please provide the vehicle model");
                VehicleMode[fn][i]= input.next();


            }


        }


        boolean paymentAtgates( boolean IsPaid[][] , int FloorNumber,int Slot ) // deals whether to pay or not, amount to pay, storing whether a particular person paid or not
        {
            System.out.println("Do you want to pay for the parking lot?");
            System.out.println("TYPE YES OR NO");
            String rep1 = input.next();


            double rate = 0;

            //payment
            if(FloorNumber == 1){
                System.out.print( " Bill fare per hour is 20" + "\n ");
                rate = 20;
            }
            else if(FloorNumber == 2){
                System.out.print( " Bill fare per hour is 30 ");
                rate = 30;
            }
            else if(FloorNumber == 3){
                System.out.print( "Bill fare per hour is 50");
                rate = 50;
            }




            Clock clock = Clock.systemUTC(); // importing clock class and methods to store entry and exit time
            // System.out.println("UTC time :: " + clock.instant())

            if(rep1.equalsIgnoreCase("Yes")){





                System.out.println("How do you want to pay? " +'\n'+"1.CASH"+'\n'+"2.CARD"+'\n'+"3.UPI");
                String rep2 = input.next();

                if(rep2.equalsIgnoreCase("cash") == true){
                    System.out.println("Please gimme cash: ");
                    int cash = input.nextInt();
                    if(cash<rate) {
                        System.out.println("Please pay full amount, otherwise contact administration ");   // :)
                        cash = input.nextInt();
                    }
                    System.out.println("Please take the change : "+ parking_entry_exit.exchange_cash((double)cash,rate));
                    return  IsPaid[FloorNumber][Slot]= true;



                }
                else if(rep2.equalsIgnoreCase("card") == true) {
                    System.out.println("Could you please give me the card.");
                    System.out.println("Do you want a receipt ?");
                    String s = input.next();
                    if (s.equalsIgnoreCase("yes")) {
                        System.out.println("Please take the receipt and your card");
                    } else {
                        System.out.println("Please take  your card");
                    }
                    return IsPaid[FloorNumber][Slot] = true;
                }
                else {
                    System.out.println("Please scan the QR code and pay");
                    return IsPaid[FloorNumber][Slot] = true;

                }

            }
            else{
                return IsPaid[FloorNumber][Slot] = false;
            }








        }

    }




    public static class parking_entry_exit{
        private static boolean gate = true;
      static boolean  isPaid= false;


        long SpentTime;
        boolean revCard=false;



        public static double exchange_cash(double in_cash, double rate){ // to give remaining amount for what he paid extra
            if(rate<in_cash) return (in_cash - rate);
            else return 0;
        }



        static int fInp;

        static boolean  entry(int EntryPoint){   // main entry method



            gate = false;
            // RANDOM GENERATOR
           
            displayBoard dobj = new displayBoard();
            dobj.DSP1();

            fInp = input.nextInt();
            dobj.DSP2( fInp);




            System.out.println( "\n"+"Please select one of the following: 1 for EV, 2 for PWD, 3  for normal");
            int rep2 = input.nextInt();




            boolean status = false; // for defining parking space status

            Clock clock = Clock.systemUTC();

            // System.out.println("UTC time :: " + clock.instant());
            Floor.GroundFLoor obj1 = new Floor.GroundFLoor();
            Floor.FirstFloor obj2 = new Floor.FirstFloor();
            Floor.SecondFloor obj3 = new Floor.SecondFloor();

            int maxEV=0,maxPWD=0,maxSlots=0;
            int counterEV=0,counterPwD=0,counter=0;


            switch(fInp){   // to abstract respective floors' slots lists
                case 1:
                    counterEV = obj1.gf.counterEV;
                    counterPwD = obj1.gf.counterPwD;
                    counter = obj1.gf.counter;
                    maxEV = obj1.gf.maxEV;
                    maxPWD = obj1.gf.maxPwD;
                    maxSlots = obj1.gf.slots;
                    break;
                case 2:
                    counterEV = obj2.ff.counterEV;
                    counterPwD = obj2.ff.counterPwD;
                    counter = obj2.ff.counter;
                    maxEV = obj2.ff.maxEV;
                    maxPWD = obj2.ff.maxPwD;
                    maxSlots = obj2.ff.slots;
                    break;
                case 3:
                    counterEV = obj3.sf.counterEV;
                    counterPwD = obj3.sf.counterPwD;
                    counter = obj3.sf.counter;
                    maxEV = obj3.sf.maxEV;
                    maxPWD = obj3.sf.maxPwD;
                    maxSlots = obj3.sf.slots;
                    break;
            }




            int i = 0;

            switch(rep2)
            {
                case 1:

                    for(i =counterEV ; Floor.layout[fInp][i] == true && i< maxEV; i++); // checks whether there is a empty slot in that particular floors' type(like EV, PwD)



                    if( i == maxEV)
                    {

                        System.out.println("No space available for parking ");
                        return false;
                    }
                    else
                    {
                        status = true;
                        Floor.layout[fInp][i] = true;
                        System.out.println(i + " This space is available");
                        System.out.println("Please take the token");
                        Floor.EntryTime[fInp][i] = clock.millis();
                    }




                    break;
                case 2:

                    for( i =counterPwD ; Floor.layout[fInp][i] == true && i<  maxPWD;i++);



                    if( i ==  maxPWD)
                    {
                        System.out.println("No space available for parking ");
                        return false;
                    }
                    else
                    {
                        Floor.layout[fInp][i]= true;
                        status = true;
                        System.out.println(i + " This space is available");
                        System.out.println("Please take the token");
                        System.out.println("Please use wheelchair if required....");
                        Floor.EntryTime[fInp][i] = clock.millis();

                    }
                    // need to figure for both pwd and ev
                    break;
//                case 3:
//
//                    for( i = 0 ; Floor.layout[fInp][i] == true && i<  Floor.GroundFLoor.gf.max;i++);
//
//
//
//                    if( i ==  Floor.GroundFLoor.gf.maxEV)
//                    {
//                        System.out.println("No space available for parking ");
//                    }
//                    else
//                    {
//                        Floor.layout[fInp][i] = true;
//                        status = true;
//                        System.out.println(i + " This space is available");
//
//
//                    }
//
//
//
//
//
//
//
//                 break;
                case 3:


                    for( i = counter ; Floor.layout[fInp][i] == true && i< maxSlots;i++);



                    if( i == maxSlots)
                    {
                        System.out.println("No space available for parking!");
                        return false;
                    }
                    else
                    {
                        Floor.layout[fInp][i] = true;
                        status = true;
                        System.out.println(i + " This space is available");
                        System.out.println("Please take the token");
                        Floor.EntryTime[fInp][i] = clock.millis();
                    }


                    break;
            }
            Payment.customer.customerDetails(fInp,i);
            Payment.Vehicles.vehiclesDetails(fInp,i);
            if(status == true ) {
                Payment pobj1 = new Payment();
                isPaid = pobj1.paymentAtgates(Floor.IsPaid, fInp,i);
            }

            if ( status)
            {

                //System.out.println( "Please say your mobile number:")
                // ph = input.nextInt();


//                paymentAtgates(boolean isPaid, int floor_nummber);



            }
            return true;
        }


        void exit(int exitPoint)      /// main Exit Method
        {

            Clock clock = Clock.systemUTC();

            System.out.println("Please gimme the token");
            int floor_number_token = input.nextInt();
            int slot_token = input.nextInt();
            Floor.ExitTime[floor_number_token][slot_token] = clock.millis();
            SpentTime = (int)(Floor.ExitTime[floor_number_token][slot_token]-Floor.EntryTime[floor_number_token][slot_token])/3600000 +1;




            if(Floor.IsPaid[floor_number_token][slot_token])
            {
                System.out.println("Thanks for visiting, please provide some feedback");
                // some funtion to send mail of feedback


            }
            else {
//                paymentAtgates(isPaid, FloorNumber);
                System.out.println("\n"+"Do you have a revCard. 1 for yes, 2 for no");
                int s = input.nextInt();
                if (s == 1)
                    revCard = true;

                if (revCard == true) {
                    SpentTime = 0;
                    System.out.println("Thanks for coming :)");
                }
                if(revCard==false){
                    int FloorNumber = floor_number_token;
                    System.out.println("How do you want to pay? " +'\n'+"1.CASH"+'\n'+"2.CARD"+'\n'+"3.UPI");
                    String rep2 = input.next();



                    if (FloorNumber == 1) {
                        if(rep2.equalsIgnoreCase("cash") == true) {
                            System.out.println("Please gimme cash: ");
                            System.out.println("The fee to pay is " + SpentTime * 20);

                            double amount_received = input.nextDouble();
                            double amount_due = exchange_cash(amount_received, SpentTime * 20);
                            System.out.println("Please take the cash of: " + amount_due);
                            System.out.println("Thanks for coming :)");
                        }
                        else if(rep2.equalsIgnoreCase("card") == true) {
                            System.out.println("Could you please give me the card.");
                            System.out.println("Do you want a receipt ?");
                            String sinput = input.next();
                            if (sinput.equalsIgnoreCase("yes")) {
                                System.out.println("Please take the receipt and your card");
                                System.out.println("Thanks for coming :)");
                            } else {
                                System.out.println("Please take  your card");
                                System.out.println("Thanks for coming :)");
                            }
                        }
                        else {
                            System.out.println("Please scan the QR code and pay");
                            System.out.println("Thanks for coming :)");
                        }

                    }
                    if (FloorNumber == 2) {
                        if(rep2.equalsIgnoreCase("cash") == true) {
                            System.out.println("Please gimme cash: ");
                            System.out.println("The fee to pay is " + SpentTime * 30);

                            double amount_received = input.nextDouble();
                            double amount_due = exchange_cash(amount_received, SpentTime * 30);
                            System.out.println("Please take the cash of: " + amount_due);
                            System.out.println("Thanks for coming :)");
                        }
                        else if(rep2.equalsIgnoreCase("card") == true) {
                            System.out.println("Could you please give me the card.");
                            System.out.println("Do you want a receipt ?");
                            String sinput = input.next();
                            if (sinput.equalsIgnoreCase("yes")) {
                                System.out.println("Please take the receipt and your card");
                                System.out.println("Thanks for coming :)");
                            } else {
                                System.out.println("Please take  your card");
                                System.out.println("Thanks for coming :)");
                            }
                        }
                        else {
                            System.out.println("Please scan the QR code and pay");
                            System.out.println("Thanks for coming :)");
                        }
                    }
                    if (FloorNumber == 3) {
                        if(rep2.equalsIgnoreCase("cash") == true) {
                            System.out.println("Please gimme cash: ");
                            System.out.println("The fee to pay is " + SpentTime * 50);

                            double amount_received = input.nextDouble();
                            double amount_due = exchange_cash(amount_received, SpentTime * 50);
                            System.out.println("Please take the cash of: " + amount_due);
                            System.out.println("Thanks for coming :)");
                        }
                        else if(rep2.equalsIgnoreCase("card") == true) {
                            System.out.println("Could you please give me the card.");
                            System.out.println("Do you want a receipt ?");
                            String sinput = input.next();
                            if (sinput.equalsIgnoreCase("yes")) {
                                System.out.println("Please take the receipt and your card");
                                System.out.println("Thanks for coming :)");
                            } else {
                                System.out.println("Please take  your card");
                                System.out.println("Thanks for coming :)");
                              }
                        }
                        else {
                            System.out.println("Please scan the QR code and pay");
                            System.out.println("Thanks for coming :)");
                          }
                    }
                }
            }

            Floor.layout[floor_number_token][slot_token] = false;   ///   changes that particular slot to empty as customer is exiting
        }
    }


    public static class displayBoard {     // display board to give instructions to customer
        void DSP1() {
            System.out.println("\n"+"Please select floor as per vehicle:");
            System.out.println("2 Wheeler - ground floor - enter 1");
            System.out.println("4 Wheeler - first floor - enter 2");
            System.out.println("Heavy vehicles - second  - enter 3" +"\n");
            System.out.println("floornumber ");
        }





        void DSP2(int fn){   // displays occupied and empty spaces in the particular floor

            switch (fn) {
                case 1:
                    Floor.GroundFLoor obj1 = new Floor.GroundFLoor();
                    for (int j = 0; j < obj1.gf.slots; j++) {
                        if(Floor.layout[fn][j] == false) {
                            System.out.print("empty space " + fn + " " + j + "      ");
                            if(j%3==0) System.out.println();
                        }else {
                            System.out.print("occupied space " + fn + " " + j + "      " );
                            if(j%3==0) System.out.println();
                        }
                    }

                    break;
                case 2:
                    Floor.FirstFloor obj2 = new Floor.FirstFloor();
                    for (int j = 0; j < obj2.ff.slots; j++) {
                        if(Floor.layout[fn][j] == false) {
                            System.out.print("empty space " + fn + " " + j + "      ");
                               if(j%3==0) System.out.println();
                        }else {
                            System.out.print("occupied space " + fn + " " + j + "      " );
                            if(j%3==0) System.out.println();
                        }
                        }
                    break;
                case 3:
                    Floor.SecondFloor obj3 = new Floor.SecondFloor();
                    for (int j = 0; j < obj3.sf.slots; j++) {
                        if(Floor.layout[fn][j] == false) {
                            System.out.print("empty space " + fn + " " + j + "      ");
                            if(j%3==0) System.out.println();
                        }else {
                            System.out.print("occupied space " + fn + " " + j + "      " );
                            if(j%3==0) System.out.println();
                        }
                    }
                    break;
            }
        }
    }
}