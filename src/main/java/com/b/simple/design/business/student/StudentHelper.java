package com.b.simple.design.business.student;
public class StudentHelper {

	public static final int GRADE_B_MINIMUM = 51;
	public static final int GRADE_B_MAXIMUM = 80;
	public static final int EXTRA_FOR_MATHS = 10;
	public static final int B_GRADE_MIN = 50;
	public static final int B_GRADE_MAX = 90;
	public static final int A_GRADE_MAX = 100;
	public static final int A_GRADE_MIN = 90;
	public static final int EXTRA_MARKS_MATHS = 5;
	public static final int MIN_MARKS_TO_QUALIFY = 20;
	public static final int MAX_MARK_TO_QUALIFY = 80;

	/* PROBLEM 1 */
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		int upperLimit = isMaths ? GRADE_B_MAXIMUM+ EXTRA_FOR_MATHS : GRADE_B_MAXIMUM ;

		return  marks >= GRADE_B_MINIMUM && marks <= upperLimit;
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {

		int extraMarks = isMaths ? EXTRA_MARKS_MATHS : 0;

		if (mark > A_GRADE_MIN + extraMarks && mark <= A_GRADE_MAX) return "A";

		else if (mark > B_GRADE_MIN + extraMarks) return "B";

		return "C";
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
		int extraForMaths = isMaths ? 5 : 0;
		if (isMarksBad(marks1, extraForMaths) || isMarksBad(marks2, extraForMaths)) return "NO";
        if (IsMarksGood(marks1, extraForMaths) || IsMarksGood(marks2, extraForMaths)) return "YES";
        return "MAYBE";
    }

	private boolean IsMarksGood(int marks1, int extraForMaths) {
		return marks1 >= MAX_MARK_TO_QUALIFY + extraForMaths;
	}

	private boolean isMarksBad(int marks1, int extraForMaths) {
		return marks1 <= MIN_MARKS_TO_QUALIFY + extraForMaths;
	}

}