class Solution {
    public String convert(String s, int numRows) {
        
        //Define a string builder that creates numrows amount of strings
        StringBuilder[] word = new StringBuilder[numRows];

        //build a string builder into every part (row) of the word array
        for (int i=0; i < numRows; i++){
            word[i] = new StringBuilder();
        }

        //character array
        char[] arr = s.toCharArray();
        int length = arr.length;
        int index = 0;

        //traverse the array opf characters
        while (index < length){

            //go down the zigzag
            for (int j = 0; j < numRows && index < length; j++){
                word[j].append(arr[index]);
                index++;
            }
            //go up the zigzag
            //numRows-2 represents 1 row up from bottom
            for (int j = numRows-2; j > 0 && index< length; j--){
                word[j].append(arr[index]);
                index++;

            }

        }

        //combine all the string builders
        StringBuilder result = word[0];
        for (int i =1; i < numRows; i++){
            result.append(word[i].toString());
        }
        return result.toString();
            


    }
}
