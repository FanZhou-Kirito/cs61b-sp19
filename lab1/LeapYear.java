/** Class that determines whether or not a year is a leap year.
 *  @author Fan ZHOU
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    /** java中private, public, protected 主要是通过“访问级别”区分：访问级别修饰符
        确定其他类是否可以使用特定字段或调用特定方法。大类可分为两个级别的访问控制：
        1.  在顶部：
            -public或package-private（没有显式修饰符即默认权限）。
            类可以用修饰符public声明，在这种情况下，类对所有类都可见。如果一个类没有
            修饰符（默认，也称为package-private），它只在自己的包中可见。
        2.  在成员级别：
            - public，private，protected或package-private（没有显式修饰符即默认权
            限）。
            （1）在成员级别，也可以使用public修饰符或无修饰符（package-private），
            如同顶级类一样，具有相同的含义。 
            （2）对于成员，除public和默认外有两个附加的访问修饰符：
                private和protected：
                -private修饰符指定该成员只能在其自己的类中访问。
                -protected修饰符指定该成员只能在其自己的包（如package-private）中
                访问，此外还可以由另一个包中的该类的子类访问。
        下表显示了对每个修饰符允许的成员访问权限：
        —————————————————————————————————————————————————
        Modifier    Class    package    Subclass    World
        -------------------------------------------------
        public        Y         Y          Y          Y
        protected     Y         Y          Y          N
        no modifier   Y         Y          N          N
        private       Y         N          N          N
        _________________________________________________
    */

    public static boolean isLeapYear(int year) {
        boolean p = false;
        if (year % 400 == 0) {
            p = true;
        } else if ((year % 4 == 0) && (year % 100 != 0)) {
            p = true;
        } else {
            p = false;
        }
        return p;
    }

    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }



    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
            /** Java try and catch:
                1.  The try statement allows you to define a block of code
                    to be tested for errors while it is being executed.
                2.  The catch statement allows you to define a block of code
                    to be executed, if an error occur in the try block, and 
                    the error type is marked after "catch" statement.
                3.  The try and catch keywords come in pairs.*/
        }
    }
}

