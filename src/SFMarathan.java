/*
 *  Description: Processing 2D arrays.
 *  Name: Rick
 *  Semester: Fall 2021
 */

public class SFMarathan {

    public static void main(String[] args) {

        // Declaring String arrays.
        String nameList[] = {"Stephanie", "Caleb", "Simon", "Martha", "Cindy", "Lola"};
        String revisednameList[] = new String[nameList.length];

        // Declaring int arrays and vars.
        int[][] runTimes1 = {{307, 299, 326, 275, 450, 265}, {299, 307, 283, 274, 359, 256}};
        int[] resultsComparison;
        int topTimeInt, topImproved = 0, topImprovedIndex = 0, highResultsTime = 0;
        int resultsAvg = 0, medianOn = 0;

        System.out.println();

        // Display prompt and call method fastestRunner() for 2018.
        System.out.println("The three fastest runners in 2018 and their time in minutes are : ");
        topTimeInt = fastestRunner(runTimes1[0], nameList);
        System.out.println();

        // Display prompt and call method fastestRunner() for 2019.
        System.out.println("The three fastest runners in 2019 and their time in minutes are : ");
        topTimeInt = fastestRunner(runTimes1[1], nameList);
        System.out.println();

        // Call compareTimes to get the time differences between 2018 and 2019
        resultsComparison = compareTimes(runTimes1);

        // Display students who improved their runs between 2018 and 2019
        System.out.println();
        System.out.println("The list of students who improved their time from 2018 to 2019 are : ");
        for (int s = 0; s <= resultsComparison.length-1; s++) {
            if(resultsComparison[s] > 0) {
                System.out.println(nameList[s] + " : " + resultsComparison[s] + " minute(s)");

                // Check for and determine most improved time
                if (topImproved < resultsComparison[s]) {
                    topImproved = resultsComparison[s];
                    topImprovedIndex = s;
                }
            }

        }

        System.out.println();
        // Display the runner with most improved time
        System.out.println(nameList[topImprovedIndex] + " is the tenacious runner.");

        System.out.println();

        // Call meanTime to get avg for 2018 and display it.
        resultsAvg =  meanTime(runTimes1[0]);
        System.out.println("The average running time in 2018 : " + resultsAvg + " minutes");

        // Call meanTime to get avg for 2019 and display it.
        resultsAvg =  meanTime(runTimes1[1]);
        System.out.println("The average running time in 2019 : " + resultsAvg + " minutes");

        // Call median to get median time for 2018 and display it.
        medianOn = median(runTimes1[0]);
        System.out.println("The median running time in 2018 : " + medianOn + " minutes");

        // Call median to get median time for 2019 and display it.
        medianOn = median(runTimes1[1]);
        System.out.println("The median running time in 2019 : " + medianOn + " minutes");

    }


