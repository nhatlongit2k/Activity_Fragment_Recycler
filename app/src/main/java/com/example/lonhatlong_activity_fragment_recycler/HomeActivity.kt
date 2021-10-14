package com.example.lonhatlong_activity_fragment_recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager


class HomeActivity : AppCompatActivity() {
    lateinit var fragmentManager: FragmentManager
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.homeactivity_bottomNavigationView)
//        val navController = findNavController(R.id.homeActivity_fragmentContainerView)
//        bottomNavigationView.setupWithNavController(navController)
        fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val coinFragment = CoinFragment()
        val newsFragment = NewsFragment()
        val menuFragment = MenuFragment()


        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment ->{
                    val fragmentTranSaction = fragmentManager.beginTransaction()
                    fragmentTranSaction.replace(R.id.homeActivity_fragmentContainerView, homeFragment)
                    fragmentTranSaction.addToBackStack("HomeFragment")
                    fragmentTranSaction.commit()
                }
                R.id.coinFragment ->{
                    val fragmentTranSaction = fragmentManager.beginTransaction()
                    fragmentTranSaction.replace(R.id.homeActivity_fragmentContainerView, coinFragment)
                    fragmentTranSaction.addToBackStack("CoinFragment")
                    fragmentTranSaction.commit()
                }
                R.id.newsFragment ->{
                    val fragmentTranSaction = fragmentManager.beginTransaction()
                    fragmentTranSaction.replace(R.id.homeActivity_fragmentContainerView, newsFragment)
                    fragmentTranSaction.addToBackStack("NewsFragment")
                    fragmentTranSaction.commit()
                }
                R.id.menuFragment ->{
                    val fragmentTranSaction = fragmentManager.beginTransaction()
                    fragmentTranSaction.replace(R.id.homeActivity_fragmentContainerView, menuFragment)
                    fragmentTranSaction.addToBackStack("MenuFragment")
                    fragmentTranSaction.commit()
                }
            }
            return@setOnItemSelectedListener true
        }


    }
    override fun onBackPressed() {
        Log.d("TAG", "Stack: ${supportFragmentManager.backStackEntryCount}")
        if(supportFragmentManager.backStackEntryCount == 0 ){
            AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id -> this@HomeActivity.finish() })
                .setNegativeButton("No", null)
                .show()
        }else{
            if(supportFragmentManager.backStackEntryCount == 1){
                bottomNavigationView.menu.getItem(0).setChecked(true)
            }
            super.onBackPressed()
        }
//        else{
//            super.onBackPressed()
//            val index = fragmentManager.backStackEntryCount-1
//            Log.d("TAG", "Index: $index")
//            if(index>=0){
//                Log.d("TAG", "Name: ${fragmentManager.getBackStackEntryAt(index).name}")
//                if(fragmentManager.getBackStackEntryAt(index).name.equals("HomeFragment")){
//                    bottomNavigationView.menu.getItem(0).setChecked(true)
//                    //navigation.getMenu().getItem(0).setChecked(true);
//                }
//                if(fragmentManager.getBackStackEntryAt(index).name.equals("CoinFragment")){
//                    bottomNavigationView.menu.getItem(1).setChecked(true)
//                    //navigation.getMenu().getItem(0).setChecked(true);
//                }
//                if(fragmentManager.getBackStackEntryAt(index).name.equals("NewsFragment")){
//                    bottomNavigationView.menu.getItem(2).setChecked(true)
//                    //navigation.getMenu().getItem(0).setChecked(true);
//                }
//                if(fragmentManager.getBackStackEntryAt(index).name.equals("MenuFragment")){
//                    bottomNavigationView.menu.getItem(3).setChecked(true)
//                    //navigation.getMenu().getItem(0).setChecked(true);
//                }
//            }
//            if(index == -1){
//                bottomNavigationView.menu.getItem(0).setChecked(true)
//            }
//        }
    }
}