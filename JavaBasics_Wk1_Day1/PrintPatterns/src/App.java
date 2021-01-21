/*
*
* Runs the main function for the code
* Created by Jordan Divina
*/

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Integer[][] firstPattern = {{0,0,1},{0,0,2},{0,0,3},{0,0,4},{0,1,9}};
        Integer[][] secondPattern = {{5,0,1},{4,0,3},{3,0,5},{2,0,7},{0,1,11}};
        System.out.println("1)");
        for (int i = 0; i < firstPattern.length; i++){
            PrintPattern(firstPattern[i]);
        }
        System.out.println("");
        System.out.println("2)");
        for (int i = firstPattern.length - 1; i >= 0; i--){
            PrintPattern(firstPattern[i]);
        }
        System.out.println("");
        System.out.println("3)");
        for (int i = 0; i < secondPattern.length; i++){
            PrintPattern(secondPattern[i]);
        }
        System.out.println("");
        System.out.println("4)");
        for (int i = secondPattern.length - 1; i >= 0; i--){
            PrintPattern(secondPattern[i]);
        }
    }

    /*
     * Takes in Integer[] array
     * Then uses that information to formulate a string 
     * which we print out to console
    */

    public static void PrintPattern(Integer[] values){

        String printString = "";
        String currentType = "";

        for (int i = 0; i < values.length; i++){
            switch(i){
                case 0:
                    printString = printString + " ".repeat(values[0]);
                    break;
                case 1:
                    if (values[1] == 0){
                        currentType = "*";
                    }
                    else{
                        currentType = "·";
                    }
                    break;
                case 2:
                    printString = printString + currentType.repeat(values[2]);
            }
        }
        System.out.println(printString);
        return;
    }
}
