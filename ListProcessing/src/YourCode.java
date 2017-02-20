import java.util.ArrayList;

import ecs100.UI;

public class YourCode {
	// Return an ArrayList that contains twice each of the numbers
    // in the input list.
    //
    // For example, if input contained [1,2,10] this method should
    // return a list with [2,4,20].
    //
    // You should not modify the input ArrayList.
    // Exercise 1
    public ArrayList<Double> mapTwice(ArrayList<Double> numList) {
         
        ArrayList<Double> mapTwice = new ArrayList<Double>();
         
        for (int i = 0; i < numList.size(); i++) {
            double doubleNum = (numList.get(i) * 2);
            mapTwice.add(doubleNum);
        }
        return mapTwice;
    }
 
    // Return an ArrayList that contains the strings from the
    // input list, in the same order, converted to upper case.
    //
    // Hint: The toUpperCase() method on String returns an
    // uppercased version of the string.
    //
    // You should not modify the input ArrayList.
    // Exercise 2
    public ArrayList<String> mapToUpper(ArrayList<String> wordList) {
         
        ArrayList<String> mapToUpper = new ArrayList<String>();
         
        for (int i = 0; i < wordList.size(); i++) {
            String upperCaseWord = wordList.get(i).toUpperCase(); 
            mapToUpper.add(upperCaseWord);
        }
        return mapToUpper;
    }
 
    // Return true if word is a palindrome, reading the same
    // backwards and forwards.
    //
    // Hint: the substring(int beginIndex, int endIndex)
    // method gives the part of the string from beginIndex
    // (inclusive) to endIndex (exclusive).
    // Hint: charAt(int index) gives the character at the
    // given position in a string as a char, which is a
    // primitive type that can be used as an integer.
    // Hint: Strings have a length() method.
    // Exercise 3
    public boolean isPalindrome(String word) {
         
        int length = word.length() / 2;
         
        for (int i = 0; i < length; i++) {
            if (word.charAt(i) != word.charAt(word.length()- 1 - i)) {
                return false;
            }
        }
        return true;
    }
 
    // Return an ArrayList that contains the strings from the
    // input list starting with the given prefix, in the same
    // order they appeared.
    //
    // Hint: the startsWith(String prefix) method on String returns
    // true if and only if the string starts with the prefix.
    //
    // You should not modify the input ArrayList.
    // Exercise 4
    public ArrayList<String> filterStarts(ArrayList<String> wordList, String start) {
         
        ArrayList<String> filterStarts = new ArrayList<String>();
         
        for (int i = 0; i < wordList.size(); i ++) {
            if (wordList.get(i).startsWith(start)) {
                filterStarts.add(wordList.get(i));
            }
        }
        return filterStarts;
    }
 
    // Return the sum of all numbers in the input list.
    //
    // For example, if input contained [1,2,10] this method should
    // return 13.
    //
    // You should not modify the input ArrayList.
    // Exercise 5
    public double foldSum(ArrayList<Double> numList) {
         
        double foldSum = 0;
         
        for (int i = 0; i < numList.size(); i++) {
            foldSum = foldSum + numList.get(i);
        }
        return foldSum;
    }
 
    // Return whether the list is ordered from lowest to highest.
    //
    // For example, if input contained [1,2,3] this method should
    // return true, while if input contained [1,3,2] it should
    // return false.
    //
    // You should not modify the input ArrayList.
    // Exercise 6
    public boolean isOrderedAscending(ArrayList<Double> numList) {
         
        int inOrder = 0;
         
        for (int i = 0; i < numList.size()-1; i++) {
            if (numList.get(i) < numList.get(i+1)) {
                inOrder++;
            }
        }
         
        if (inOrder != numList.size()-1) {
            return false;
        }
        return true;
    }
 
    // Return an ArrayList that contains the words from
    // list input1 that are in the same position in
    // input2.
    //
    // Remember: compare Strings with .equals(other)
    //
    // You should not modify the input ArrayLists.
    // Exercise 7
    public ArrayList<String> matchingWords(ArrayList<String> wordList, ArrayList<String> wordList2) {
         
        ArrayList<String> matchingWords = new ArrayList<String>();
        Boolean matchedWord;
        int size = wordList.size();
         
        if (wordList2.size() < wordList.size()) {
            size = wordList2.size();
        }
         
        for (int i = 0; i < size; i++) {
            matchedWord = wordList.get(i).equals(wordList2.get(i));
                if (matchedWord) {
                    matchingWords.add(wordList.get(i));
                }
        }
        return matchingWords;
    }
 
    // Return an ArrayList that contains all the words in
    // the input1 list that are also in the input2 list.
    //
    // Hint: You will use nested loops.
    // Hint: You will probably need a boolean variable.
    //
    // You should not modify the input ArrayLists.
    // Exercise 8
    public ArrayList<String> intersection(ArrayList<String> wordList, ArrayList<String> wordList2) {
        //search through wordList, boolean is initially set to false. Search through wordList2 - if match is found, then
        //boolean becomes true. if boolean is true when 2nd loop is exited, it will add the word to the new array list.
        //this stops it from adding the word to the list multiple times. 
         
        ArrayList<String> intersection = new ArrayList<String>();
        Boolean repeatedWord;
         
        for (int i = 0; i < wordList.size(); i++) {
            repeatedWord = false;
            for (int j = 0; j < wordList2.size(); j++) {
                if (wordList.get(i).equals(wordList2.get(j))) {
                    repeatedWord = true;
                }
            }
            if (repeatedWord) {
                intersection.add(wordList.get(i));
            }
        } 
        return intersection;
    }
 
