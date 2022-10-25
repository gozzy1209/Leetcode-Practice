package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//207. Course Schedule
public class CourseSchedule {
    
}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //解题的关键，当关系形成闭环是即证伪
        //DFS

        if(numCourses==0||prerequisites==null||prerequisites.length==0)return true;

        //create the arraylist:list<list<integer>> to represent the courses
        //ArrayList是Array(动态数组)的数据结构，LinkedList是Link(链表)的数据结构。
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());
        }

        //create the dependency graph
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add

        }


        //设置一个，左边存当前course，右边存prerequisite course
        
    }
    private void name() {
        
    }
}
