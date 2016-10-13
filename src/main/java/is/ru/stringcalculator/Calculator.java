package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//")) {
			String delim = text.substring(text.indexOf("//") +2, text.indexOf("\n"));
			return sum(splitNewDelim(text, delim));
		}
		else if(text.contains(",") || text.contains("\n"))
			return sum(split(text));	
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] split(String numbers){
	    return numbers.split(",|\n");
	}
	
	private static String[] splitNewDelim(String numbers, String delim){
		return numbers.substring(numbers.indexOf("\n") + 1).split(delim);;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
		String negativeNums = null;

        for(String number : numbers) {
		    if(toInt(number) >= 0 && toInt(number) < 1000)
				total += toInt(number);
			else
				negativeNums += ("," + number);
		}
		for(String nums : numbers) {
			if(toInt(nums) < 0) {
				negativeNums = negativeNums.substring(5);
				throw new IllegalArgumentException("Negatives not allowed: " + negativeNums);
			}
		}
		return total;
    }
}