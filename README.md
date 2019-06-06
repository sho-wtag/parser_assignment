# parser_assignment

Run the jar file using below command. 

```
java -jar parser.jar -cp com.parser.ef --accesslog=F:\Development_Projects\logrepository\access.log --startDate=2017-05-31.13:00:00 --duration=hourly --threshold=100
```

Create a database in mysql using name ```access_parser``` then run the jar file using the above command. It will automatically create table schema in the ```access_parser``` database.
