/*
* 5/3
* pcの遠隔操作の成功。開発環境をラップトップからデスクトップへ移行。
*
* 4/25
* 西暦を元号へ変換して表示する。ところまで
*
*/

package com.example.y3033028_kadai_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //フィールド変数
    EditText et;//入力のためのビュー
    TextView tv_result;//"結果表示用のビュー"
    String str;//一時保存用
    SpannableStringBuilder sb;//一時保存用
    int ad;//西暦
    int gengoNum;//元号の年度
    String gengoName;//元号の名称

    @Override
    protected void onCreate(Bundle savedInstanceState) {//最初に呼ばれるメソッド
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditTextの設定
        et = (EditText) findViewById(R.id.editText_1);

        //buttonの設定
        Button b =(Button) findViewById(R.id.button_01);

        //buttonイベント処理の受付
        b.setOnClickListener(this);

        //text viewの設定
        tv_result = (TextView)findViewById(R.id.result);
        //tv.setText("Hello Android !");

    }
    //ライフサイクル、Toastの確認
//    @Override
//    protected void onStart() {
//        super.onStart();
//        showToast("onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        showToast("onResume");
//    }
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        showToast("onPause");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        showToast("onStop");
//    }
//
//    @Override
//    protected void onRestart(){
//        super.onRestart();
//        showToast("onRestart");
//    }
//
//    public void showToast(String string){//引数stringをtoastに表示するメソッド
//        Toast t = Toast.makeText(this, string, Toast.LENGTH_SHORT);
//        t.show();
//    }

    @Override
    //inplementsした インターフェイスのメソッドの実装
    public void onClick(View v) {
        //showToast("Button Clicked");

        sb = (SpannableStringBuilder)et.getText();//EditTextに入力した文字列を取得
        str = sb.toString();//文字列をStringに変換
        ad = Integer.parseInt(str);//文字列をintに変換
        ad_to_Gengo();//元号に変換する
        StringBuilder bld = new StringBuilder();//文字列連結用のバッファー変数
        //以下 表示する文字列の連結
        bld.append(gengoName);
        bld.append(Integer.toString(gengoNum));
        bld.append("年です。");

        tv_result.setText(bld.toString());//テキストビューに表示
        //finish(); //アプリを閉じる
    }
    //西暦：adを元号に変換するメソッド
    public void ad_to_Gengo(){
        if(ad >= 2019){
            gengoName= "令和";
            gengoNum = ad -2019 +1;
        }
        else if(ad >= 1989){
            gengoName = "平成";
            gengoNum = ad -1989 +1;
        }
        else if(ad >= 1926){
            gengoName = "昭和";
            gengoNum = ad -1926 +1;
        }
        else if(ad >= 1912){
            gengoName = "大正";
            gengoNum = ad -1912 +1;
        }
        else if(ad >= 1868){
            gengoName = "明治";
            gengoNum = ad -1868 +1;
        }
        else{
            gengoName ="対応範囲外です。\n";
            gengoNum = 0;
        }
    }
}