    // Return an ArrayList that contains all the words in
    // the input1 list with any duplicate occurrences
    // removed. Keep the first time any duplicate word
    // appears.
    //
    // Hint: You will use nested loops.
    // Hint: Remember that everything is equal to itself.
    //
    // You should not modify the input ArrayList.
    // Exercise 9
    public ArrayList<String> noDuplicates(ArrayList<String> wordList) {
        //search through wordList with i loop. With j loop, check if each word has already occurred in 
        //wordList. If yes, boolean duplicate will be true, and if true, it will add one to the k counter.
        //Once j loop has finished running, if k counter is zero then the word will be added to the new
        //array. If k counter is not zero, the word has already occurred in wordList and has already been added
        //to the new array list. 
         
        ArrayList<String> noDuplicates = new ArrayList<String>();
         
        for (int i = 0; i < wordList.size(); i++) {
            int k = 0;
            for (int j = 0; j < i; j++) {
                Boolean duplicate = wordList.get(i).equals(wordList.get(j));
                if (duplicate) {
                    k++;
                }
            }
            if (k == 0) {
                noDuplicates.add(wordList.get(i));
            }
        }
        return noDuplicates;
    }
 
    // Return an ArrayList that contains all the words in
    // the input1 list that are NOT in the input2 list.
    // Duplicated words in input1 that are not in input2
    // will appear more than once.
    //
    // You should not modify the input ArrayLists.
    // Exercise 10
    public ArrayList<String> difference(ArrayList<String> wordList, ArrayList<String> wordList2) {
        // go through each word in list. compare to words in list2. If match found, boolean check becomes
        // false. if no match found at end of j loop, check is still true and word added to new array list 
         
        ArrayList<String> difference = new ArrayList<String>();
        Boolean check;
         
        for (int i = 0; i < wordList.size(); i++) {
            check = true;
            for (int j = 0; j < wordList2.size(); j++) {
                if (wordList.get(i).equals(wordList2.get(j))) {
                    check = false;
                }
            }
            if (check) {
                difference.add(wordList.get(i));
            }
        }
        return difference;
    }
 
    // Return an ArrayList that contains all the words that
    // are in exactly one of the input lists. Duplicated words
    // in each list should appear appropriately.
    //
    // You should not modify the input ArrayLists.
    // Exercise 11
    public ArrayList<String> symmetricDifference(ArrayList<String> wordList, ArrayList<String> wordList2) {
        // go through each word in list. compare to words in list2. If match found, boolean check becomes
        // false. if no match found at end of j loop, check is still true and word added to new array list
         
        ArrayList<String> symmetricDifference = new ArrayList<String>();
        Boolean onlyOneList;
                 
        for (int i = 0; i < wordList.size(); i++) {
            onlyOneList = true;
            for (int j = 0; j < wordList2.size(); j++) {
                if (wordList.get(i).equals(wordList2.get(j))) {
                    onlyOneList = false;
                }
            }
            if (onlyOneList) {
                symmetricDifference.add(wordList.get(i));
            }
        }
         
        for (int i = 0; i < wordList2.size(); i++) {
            onlyOneList = true;
            for (int j = 0; j < wordList.size(); j++) {
                if (wordList2.get(i).equals(wordList.get(j))) {
                    onlyOneList = false;
                }
            }
            if (onlyOneList) {
                symmetricDifference.add(wordList2.get(i));
            }
        }
        return symmetricDifference;
    }
 
    // Reverse the input list, in place.
    //
    // Hint: The set(index, value) method on ArrayLists updates
    // the value stored at a given index.
    // Exercise 12
    public void reverse(ArrayList<String> wordList) {
        //Go through array list, replace first and last indices until middle index, stop.
        //If don't stop at the middle, it will replace each value from the first half of the index with
        //an ALREADY REPLACED value
         
        int n = wordList.size()-1;
 
        for (int i = 0; i < (n / 2); i++) {
            int newIndex = n - i;
            String y = wordList.get(i);
            String z = wordList.get(newIndex);
            wordList.set(i, z);
            wordList.set(newIndex, y);
        }
    }
 
    // Shuffle the input list, in place, by swapping the element
    // at each position with one at a randomly-chosen equal or
    // later index
    //
    // random number from 0 to n - 1 ==> (int)(Math.random()*n)
    // random number from x to n - 1 ==> x + (int)(Math.random()* n-x)
    //
    // Hint: You can generate a random integer from 0 to n - 1 with
    // (int)(Math.random() * n), and one from x to n - 1 with
    // x + (int)(Math.random() * (n - x)).
    // Exercise 13
    public void shuffle(ArrayList<Double> numList) {
        int n = numList.size();
         
        for (int i = 0; i < n; i++) {
            // picks a random new index between i (current position in array) and end of array
            int randomIndex = i + (int)(Math.random() * (n - i));
            //get element at i index
            double z = numList.get(i);
            //get element at random index between i and end of array
            double y = numList.get(randomIndex);
            //swap elements at those two indices
            numList.set(i, y);
            numList.set(randomIndex, z);
        }   
    }
 
