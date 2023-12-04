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
                return Integer.parseInt(numbers);
            else
                throw new NegativeNumberException("Number must be non-negative: ", getNegativeNumbers(numbers));
        }
        if (numbers.startsWith("//")){
            int index = numbers.indexOf("\n");

            char delimiter = numbers.charAt(index-1);
            String newDelimiter="" ;

            boolean isMeta = false;
            for(char meta : metaChars){
                if(delimiter==meta){
                    newDelimiter+="\\"+delimiter;
                    isMeta = true;
                    break;
                }

            }
            if(!isMeta)
                newDelimiter+=delimiter;

            String[] nums = numbers.substring(index+1).split(newDelimiter+"|,|\n");
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