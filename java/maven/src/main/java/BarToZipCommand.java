

public class BarToZipCommand implements Command {
    private BarToZipService barToZipService;

    public BarToZipCommand(BarToZipService barToZipService) {
        this.barToZipService = barToZipService;
    }

    public Results invoke(String input) {

        ResultForCode resultForCode = barToZipService.translate(input);
        if (!resultForCode.isValid()){
            resultForCode.setValue("invalid input");
            return new Results(resultForCode.getValue(), false);
        }
        return new Results(resultForCode.getValue(), true);
    }
}
