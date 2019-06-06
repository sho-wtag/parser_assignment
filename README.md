# parser_assignment

Step for Running the Program: 

## Steps 1:

Create a database in mysql using name ```access_parser``` then run the jar file using the below command. It will automatically create table schema in the ```access_parser``` database.

## Steps 2

Run the jar file using below command. 

```
java -jar parser.jar -cp com.parser.ef --accesslog=F:\Development_Projects\logrepository\access.log --startDate=2017-05-31.13:00:00 --duration=hourly --threshold=100
```

Note: --accesslog can take absolute path as well. Please provide absolutepath of access.log file. 

## Steps 3

sql_queries.sql for the defined sql queries mentioned in the requirement. 
schema.sql for DB schema for the program. 

