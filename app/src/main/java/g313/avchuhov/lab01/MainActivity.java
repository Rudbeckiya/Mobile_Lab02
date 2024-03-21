package g313.avchuhov.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ain;
    EditText bin;
    TextView resout;

    float a, b;

    boolean check = false;

    Button badd, bsub, bnul, bdiv, bsin, bcos, btan, broot, bdegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ain = findViewById(R.id.a_input);
        bin = findViewById(R.id.b_input);
        resout = findViewById(R.id.result_output);

        badd = findViewById(R.id.add_button);
        bsub = findViewById(R.id.sub_button);
        bnul = findViewById(R.id.nul_button);
        bdiv = findViewById(R.id.div_button);
        bsin = findViewById(R.id.sin_button);
        bcos = findViewById(R.id.cos_button);
        btan = findViewById(R.id.tan_button);
        broot = findViewById(R.id.root_button);
        bdegree = findViewById(R.id.degree_button);

    }

    boolean get_numbers()
    {
        String astr = ain.getText().toString();
        String bstr = bin.getText().toString();
        try
        {
            if (check == true)
            {
                a = Float.parseFloat(astr);
                b = Float.parseFloat(bstr);
            }
            else
            {
                a = Float.parseFloat(astr);
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public void universal_code(View v)
    {
        if (v == badd || v == bsub || v == bnul || v == bdiv || v == bdegree) check = true;
        else check = false;
        get_numbers();
        if (get_numbers() == false)
        {
            resout.setText("Некорректный ввод");
            return;
        }
        float r = 0;
        if (v == badd) r = a + b;
        if (v == bsub) r = a - b;
        if (v == bnul) r = a * b;
        if (v == bdiv)
        {
            if (b != 0) r = a / b;
            else
            {
                resout.setText("Нельзя делить на ноль");
                return;
            }
        }
        if (v == bsin) r = (float)Math.sin(a);
        if (v == bcos) r = (float)Math.cos(a);
        if (v == btan) r = (float)Math.tan(a);
        if (v == broot)
        {
            if (a < 0)
            {
                resout.setText("Число должно быть больше нуля");
                return;
            }
            else r = (float) Math.sqrt(a);
        }
        if (v == bdegree) r = (float)Math.pow(a, b);
        set_result(r);
    }

    void standard_operations()
    {
        
    }

    void set_result(float r)
    {
        String resstr = String.valueOf(r);
        resout.setText(resstr);
    }
}