package language.features;

public class InnerClassDemo {
    protected InnerClass1 ic;

    public InnerClassDemo() {
        ic = new InnerClass1();
    }

    public void displayStrings() {
        System.out.println(ic.getString() + ".");
        System.out.println(ic.getAnotherString() + ".");
        System.out.println(ic.getClass());
        System.out.println(ic.getClass().getName());
    }

    public static void main(String[] args) {
        InnerClassDemo c1 = new InnerClassDemo();
        c1.displayStrings();
    }

    protected class InnerClass1 {
        public String getString() {
            return "InnerClass1: getString invoked";
        }

        public String getAnotherString() {
            return "InnerClass1: getAnotherString invoked";
        }
    }
}