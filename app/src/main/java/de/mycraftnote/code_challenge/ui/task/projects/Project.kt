package de.mycraftnote.code_challenge.ui.task.projects

data class Project(
     val id: String,
     val name: String,
     val startDate: Long,
     val endDate: Long,
     val street: String,
     val zipcode: String
)