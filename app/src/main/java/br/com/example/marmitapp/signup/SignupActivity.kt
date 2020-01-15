package br.com.example.marmitapp.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.marmitapp.R

class SignupActivity : AppCompatActivity() {

    /*private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mAuth = FirebaseAuth.getInstance()
        btCreate.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(
                inputEmail.text.toString(),
                inputPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    saveInRealTimeDatabase()
                } else {
                    Toast.makeText(this@SignUpActivity, it.exception?.message,
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun saveInRealTimeDatabase() {
        val user = User(inputName.text.toString(), inputEmail.text.toString(),
            inputPhone.text.toString())
        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Usuário criado com sucesso",
                        Toast.LENGTH_SHORT).show()
                    val returnIntent = Intent()
                    returnIntent.putExtra("email", inputEmail.text.toString())
                    setResult(RESULT_OK, returnIntent)
                    finish()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao criar o usuário", Toast.LENGTH_SHORT).show()
                }
            }
    }*/
}
