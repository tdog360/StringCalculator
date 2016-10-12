package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
		if(text.equals("")){
			return 0;
		}
		
		if(text.contains(",") || text.contains("\n"))
			return sum(split(text));	
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] split(String numbers){
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
		String negativeNums = null;

        for(String number : numbers){
		    if(toInt(number) >= 0)
				total += toInt(number);
			else
				negativeNums += ("," + number);
		}
		for(String nums : numbers)
			if(toInt(nums) < 0) {
				negativeNums = negativeNums.substring(5);
				throw new IllegalArgumentException("Negatives not allowed: " + negativeNums);
			}
		
		return total;
    }



}