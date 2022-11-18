package com.example.stockapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.example.stockapp.databinding.FragmentFirstBinding


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

        val requestQueue = Volley.newRequestQueue(requireContext())
        //define a request.
        val request = StringRequest(
            Request.Method.GET, "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=<HKB0Z76QN7Z6GDZZ>",
            { response ->
                val stockBase = Klaxon().parse<StockKlaxonBase>(response)
                Log.i("ibm", stockBase!!.globalQuote.symbol)

                val items = mutableListOf(
                    stockBase.globalQuote,
                    Stock("AAPL", "115.69"),
                    Stock("MSFT", "214.36"),
                    Stock("GOOGL", "1519.45"),
                    Stock("CRM", "255.52"))

                val adapter = StockAdapter(
                    items,
                    requireContext());

                binding.listView.adapter = adapter
            },
            {
                //use the provided VolleyError to display
                //an error message
            })
        //add the call to the request queue
        requestQueue.add(request)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}