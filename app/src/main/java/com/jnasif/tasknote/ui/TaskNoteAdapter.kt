package com.jnasif.tasknote.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.jnasif.tasknote.database.TaskNoteEntity
import com.jnasif.tasknote.databinding.TaskNoteListItemBinding

class TaskNoteAdapter(mTaskNotes : List<TaskNoteEntity>) : RecyclerView.Adapter<TaskNoteAdapter.ViewHolder>() {

    lateinit var binding: TaskNoteListItemBinding
    val mTaskNotes: List<TaskNoteEntity> = mTaskNotes
//    val mContext: Context = mContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = TaskNoteListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = mTaskNotes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskNote : TaskNoteEntity = mTaskNotes.get(position)
        binding.textViewTaskDetails.text = taskNote.taskNameText
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