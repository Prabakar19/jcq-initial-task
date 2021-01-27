import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InitialTask {

    public static HashMap<String, List<String>> initializeCountries(){
        HashMap<String, List<String>> countries = new HashMap<>();
        List<String> indianCities = new ArrayList<>(Arrays.asList("Mumbai","Delhi","Bangalore","Hyderabad", "Chennai"));
        List<String> southKoreanCities =  new ArrayList<>(Arrays.asList("Andong","Anseong","Ansan","Asan", "Busan"));
        List<String> nepalCities = new ArrayList<>( Arrays.asList("Kathmandu","Pokhara","Lalitpur","Bharatpur", "BiratNagar"));
        List<String> somaliaCities = new ArrayList<>(Arrays.asList("Boon","Burco","Burane","Beyra", "Bosaso"));
        List<String> vietnamCities = new ArrayList<>(Arrays.asList("Ba Ria","Can tho","Da Nang","Hanoi", "Haiphong"));

        countries.put("India", indianCities);
        countries.put("South Korea", southKoreanCities);
        countries.put("Nepal", nepalCities);
        countries.put("Somalia", somaliaCities);
        countries.put("Vietnam", vietnamCities);

        return countries;
    }


    public static void main(String[] args) throws URISyntaxException, IOException {

        String openTitleTag = "<title>";
        String closeTitleTag = "</title>";
        String title;
        HashMap<String, List<String>> countries = new HashMap<>();

        Path path = Paths.get(InitialTask.class.getClassLoader().getResource("sample.html").toURI());
        String contents = new String(Files.readAllBytes(path));

        //Your logic goes here
//        System.out.println(contents);

        countries = initializeCountries();
        title = contents.substring(contents.indexOf(openTitleTag)+openTitleTag.length(), contents.indexOf(closeTitleTag));
        System.out.println("Country name: " +title);
        System.out.println("\n5 Cities in " +title + ":");

        for(String city : countries.get(title)){
            System.out.println(city);
        }



    }
}
