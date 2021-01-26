## Assignments

1)	Basic lambdas. Make an array containing a few Strings. Sort it by

• length (i.e., shortest to longest)
(Hint: this exact solution was shown in the lecture)
• reverse length (i.e., longest to shortest)
(Hint: minor variation of the first bullet)
• alphabetically by the first character only
(Hint: charAt(0) returns the numeric code for the first character)
• Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
(Hint: remember that the body of a lambda is allowed to have curly braces and a return statement.
See the first two lambda examples in the notes.)
• Redo the previous problem, but use a static helper method so that your lambda looks like this:
Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))

2)	Using Java 8 features write a method that returns a comma separated string based on a given list of integers. Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd. For example, if the input list is (3,44), the output should be 'o3,e44'.

3)	Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters. TIP: Use Java 8 Lambdas and Streams API's.

