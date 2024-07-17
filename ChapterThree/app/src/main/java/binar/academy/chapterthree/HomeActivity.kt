package binar.academy.chapterthree

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    private lateinit var usernameTextView : TextView
    private lateinit var emailTextView : TextView
    private lateinit var addressTextView : TextView
    private lateinit var ageTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        try {
            this.serializablereceipt()
        }catch (e: ActivityNotFoundException){
            Log.e("LoginActivity",e.toString())
            Toast.makeText(this, "Halo ini toast", Toast.LENGTH_SHORT).show()
        }
        try {
            passingreceipt()
        }catch (e: ActivityNotFoundException){
            Log.e("LoginActivity",e.toString())
            Toast.makeText(this, "Halo ini toast", Toast.LENGTH_SHORT).show()
        }
        try {
            parcelablereceipt()
        }catch (e: ActivityNotFoundException){
            Log.e("LoginActivity",e.toString())
            Toast.makeText(this, "Halo ini toast", Toast.LENGTH_SHORT).show()
        }
    }

    private fun passingreceipt(){
        val passingusername=intent.getStringExtra("name")
        val passingemail=intent.getStringExtra("email")
        val passingaddress=intent.getStringExtra("address")
        val passingage=intent.getIntExtra("age",0)
        Log.d("MainActivity", passingusername.toString())
        Log.d("MainActivity", passingemail.toString())
        Log.d("MainActivity", passingaddress.toString())
        Log.d("MainActivity", passingage.toString())
    }
    fun serializablereceipt(){
        val personserializable = intent.getSerializableExtra("an_object_serializable") as PersonSerializable
        Log.d("MainActivity", personserializable.toString())
    }
    private fun parcelablereceipt(){
        usernameTextView = findViewById(R.id.username_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        addressTextView = findViewById(R.id.address_text_view)
        ageTextView = findViewById(R.id.age_text_view)

        val personparcelable = intent.getParcelableExtra<PersonParcelable>("an_object_parcelable")
        Log.d("MainActivity", personparcelable.toString())
        usernameTextView.text=personparcelable?.name
        emailTextView.text=personparcelable?.email
        addressTextView.text=personparcelable?.address
//        val age = person.age.toInt()
        ageTextView.text= personparcelable?.age
    }
}