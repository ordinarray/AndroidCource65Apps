package com.home.androidcourse65apps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.saystayandfly.androidcourse65apps.Contact
import com.saystayandfly.androidcourse65apps.R

interface ToolBarTitleSetter {
    fun setToolBarTitle(title: String)
}

interface CardClickListener {
    fun onCardClick(fragment: Fragment)
}

class ContactListFragment : Fragment() {

    private val contactId = 1
    private var titleSetter: ToolBarTitleSetter? = null
    private var listener: CardClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolBarTitleSetter)
            titleSetter = context
        titleSetter?.setToolBarTitle(getString(R.string.title_contact_list))
        if (context is CardClickListener)
            listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.contactAvatar).setImageResource(Contact.image)
        view.findViewById<TextView>(R.id.contactName).text = Contact.name
        view.findViewById<TextView>(R.id.contactNumber).text = Contact.num1
        view.findViewById<CardView>(R.id.contact).setOnClickListener {
            listener?.onCardClick(ContactDetailsFragment.newInstance(contactId))
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        titleSetter = null
    }
}