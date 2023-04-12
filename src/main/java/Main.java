
public class Main {
    public static void main(String[] args) throws Exception {

        Printer printer = new Printer();
        printer.displayCategoriesAndTheirTotalValue();
        System.out.println();
        printer.displayCartWithHighestValue();
        System.out.println();
        printer.displayFurthestUsers();

    }
}