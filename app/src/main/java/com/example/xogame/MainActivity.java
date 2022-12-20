package com.example.xogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
TextView player1Score,player2Score;
int player1ScoreValue =0 ,player2ScoreValue =0;
ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Score=findViewById(R.id.player1_Score);
        player2Score=findViewById(R.id.player2_Score);
        constraintLayout = findViewById(R.id.root_view);
        initializeBoard();
    }
    int counter =0;
    ArrayList<String> board;

    public void initializeBoard(){
        board = new ArrayList<>(9);
        counter =0;
        for(int i =0;i<9;i++){
            board.add("");
        }

        // 3lshan lama a5als yraglii al bord tani fadya
    for(int i =0;i< constraintLayout.getChildCount();i++){

      View view = constraintLayout.getChildAt(i);
       if(view instanceof  Button){
        ((Button) view).setText("");

    }
}
    }



    public void onPlayerClick(View view){
        Button btn;
        // 3lshan awl ma yla2ii haga mktobkamykamlsh w ytl3

        if(view instanceof Button){
            btn=((Button) view);
            if(!btn.getText().toString().isEmpty()){
                return;
            }
               String playerSymbole;
               if(counter % 2 == 0){
                   playerSymbole = "X";
                   btn.setText("X");
                }else{
                   playerSymbole="O";
                   btn.setText("O");
               }
               //3lshan lama ydos 3ala al btn yhot ali atkatb feh hata lw mdash 3ala al btn bltarteb
              placePlayerSympol(btn,board,playerSymbole);
               ++counter;

               if(checkIfPlayerWin("X",board)){
                   player1ScoreValue+=1;
                   player1Score.setText("" + player1ScoreValue);
                   Toast.makeText(this,getString(R.string.player_1_x)+"Wins",Toast.LENGTH_SHORT).show();
                   initializeBoard();
               }else if (checkIfPlayerWin("O",board)){
                   player2ScoreValue+=1;
                   player2Score.setText(""+player2ScoreValue);
                   Toast.makeText(this,getString(R.string.player_2_o)+"Wins",Toast.LENGTH_SHORT).show();
                   initializeBoard();
               }else if(counter == 9){
                   Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
                   initializeBoard();
               }

               //btn.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red, null));

            //counter++;
        }
    }

    private void placePlayerSympol(Button btn,ArrayList<String> boardState,String playerSymbole) {

          //lama ygii yktb hafa hda5lha feh al array list w rabt al aray bl btns

           if(btn.getId() == R.id.btn1){

                boardState.set(0,playerSymbole);

            }else if (btn.getId() == R.id.btn2){

                boardState.set(1,playerSymbole);
            }else if (btn.getId() == R.id.btn3){

                boardState.set(2,playerSymbole);
            }else if (btn.getId() == R.id.btn4){

                boardState.set(3,playerSymbole);
            }else if (btn.getId() == R.id.btn5){

                boardState.set(4,playerSymbole);
            }else if (btn.getId() == R.id.btn6){

                boardState.set(5,playerSymbole);
            }else if (btn.getId() == R.id.btn7){

                boardState.set(6,playerSymbole);
            }else if (btn.getId() == R.id.btn8){

                boardState.set(7,playerSymbole);
            }else if (btn.getId() == R.id.btn9){

                boardState.set(8,playerSymbole);
            }

    }



    public boolean checkIfPlayerWin(String playerSympole,ArrayList<String> boardState){
       //h3ml chek ll row w ll column
        //chek rows
        for(int i =0;i<9;i+=3){

            if(boardState.get(i).equals(playerSympole) && boardState.get(i+1).equals(playerSympole) && boardState.get(i+2).equals(playerSympole))
                return  true;

        }
        //3lshan ymshii 3ala a column

        for(int i = 0;i < 3; i++){
            if(boardState.get(i).equals(playerSympole) && boardState.get(i+3).equals(playerSympole) && boardState.get(i+6).equals(playerSympole))
             return true;
        }
 //check diagonals
        if(boardState.get(0).equals(playerSympole) && boardState.get(4).equals(playerSympole) && boardState.get(8).equals(playerSympole))
            return true;

        if(boardState.get(2).equals(playerSympole) && boardState.get(5).equals(playerSympole) && boardState.get(6).equals(playerSympole))
            return true;
        return false;
    }


}