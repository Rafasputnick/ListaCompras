package com.lucas.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tratarLogin()
    }

    fun tratarLogin() {
        if (FirebaseAuth.getInstance().currentUser == null) {
            val provedores = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build())

            val intent = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(provedores).build()

            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Toast.makeText(this, "", Toast.LENGTH_LONG)
        }
    }
}