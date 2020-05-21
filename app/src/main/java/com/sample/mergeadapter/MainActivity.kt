package com.sample.mergeadapter

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import androidx.recyclerview.widget.SimpleItemAnimator
import com.sample.mergeadapter.adapter.FooterAdapter
import com.sample.mergeadapter.adapter.MyDetailAdapter
import com.sample.mergeadapter.adapter.UserAdapter
import com.sample.mergeadapter.data.DataSource
import com.sample.mergeadapter.models.MyDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MergeAdapter
    lateinit var myDetailAdapter: MyDetailAdapter
    lateinit var userAdapter: UserAdapter
    lateinit var footerAdapter: FooterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataInRecyclerView()

       /* // Removing items on a single adapter
        Handler().postDelayed({
            userAdapter.removeItem(3)
        }, 1000)

        Handler().postDelayed({
            userAdapter.removeItem(5)
        }, 2000)
        Handler().postDelayed({
            userAdapter.removeItem(7)
        }, 3000)*/
    }

    private fun setDataInRecyclerView() {
        val userDetail = MyDetail(1, "Danish Amjad", "Software Engineer Android Developer")
        recycler.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(this,DataSource.getUser())
        footerAdapter = FooterAdapter(DataSource.getFooter())
        myDetailAdapter = MyDetailAdapter(userDetail)
        adapter = MergeAdapter(myDetailAdapter, userAdapter, footerAdapter)
        recycler.adapter = adapter
    }

    fun removeItem(position: Int) {
        userAdapter.users.removeAt(position)
        userAdapter.notifyItemRemoved(position)
        userAdapter.notifyItemRangeChanged(position,userAdapter.users.size)
    }
}
