package binar.academy.chapterthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    lateinit var usernameTextView : TextView
    lateinit var passwordTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         usernameTextView = findViewById(R.id.username_text_view)
         passwordTextView = findViewById(R.id.password_text_view)
//        val bundle = intent.extras
//        val resultname = bundle?.getString("name")
//        val resultpass = bundle?.getString("pass")
//        val result = intent.getStringExtra("key")
//        val userresult = intent.getStringExtra("name")
//        val passresult = intent.getStringExtra("pass")

//        val userresult = intent.getStringExtra("name")
//        val emailresult = intent.getStringExtra("email")
//        val addressresult = intent.getStringExtra("address")
//        val ageresult = intent.getStringExtra("age")

//      Typecasting object person
//        val person = intent.getSerializableExtra("an_object") as PersonSerializable

//        Log.d("MainActivity", result.toString())
//        Log.d("MainActivity", userresult.toString())
//        Log.d("MainActivity", passresult.toString())
//        Log.d("MainActivity", userresult.toString())
//        Log.d("MainActivity", emailresult.toString())
//        Log.d("MainActivity", person.toString())
//        usernameTextView.text=person.name
//        passwordTextView.text=person.email
//        usernameTextView.text=resultname.toString()
//        passwordTextView.text=resultpass.toString()
    }
}