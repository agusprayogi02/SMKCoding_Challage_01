package id.agusbro.appchallenge01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    private var handler = Handler()
    private var progressStatus = 0
    private var isStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler(Handler.Callback {
            if (isStarted) {
                progressStatus++
            }

            if (progressStatus == 101) {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
                finish()
            }else{
                Loading.progress = progressStatus
                textProsess.text = "${progressStatus}/${Loading.max}"
                handler.sendEmptyMessageDelayed(0, 30)
            }

            true
        })
        handler.sendEmptyMessage(0)
        isStarted = true
    }
}
