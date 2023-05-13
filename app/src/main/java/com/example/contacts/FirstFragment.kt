package com.example.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.contacts.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    var contacts = mutableListOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater,container,false)
        val db = DBHelper(requireContext())

        contacts = db.getContacts()

        if (contacts.isEmpty()){
            binding.box.visibility = View.VISIBLE
        }else{
            var adapter = ItemAdapter(contacts, object : ItemAdapter.ItemInterface{
                override fun onClick(contact: Contact) {
                    val bundle = bundleOf()
                    bundle.putSerializable("contact",contact)
                    findNavController().navigate(R.id.action_firstFragment_to_thirdFragment2,bundle)
                }

            })
            binding.rv.adapter = adapter


        }

        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return binding.root
    }


}