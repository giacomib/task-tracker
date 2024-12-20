# task-tracker
A project to track and manage your tasks, implements a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on.

## Project URL
https://roadmap.sh/projects/task-tracker

# Documentation

## Assumptions
- todo
## How to run the app
- to run the app from the command line, move to the task-tracker/src folder, then run the command `javac.App.java` to compile the code, then, to run the app, you have to run the command `java App ...` where the `...` stand for the command you want the app to do, example, i want to add a task with description "my little house", i will run the following command: `java App add "my little house"`
### Commands
- To add a task: `add "description of the new task"`
- To update a task: `update task_id "description of the updated task"`
- To delete a task: `delete task_id`
- To mark a task as in progress `mark-in-progress task_id`
- To mark a task as done `mark-done task_id`
- To list all tasks `list`
- To list all tasks that are to-do: `list-todo`
- To list all tasks that are in progress: `list-in-progress`
- To list all tasks that are done: `list-done`
## Other notes
- Even if the user type in a wrong operation, the basic file with an empty file structure will be correctly created.
- The JSON file storing all tasks will be created in the src directory if you run the program with the command line; if you run the program with visual studio code, the JSON file will be created in the root folder of the project(should be named *task-tracker*).

## JSON file structure
### Base structure
The app will create a JSON file named *taskList.json* if it does not already exist, otherwise the app will open the existing file named *taskList.json*; if you want to create an empty file, be sure to name it as *taskList.json* and that the structure respect the following schema:
```
{
    "tasks":[
    ]
}
```
### Task structure
If you want to manually ad a task, be sure to respect the following schema:
```
{"ID":1, "description":"Buy groceries", "status":"in-progress", "createdAt":"2024-12-05T18:54:30.000951", "updatedAt":"2024-12-17T18:54:54.004357"}
```
note that, if the task that you are manually adding isn't the last one in the file you have to add a comma at the end of the line, so the previous example will result in:
```
{
    "tasks":[
        {"ID":1, "description":"Buy groceries", "status":"in-progress", "createdAt":"2024-12-05T18:54:30.000951", "updatedAt":"2024-12-17T18:54:54.004357"},
        {"ID":2, "description":"Buy groceries", "status":"in-progress", "createdAt":"2024-12-05T18:54:30.000951", "updatedAt":"2024-12-17T18:54:54.004357"}
    ]
}
```
## Tests made
#### add
- [x] add task when there is no JSON file
- [x] add task when there is a JSON file (not containing any tasks, but already structured as documentation say)
- [x] add task when there is a JSON file and there is one task in the JSON file
- [x] add task when there is a JSON file and there are more tasks in the JSON file
#### update
- [x] update a task when there is not the file
- [x] update a task when there is not a task in the file
- [x] update a task when there is one task in the file and the id doesn't match
- [x] update a task when there is one task in the file and the id match
- [x] update a task when there is more than one task in the file and the id match
#### delete
- [x] delete a task when there is not the file
- [x] delete a task when there is not a task in the file
- [x] delete a task when there is one task in the file and the id doesn't match
- [x] delete a task when there is one task in the file and the id match
- [x] delete a task when there is more than one task in the file and the id match
#### mark in progress
- [x] mark in progress a task when there is not the file
- [x] mark in progress a task when there is not a task in the file
- [x] mark in progress a task when there is one task in the file and the id doesn't match
- [x] mark in progress a task when there is one task in the file and the id match
- [x] mark in progress a task when there is more than one task in the file and the id match
#### mark done
- [x] mark as done a task when there is not the file
- [x] mark as done a task when there is not a task in the file
- [x] mark as done a task when there is one task in the file and the id doesn't match
- [x] mark as done a task when there is one task in the file and the id match
- [x] mark as done a task when there is more than one task in the file and the id match
#### list
- [x] list all task when there is not the file
- [x] list all task when there is not a task in the file
- [x] list all task when there is one task in the file
- [x] list all task when there are more than one tasks in the file
#### list to-do
- [x] list all task with status "to-do" when there is not the file
- [x] list all task with status "to-do" when there is not a task in the file
- [x] list all task with status "to-do" when there is one task in the file and the status is "in-progress"
- [x] list all task with status "to-do" when there is one task in the file and the status is "done"
- [x] list all task with status "to-do" when there is one task in the file and the status is "to-do"
- [x] list all task with status "to-do" when there are more than one tasks in the file, at least one of them has the status attibute setted to "to-do"
#### list in-progress
- [x] list all task with status "in-progress" when there is not the file
- [x] list all task with status "in-progress" when there is not a task in the file
- [x] list all task with status "in-progress" when there is one task in the file and the status is "in-progress"
- [x] list all task with status "in-progress" when there is one task in the file and the status is "done"
- [x] list all task with status "in-progress" when there is one task in the file and the status is "to-do"
- [x] list all task with status "in-progress" when there are more than one tasks in the file, at least one of them has the status attibute setted to "in-progress"
#### list done
- [x] list all task with status "done" when there is not the file
- [x] list all task with status "done" when there is not a task in the file
- [x] list all task with status "done" when there is one task in the file and the status is "in-progress"
- [x] list all task with status "done" when there is one task in the file and the status is "done"
- [x] list all task with status "done" when there is one task in the file and the status is "to-do"
- [x] list all task with status "done" when there are more than one tasks in the file, at least one of them has the status attibute setted to "done"
#### Other tests done