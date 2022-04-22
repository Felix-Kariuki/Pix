package com.flexcode.pix.presentation.ui.activitites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.flexcode.pix.R
import com.flexcode.pix.databinding.ActivityMainBinding
import com.flexcode.pix.util.invisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as
                NavHostFragment
        navController = navHostFragment.findNavController()

        binding.bottomNavigationView.apply { setupWithNavController(navController) }


        //hide bottom nav view
        navController.addOnDestinationChangedListener{_, destination, _->
            when(destination.id){
                R.id.imageDetailFragment ->{
                    binding.bottomNavigationView.invisible()
                }
            }
        }
    }
}