# **Dude** User Guide

![ui](Ui.png)

This is a chatbot that keeps track of your tasks.

## Features

## Viewing help: <ins>help</ins>
Lists out all the available commands.<br/>
Usage: help<br/>
Expected output:
```
Here are the commands you can execute:
// list of commands
```

## Listing all tasks: <ins>list</ins>
Lists out all the tasks stored by the user.<br/>
Usage: list<br/>
Example output:
```
1.[T][ ] task 1
2.[T][ ] task 2
```

## Finding tasks by keyword: <ins>find</ins>
Finds tasks by the keyword in the task description.<br/>
Usage: find KEYWORD<br/>
<br/>
Example: find book<br/>
Example output:
```
Here are the matching tasks in your list:
1.[T][ ] borrow book
2.[T][ ] return book
```

## Adding a todo task: <ins>todo</ins>
Adds a todo type task.<br/>
Usage: todo<br/>
<br/>
Example: add todo borrow book<br/>
Example output:
```
Got it. I've added this task:
  [T][ ] borrow book
You now have 1 task in your list.
```

## Adding a deadline task: <ins>deadline</ins>
Adds a deadline type task that has a given deadline in YYYY-MM-DD format.<br/>
Usage: deadline TASK_NAME /by YYYY-MM-DD<br/>
<br/>
Example: deadline shower /by 2025-12-31<br/>
Example output:
```
Got it. I've added this task:
  [D][ ] shower (by: Dec 31 2025)
You now have 2 tasks in your list.
```

## Adding a event task: <ins>event</ins>
Adds an event type task which starts and end at specified times.<br/>
Usage: event TASK_NAME /from START /to END<br/>
<br/>
Example: event meeting /from 2pm /to 3pm<br/>
Example output:
```
Got it. I've added this task:
  [E][ ] meeting (from: 2pm to: 3pm)
You now have 3 tasks in your list.
```

## Marking a task as done: <ins>mark</ins>
Marks a task as done by index.<br/>
Usage: mark TASK_INDEX<br/>
<br/>
Example: mark 1<br/>
Example output:
```
Nice! I've marked this task ad done:
  [T][X] borrow book
```

## Unmarking a task as done: <ins>unmark</ins>
Unmarks a task as done by index.<br/>
Usage: unmark TASK_INDEX<br/>
<br/>
Example: unmark 1<br/>
Example output:
```
Ok. I've marked this task as not done yet:
  [T][ ] borrow book
```

## Deleting a task: <ins>delete</ins>
Deletes a task by index.<br/>
Usage: delete TASK_INDEX<br/>
<br/>
Example: delete 5<br/>
Example output:
```
Noted. I've removed the task:
  [D][ ] shower (by: Dec 31 2025)
You now have 2 tasks in the list.
```

## Exiting the app: <ins>bye</ins>
Exits and closes the app.<br/>
Usage: bye
Expected output:
```
bye!
```