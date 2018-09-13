package miscExamples;


public class Lambdas{


    interface MyGreeting {
        String processName(String str);
    }


    interface MyString {
        String myStringFunction(String str);
    }

    //a simple conduit to turn my implementation String into a regular String for printing
    public static String reverseStr(MyString reverse, String str) {
        return reverse.myStringFunction(str);
    }

    public static void main(String args[]) {

        // Block lambda to reverse string
        MyString reverse = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        MyString forwardString = (str) -> {
            return str + "for";
        };

        // Output: omeD adbmaL
        System.out.println(reverseStr(forwardString, "Lambda Demo"));
        System.out.println("re");
    }

    public static void main1(String[] args) {


        MyGreeting morningGreeting = (str) -> "Good Morning " + str + "!";
        MyGreeting eveningGreeting = (str) -> "Good Evening " + str + "!";

        // Output: Good Morning Luis!
        System.out.println(morningGreeting.processName("Luis"));

        // Output: Good Evening Jessica!
        System.out.println(eveningGreeting.processName("Jessica"));


        MyString reverseStr = (str) -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };
    }
}
