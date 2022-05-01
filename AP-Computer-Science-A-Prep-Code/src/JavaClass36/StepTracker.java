package JavaClass36;
/*
Homework36Part2:

A simple step counting application that utilizes classes in Java
You aren't required to add Javadoc or comments for the AP Computer Science A exam free response questions;
I only added them for future reference.

Question:
This question involves the implementation of a fitness tracking system that is represented by the StepTracker class. A StepTracker object is created with a parameter that defines the minimum
number of steps that must be taken for a day to be considered active.

The StepTracker class provides a constructor and the following methods.
• addDailySteps, which accumulates information about steps, in readings taken once per day
• activeDays, which returns the number of active days
• averageSteps, which returns the average number of steps per day, calculated by dividing the
total number of steps taken by the number of days tracked
The following table contains a sample code execution sequence and the corresponding results.

*/

public class StepTracker {
    private int steps;
    private int days;
    private int activeDays;
    private int MIN;

    public void StepTracker(int minimum) {
        MIN = minimum;
        steps = 0;
        days = 0;
        activeDays = 0;
    }

    //Accumulates information about steps, in readings taken once per day
    public void addDailySteps(int s) {
        steps += s;
        days++;
        if(s > MIN) {
            activeDays++;
        }
    }

    //Returns the number of active days
    public int activeDays() {
        return activeDays;
    }

    //Returns the average number of steps per day, calculated by dividing the total number of steps by the total number of days
    public double averageSteps() {
        if (days == 0) {
            return 0.0;
        } else {
            return ((double) steps) / days;
        }
    }

}
