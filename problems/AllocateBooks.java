/*
Problem:
Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.

Link: https://www.interviewbit.com/problems/allocate-books/

Solution:
Binary search on the search space.
The search space is the min no of pages in a book to the total sum of pages in all the books
*/

public class AllocateBooks {
    private boolean isPossible(int[] pages, int students, int limit) {
        int noOfStudents = 0;
        int noOfPages = 0;
        for (int page : pages) {
            if (noOfPages + page > limit) {
                noOfStudents++;
                noOfPages = page;
                if (noOfPages > limit) {
                    return false;
                }
            } else {
                noOfPages += page;
            }
        }
        return noOfStudents < students;
    }

    public int books(int[] A, int B) {
        if (B > A.length) {
            return -1;
        }
        int low = A[0];
        int high = 0;
        for (int pages : A) {
            low = Math.min(low, pages);
            high += pages;
        }

        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, B, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}