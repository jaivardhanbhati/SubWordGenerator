# SubWordGenerator

This program uses Depth First Search approach using recursion. Given an input word, it checks in the word dictionary for validity .
If its valid, remove one character from the word at each index and recursively check the 'chopped' word if that's valid again. 
If the chopped word is invalid at any point, its a wrong path and go back to previous step. 

Complexity for a string of N characters, it iterates over N-1 remaining characters and remove each character one by one and lookup for each substring into a hastable in O(1) time.

Time Complexity - O(N*N)

Alternate Algo can be - Build a suffix tree from the word and then traverse each subtree for a valid dictionary word. 

**Instructions to run**

javac ValidSubWordGenerator.java

java ValidSubWordGenerator.java

///////////////////////////////////////Console prompt example///////////////////////////
<img width="1124" alt="image" src="https://user-images.githubusercontent.com/8976462/194810120-8f11b41a-84bf-435d-8390-ef781a2649ff.png">

