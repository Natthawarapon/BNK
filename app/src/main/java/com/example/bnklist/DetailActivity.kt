package com.example.bnklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item.view.*

class DetailActivity : AppCompatActivity() {
    var nDataArray = arrayListOf<itemBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //รับที่ละตัว
//        val username = intent.getStringExtra("username")
//        val password = intent.getStringExtra("password")

        //รับเป็นก้อน
        val acc =intent.getParcelableExtra<account>("account")
        val(username,password) =acc
        Toast.makeText(applicationContext,"username : $username password : $password", Toast.LENGTH_LONG).show()

        addDummyData()

        //ต้องมีการติดตั้ง Adapter แปลงarray Data ให้สามารถแสดง บนตัว RecleView ได้
        mRecycleView.adapter =CustomAdapter()
        mRecycleView.layoutManager =LinearLayoutManager(this)

    }

    private fun addDummyData() {
        for (item in 1..100){
            nDataArray.add(itemBean("cream","index : $item",""))

        }

    }


    inner class CustomAdapter : RecyclerView.Adapter<CustomHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
              val view =LayoutInflater.from(applicationContext).inflate(R.layout.list_item,parent,false)
            return CustomHolder(view)
        }

        override fun getItemCount(): Int {
            return nDataArray.size
        }

        override fun onBindViewHolder(holder: CustomHolder, position: Int) {
            //update data in row  by CustomHolder sent holder and position in here

            holder.title.text = nDataArray[position].title
            holder.subtitle.text = nDataArray[position].subtitle

        }

    }

    inner class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title =itemView.mTitleView
        var subtitle =itemView.mSubtitleView
        var image =itemView.mImageView
    }
}


