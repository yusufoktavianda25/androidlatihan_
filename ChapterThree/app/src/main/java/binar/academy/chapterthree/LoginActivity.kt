package binar.academy.chapterthree

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    //TODO 1 deklarasi widget
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var passingButton: Button
    private lateinit var serializableButton: Button
    private lateinit var parcelableButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //TODO 2 casting view/widget
        passingButton = findViewById(R.id.passing_button_)
        serializableButton = findViewById(R.id.serializable_button_)
        parcelableButton = findViewById(R.id.parcelable_button_)
        usernameEditText = findViewById(R.id.username_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        addressEditText = findViewById(R.id.address_edit_text)
        ageEditText = findViewById(R.id.age_edit_text)

        //TODO 3 action listener pada sebuah button > button melakukan sebuah aksi
//        loginButton.setOnClickListener{
            //TODO 4 lakukan actionnya / do something
//            Toast.makeText(this, "Halo ini toast", Toast.LENGTH_SHORT).show(
            /**
             * param 1 adalah activity asal
             * param 2 adalah activity tujuan
             */
//            val username = usernameEditText.text.toString().trim()
//            val email = emailEditText.text.toString().trim()
//            val address = addressEditText.text.toString().trim()
////            val age = ageEditText.text.toString().trim()

//            Ketika mengirim datanya String yang menerima juga harus String dan seterusnya
//


//            coba Bundle
//            val bundle = Bundle()
//            bundle.putString("name", username)
//            bundle.putString("pass", password)
//            intent.putExtras(bundle)
            passingData()
            serializableData()
            parcelableData()
//        }
    }

    private fun passingData(){
        val intent = Intent(this, HomeActivity::class.java)
        passingButton.setOnClickListener{
            intent.putExtra("name", "Yusuf")
            intent.putExtra("email", "Yusuf@gmail.com")
            intent.putExtra("address", "Otista")
            intent.putExtra("age", 20)
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                Log.e("LoginActivity",e.toString())
                Toast.makeText(this, "Halo ini toast", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun serializableData(){
        serializableButton.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            val personserializ=PersonSerializable (
                name = usernameEditText.text.toString().trim(),
                email = emailEditText.text.toString().trim(),
                address = addressEditText.text.toString().trim(),
                age = ageEditText.text.toString().trim()
            )
            intent.putExtra("an_object_serializable", personserializ)
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                Log.e("LoginActivity",e.toString())
                Toast.makeText(this, "Error mas!", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun parcelableData(){
        parcelableButton.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            val personparce=PersonParcelable(
                name = usernameEditText.text.toString().trim(),
                email = emailEditText.text.toString().trim(),
                address = addressEditText.text.toString().trim(),
                age = ageEditText.text.toString().trim()
            )
            intent.putExtra("an_object_parcelable", personparce)
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                Log.e("LoginActivity",e.toString())
                Toast.makeText(this, "Error mas!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}