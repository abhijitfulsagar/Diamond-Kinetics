package com.abhijit.swing;

import java.util.ArrayList;

public class SwingProcessing implements SwingOperationsInterface {

	@Override
	public int searchContinuityAboveValue(ArrayList<Float> data, int indexBegin, int indexEnd, float threshold,
			int winLength) {
		int count=1;
		int start =indexBegin;
		int prevIndex=-999;
		for(int i=indexBegin;i<=indexEnd;i++) {
			if(data.get(i)>threshold) {
				if(prevIndex == (i-1)) {
					count++;
				}else {
					start = i;
					count=1;
				}				
				prevIndex=i;
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
				if(prevIndex == (i-1)) {
					count++;
				}else {
					start = i;
					count=1;
				}				
				prevIndex=i;
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
			
		return list;
	}

	private ArrayList<Integer> helper(ArrayList<Float> data, int indexBegin, int indexEnd, float threshold,
			int winLength, ArrayList<Integer> list) {
		
		int count=1;
		int start =indexBegin;
		int prevIndex=-999;
		for(int i=indexBegin;i<=indexEnd;i++) {
			if(data.get(i)>threshold) {
				if(prevIndex == (i-1)) {
					count++;
				}else {
					start = i;
					count=1;
				}				
				prevIndex=i;
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
			if(data.get(i)>thresholdLo && data.get(i)<thresholdHi) {
				list.add(i);
			}
		}
		for(int i=1;i<list.size();i++) {
			if(list.get(i)==(list.get(i-1)+1)) {
				count++;
			}else {
				prevCount=count;
				if(prevCount>=winLength) {
					result.add(start);
					result.add(i-1);
					return result;
				}
				start =i;				
				count=1;				
			}			
		}
		return result;
	}
}
