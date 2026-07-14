package com.littleapp.news.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.littleapp.news.databinding.ActivitySplashBinding
import com.littleapp.news.utils.applyAppTheme
import com.littleapp.news.utils.launchActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        applyAppTheme()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(SPLASH_DELAY)
            launchActivity(MainActivity::class.java, finish = true)
        }
    }

    companion object {
        private val SPLASH_DELAY = 2.seconds
    }
}
