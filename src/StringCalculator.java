import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        Pattern pattern = Pattern.compile("-?\\d");

        if (numbers.isEmpty())
            return 0;
        else if (pattern.matcher(numbers).matches()) {
            return Integer.parseInt(numbers);
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