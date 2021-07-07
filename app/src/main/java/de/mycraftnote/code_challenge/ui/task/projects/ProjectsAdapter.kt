package de.mycraftnote.code_challenge.ui.task.projects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.mycraftnote.code_challenge.databinding.ProjectListItemBinding
import de.mycraftnote.code_channlenge.domain.model.ProjectModel

class ProjectsAdapter(
  private val onClick: (ProjectModel) -> Unit,
) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {

  private val projects = mutableListOf<ProjectModel>()

  override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
    return ViewHolder(ProjectListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount() = projects.size

  private fun getItem(position: Int) = projects[position]

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  inner class ViewHolder(private val binding: ProjectListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(projectModel: ProjectModel) {
      binding.apply {
        this.projectModel = projectModel
        this.onClick = View.OnClickListener { onClick(projectModel) }
        executePendingBindings()
      }
    }
  }

  fun newData(data: List<ProjectModel>) {
    projects.apply {
      clear()
      addAll(data.toList())
    }
    notifyDataSetChanged()
  }
}

