package id.agusbro.appchallenge01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinner()

        simpan.setOnClickListener {
            Simpan()
        }
    }

    private fun ShowToast(masage: String) {
        Toast.makeText(this, masage, Toast.LENGTH_LONG).show()
    }

    private fun Simpan() {
        val nama = inpnama.text.toString()
        val email = inpemail.text.toString()
        val telp = inpTelp.text.toString()
        val alamat = inpAlamat.text.toString()
        val umur = inpumur.text.toString()
        val Jk = jenisKl.selectedItem.toString()

        when {
            nama.isEmpty() -> {
                inpnama.error = "Nama Tidak Boleh Kosong"
            }
            Jk.equals("Pilih Jenis Kelamin", true) -> {
                ShowToast("Silakan Pilih Jenis Kelamin")
            }
            email.isEmpty() -> {
                inpemail.error = "Email Tidak Boleh Kosong"
            }
            telp.isEmpty() -> {
                inpTelp.error = "Telp Tidak Boleh Kosong"
            }
            alamat.isEmpty() -> {
                inpAlamat.error = "Alamat Tidak Boleh Kosong"
            }
            umur.isEmpty()->{
                inpumur.error = "Umur Tidak Boleh Kosong"
            }
            else -> {
                val i = Intent(this, ProfilActivity::class.java)
                i.putExtra("nama", nama)
                i.putExtra("jenisKl", Jk)
                i.putExtra("email", email)
                i.putExtra("umur", umur)
                i.putExtra("telp",telp)
                i.putExtra("alamat", alamat)
                startActivity(i)
            }
        }
    }

    private fun setSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.jenisK,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        jenisKl.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.aboutme -> {
                About()
                true
            }
            R.id.exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun About() {
        val i = Intent(this, AboutActivity::class.java)
        startActivity(i)
    }
}
