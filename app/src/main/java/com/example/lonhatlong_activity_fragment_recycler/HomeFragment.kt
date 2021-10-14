package com.example.lonhatlong_activity_fragment_recycler

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class HomeFragment : Fragment() {

    companion object{
        lateinit var tradixDatas: ArrayList<Tradix>
    }
    lateinit var homeActivity: HomeActivity
    lateinit var tradixRecyclerView: RecyclerView
    lateinit var tradixArrayList: ArrayList<Tradix>
    lateinit var layoutManager: LinearLayoutManager
    lateinit var progressBar: ProgressBar
    var page = 1
    var limit = 10
    var isloading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        val btBell : FloatingActionButton = view.findViewById(R.id.bt_fragmenthome_ring)
        btBell.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
        homeActivity = activity as HomeActivity
        if(homeActivity.supportFragmentManager.backStackEntryCount!=0){
            homeActivity.bottomNavigationView.menu.getItem(0).setChecked(true)
        }
        setTradixData()

        tradixRecyclerView = view.findViewById(R.id.fragmenthome_recyclerview)
        layoutManager = LinearLayoutManager(context)
        tradixRecyclerView.layoutManager = layoutManager
        tradixRecyclerView.setHasFixedSize(true)
        tradixArrayList = ArrayList<Tradix>()

        showFirstPage()

        btBell.setOnClickListener {
            val rnd : Random = Random;
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            btBell.backgroundTintList = ColorStateList.valueOf(color)
        }

        tradixRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var visibleItemCount = layoutManager.childCount
                var totalItemCount = tradixRecyclerView.adapter?.itemCount
                var firstVisibleItemPosition =layoutManager.findFirstCompletelyVisibleItemPosition()
                if(!isloading){
                    if(visibleItemCount+firstVisibleItemPosition >= totalItemCount!!){
                        LoadMore()
                    }
                }
            }
        })

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                tradixArrayList.removeAt(position)
                tradixRecyclerView.adapter?.notifyItemRemoved(position)
            }
        })
        itemTouchHelper.attachToRecyclerView(tradixRecyclerView)

        return view
    }
    private fun LoadMore(){
        progressBar.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            isloading=true
            page++
            val start = (page-1)*limit
            val end = page*limit-1
            if(end >= tradixDatas.size){
                for(i in start until tradixDatas.size){
                    tradixArrayList.add(tradixDatas[i])
                }
                tradixRecyclerView.adapter?.notifyItemRangeInserted(start, tradixDatas.size-start)
            }
            else{
                for(i in start..end){
                    tradixArrayList.add(tradixDatas[i])
                }
                tradixRecyclerView.adapter?.notifyItemRangeInserted(start, limit)
            }
            isloading = false
            progressBar.visibility = View.GONE
        }, 500)
    }

    private fun showFirstPage() {
        for(i in 0 until limit){
            tradixArrayList.add(tradixDatas[i])
        }
        tradixRecyclerView.adapter = AdapterTradixRecycler(tradixArrayList, activity)
    }

    private fun setTradixData() {
        tradixDatas = ArrayList<Tradix>()
        tradixDatas.add(Tradix("DOWN JONES 0", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 1", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 2", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 3", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DOWN JONES 4", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 5", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 6", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 7", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DOWN JONES 8", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 9", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 10", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 11", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DOWN JONES 12", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 13", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 14", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 15", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DOWN JONES 16", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 17", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 18", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 19", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DOWN JONES 20", 2004750, "NYSE", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("FTSE 100 21", 2004750, "LONDON", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("IBEX35 22", 2004750, "MARID", "10:44:45", "+203 (+1,04%)"))
        tradixDatas.add(Tradix("DAX 23", 2004750, "XETRA", "10:44:45", "+203 (+1,04%)"))
    }

}