package com.example.stockapp

import android.app.Notification
import android.app.Notification.Action
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stockapp.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

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

        val items = mutableListOf(
            Stock("Apple", "AAPL", 115.69),
            Stock("Microsoft", "MSFT", 214.36),
            Stock("Google", "GOOGL", 1519.45),
            Stock("Salesforce", "CRM", 255.52),
            Stock("Facebook", "FB", 260.02),
            Stock("Amazon", "AMZN", 3201.86),
            Stock("eBay", "EBAY", 54.05),
            Stock("Twitter", "TWTR", 45.41),
            Stock("Snapchat", "SNAP", 28.11)
        )

        val adapter = StockAdapter(items)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(
            requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}