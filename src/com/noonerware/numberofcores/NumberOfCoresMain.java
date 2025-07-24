package com.noonerware.numberofcores;

import java.util.Arrays;
import java.util.List;

public class NumberOfCoresMain {

	public static void main(String[] args) {
		NumberOfCoresMain thisClass = new NumberOfCoresMain();

		Integer[] start = { 1, 3, 8 };
		Integer[] end = { 5, 7, 10 };

		thisClass.determineNumberOfCoresRequiredToRunTests(Arrays.asList(start), Arrays.asList(end));
	}

	void determineNumberOfCoresRequiredToRunTests(List<Integer> start, List<Integer> end) {
		int numberOfRequiredCores = 0;

		for (int i = 0; i < start.size(); i++) {
			Integer testStart = start.get(i);
			Integer testEnd = end.get(i);

			int loopNumberOfCores = determineNumberOfCoresRequiredToRunTest(start, end, testStart, testEnd);
			if (loopNumberOfCores > numberOfRequiredCores) {
				numberOfRequiredCores = loopNumberOfCores;
			}
		}
		System.out.println(String.format("Number of cores need to run these tests: %d", numberOfRequiredCores));
	}

	int determineNumberOfCoresRequiredToRunTest(List<Integer> start, List<Integer> end, Integer testStart,
			Integer testEnd) {
		int numberOfCoresRequiredToRunThisTest = 0;

		for (int i = 0; i < start.size(); i++) {
			Integer loopStart = start.get(i);
			Integer loopEnd = end.get(i);

			//
			// Determine if "loop test" will be running when the new test needs to start
			//
			if ((testStart >= loopStart) && (testStart <= loopEnd)) {
				numberOfCoresRequiredToRunThisTest++;
			}
		}
		return numberOfCoresRequiredToRunThisTest;
	}

}
