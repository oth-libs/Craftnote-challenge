# Android Coding Challenge
The following exercises should help us to better assess your skills. We have created an example project that already contains some code.<br>
Please fork the repository to an own private repository and solve following problems.

Your code should be clean, efficient and tested.

In doubt, keep it simple!

 What do you need?
* [GithHub](https://github.com/) Account
* Current version of Android Studio 4+ und Gradle

**The Exercises do not have to be solved in the given order**

## Exercise 1

After opening the app a login-screen appears. In this screen there is a login-button whereby the user can access the app.

The screen is developed for a Pixel 2XL display. Please refactor the Layout so that the app can also be used on devices like Pixel 2.

context-package: package de.mycraftnote.code_challenge.ui.login.*

## Exercise 2
Create a project list in the ProjectListFragment. A single list item should look like:

![viewholder example](./project_item.png)

Where the first character from the project-name displayed in circle.
The first line is the name of the project, the second line is the full address and can be ignored if the response doesn't contain one.
You can ignore attributes that are not required for this task.
The list for this task should contains only Folders, no Projects and sorted after creationDate<br>
On click on the project a snackbar should be shown with a localized lastOpenedDate.
Like: Project last opened on: Wed, Mar 31, '21.

endpoint: https://europe-west1-craftnote-development.cloudfunctions.net/api/v1/projects

api key: c322f488-05e7-4f4a-a2b3-41a4f31af501

you can find the documentation for the endpoint [here](https://bitbucket.org/Craftnote/api-doc/).


context-package: de.mycraftnote.code_challenge.ui.task.projects.*