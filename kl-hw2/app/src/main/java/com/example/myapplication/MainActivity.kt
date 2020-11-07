package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Nullable

class MainActivity : AppCompatActivity() {
    private lateinit var btn : Button
    private lateinit var tv_meal : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_meal = findViewById(R.id.tv_meal)
        btn = findViewById(R.id.btn_choice)
        btn.setOnClickListener{
                startActivityForResult( Intent(MainActivity@this,MainActivity2::class.java),1)
            }
        }

    override fun onActivityResult( requestCode : Int,  resultCode : Int, data : Intent? ) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data==null)return

        if(requestCode==1){
            if(resultCode==101){
                var  str1 = data?.getStringExtra("drink")
                var  str2 = data?.getStringExtra("sugar")
                var  str3 = data?.getStringExtra("ice")
                tv_meal.setText(String.format("飲料：%s\n\n甜度：%s\n\n冰塊：%s\n\n",
                    str1,
                    str2,
                    str3))
            }
        }
    }
}