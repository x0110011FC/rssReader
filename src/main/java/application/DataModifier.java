package application;

public class DataModifier {

    public static String replaceNasaWithFbi(String text) {
        String modifiedString = "";

        if (text.contains("NASA")) {
            modifiedString = text.replace("NASA", "FBI");
        } else {
            modifiedString = text.concat(" SAMPLE");
        }

        return modifiedString;
    }
}
