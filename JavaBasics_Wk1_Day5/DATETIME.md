## Date-Time API Questions and Answers

### Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?

I would probably go about using a ZonedDateTime because people can be born in different timezones. For example, if someone was born in Australia (like me), then I would store the time corresponding to the time in Australia rather than some centralized time.

### Given a random date, how would you find the date of the previous Thursday?

I would probably use this class TemporalAdjusters. Looking at the documentation, we can use it for "finding the next or previous day-of-week such as 'next Thursday'". If given a random date, we can say like randomDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)) or something of the like.

### What is the difference between a ZoneId and a ZoneOffset?

ZoneID represents the ID of a timezone. It is an identifier

ZoneOffset is the amount of time by which a time zone differs from the UTC/Greenwich

### How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?

a) Get the current time zone instant, then use instant.atZone("specific time zone")

b) With our ZonedDateTime, use the toInstant() function

### Write an example that, for a given year,  reports the length of each month within that year?

Check the Java file in the com.ss.basics.datetime

### Write an example that, for a given month of the the current year, lists all the Mondays in that month

Check the Java file in the com.ss.basics.datetime

### Write an example that tests whether a given date occurs on Friday the 13th

Check the Java file in the com.ss.basics.datetime
