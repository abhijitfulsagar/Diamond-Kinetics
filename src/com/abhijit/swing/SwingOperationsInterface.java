package com.abhijit.swing;

import java.util.ArrayList;

public interface SwingOperationsInterface {
	public void searchContinuityAboveValue(ArrayList<Integer>data, int indexBegin, int indexEnd, float threshold, int winLength);
	public void backSearchContinuityWithinRange(ArrayList<Integer>data, int indexBegin, int indexEnd, float thresholdLo, float thresholdHi, int winLength);
	public void searchContinuityAboveValueTwoSignals(ArrayList<Integer>data1, ArrayList<Integer>data2,int indexBegin, int indexEnd, float threshold1,float threshold2, int winLength);
	public void searchMultiContinuityWithinRange(ArrayList<Integer>data, int indexBegin, int indexEnd, float thresholdLo, float thresholdHi, int winLength);
}
