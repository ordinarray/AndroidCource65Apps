package com.saystayandfly.androidcourse65apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.home.androidcourse65apps.CardClickListener
import com.home.androidcourse65apps.ContactDetailsFragment
import com.home.androidcourse65apps.ContactListFragment
import com.home.androidcourse65apps.ToolBarTitleSetter

class Contact{
    companion object {
        const val image = R.drawable.avatar
        const val name = "Alex"
        const val num1 = "89090552090"
        const val num2 = "89128141209"
        const val email1 = "picka4u@mail.ru"
        const val email2 = "samurai@gmail.com"
        const val description = "Описание контакта"
    }
}

class MainActivity : AppCompatActivity(), ToolBarTitleSetter, CardClickListener {

    override fun setToolBarTitle(title: String) {
        setTitle(title)
    }

    override fun onCardClick(fragment: Fragment) {
        addFragment(fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addFragment(ContactListFragment())
        }
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragments_container, fragment)
        when (fragment) {
            is ContactDetailsFragment -> transaction.addToBackStack("")
        }
        transaction.commit()
    }
}