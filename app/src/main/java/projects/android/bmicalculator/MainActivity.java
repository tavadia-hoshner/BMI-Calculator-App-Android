package projects.android.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import projects.android.bmicalculator.model.*;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Hint: How do you initialize an empty bank and displays its status to the output textview
         * when the app is first launched?
         */
    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    public void onCalculateClicked(View view){
        String result = "";
        if(isDouble(getInputOfTextField(R.id.weight))&&isDouble(getInputOfTextField(R.id.height))) {
            double weight = Double.valueOf(getInputOfTextField(R.id.weight));
            double height = Double.valueOf(getInputOfTextField(R.id.height));
            String unitweight = getItemSelected(R.id.unitweight);
            String unitheight = getItemSelected(R.id.unitheight);
            if (unitweight.equals("Kg"))
                unitweight = "kilogram";
            if (unitweight.equals("Lb"))
                unitweight = "pound";
            if (unitheight.equals("Inch"))
                unitheight = "inch";
            if (unitheight.equals("Foot"))
                unitheight = "foot";
            result = Utilities.getBMIReport(unitweight, weight, unitheight, height);
        }
        else {
            result = "Error: All inputs should be numbers.";
        }
        setContentsOfTextView(R.id.result,result);
    }

    public void onResetClicked(View view){
        setContentsOfTextView(R.id.result,"");
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}