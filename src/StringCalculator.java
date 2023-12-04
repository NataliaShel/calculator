import java.util.regex.Pattern;

public class StringCalculator {
    private static char[] metaChars={'*','+','&','?','|','%','$','#'};
    public int add(String numbers) {
        Pattern pattern = Pattern.compile("-?\\d");

        if (numbers.isEmpty())
            return 0;
        else if (pattern.matcher(numbers).matches()) {
            return Integer.parseInt(numbers);
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
            int sum = 0;
            for (int i=0; i < nums.length; i++){
                if (!nums[i].isEmpty()){
                    int num = Integer.parseInt(nums[i]);

                        sum += num;

                }
            }
            return sum;
        }
        String[] nums = numbers.split(",|\\n");
        int sum = 0;

        for (int i=0; i < nums.length; i++){
            int num = Integer.parseInt(nums[i]);

                sum += num;
        }
        return sum;
    }

}