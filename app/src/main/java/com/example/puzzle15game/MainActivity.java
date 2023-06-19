package com.example.puzzle15game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Random;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    //private int[] puzzle = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;
    Button btn16;
    Button btn_Start;
    CheckBox test_btn;
    Model X1 = new Model();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      btn1 = (Button) findViewById(R.id.btn1);
      btn2 = (Button)findViewById(R.id.btn2);
      btn3 = (Button)findViewById(R.id.btn3);
      btn4 = (Button)findViewById(R.id.btn4);
      btn5 = (Button)findViewById(R.id.btn5);
      btn6 = (Button)findViewById(R.id.btn6);
      btn7 = (Button)findViewById(R.id.btn7);
      btn8 = (Button)findViewById(R.id.btn8);
      btn9 = (Button)findViewById(R.id.btn9);
      btn10 = (Button)findViewById(R.id.btn10);
      btn11 = (Button)findViewById(R.id.btn11);
      btn12 = (Button)findViewById(R.id.btn12);
      btn13 = (Button)findViewById(R.id.btn13);
      btn14 = (Button)findViewById(R.id.btn14);
      btn15 = (Button)findViewById(R.id.btn15);
      btn16 = (Button)findViewById(R.id.btn16);
      btn_Start= (Button)findViewById(R.id.Start);
      test_btn = (CheckBox) findViewById(R.id.Test);
        updateButtons();

        btn1.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn2.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn3.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn4.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn5.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn6.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn7.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn8.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn9.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn10.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn11.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn12.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn13.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn14.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn15.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn16.setOnClickListener(view -> {
            buttonClicked(view);
        });
        btn_Start.setOnClickListener(view -> {
            StartButton(view);
        });


    }

    private void updateButtons() {
        btn1.setText(String.valueOf(X1.puzzle[0]));
        btn2.setText(String.valueOf(X1.puzzle[1]));
        btn3.setText(String.valueOf(X1.puzzle[2]));
        btn4.setText(String.valueOf(X1.puzzle[3]));
        btn5.setText(String.valueOf(X1.puzzle[4]));
        btn6.setText(String.valueOf(X1.puzzle[5]));
        btn7.setText(String.valueOf(X1.puzzle[6]));
        btn8.setText(String.valueOf(X1.puzzle[7]));
        btn9.setText(String.valueOf(X1.puzzle[8]));
        btn10.setText(String.valueOf(X1.puzzle[9]));
        btn11.setText(String.valueOf(X1.puzzle[10]));
        btn12.setText(String.valueOf(X1.puzzle[11]));
        btn13.setText(String.valueOf(X1.puzzle[12]));
        btn14.setText(String.valueOf(X1.puzzle[13]));
        btn15.setText(String.valueOf(X1.puzzle[14]));
        btn16.setText(String.valueOf(X1.puzzle[15]));
    }

    public void buttonClicked(View view) {
        Button btn = (Button) view;
        int btnIndex = getButtonIndex(btn);
        int zeroIndex = X1.getZeroIndex();
        count++;
        //System.out.println(zeroIndex);
        //System.out.println(btnIndex);
        if (X1.isAdjacent(btnIndex, zeroIndex)) {
            System.out.println("Hello");
            X1.swap(btnIndex, zeroIndex);
            updateButtons();
            if (X1.isSolved()) {
                String msg = Integer.toString(count);
                count=0;
                msg = "Congratulations, you solved the puzzle in  " + msg + " !";
                Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Test(View view)
    {
        X1.puzzle[0]=1;X1.puzzle[1]=2;X1.puzzle[2]=3;X1.puzzle[3]=4;
        X1.puzzle[4]=5;X1.puzzle[5]=6;X1.puzzle[6]=7;X1.puzzle[7]=8;
        X1.puzzle[8]=9;X1.puzzle[9]=10;X1.puzzle[10]=11;X1.puzzle[11]=0;
        X1.puzzle[12]=13;X1.puzzle[13]=14;X1.puzzle[14]=15;X1.puzzle[15]=12;
      updateButtons();
    }

    public void StartButton(View view)
    {
        count=0;
        if(test_btn.isChecked()) {
            Test(view);
            return;
        }
        else {
            boolean[] used = new boolean[16];
            Random rand = new Random();
            for (int i = 0; i < X1.puzzle.length; i++) {
                int num = rand.nextInt(16);
                while (used[num]) {
                    num = rand.nextInt(16);
                }
                used[num] = true;
                X1.puzzle[i] = num;
            }
            updateButtons();
        }
    }

    private int getButtonIndex(Button btn) {
        if (btn == btn1) {
            return 0;
        } else if (btn == btn2) {
            return 1;
        } else if (btn == btn3) {
            return 2;
        } else if (btn == btn4) {
            return 3;
        } else if (btn == btn5) {
            return 4;
        } else if (btn == btn6) {
            return 5;
        } else if (btn == btn7) {
            return 6;
        } else if (btn == btn8) {
            return 7;
        } else if (btn == btn9) {
            return 8;
        } else if (btn == btn10) {
            return 9;
        } else if (btn == btn11) {
            return 10;
        } else if (btn == btn12) {
            return 11;
        } else if (btn == btn13) {
            return 12;
        } else if (btn == btn14) {
            return 13;
        } else if (btn == btn15) {
            return 14;
        } else if (btn == btn16)
        {
            return 15;
        }
            else {
            return -1;
        }
    }


}

class Model {

    public int[] puzzle = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};



    public int getZeroIndex() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAdjacent(int btnIndex, int zeroIndex) {
        return (btnIndex == zeroIndex - 1 && btnIndex % 4 != 3) || (btnIndex == zeroIndex + 1 && btnIndex % 4 != 0) || (btnIndex == zeroIndex - 4) || (btnIndex == zeroIndex + 4) ;
    }

    public void swap(int btnIndex, int zeroIndex) {
        int temp = puzzle[btnIndex];
        puzzle[btnIndex] = puzzle[zeroIndex];
        puzzle[zeroIndex] = temp;
    }

    public boolean isSolved() {
        for (int i = 0; i < puzzle.length; i++) {
            if (puzzle[i] != i + 1 && i != puzzle.length - 1) {return false;
            }
        }
        return true;
    }
        }