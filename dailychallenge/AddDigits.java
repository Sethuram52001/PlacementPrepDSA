/*
Problem:
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Link: https://leetcode.com/problems/add-digits/

Solution:
Digital root, we can observe the pattern for 1 to 100 as follows:

1 1
2 2
3 3
4 4
5 5
6 6
7 7
8 8
9 9
---------
10 1
11 2
12 3
13 4
14 5
15 6
16 7
17 8
18 9
--------
19 1
20 2
21 3
22 4
23 5
24 6
25 7
26 8
27 9
-------
28 1
29 2
30 3
31 4
32 5
33 6
34 7
35 8
36 9
-------
37 1
38 2
39 3
40 4
41 5
42 6
43 7
44 8
45 9
------
46 1
47 2
48 3
49 4
50 5
51 6
52 7
53 8
54 9
--------
55 1
56 2
57 3
58 4
59 5
60 6
61 7
62 8
63 9
--------
64 1
65 2
66 3
67 4
68 5
69 6
70 7
71 8
72 9
--------
73 1
74 2
75 3
76 4
77 5
78 6
79 7
80 8
81 9
--------
82 1
83 2
84 3
85 4
86 5
87 6
88 7
89 8
90 9
-------
91 1
92 2
93 3
94 4
95 5
96 6
97 7
98 8
99 9
------
100 1
*/

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}