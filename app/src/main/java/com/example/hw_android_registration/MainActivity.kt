package com.example.hw_android_registration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw_android_registration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[com]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regestrationButton.setOnClickListener{regester()}
    }

    @SuppressLint("SetTextI18n")
    fun regester(){
        var name = binding.name.text.toString().isNotEmpty()
        var e_mail = binding.editTextTextEmailAddress.text.toString().matches(emailPattern.toRegex())
        var pass = binding.Password.text.toString().isNotEmpty()
        var re_pass = binding.reenterPassword.text.toString().isNotEmpty()
        var equality = binding.Password.text.toString().equals(binding.reenterPassword.text.toString())
        var checked = binding.switchButton.isChecked

        if(equality && name && e_mail && pass && re_pass){
            binding.comment.setText("Registration Successed")
            binding.nameComment.setText(binding.name.text.toString())
            binding.emailComment.setText(binding.editTextTextEmailAddress.text.toString())
            binding.dateComment.setText(binding.date.text.toString())
        }else{
            binding.comment.setText("Registration not Successed")
            binding.nameComment.setText("")
            binding.emailComment.setText("")
            binding.dateComment.setText("")
        }

        if(checked){
            binding.comment2.setText("User is Female")
        }else{
            binding.comment2.setText("User is Male")
        }
    }
}