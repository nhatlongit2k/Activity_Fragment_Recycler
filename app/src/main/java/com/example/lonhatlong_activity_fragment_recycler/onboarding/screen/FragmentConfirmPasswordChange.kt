package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.lonhatlong_activity_fragment_recycler.R

class FragmentConfirmPasswordChange : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_confirm_password_change, container, false)
        val btReturnLogin: Button = view.findViewById(R.id.bt_fragmentChange_retur_to_login)
        btReturnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentConfirmPasswordChange_to_fragmentLogin)
        }
        return view
    }

}