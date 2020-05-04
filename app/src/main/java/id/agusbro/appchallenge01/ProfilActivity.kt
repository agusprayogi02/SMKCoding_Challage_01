package id.agusbro.appchallenge01

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        edit.setOnClickListener {
            finish()
        }
        about.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        dial.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                val uri = bundle.getString("telp")
                intent.putExtra(Intent.EXTRA_SUBJECT,"Share Here")
                intent.putExtra(Intent.EXTRA_TEXT,uri)
                startActivity(Intent.createChooser(intent,"Sharing Option"))
            }catch (exp: Exception){
                Toast.makeText(applicationContext,"Whatsapp Tidak Terintall!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
