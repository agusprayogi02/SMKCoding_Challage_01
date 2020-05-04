package id.agusbro.appchallenge01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val bundle = intent.extras
        tnama.text = " : " + bundle!!.getString("nama")
        tjk.text = " : " + bundle.getString("jenisKl")
        tumur.text = " : " + bundle.getString("umur")
        ttelp.text = " : " + bundle.getString("telp")
        tamt.text = " : " + bundle.getString("alamat")
        temail.text = " : " + bundle.getString("email")
    }
}
