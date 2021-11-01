package com.home.androidcourse65apps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import com.saystayandfly.androidcourse65apps.Contact
import com.saystayandfly.androidcourse65apps.R

class ContactDetailsFragment : Fragment() {

    private var titleSetter: ToolBarTitleSetter? = null
    private var contactId: Int? = null

    companion object {

        private const val ID = "ID"

        fun newInstance(id: Int) = ContactDetailsFragment().apply {
            arguments = bundleOf(
                    ID to id
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactId = requireArguments().getInt(ID)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolBarTitleSetter)
            titleSetter = context
        titleSetter?.setToolBarTitle(getString(R.string.title_contact_details))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ImageView>(R.id.detailsAvatar).setImageResource(Contact.image)
        view.findViewById<TextView>(R.id.detailsName).text = Contact.name
        view.findViewById<TextView>(R.id.detailsNum1).text = Contact.num1
        view.findViewById<TextView>(R.id.detailsNum2).text = Contact.num2
        view.findViewById<TextView>(R.id.detailsEmail1).text = Contact.email1
        view.findViewById<TextView>(R.id.detailsEmail2).text = Contact.email2
        view.findViewById<TextView>(R.id.detailsDescription).text = Contact.description
    }

    override fun onDetach() {
        super.onDetach()
        titleSetter = null
        contactId = null
    }
}