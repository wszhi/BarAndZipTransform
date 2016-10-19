public class HomeCommand implements Command {
    public Result invoke(String input) {
        return new Result("--------\n" +
                "1. Translate Zipcode to Barcode\n" +
                "2. Translate Barcode to Zipcode\n" +
                "3. Exit\n" +
                "-------------" +
                "What is your command(1~3): ");
    }
}
