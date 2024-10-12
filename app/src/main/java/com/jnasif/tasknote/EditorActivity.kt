package com.jnasif.tasknote

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jnasif.tasknote.databinding.ActivityEditorBinding
import com.jnasif.tasknote.utilities.TASK_NOTE_ID_KEY
import com.jnasif.tasknote.viewmodel.EditorViewModel

class EditorActivity : AppCompatActivity() {
    private var mNewTaskNote: Boolean = false
    private var mViewModel: EditorViewModel? = null
    private var binding: ActivityEditorBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditorBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        val toolbar = binding!!.toolbar
        setSupportActionBar(toolbar)
        //        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        //        toolBarLayout.setTitle(getTitle());
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_done)
        val fab = binding!!.fab
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        initViewModel()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        mViewModel!!.mLiveTaskNote.observe(this, Observer {
            if(it!=null){
                binding?.layoutEditorContent?.editTextTaskNote!!.setText(it.taskNameText)
                binding?.layoutEditorContent?.editTextTaskNoteDetails!!.setText(it.taskNoteText)
            }
            val extras = intent.extras
            if(extras == null){
                setTitle(getString(R.string.new_task_note))
                mNewTaskNote = true
            }else{
                setTitle(getString(R.string.edit_task_note))
                val taskNoteId = extras.getInt(TASK_NOTE_ID_KEY)
                mViewModel!!.loadData(taskNoteId)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(!mNewTaskNote){
            val inflater = menuInflater
            inflater.inflate(R.menu.menu_editor, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == android.R.id.home){
            saveAndReturn()
            return true
        }else if(item.itemId == R.id.action_delete){
            mViewModel?.deleteTaskNote()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        saveAndReturn()
    }

    private fun saveAndReturn() {
        mViewModel?.saveTaskNote(binding?.layoutEditorContent?.editTextTaskNote?.text.toString(), binding?.layoutEditorContent?.editTextTaskNoteDetails?.text.toString())
    }
}