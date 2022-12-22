package ch.zhaw.assignment_08

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.zhaw.assignment_08.databinding.FragmentFirstBinding
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val model: StockDataViewModel by activityViewModels()
    private lateinit var adapter: StockAdapter
    private val items = mutableListOf<Stock>()

    /*
    private val items = mutableListOf(
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
     */

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
        //create and add the adapter

        adapter = StockAdapter(items, this)
        binding.recyclerView.adapter = adapter

        model.initDatabase(requireContext())    // Database empty init

        lifecycleScope.launchWhenStarted {
            withContext(Dispatchers.Default) {
                model.readStocks()
            }
        }

        model.stocks.observe(viewLifecycleOwner, Observer<MutableList<Stock>>{stocks ->
            adapter.list.clear()
            adapter.list.addAll(stocks)
            adapter.notifyDataSetChanged()
            Log.i("STOCKSIZE", stocks.size.toString())  // Stock size after adding
        })

        binding.AddNewStock.setOnClickListener() {
            addNewStock()
        }

        //and a layout manager (needed!). This layout defines the positioning of the cells
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //horizontal line
        val itemDecor = DividerItemDecoration(context, RecyclerView.VERTICAL)
        binding.recyclerView.addItemDecoration(itemDecor)
    }

    private fun addNewStock() {
        val name = binding.NewStock.text.toString()
        val symbol = binding.NewSymbol.text.toString()
        val newStock = Stock(items.size + 1, name, symbol, 0.0)     // Stock gets added with empty value

        lifecycleScope.launchWhenStarted {
            withContext(Dispatchers.Default) {
                model.insertStocks(newStock)
                Log.i("NEWSTOCK", newStock.name!!)      // Who was added?
                model.readStocks()
            }
        }

    }

    fun callServer(stock: Stock) {
        //create a request queue
        val requestQueue = Volley.newRequestQueue(requireContext())
        //define a request.
        //key: HKB0Z76QN7Z6GDZZ
        val url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=${stock.symbol}&apikey=HKB0Z76QN7Z6GDZZ"
        val request = StringRequest(Request.Method.GET, url, { response ->
            Log.i("START", "Update starts!")
            parseJSON(response, stock)
            Log.i("END", "Update ends!")
        },
            { Log.i("END", "Update didn't work!")})
        requestQueue.add(request)
    }

    private fun parseJSON(response: String, stock: Stock) {
        val jsonObject = JSONObject(response)

        val global = jsonObject.getJSONObject("Global Quote")
        Log.i("GLOBAL", global.toString())

        val price = global.getString("05. price")
        stock.value = price.toDouble()
        Log.i("STOCK_CHANGE", stock.name!!)
        Log.i("STOCK_CHANGE", stock.value.toString())

        adapter.notifyDataSetChanged()
    }

    // Global Quote IBM
    //{"01. symbol":"IBM",
    // "02. open":"130.0000",
    // "03. high":"130.9600",
    // "04. low":"129.5200",
    // "05. price":"130.6300",
    // "06. volume":"3632177",
    // "07. latest trading day":"2021-12-23",
    // "08. previous close":"129.7500",
    // "09. change":"0.8800",
    // "10. change percent":"0.6782%"}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}