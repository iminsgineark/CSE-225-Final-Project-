package com.eljem.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.eljem.myapplication.R
import com.eljem.myapplication.databinding.ActivityMainBinding
import com.eljem.myapplication.model.entity.Category
import com.eljem.myapplication.model.entity.Color
import com.eljem.myapplication.vm.PhotoVM

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var photoVM : PhotoVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        photoVM = PhotoVM()

        val colors = arrayListOf<Color>(Color("Light Orange","#F9A828"),
            Color("Gray","#ECECEB"),
            Color("Gold","#FFD700"),
            Color("Cyan","#00FFFF"),
            Color("Yellow","#FFFF00"),
            Color("Blue","#0000ff"),
            Color("Red","#FF0000"),
            Color("Navy", "#07617D"),
            Color("Magneta","#ff00ff"),
            Color("Purple","#800080"),
            Color("Black Cat","#413839"),
            Color("Magic Mint","#AAF0D1"),
            Color("Tea Green","#CCFB5D"),
            Color("Chrome White","#E8F1D4"),
            Color("Parchment","#FFFFC2"),
            )

        val categories = arrayListOf<Category>(
            Category("SUV",R.drawable.suv)
,            Category("Train", R.drawable.train2),
            Category("Airplane",R.drawable.airplane1),
            Category("coding",R.drawable.coding2),
            Category("nature",R.drawable.nature),
            Category("flowers",R.drawable.flowers),
            Category("birds",R.drawable.birds),
            Category("hypercars",R.drawable.hypercars),
            Category("louis philippe",R.drawable.images),
            Category("louis vuitton",R.drawable.louisvuitton),
            Category("google",R.drawable.google),
            Category("amzaon",R.drawable.amazon),
            Category("meta",R.drawable.meta),
            Category("Netflix",R.drawable.netflix),
            Category("TATA",R.drawable.tata)
        )


        val adapter = ColorAdapter(this, colors)

        binding.colors.layoutManager = LinearLayoutManager(this)
        binding.colors.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

            binding.colors.adapter = adapter

        val categoriesAdapter = CategoriesAdapter(this, categories)
        binding.categories.setHasFixedSize(true)
        binding.categories.itemAnimator = null
        binding.categories.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.categories.adapter = categoriesAdapter


    }
}