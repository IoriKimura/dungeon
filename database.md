# Database
## ER model
![ER-diagram](image.png)
### users
>Table for main information about users

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |User ID number   | UUID    |PK FK NN UN|
| uName     |User's name      | Text    |NN UN      |
| uMail     |Users's email    | Text    |NN UN      |
| uPassword |User's pwd       | Text    |NN         |

### maps
>Table for main information about maps

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Map's ID number  | UUID    |PK FK NN UN|
| ownerId   |Owner ID number  | UUID    |FK NN UN   |
| data      |Map's components | JSON    |NN         |

### games
>Table for main information about games

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Map's ID number  | UUID    |PK FK NN UN|
| ownerId   |Owner ID number  | UUID    |FK NN UN   |
| mapId     |Map's ID number  | UUID    |FK NN      |