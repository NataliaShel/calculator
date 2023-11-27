import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        Pattern pattern = Pattern.compile("-?\\d");

        if (numbers.isEmpty())
            return 0;
        else if (pattern.matcher(numbers).matches()) {
            return Integer.parseInt(numbers);
        }
        String[] nums = numbers.split(",");
        return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
    }

}