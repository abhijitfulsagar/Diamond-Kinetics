package com.abhijit.swing;

import java.util.ArrayList;
import java.util.Arrays;

public class SwingProcessing implements SwingOperationsInterface {

	@Override
	public int searchContinuityAboveValue(ArrayList<Float> data, int indexBegin, int indexEnd, float threshold,
			int winLength) {
		int count=1;
		int start =indexBegin;
		int prevIndex=-999;
		for(int i=indexBegin;i<=indexEnd;i++) {
			if(data.get(i)>threshold) {
				//checking for continuous samples
				if(prevIndex == (i-1)) {
					//counting the number of continuous samples
					count++;
				}else {
					//reassigning the starting index and count
					start = i;
					count=1;
				}				
				prevIndex=i;
				//if winlength conditions satisfies return the starting index 
				if(count>=winLength) return start;
			}
		}
		return -1;
	}

	@Override
	public int backSearchContinuityWithinRange(ArrayList<Float> data, int indexBegin, int indexEnd,
			float thresholdLo, float thresholdHi, int winLength) {
		int count=1;
		int start =indexBegin;
		int prevIndex=-999;
		for(int i=indexBegin;i>=indexEnd;i--) {
			if(data.get(i)>thresholdLo && data.get(i)<thresholdHi) {
				//checking for continuous samples
				if(prevIndex == (i-1)) {
					//counting the number of continuous samples
					count++;
				}else {
					//reassigning the starting index and count
					start = i;
					count=1;
				}				
				prevIndex=i;
				//if winlength conditions satisfies return the starting index 
				if(count>=winLength) return start;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<Integer> searchContinuityAboveValueTwoSignals(ArrayList<Float> data1, ArrayList<Float> data2, int indexBegin,
			int indexEnd, float threshold1, float threshold2, int winLength) {
		
		ArrayList<Integer> list =new ArrayList<Integer>();
		list = helper(data1,indexBegin,indexEnd,threshold1,winLength,list);
		list = helper(data2,indexBegin,indexEnd,threshold2,winLength,list);
		
		if(list.size()==2) return list;
		
		return new ArrayList<Integer>(Arrays.asList(-1,-1));
	}

	private ArrayList<Integer> helper(ArrayList<Float> data, int indexBegin, int indexEnd, float threshold,
			int winLength, ArrayList<Integer> list) {
		
		int count=1;
		int start =indexBegin;
		int prevIndex=-999;
		for(int i=indexBegin;i<=indexEnd;i++) {
			if(data.get(i)>threshold) {
				//checking for continuous samples
				if(prevIndex == (i-1)) {
					//counting the number of continuous samples
					count++;
				}else {
					//reassigning the starting index and count
					start = i;
					count=1;
				}				
				prevIndex=i;
				//if winlength conditions satisfies add the starting index to list
				if(count>=winLength) {
					list.add(start);
					return list;
				}
			}
		}
		return list;
	}

	@Override
	public ArrayList<Integer> searchMultiContinuityWithinRange(ArrayList<Float> data, int indexBegin, int indexEnd,
			float thresholdLo, float thresholdHi, int winLength) {
		
		int count=1;
		int start =indexBegin;
		int prevCount=-1;
		ArrayList<Integer> list =new ArrayList<Integer>();
		ArrayList<Integer> result =new ArrayList<Integer>();
		for(int i=indexBegin;i<=indexEnd;i++) {
			//if threshold conditions satisfies add the index to list
			if(data.get(i)>thresholdLo && data.get(i)<thresholdHi) {
				list.add(i);
			}
		}
		//checking for continuous samples
		for(int i=1;i<list.size();i++) {
			//counting the number of continuous samples
			if(list.get(i)==(list.get(i-1)+1)) {
				count++;
			}else {
				prevCount=count;
				//if winlength conditions satisfies add the starting index and ending index to list
				if(prevCount>=winLength) {
					result.add(start);
					result.add(i-1);
					return result;
				}
				//reassigning the starting index and count
				start =i;				
				count=1;				
			}			
		}
		if(result.size()==2) return result;
		return new ArrayList<Integer>(Arrays.asList(-1,-1));
	}
}
