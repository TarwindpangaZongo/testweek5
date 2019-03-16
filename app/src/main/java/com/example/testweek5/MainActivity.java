package com.example.testweek5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> output = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] input = {2,8,9,3,4,3,2,6,6,2,4,9,8};
        String inputString = "frog";

        //Merge sort the array
        sortAscendingOrder(input);

        //generate substring
        subString(inputString, new StringBuffer(), 0);

        //Print results
        for(int i = 0; i <input.length;i++){
            System.out.print(input[i] + " ");
        }
        System.out.print(output);

    }

    private void sortAscendingOrder(int[] input) {
        if (input.length > 1) {
            //merge sort the first half
            int[] firstHalf = new int[input.length / 2];
            System.arraycopy(input, 0, firstHalf,0,input.length/2);
            sortAscendingOrder(firstHalf);

            //merge sort the second half
            int secondHalfLength = input.length -input.length/2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(input,input.length/2,secondHalf,0,secondHalfLength);
            sortAscendingOrder(secondHalf);

            //merge firstHalf with secondHalf
            int[] temp = merge(firstHalf,secondHalf);
            System.arraycopy(temp,0,input,0,temp.length);
        }
    }

    private int[] merge(int[] input1, int[] input2) {
        int[] temp = new int[input1.length+input2.length];
        int current1 = 0; // Current index in input1
        int current2 = 0; // Current index in input2

        int current3 = 0; // Current index in temp

        while (current1 < input1.length && current2< input2.length){
            if(input1[current1]< input2[current2])
                temp[current3++] = input1[current1++];
            else temp[current3++] = input2[current2++];
        }

        while (current1 < input1.length){
            temp [current3++] = input1[current1++];
        }

        while (current2 < input2.length){
            temp [current3++] = input2[current2++];
        }
        return temp;
    }

    private void subString(String inputString, StringBuffer outputString, int index)
    {
        for (int i = index; i < inputString.length(); i++)
        {
            outputString.append(inputString.charAt(i));
            //System.out.println(outputString);
            output.add(outputString.toString());
            subString(inputString, outputString, i + 1);
            outputString.deleteCharAt(outputString.length() - 1);
        }
    }
}
