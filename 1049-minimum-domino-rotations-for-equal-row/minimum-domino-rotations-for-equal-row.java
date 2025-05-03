class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> maptop = new HashMap<>();
        HashMap<Integer, Integer> mapbot = new HashMap<>();
        int maxElTop = 0, maxElBot = 0;
        int countMaxT = 0, countMaxB = 0;
        for(int i =0;i<tops.length;i++){
            maptop.put(tops[i],maptop.getOrDefault(tops[i],0)+1);
            if(maptop.get(tops[i]) >= countMaxT){
                countMaxT = maptop.get(tops[i]);
                maxElTop = tops[i];
            }
        }

        for(int i = 0;i<bottoms.length;i++){
            mapbot.put(bottoms[i], mapbot.getOrDefault(bottoms[i],0)+1);
            if(mapbot.get(bottoms[i]) >= countMaxB){
                countMaxB = mapbot.get(bottoms[i]);
                maxElBot = bottoms[i];
            }
        }
        int count = 0;
        if(maxElBot == maxElTop){
            if(countMaxT >= countMaxB){
                for(int i = 0;i<tops.length;i++){
                    if(tops[i] == maxElTop){
                        continue;
                    } else if(tops[i] != maxElTop && bottoms[i] == maxElTop){
                        count++;
                    } else{
                        return -1;
                    }
                }
            } else{
                for(int i = 0;i<tops.length;i++){
                    if(bottoms[i] == maxElBot){
                        continue;
                    } else if(tops[i] == maxElBot && bottoms[i] != maxElBot){
                        count++;
                    } else{
                        return -1;
                    }
                }
            }

        } else{
            if(countMaxT >= countMaxB){
                for(int i = 0;i<tops.length;i++){
                    if(tops[i] == maxElTop){
                        continue;
                    } else if(tops[i] != maxElTop && bottoms[i] == maxElTop){
                        count++;
                    } else{
                        return -1;
                    }
                }
            } else{
                for(int i = 0;i<tops.length;i++){
                    if(bottoms[i] == maxElBot){
                        continue;
                    } else if(tops[i] == maxElBot && bottoms[i] != maxElBot){
                        count++;
                    } else{
                        return -1;
                    }
                }
            }
        }
        return count;
    }
}