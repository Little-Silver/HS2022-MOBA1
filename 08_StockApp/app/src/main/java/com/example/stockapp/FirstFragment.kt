package com.example.stockapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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

        //init adapter
        val adapter = StockAdapter(mutableListOf<Stock>(), requireContext())
        val model: StockViewModel by activityViewModels()
        val items = mutableListOf(
            Stock("Apple", "AAPL", 115.69),
            Stock("Microsoft", "MSFT", 214.36),
            Stock("Google", "GOOGL", 1519.45),
            Stock("Salesforce", "CRM", 255.52),
            Stock("Facebook", "FB", 260.02),
            Stock("Amazon", "AMZN", 3201.86),
            Stock("eBay", "EBAY", 54.05),
            Stock("Twitter", "TWTR", 45.41),
            Stock("Snapchat", "SNAP", 28.11))

        //update livedata
        model.stocks.observe(viewLifecycleOwner){
            Observer<MutableList<Stock>> {newVal ->
                adapter.stocks.clear()
                adapter.stocks.addAll(newVal)
                adapter.notifyDataSetChanged()
            }
        }
        //call observer
        //stocks.value = mutableListOf<Stock>()
        context?.let { model.loadStock(it) }

        binding.addButton.setOnClickListener{
            Log.i("tag","Button clicked")
            context?.let { it1 ->
                val requestQueue = Volley.newRequestQueue(requireContext())
                //define a request.
                val request = StringRequest(
                    Request.Method.GET,
                    "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=<HKB0Z76QN7Z6GDZZ>",
                    { response ->
                        val stockBase = Klaxon().parse<StockKlaxonBase>(response)
                        Log.i("ibm", "${stockBase?.globalQuote?.symbol}")

                        model.addStock("n/a",binding.stockText.text.toString(),stockBase!!.globalQuote.price.toDouble(),it1)

                        //binding.listView.adapter = adapter
                    },
                    {
                        //use the provided VolleyError to display
                        //an error message
                    })
                //add the call to the request queue
                requestQueue.add(request)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}