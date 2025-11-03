package com.example.projecta


import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


//
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle

    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    val thirdFragment = ThirdFragment()
    val fourFragment = FourFragment()
    val fiveFragment = FiveFragment()


  


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //bottomNavigation
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (intent.getBooleanExtra("openFifthFragment", false)) {
            openFifthFragment()
        }else{
            if(intent.getBooleanExtra("openSecondFragment", false)){
                openSecondFragment()
            }else{
                loadFragment(firstFragment)
            }

        }


        //DrwerBar
        val toolBar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolBar)



        drawer = findViewById(R.id.drawer_layout)

        toogle = ActionBarDrawerToggle(this, drawer, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    private fun openSecondFragment() {
        val fragment = SecondFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()    }

    private fun openFifthFragment() {
        val fragment = FiveFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.firsFragment -> {
                loadFragment(firstFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.secondFragment -> {
                loadFragment(secondFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.thirdFragment -> {
                loadFragment(thirdFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.fourFragment -> {
                loadFragment(fourFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.fiveFragment -> {
                loadFragment(fiveFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment (fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedor, fragment)
            .commit()
    }









    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this, "Itmen1", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Itmen2", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Itmen3", Toast.LENGTH_SHORT).show()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}