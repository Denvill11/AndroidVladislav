package com.example.foodcrut

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        val button = findViewById<Button>(R.id.sign_in_button)
        val emailText = findViewById<EditText>(R.id.sign_in_email)
        val passwordText = findViewById<EditText>(R.id.sign_in_password)
        val emailData: Array<String> = resources.getStringArray(R.array.emails)
        val passwordData: Array<String> = resources.getStringArray(R.array.password)

        val errorColor = Color.parseColor("#FF0000")

        emailText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {}
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                emailText.setTextColor(Color.BLACK)
                passwordText.setTextColor(Color.BLACK)
            }
        })
        passwordText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {}
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                emailText.setTextColor(Color.BLACK)
                passwordText.setTextColor(Color.BLACK)
            }
        })

        button.setOnClickListener {
            val emailCheck = emailText.text.toString()
            val passwordCheck = passwordText.text.toString()
            var check: Boolean = false

            for (i in 0..4) {
                if (emailCheck == emailData[i] && passwordCheck == passwordData[i]) {
                    check = true
                    break
                }
            }

            if (check) {
                val intent = Intent(this@LoginUserActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                emailText.setTextColor(errorColor)
                passwordText.setTextColor(errorColor)
            }
        }
    }
}
