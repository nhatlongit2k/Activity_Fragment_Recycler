package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lonhatlong_activity_fragment_recycler.OnBoardingActivity
import com.example.lonhatlong_activity_fragment_recycler.R
import kotlin.math.log

class FragmentSignUp : Fragment() {

    lateinit var onBoardingActivity: OnBoardingActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val btSignUp: Button = view.findViewById(R.id.bt_fragmentsignup_sign_up)
        val tvLogin: TextView = view.findViewById(R.id.tv_fragmentsignup_login)
        val tvFgPassword: TextView = view.findViewById(R.id.tv_fragmentsignup_forgot_password)
        val edtUserName: EditText = view.findViewById(R.id.edt_fragmentsignup_username)
        val edtPassword: EditText = view.findViewById(R.id.edt_fragmentsignup_password)

        btSignUp.setOnClickListener {
            onBoardingActivity = activity as OnBoardingActivity
            onBoardingActivity.userName = edtUserName.text.toString()
            onBoardingActivity.password = edtPassword.text.toString()
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentLogin)
        }
        tvLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentLogin)
        }
        tvFgPassword.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentEmail)
        }
        return view
    }
}