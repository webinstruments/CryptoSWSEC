package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var encryptor: Encryptor
    lateinit var decryption: Decryption
    val DEFAULT_ALIAS = "TESTALIAS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encryptor = Encryptor()
        decryption = Decryption()

        val keyFromStore = decryption.getSecretKey(DEFAULT_ALIAS)

        button.setOnClickListener { view ->
            run {
                if (alias.text.isNotEmpty() && text2encrypt.text.isNotEmpty()) {
                    val text = text2encrypt.text.toString()
                    val enc = encryptor.encryptText(DEFAULT_ALIAS, text)
                    val dec = decryption.decryptData(DEFAULT_ALIAS, enc, encryptor.iv!!)
                    encrypted.text = enc.toString()
                    decrypted.text = dec
                } else {
                    Toast.makeText(this, "Alias or Text2Encrypt is empty", Toast.LENGTH_SHORT);
                }
            }
        }
    }
}
