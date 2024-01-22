package br.com.danielfreitassc.cursoSpringBoot.converters;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
            
        String number = strNumber.replaceAll("," ,".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;   
    }

    public static boolean isNumeric(String srtNumber) {
       if (srtNumber == null) return false;
       String number = srtNumber.replaceAll(",", ".");
       return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
// A injeção de dependencia serve para suprir isso