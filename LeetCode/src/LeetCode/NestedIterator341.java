package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;*

interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

public class NestedIterator341 {
    public class NestedIterator implements Iterator<Integer> {
        private Iterator<Integer> it;
        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> res = new ArrayList<>();
            for(NestedInteger ne : nestedList){
                traverse(ne,res);
            }
            this.it = res.listIterator();
        }



        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        void traverse(NestedInteger nesdInt, List<Integer> res){
            if(nesdInt.isInteger()){
                res.add(nesdInt.getInteger());
            }else{
                for(NestedInteger ne : nesdInt.getList()){
                    traverse(ne,res);
                }
            }
        }
    }
}
