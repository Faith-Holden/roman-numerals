package solution;

public class RomanNumeral {
    int arabicNumeral;
    String romanNumeral;

    //constructors
    public RomanNumeral(String romanNumeral){
        this.romanNumeral = romanNumeral;
        try{
            this.arabicNumeral = toArabicFromRomanNumeral();
        }catch (NumberFormatException e){
            throw new NumberFormatException(e.getMessage());
        }
    }
    public RomanNumeral(int arabicNumeral){
        this.arabicNumeral = arabicNumeral;

        try{
            this.romanNumeral = toRomanFromArabicNumeral(arabicNumeral);
        }catch (NumberFormatException e){
            throw new NumberFormatException(e.getMessage());
        }


    }

    //instance methods
    private int toArabicFromRomanNumeral() throws NumberFormatException{
        romanNumeral = romanNumeral.toUpperCase();
        int repeatChar = 0;
        char prevChar = ' ';
        char currentChar;
        char nextChar = ' ';
        int arabicNumeral = 0;
        for(int i = 0; i<romanNumeral.length(); i++){
            currentChar = romanNumeral.charAt(i);
            if(i<romanNumeral.length()-1){
                nextChar = romanNumeral.charAt(i+1);
            }
            if (currentChar==prevChar){
                repeatChar++;
            }else{
                repeatChar = 1;
            }

            if(repeatChar>3){
                throw new NumberFormatException(romanNumeral + " is not a legal roman numeral.");
            }

            switch (currentChar){
                case 'I':
                    if(nextChar == 'X'){
                        arabicNumeral+=9;
                        i++;
                    }else if(nextChar=='V'){
                        arabicNumeral+=4;
                        i++;
                    }else{
                        arabicNumeral+=1;
                    }
                    break;
                case 'X':
                    if(nextChar=='C'){
                        arabicNumeral+=90;
                        i++;
                    }else if(nextChar == 'L'){
                        arabicNumeral+=40;
                        i++;
                    }else{
                        arabicNumeral+=10;
                    }
                    break;
                case 'C':
                    if(nextChar=='M'){
                        arabicNumeral+=900;
                        i++;
                    }else if(nextChar == 'D'){
                        arabicNumeral+=400;
                        i++;
                    }else{
                        arabicNumeral+=100;
                    }
                    break;
                case 'V':
                    arabicNumeral+=5;
                    break;
                case 'L':
                    arabicNumeral+=50;
                    break;
                case 'D':
                    arabicNumeral+=500;
                    break;
                case 'M':
                    arabicNumeral+=1000;
                    break;
                default:
                    throw new NumberFormatException(romanNumeral + " is not a legal roman numeral.");
                }

            prevChar = currentChar;
        }
        return arabicNumeral;
    }

    private String toRomanFromArabicNumeral(int arabicNumeral) throws NumberFormatException{
        int maxNumTranslatable = 3999;
        if(arabicNumeral>maxNumTranslatable){
            throw new NumberFormatException(arabicNumeral+" is too big! Please Type a number between 0 and " +maxNumTranslatable+1);
        }

        String[] romanNumHolder = new String[]{"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] intCounter = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        StringBuilder numeralBuilder = new StringBuilder();

        for(int i = intCounter.length-1; i>=0; i--){
            int tempInt = 0;
            tempInt = arabicNumeral/intCounter[i];
            arabicNumeral -= tempInt*intCounter[i];
            numeralBuilder.append(romanNumHolder[i].repeat(Math.max(0, tempInt)));
        }
        return numeralBuilder.toString();
    }

    public String toString(){
        return romanNumeral;
    }

    public int toInt(){
        return arabicNumeral;
    }
}
