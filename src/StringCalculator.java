import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringCalculator {
    private static char[] metaChars={'*','+','&','?','|','%','$','#'};
    public int add(String numbers) throws Exception {
        Pattern pattern = Pattern.compile("-?\\d");

        if (numbers.isEmpty())
            return 0;
        else if (pattern.matcher(numbers).matches()) {
            if(getNegativeNumbers(numbers).isEmpty())
                if (Integer.parseInt(numbers)>1000)
                    return 0;
                else
                    return Integer.parseInt(numbers);
            else
                throw new NegativeNumberException("Number must be non-negative: ", getNegativeNumbers(numbers));
        }
        if (numbers.startsWith("//")){
            int index = numbers.indexOf("\n");
            String del = numbers.substring(3,index-1);
            String delimiters[]=del.split("\\]\\[");
            //char delimiter = numbers.charAt(index-1);
            String sep="";
            for(int i=0;i<delimiters.length; i++) {
                String newDelimiter="" ;
                for (char d :  delimiters[i].toCharArray()) {
                    boolean isMeta = false;
                    for (char meta : metaChars) {
                        if (d == meta) {
                            newDelimiter += "\\" + d;
                            isMeta = true;
                            break;
                        }


                    }
                    if (!isMeta) {
                        newDelimiter += d;
                    }
                }
                if(i!=delimiters.length-1)
                    sep+=newDelimiter+"|";
                else
                    sep+=newDelimiter;
            }

            String[] nums = numbers.substring(index+1).split(sep+"|,|\n");
            if(!getNegativeNumbers(nums).isEmpty()){
                throw new NegativeNumberException("Numbers must be non-negative: ", getNegativeNumbers(nums));
            }
            int sum = 0;
            for (int i=0; i < nums.length; i++){
                if (!nums[i].isEmpty()){
                    int num = Integer.parseInt(nums[i]);
                    if (num <= 1000) {
                        sum += num;
                    }
                }
            }
            return sum;
        }
        String[] nums = numbers.split(",|\\n");
        int sum = 0;
        if(!getNegativeNumbers(nums).isEmpty()){
            throw new NegativeNumberException("Numbers must be non-negative: ", getNegativeNumbers(nums));
        }
        for (int i=0; i < nums.length; i++){
            int num = Integer.parseInt(nums[i]);
            if (num <= 1000) {
                sum += num;
            }
        }
        return sum;
    }

    ArrayList<Integer> getNegativeNumbers(String[] numbers){
        ArrayList<Integer> nums = new ArrayList<>();
        for(String num: numbers){
            int n = Integer.parseInt(num);
            if(n<0){
                nums.add(n);
            }
        }
        return nums;
    }

    ArrayList<Integer> getNegativeNumbers(String number){
        ArrayList<Integer> nums = new ArrayList<>();
        int n = Integer.parseInt(number);
        if(n<0){
            nums.add(n);
        }
        return nums;
    }

}