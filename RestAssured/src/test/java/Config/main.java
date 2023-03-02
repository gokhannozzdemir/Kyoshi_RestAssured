package Config;

import java.util.Map;

public class main {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();

        for (String envName : envMap.keySet()) {
            System.out.format("%s = %s%n", envName, envMap.get(envName));
        }
    }
}
