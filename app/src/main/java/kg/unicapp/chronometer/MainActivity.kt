package kg.unicapp.chronometer

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var chronometer: Chronometer? = null
    private var buttonStart: Button? = null
    private var buttonStop: Button? = null
    private var buttonResetBaseTime: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById<View>(R.id.myChron) as Chronometer
        buttonStart = findViewById<View>(R.id.btnStart) as Button
        buttonStop = findViewById<View>(R.id.btnStop) as Button
        buttonResetBaseTime = findViewById<View>(R.id.btnReset) as Button
        buttonStop!!.isEnabled = false
        buttonResetBaseTime!!.isEnabled = false
        buttonStart!!.setOnClickListener { doStart() }
        buttonStop!!.setOnClickListener { doStop() }
        buttonResetBaseTime!!.setOnClickListener { doResetBaseTime() }
    }



    private fun doStart() {
        val elapsedRealtime = SystemClock.elapsedRealtime()
        chronometer!!.base = elapsedRealtime
        chronometer!!.start()
        buttonStart!!.isEnabled = false
        buttonStop!!.isEnabled = true
        buttonResetBaseTime!!.isEnabled = true
    }

    private fun doStop() {
        chronometer!!.stop()
        buttonStart!!.isEnabled = true
        buttonStop!!.isEnabled = false
        buttonResetBaseTime!!.isEnabled = false
    }

    private fun doResetBaseTime() {
        val elapsedRealtime = SystemClock.elapsedRealtime()
        chronometer!!.base = elapsedRealtime

    }
}