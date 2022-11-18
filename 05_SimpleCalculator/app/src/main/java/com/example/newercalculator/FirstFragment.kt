package com.example.newercalculator

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newercalculator.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.plusButton.setOnClickListener {
            val number1String : String = binding.firstNumber.text.toString()
            val number2String : String = binding.secondNumber.text.toString()
            if(!(TextUtils.isEmpty(number1String) && TextUtils.isEmpty(number2String))){
                val number1 : Double = number1String.toDouble()
                val number2 : Double = number2String.toDouble()
                val res : Double = number1 + number2
                binding.resultView.text = res.toString()
            }
        }
        binding.minusButton.setOnClickListener {
            val number1String : String = binding.firstNumber.text.toString()
            val number2String : String = binding.secondNumber.text.toString()
            if(!(TextUtils.isEmpty(number1String) && TextUtils.isEmpty(number2String))){
                val number1 : Double = number1String.toDouble()
                val number2 : Double = number2String.toDouble()
                val res : Double = number1 - number2
                binding.resultView.text = res.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}