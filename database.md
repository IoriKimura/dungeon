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

### stats
>Table for main information about chatacter's stats

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| bonus     |Owner ID number  | Integer |NN         |
| strength  |Map's ID number  | Integer |NN         |
| dexterity |Map's ID number  | Integer |NN         |
| constitution|Map's ID number  | Integer|NN        |
| intelligence|Map's ID number  | Integer|NN        |
| wisdom    |Map's ID number  | Integer |NN         |
| charisma  |Map's ID number  | Integer |NN         |
| armor     |Map's ID number  | Integer |           |
| initiative|Map's ID number  | Integer |           |
| speed     |Map's ID number  | Integer |NN         |
| hitDice   |Map's ID number  | Text    |NN         |
| hp        |Map's ID number  | Integer |           |


### saving throws
>Table for main information about chatacter's saving throws

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| isStrength|Owner ID number  | Integer |NN         |
| isDexterity|Map's ID number | Integer |NN         |
| isConstitution|Map's ID number| Integer|NN        |
| isIntelligence|Map's ID number| Integer|NN        |
| isWisdom  |Map's ID number  | Integer |NN         |
| isCharisma|Map's ID number  | Integer |NN         |

### skills
>Table for main information about chatacter's skills

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| acrobatics|Owner ID number  | Integer |         |
| animalH|Map's ID number | Integer |         |
| arcana|Map's ID number| Integer|        |
| athletics|Map's ID number| Integer|        |
| deception  |Map's ID number  | Integer |         |
| history|Map's ID number  | Integer |         |
| insight|Map's ID number  | Integer |         |
| intimidation|Map's ID number  | Integer |         |
| investigation|Map's ID number  | Integer |         |
| medicine|Map's ID number  | Integer |         |
| nature|Map's ID number  | Integer |         |
| perception|Map's ID number  | Integer |         |
| performance|Map's ID number  | Integer |         |
| persuasion|Map's ID number  | Integer |         |
| religion|Map's ID number  | Integer |         |
| sleighH|Map's ID number  | Integer |         |
| stealth|Map's ID number  | Integer |         |
| survival|Map's ID number  | Integer |         |

### inventory
>Table for main information about chatacter's inventory

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| plat|Owner ID number  | Integer |         |
| gold|Map's ID number | Integer |         |
| silver|Map's ID number| Integer|        |
| copper|Map's ID number| Integer|        |
| content|Map's ID number  | Text |         |


### features
>Table for main information about chatacter's features

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| feature|Owner ID number  | String |         |

### attack spells
>Table for main information about chatacter's attack spells

| Name      | Purpose         | Type    | Limits    | 
| :-------- | :--------------:|:-------:| ---------:| 
| id        |Stat's ID number | UUID    |PK NN UN   |
| attack |Owner ID number  | String |         |