package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lonhatlong_activity_fragment_recycler.HomeActivity
import com.example.lonhatlong_activity_fragment_recycler.OnBoardingActivity
import com.example.lonhatlong_activity_fragment_recycler.R

class FragmentLogin : Fragment() {

    lateinit var onBoardingActivity: OnBoardingActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        onBoardingActivity = activity as OnBoardingActivity
        val btLogin: Button = view.findViewById(R.id.bt_fragmentlogin_login)
        val tvSignUp: TextView = view.findViewById(R.id.tv_fragmentlogin_sign_up)
        val tvFgPassowrd: TextView = view.findViewById(R.id.tv_fragmentlogin_forgot_password)
        val edtUserName: EditText = view.findViewById(R.id.edt_fragmentlogin_username)
        val edtPassword: EditText = view.findViewById(R.id.edt_fragmentlogin_password)
        if(onBoardingActivity.userName.equals("") != null && onBoardingActivity.password.equals("")!=null){
            edtUserName.setText(onBoardingActivity.userName)
            edtPassword.setText(onBoardingActivity.password)
        }
        tvSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentSignUp)
        }
        tvFgPassowrd.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentEmail)
        }
        btLogin.setOnClickListener {
            if(edtUserName.text.toString().equals(onBoardingActivity.userName) && edtPassword.text.toString().equals(onBoardingActivity.password)){
                val intent = Intent(activity, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }else{
                Toast.makeText(onBoardingActivity.applicationContext, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}