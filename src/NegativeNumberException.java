import java.util.ArrayList;

class NegativeNumberException extends Exception{

        private ArrayList<Integer> numbers;
        public ArrayList<Integer> getNumbers(){return numbers;}
        public NegativeNumberException(String message, ArrayList<Integer> nums){

            super(message);
            numbers=nums;
        }

        @Override
    public String getMessage(){
            String res = "";
            res+=super.getMessage();
            for(int i : numbers){
                res+= i+" ";
            }
            return res;
        }
    }

