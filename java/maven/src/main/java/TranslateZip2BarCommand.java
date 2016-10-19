public class TranslateZip2BarCommand implements Command {


    private TranslateZip2BarService service;

    public TranslateZip2BarCommand(TranslateZip2BarService service) {
        this.service = service;
    }

    public Result invoke(String input) {
        CoreResult response = this.service.translate(input);
        if (response.isError()) {
            return new Result("Please input valid zip code:");
        }
        String result = response.getMessage();
        result += "\n--------\n" +
                "1. Translate Zipcode to Barcode\n" +
                "2. Translate Barcode to Zipcode\n" +
                "3. Exit\n" +
                "-------------" +
                "What is your command(1~3): ";
        return new Result(result, null, true);
    }

}