    // Method that takes int and string array, prints fastest 3 times and returns index number of fastest time
    public static int fastestRunner(int timesList[], String contestants[]) {

        // Declare arrays to check times.
        String revisedNameList[] = new String[contestants.length];
        int copyofMinList[] = new int[timesList.length];

        // Declare vars for top three times and indexes
        int firstLowestTime = 0, secondLowestTime = 0, thirdLowestTime = 0;
        int firstIndex = 0, secondIndex = 0, thirdIndex = 0;
        int highTime = 0;

        // Make a copy of the time list to search through.
        for (int i = 0; i <= timesList.length-1; i++) {
            copyofMinList[i] = timesList[i];
        }

        // Determine longest time and assign to highTime.
        for (int t = 0; t <= timesList.length-1; t++) {
            if (highTime < timesList[t]) {
                highTime = timesList[t];
            }
        }

        // Start vars with highest time.
        firstLowestTime = highTime;
        secondLowestTime = highTime;
        thirdLowestTime = highTime;


        // Search through array for lowest time.
        for (int t = 0; t <= timesList.length-1; t++) {
            // Check for lowest number, then assign to var if it's lowest number
            if (firstLowestTime > timesList[t]) {
                firstLowestTime = timesList[t];
                // Assign first lowest time index to var.
                firstIndex = t;
            }
        }

        // Display fastest time .
        System.out.println("1st " + contestants[firstIndex] + " : " + firstLowestTime);

        // Search through array for 2nd lowest time.
        for (int t = 0; t <= timesList.length-1; t++) {
            // Check for lowest number, as long as not firstLowestTime
            if ((timesList[t] != firstLowestTime) && (secondLowestTime > timesList[t])) {
                secondLowestTime = timesList[t];
                // Assign second lowest time index to var.
                secondIndex = t;
            }
        }

        // Display 2nd fastest time.
        System.out.println("2nd " + contestants[secondIndex] + " : " + secondLowestTime);

        // Search through array for 3rd lowest time.
        for (int t = 0; t <= timesList.length-1; t++) {
            // Check for 3rd lowest number, as long as not firstLowestTime or secondLowestTime
            if (timesList[t] != secondLowestTime)
                if (timesList[t] != firstLowestTime)
                    if (thirdLowestTime > timesList[t]){
                        thirdLowestTime = timesList[t];
                        // Assign 3rd lowest time index to var.
                        thirdIndex = t;
            }
        }

        //Display 3rd fastest time.
        System.out.println("3rd " + contestants[thirdIndex] + " : " + thirdLowestTime);

        System.out.println();

        // Call swapFirst to put person with lowest time at top of contestant list, index 0 .
        revisedNameList = swapFirst(firstIndex, contestants);

        // Return index for person with lowest time.
        return firstIndex ;
    }

    // Method to have index as input, and string array, swap based on index and return new array
    public static String[] swapFirst(int indexInt, String contestants[]) {

        // Declare array for copy of String array and var
        String [] copyofList = new String[contestants.length];
        String nameChange;

        // Make a copy of String array
        for (int s = 0; s <= contestants.length-1; s++) {
            copyofList[s] = contestants[s];
        }

        // Swap name based on index and place it at top of list, index 0
        nameChange = contestants[0];
        copyofList[0] = contestants[indexInt];
        copyofList[indexInt] = nameChange;

        // Return array which has person with lowest time at top of list
        return copyofList;
    }

    // Method to compareTimes
    public static int[] compareTimes(int indexInt[][]){

        // Declare arrays to check times
        int timesComparedArray [] = indexInt[0];
        int timesComparedArray2 [] = indexInt[1];
        int comparisonList [] = new int [indexInt[0].length];

        // Proceed through array, subtract between the columns at each index position and put result in new array.
        for (int s = 0; s <= timesComparedArray.length-1; s++) {
            comparisonList[s] = timesComparedArray[s] - timesComparedArray2[s];
        }

        // Return array with results
        return comparisonList;
    }

    // Method that takes in array and returns average
    public static int meanTime(int indexInt[]){

        // Declare vars for calculating average.
        int comparisonList [] = new int [indexInt.length];
        int total = 0, count = 0;
        int avg = 0;

        // Get sum of all values in array.
        for (int s = 0; s <= indexInt.length-1; s++) {
            total = total + indexInt[s];
            count++;
        }

        // Calculate average with total divided by count.
        avg = total / count;

        // Return result from average.
        return avg;
    }

    // Method to determine median, returns medium value of running times
    public static int median(int indexInt[]){
        // Declare vars for calculating median.
        int copyofTimeList [] = new int [indexInt.length];
        int total = 0, count = 0;
        int medianResult = 0;

        // Make copy of array
        for (int s = 0; s <= indexInt.length-1; s++) {
            copyofTimeList[s] = indexInt[s];
        }

        // Determine if array has even set of numbers
        if(copyofTimeList.length % 2 == 0) {
            int mid;
            mid = copyofTimeList.length / 2;
            // With even set of numbers, take the two middle numbers and divide by two to get the average.
            medianResult =  (copyofTimeList[mid] + copyofTimeList[mid - 1]) / 2;
            return medianResult;
        }

        // Otherwise, it's an odd set of numbers and return the middle number.
        medianResult = copyofTimeList[copyofTimeList.length/2 ];
        return medianResult;
    }
}

