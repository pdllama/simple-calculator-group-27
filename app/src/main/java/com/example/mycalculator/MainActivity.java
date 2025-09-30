package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4 ,btn5 ,btn6 , btn7, btn8, btn9, btn_clear, btn_plus, btn_minos, btn_multiply, btn_devide, btn_equal, btn_dot;
    TextView text_display;

    // This is to evaluate the math expression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minos = (Button) findViewById(R.id.btn_minos);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_devide = (Button) findViewById(R.id.btn_devide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        text_display = (TextView) findViewById(R.id.textview_input_display);

        setClickListeners();
    }

    private void setClickListeners() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minos.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_devide.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                addNumber("0");
                break;
            case R.id.btn1:
                addNumber("1");
                break;
            case R.id.btn2:
                addNumber("2");
                break;
            case R.id.btn3:
                addNumber("3");
                break;
            case R.id.btn4:
                addNumber("4");
                break;
            case R.id.btn5:
                addNumber("5");
                break;
            case R.id.btn6:
                addNumber("6");
                break;
            case R.id.btn7:
                addNumber("7");
                break;
            case R.id.btn8:
                addNumber("8");
                break;
            case R.id.btn9:
                addNumber("9");
                break;
            case R.id.btn_plus:
                addNumber("+");
                break;
            case R.id.btn_minos:
                addNumber("-");
                break;
            case R.id.btn_multiply:
                addNumber("×");
                break;
            case R.id.btn_devide:
                addNumber("÷");
                break;
            case R.id.btn_equal:
                String result = null;
                try {
                    result = evaluate(text_display.getText().toString());
                    text_display.setText(result);
                } catch (Exception e) {
                    text_display.setText("Error");
                }
                break;
            case R.id.btn_clear:
                clear_display();
                break;
            case R.id.btn_dot:
                addNumber(".");
                break;
        }
    }

    private String evaluate(String expression) throws Exception {
        //to go from frontend form for multiplication and division to backend https://www.w3schools.com/jsref/jsref_replace.asp
        String Expr = expression.replace("×", "*").replace("÷", "/");

        String result = MathEval.eval(Expr);

        BigDecimal decimal = new BigDecimal(result);

        if (decimal.scale() > 0 && decimal.stripTrailingZeros().scale() > 0) {
            return decimal.stripTrailingZeros().toPlainString();
        } else {
            return decimal.toBigInteger().toString();
        }
    }



    private void addNumber(String number) {
        text_display.setText(text_display.getText() + number);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
