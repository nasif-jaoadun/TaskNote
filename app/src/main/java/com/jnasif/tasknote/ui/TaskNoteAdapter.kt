package com.jnasif.tasknote.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jnasif.tasknote.EditorActivity
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.databinding.TaskNoteListItemBinding
import com.jnasif.tasknote.utilities.TASK_NOTE_ID_KEY

class TaskNoteAdapter(mTaskNotes : List<TaskNoteEntity>, mContext : Context) : RecyclerView.Adapter<TaskNoteAdapter.ViewHolder>() {

    lateinit var binding: TaskNoteListItemBinding
    val mTaskNotes: List<TaskNoteEntity> = mTaskNotes
    val mContext : Context = mContext
//    val mContext: Context = mContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = TaskNoteListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = mTaskNotes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskNote : TaskNoteEntity = mTaskNotes.get(position)
        binding.textViewTaskDetails.text = taskNote.taskNoteText
        binding.textViewTaskName.text = taskNote.taskNameText
        binding.floatingActionButton.setOnClickListener { view ->
            val intent = Intent(mContext, EditorActivity::class.java)
            intent.putExtra(TASK_NOTE_ID_KEY, taskNote.id)
            mContext.startActivity(intent)
        }
        binding.radioButton.isChecked = taskNote.taskDone
        binding.radioButton.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked: Boolean ->

        }
//        holder.bind(taskNote)
    }

    class ViewHolder(binding: TaskNoteListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        /*val binding = binding
        fun bind(taskNoteEntity: TaskNoteEntity){
            binding.textView.text = taskNoteEntity.taskNameText
        }*/
    }
}