package com.example.bnklist

import android.accounts.Account
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickLogin(view: View) {

            val username =mUsername.text.toString()
            val password = mPassword.text.toString()

        //change Activity
        val i = Intent(this@MainActivity,DetailActivity::class.java)
        //Easy Send Data
            //   i.putExtra("username",username)
            //   i.putExtra("password",password)

        //Parcelable Data
        val acc = account(username,password)
        i.putExtra("account",acc)
        startActivity(i)

    }
}