    // Return true if word1 and word2 are anagrams of one
    // another. One word is an anagram of another if it
    // has all the letters of the other word in a different
    // order.
    //
    // Hint: the substring(int beginIndex, int endIndex)
    // method gives the part of the string from beginIndex
    // (inclusive) to endIndex (exclusive).
    // Hint: charAt(int index) gives the character at the
    // given position in a string as a char, which is a
    // primitive type that can be used as an integer.
    // Exercise 14
    public boolean isAnagram(String word1, String word2) {
    	
    	char[] word1array = word1.toCharArray();
    	char[] word2array = word2.toCharArray();
    
    	
    	//if word lengths are different then definitely not an anagram
        if (word1.length() != word2.length()) {
            return false;
        }
        
        
        int matchedLetter = 0;

        //go through char arrays for both words. if match is found, then char in word2
        //is turned to 0, so that it isn't incorrectly matched again
        for (int i = 0; i < word1array.length; i++) {
            for (int j = 0; j < word2array.length; j++) {
                if (word1array[i] == word2array[j]) {
                    matchedLetter++;
                    word2array[j] = 0;
                    break;
                }
            }   
        }
         
        //if number of matches found does not equal word1.length, then not an anagram
        if (matchedLetter != word1.length()) {
            return false;
        }
        
        String b = new String(word1array);
        
        UI.print(b);
        
        return true;
    }
 
    // Return an ArrayList with a rolling five-item Olympic average
    // of the numbers in the input list.
    //
    // An Olympic average of five numbers is the average of the three
    // numbers left after ignoring the lowest and highest numbers. For
    // example, the Olympic average of [9,7,5,6,8] is the average of
    // 7, 6, and 8 (which is 7: (7 + 6 + 8) / 3 = 21 / 3).
    //
    // A rolling average over a list of numbers is a list of the averages
    // of consecutive numbers in the first list centered around each
    // possible point in the first list.
    //
    // Your method should return an Olympic average of each five-item
    // sequence of consecutive numbers in the list.
    //
    // You should not modify the input ArrayList.
    // Exercise 15
    public ArrayList<Double> olympicAverages(ArrayList<Double> numList) {
         
        ArrayList<Double> olympicAverages = new ArrayList<Double>();
        double average = 0;
         
        for (int i = 0; i < numList.size()-4; i++) {
            ArrayList<Double> shortList = new ArrayList<Double>();
            for (int j = i; j < (i+5); j++) {
                shortList.add(numList.get(j));
                if (shortList.size() == 5) {
                    shortList.sort((a,b) -> Double.compare(a,b));
                    double first = shortList.get(j+1);
                    double second = shortList.get(j+2);
                    double third = shortList.get(j+3);
                    average = (first + second + third) / 3;
                     
                }
            }
            olympicAverages.add(average);
        }
        return olympicAverages;
    }
 
    
    // Order all the numbers in the input list from lowest to highest.
    //
    // Hint: You can loop over the list repeatedly until it is in order,
    // swapping adjacent items that are out of order.
    // Exercise 16
    public void orderAscending(ArrayList<Double> numList) {
        //use boolean to check if list is in order
    	//while list is not in order, go through and order list

        int inOrder = 0;
        Boolean ordered;
        
        for (int i = 0; i < numList.size()-1; i++) {
            if (numList.get(i) < numList.get(i+1)) {
                inOrder++;
            }
        }
         
        if (inOrder != numList.size()-1) {
            ordered = false;      
        } else {
        	ordered = true;
        }
 
          	
    	while (ordered == false) {
    		for (int i = 0; i < numList.size()-1; i++) {
    			if (numList.get(i) > numList.get(i+1)) {
    				double x = numList.get(i);
    				double y = numList.get(i+1);
    				numList.set(i, y);
    				numList.set(i+1, x);
    			}
    		}
    	}
    }

    
 
    // The previous method takes up to n^2 steps for a list with size n.
    // It could be faster. This method should do the same thing, but
    // taking many fewer steps.
    // Exercise 17
    public void orderAscendingFaster(ArrayList<Double> numList) {
        numList.sort((a,b) -> Double.compare(a,b));
    }
 
    
    
    // Reverse a string correctly.
    // Exercise 18
    public String reverseString(String text) {
    	
    	char[] textArray = text.toCharArray();
    	
    	char temp;
    	
    	for (int i = 0; i < (textArray.length/2); i++) {
    		temp = textArray[i];
    		textArray[i] = textArray[(textArray.length -1 -i)];
    		textArray[(textArray.length -1 -i)] = temp;
    	}
    	
    	String reversedText = new String(textArray);
    	
    	return reversedText;
    }
    
    
    //main method
    public static void main(String[] args) {
        new UserInterface();
    }

}
