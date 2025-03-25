class Solution {
    public boolean checkValidCuts(int m, int[][] rectangles) {
        int n = rectangles.length;
        int[][] xInd = new int[2*n][2];
        int k =0;
        for(int i=0;i<n;i++){
            xInd[k][0]=rectangles[i][0];
            xInd[k++][1]=1;
            xInd[k][0]=rectangles[i][2];
            xInd[k++][1]=0;
        }
        int[][] yInd = new int[2*n][2];
        k=0;
        for(int i=0;i<n;i++){
            yInd[k][0]=rectangles[i][1];
            yInd[k++][1]=1;
            yInd[k][0]=rectangles[i][3];
            yInd[k++][1]=0;
        }
        // now I created xInd, yInd
        // now I have to sort them
        // then I will iterate them and make a track count of overlaps and lines
        // sort xInd
        Arrays.sort(xInd, (a,b) -> {
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            } else{
                return Integer.compare(a[1],b[1]);
            }
        });
        // sorted xInd now iterate
        // on each startInd -> start - 1, end = 0
        // s - overlap++, e- overlap--, and if overlap == 0 layer ++;
        int overlap=0, layer=0;
        for(int i =0;i<xInd.length;i++){
            if(xInd[i][1] == 1){
                overlap++;
            } else{
                overlap--;
            }
            if(overlap == 0) layer++;
        }
        if(layer >= 3){
            return true;
        }
        // else we would try this vertically
        Arrays.sort(yInd, (a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }
        });
        overlap=0;
        layer=0;
        for(int i =0;i<yInd.length;i++){
            if(yInd[i][1]==1){
                overlap++;
            }else{
                overlap--;
            }
            if(overlap==0) layer++;
        }
        
        return layer>=3;
    }
}