package projects.android.bmicalculator.model;

public class Utilities {

    public static String getBMIReport(String unitOfWeight, double valueOfWeight, String unitOfHeight, double valueOfHeight) {
        String result = "";
        int flag = 0;
        double weight;
        double height;
        if (unitOfWeight!="pound" && unitOfWeight!="kilogram") {
            result = "Error: "+unitOfWeight+" is not a valid weight unit";flag++;}
        else if (unitOfHeight!="inch" && unitOfHeight!="foot") {
            result = "Error: "+unitOfHeight+" is not a valid height unit";flag++;}
        else if (valueOfWeight<=0.0 || valueOfHeight<=0.0) {
            result = "Error: both weight and height must be positive";flag++;}

        if (unitOfHeight.equals("inch"))
        {
            height=valueOfHeight*0.0254;
        }
        else
        {
            height=valueOfHeight*0.3048;
        }
        if (unitOfWeight.equals("pound"))
        {
            weight = valueOfWeight*0.453592;
        }
        else
        {
            weight = valueOfWeight;
        }
        double bmi = weight/(Math.pow(height, 2));

        if (flag==0)
        {
            result = "BMI is: "+String.format("%.2f", bmi);
            if (bmi<18.5)
                result = result+" (Underweight)";
            else if (bmi>=18.5 && bmi<25.0)
                result = result+" (Normal)";
            else if (bmi>=25.0 && bmi<30.0)
                result = result+" (Overweight)";
            else
                result = result+" (Obese)";
        }

        return result;
    }
}
