package com.ronaldiputra.coronainformasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.os.postDelayed
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var backPressOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavMenu()
    }

    override fun onBackPressed() {
        var navController = findNavController(R.id.fragmentHost)

        if (navController.graph.startDestination == navController.currentDestination?.id){
            if (backPressOnce){
                super.onBackPressed()
                return
            }

            backPressOnce = true
            Toast.makeText(this, "Tekan Sekali Lagi Untuk Keluar", Toast.LENGTH_SHORT).show()

            Handler().postDelayed(2000){
                backPressOnce = false
            }
        }else {
            super.onBackPressed()
        }
    }

    private fun bottomNavMenu() {
        var navController = findNavController(R.id.fragmentHost)

        var appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.informasiFragment,
            R.id.bantuanFragment,
            R.id.infoFragment
        ).build()

        bottomNav.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}