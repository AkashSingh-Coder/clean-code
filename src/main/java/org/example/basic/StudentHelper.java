package org.example.basic;

public class StudentHelper {
	// --- Constants for Grade B thresholds ---
	private static final int GRADE_B_MIN = 51;
	private static final int GRADE_B_MAX = 80;
	private static final int GRADE_B_MAX_MATHS = 90;

	// --- Constants for Grade A thresholds ---
	private static final int GRADE_A_MIN = 91;
	private static final int GRADE_A_MIN_MATHS = 96;

	// --- Constants for Quiz qualification ---
	private static final int QUIZ_NOT_GOOD_MAX = 20;
	private static final int QUIZ_NOT_GOOD_MAX_MATHS = 25;
	private static final int QUIZ_GOOD_MIN = 80;
	private static final int QUIZ_GOOD_MIN_MATHS = 85;

	// --- Grade Labels ---
	private static final String GRADE_A = "A";
	private static final String GRADE_B = "B";
	private static final String GRADE_C = "C";
	// --- Quiz Result Labels ---
	private static final String RESULT_YES = "YES";
	private static final String RESULT_NO = "NO";
	private static final String RESULT_MAYBE = "MAYBE";

	/* PROBLEM 1 */	
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		int upperLimit = isMaths ? GRADE_B_MAX_MATHS : GRADE_B_MAX;
		return marks >= GRADE_B_MIN && marks <= upperLimit;
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {
		if (isGradeA(mark, isMaths)) {
			return GRADE_A;
		} else if (isGradeB(mark, isMaths)) {
			return GRADE_B;
		}
		return GRADE_C;
	}

	private boolean isGradeA(int mark, boolean isMaths) {
		int threshold = isMaths ? GRADE_A_MIN_MATHS : GRADE_A_MIN;
		return mark >= threshold;
	}

	private boolean isBGrade(int mark, boolean isMaths) {
		int lowerLimit = isMaths ? GRADE_B_MIN + 4 : GRADE_B_MIN - 1; // 55 for Maths, 50 for others
		return mark > lowerLimit && mark < GRADE_A_MIN;
	}

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
		int notGoodThreshold = isMaths ? QUIZ_NOT_GOOD_MAX_MATHS : QUIZ_NOT_GOOD_MAX;
		int goodThreshold = isMaths ? QUIZ_GOOD_MIN_MATHS : QUIZ_GOOD_MIN;

		if (marks1 <= notGoodThreshold || marks2 <= notGoodThreshold) {
			return RESULT_NO;
		}

		if (marks1 >= goodThreshold || marks2 >= goodThreshold) {
			return RESULT_YES;
		}

		return RESULT_MAYBE;
    }	

}