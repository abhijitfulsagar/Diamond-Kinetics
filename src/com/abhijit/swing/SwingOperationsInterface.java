package com.abhijit.swing;

import java.util.ArrayList;

public interface SwingOperationsInterface {
	public int searchContinuityAboveValue(ArrayList<Float>data, int indexBegin, int indexEnd, float threshold, int winLength);
	public int backSearchContinuityWithinRange(ArrayList<Float>data, int indexBegin, int indexEnd, float thresholdLo, float thresholdHi, int winLength);
	public ArrayList<Integer> searchContinuityAboveValueTwoSignals(ArrayList<Float>data1, ArrayList<Float>data2,int indexBegin, int indexEnd, float threshold1,float threshold2, int winLength);
	public ArrayList<Integer> searchMultiContinuityWithinRange(ArrayList<Float>data, int indexBegin, int indexEnd, float thresholdLo, float thresholdHi, int winLength);
}
