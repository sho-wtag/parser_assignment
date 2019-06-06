(1) Write MySQL query to find IPs that mode more than a certain number of requests for a given time period.

# for hourly time interval

SELECT distinct log_ip, log_request from log_entries where log_ip in (SELECT s.log_ip FROM log_entries as s where s.log_date>=<START_TIME> and s.log_date <= date_add(<START_TIME>, interval 1 day_hour) group by s.log_ip having count(*)>=<THRESHOLD>) and log_date>=<START_TIME> and log_date <= date_add(<START_TIME>, interval 1 day_hour)

# for daily time interval

SELECT distinct log_ip, log_request from log_entries where log_ip in (SELECT s.log_ip FROM log_entries as s where s.log_date>=<START_TIME> and s.log_date <= date_add(<START_TIME>, interval 1 day) group by s.log_ip having count(*)>=<THRESHOLD>) and log_date>=<START_TIME> and log_date <= date_add(<START_TIME>, interval 1 day)

(2) Write MySQL query to find requests made by a given IP.

SELECT * FROM log_entries where log_ip=<LOG_IP>;n