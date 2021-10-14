package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lonhatlong_activity_fragment_recycler.OnBoardingActivity
import com.example.lonhatlong_activity_fragment_recycler.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentEmail : Fragment() {

    lateinit var onBoardingActivity: OnBoardingActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_email, container, false)
        onBoardingActivity = activity as OnBoardingActivity
        val tvWait: TextView = view.findViewById(R.id.tv_fragmentemail_wait)
        val btResendEmail: Button = view.findViewById(R.id.bt_fragmentemail_resend_email)
        btResendEmail.isEnabled = false
        btResendEmail.isClickable = false
        var count = 5
        GlobalScope.launch(Dispatchers.Main) {
            while (count >= 0){
                tvWait.setText("Wait $count seconds before sending it")
                delay(1000)
                count--
                if(count == -1){
                    tvWait.setText("You can resend email now!")
                    btResendEmail.isEnabled = true
                    btResendEmail.isClickable = true
                }
            }
        }
        btResendEmail.setOnClickListener {
            if(onBoardingActivity.userName == null && onBoardingActivity.password == null){
                Toast.makeText(onBoardingActivity.applicationContext, "Bạn chưa có tài khoản!!. vui lòng tạo tài khoản", Toast.LENGTH_SHORT).show()
            }else{
                val password: String = "123"
                onBoardingActivity.password = password.toString()
                Toast.makeText(onBoardingActivity.applicationContext, "Lấy lại mật khẩu thành công. Mật khẩu mặc định của bạn là: 123", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_fragmentEmail_to_fragmentConfirmPasswordChange)
            }
        }
        return view
    }
}