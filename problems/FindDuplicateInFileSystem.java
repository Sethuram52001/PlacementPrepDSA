/*
Problem:
Given a list paths of directory info, including the directory path, and all the files with contents in 
this directory, return all the duplicate files in the file system in terms of their paths. You may return 
the answer in any order.

A group of duplicate files consists of at least two files that have the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
It means there are n files (f1.txt, f2.txt ... fn.txt) with content (f1_content, f2_content ... fn_content) 
respectively in the directory "root/d1/d2/.../dm". Note that n >= 1 and m >= 0. If m = 0, it means the 
directory is just the root directory.

The output is a list of groups of duplicate file paths. For each group, it contains all the file paths of
the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Link: https://leetcode.com/problems/find-duplicate-file-in-system/

Solution:
HashMap - we can map content to group of files sharing the same content
*/

public class FindDuplicateInFileSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> duplicatePaths = new ArrayList<>();
        HashMap<String, List<String>> contentToPath = new HashMap<>();

        for (String path : paths) {
            String[] temp = path.split(" ");
            for (int i = 1; i < temp.length; i++) {
                String content = temp[i].substring(temp[i].indexOf('('));
                if (!contentToPath.containsKey(content)) {
                    contentToPath.put(content, new ArrayList<>());
                }
                String filePath = temp[0];
                filePath += "/" + temp[i].substring(0, temp[i].indexOf('('));
                contentToPath.get(content).add(filePath);
            }
        }

        for (String content : contentToPath.keySet()) {
            if (contentToPath.get(content).size() == 1) {
                continue;
            }
            duplicatePaths.add(new ArrayList<>(contentToPath.get(content)));
        }

        return duplicatePaths;
    }
}