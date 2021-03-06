package main;

import java.util.*;

public class daily {
    public String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }

        int left = 0, right = 1;
        int valid = 0;
        //初始化target
        HashMap<Character,Integer> target = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(Character c : t.toCharArray()){
            if(target.containsKey(c)){
                target.put(c,target.get(c) + 1);
            }else{
                target.put(c,1);
            }
        }

        int sourceSize = s.length();
        int targetSize = target.size();
        String res = "";
        while(right <= sourceSize){
            //滑动右指针
            while(valid != targetSize && right <= sourceSize){
                char sChar = s.charAt(right - 1);
                if(!target.containsKey(sChar)){
                    right++;
                    continue;
                }else if(target.containsKey(sChar)){
                    if(!window.containsKey(sChar)){
                        window.put(sChar,1);
                    }else if(window.containsKey(sChar)){
                        window.put(sChar,window.get(sChar) + 1);
                    }

                    if(target.get(sChar).equals(window.get(sChar))){
                        valid++;
                    }
                }
                right++;
            }
            //滑动左指针
            String tmp = "";
            while(valid == targetSize){
                char sChar = s.charAt(left);
                if(!target.containsKey(sChar)){
                    left++;
                    continue;
                }else if(target.containsKey(sChar)){
                    if(window.get(sChar) > target.get(sChar)){
                        window.put(sChar,window.get(sChar) - 1);
                    }else if(window.get(sChar).equals(target.get(sChar))){
                        valid--;
                        tmp = s.substring(left,right - 1);
                        if(window.get(sChar) > 1){
                            window.put(sChar,window.get(sChar) - 1);
                        }else{
                            window.remove(sChar);
                        }
                    }
                }
                left++;
            }
            //更新结果
            if(tmp.length() == 0){
                return res;
            }else if(res.length() == 0 && tmp.length() != 0){
                res = tmp;
            }else if(res.length() != 0 && tmp.length() != 0){
                res = tmp.length() < res.length() ? tmp : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
