
public class HomeCommand  implements Command{

    public Results invoke(String input) {
        String message = "1. Translate zip code to bar code\n" +
                "2. Translate bar code to zip code\n" +
                "3. Quit\n" +
                "Please input your choices(1~3)";
        return new Results(message);
    }
}
