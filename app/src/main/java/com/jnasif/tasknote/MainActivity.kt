 package com.jnasif.tasknote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.databinding.ActivityMainBinding
import com.jnasif.tasknote.ui.TaskNoteAdapter
import com.jnasif.tasknote.viewmodel.MainViewModel

 class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskNoteAdapter
    private lateinit var mainViewModel: MainViewModel
    private lateinit var taskNotes : List<TaskNoteEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }
//        taskNotes = SampleDataCreatorUtility.getTaskNotes()
        initRecyclerview()
        initViewModel()
//        taskNotes = mainViewModel.mTaskNote


        for(taskNote in taskNotes){
            System.out.println(taskNote)
        }
    }

     private fun initViewModel() {
         mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
         mainViewModel.mTaskNote.observe(this, Observer {
             if(adapter==null){
                 adapter = TaskNoteAdapter(taskNotes, this)
                 binding.layoutContentMain.recyclerVIew.adapter =adapter
             }else{
                 adapter.notifyDataSetChanged()
             }
         })
     }

     private fun initRecyclerview() {
        binding.layoutContentMain.recyclerVIew.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        binding.layoutContentMain.recyclerVIew.layoutManager = layoutManager
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_sdd_sample_data -> {
                addSampleData()
                true
            }
            R.id.action_delete_all_data -> {
                deleteAllData()
               true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

     private fun addSampleData() {
         mainViewModel.addSampleData()
     }
     private fun deleteAllData() {
         mainViewModel.deleteAllData()
     }
 }