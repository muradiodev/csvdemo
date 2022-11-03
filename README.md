Conditions: 
Use java & spring
Use an in-memory database

The goal is to create an application that allows uploading and getting a csv file.
The sample csv file can be found here: 

https://drive.google.com/file/d/16CUqOllyxxp-VRom40cuFFXTghlh9wTW/view?usp=share_link

The first line of the file are the headers!
Note: The field code is unique

The application allows interaction through a Rest endpoint that allows the user to:

upload the data
Fetch all data
Fetch by code
Delete all data

Data upload:
Store to a database. The in memory database table will contain the fields as described on the csv file 
