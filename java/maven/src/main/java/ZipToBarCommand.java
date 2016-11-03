
public class ZipToBarCommand implements Command{
    private ZipToBarService zipToBarService;

    public ZipToBarCommand(ZipToBarService zipToBarService) {

        this.zipToBarService = zipToBarService;
    }

    public Results invoke(String input) {
        ResultForCode resultForCode = zipToBarService.translate(input);
        if (!resultForCode.isValid()){
            resultForCode.setValue("invalid input");
            return new Results(resultForCode.getValue(), false);
        }
        return new Results(resultForCode.getValue(),true);
    }
}
