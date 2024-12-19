# task-tracker
A project to track and manage your tasks, implements a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on.

## Project URL
https://roadmap.sh/projects/task-tracker

# Documentation
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
- add task when there is no JSON file
- add task when there is a JSON file (not containing any tasks, but already structured as documentation say)
- add task when there is a JSON file and there are already tasks in the JSON file
#### update
#### delete
#### mark in progress
#### mark done
#### list
- list all task when there is not a task in the file
- list all task when there is one task in the file
- list all task when there are more than one tasks in the file
#### list to-do
#### list in-progress
#### list done
