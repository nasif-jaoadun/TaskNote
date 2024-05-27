package com.jnasif.tasknote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jnasif.tasknote.databinding.ActivityEditorBinding
import com.jnasif.tasknote.viewmodel.EditorViewModel

class EditorActivity : AppCompatActivity() {
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
            binding?.layoutEditorContent?.editTextTaskNote?.text
            binding?.layoutEditorContent?.editTextTaskNoteDetails?.text
        })
    }
}