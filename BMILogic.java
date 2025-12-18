public class BMILogic {
    public  static double  calculateBMI(double heightM,double weightKg){
        return weightKg / (heightM * heightM);
    }
    public static  String getStatuse(double bmi, String gender){
        if(gender.equals("Female")){
            if(bmi < 18) return "underweight";
            else if (bmi < 24) return  "normal";
            else return "overweight";
        }
        else{
            if(bmi < 18.5) return "underweight";
            else if (bmi < 25) return  "normal";
            else return "overweight";

        }
    }
}
