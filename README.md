# task-tracker
A project to track and manage your tasks, implements a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on.

## Project URL
https://roadmap.sh/projects/task-tracker

# Documentation

## Assumptions
- todo
## How to run the app
- todo
## Other notes
- Even if the user type in a wrong operation, the basic file with the basic file structure will be correctly created, the just created file will be empty.

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
#### delete
#### mark in progress
#### mark done
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
#### Other test done