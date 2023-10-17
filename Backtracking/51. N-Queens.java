// class Solution {
//     public void nqueens(int row, HashMap<Integer, Boolean> colmap, 
//                 HashMap<Integer, Boolean> d1map, HashMap<Integer, Boolean> d2map, 
//                 int A, ArrayList<ArrayList<Character>> mat,  List<List<String>>ans )
//     {
//         if(row==A)
//         {
//             int i, j;  
//             ArrayList<String> v=new ArrayList<String>();
//             for(i=0;i<A;i++)
//             {
//                 String str="";
//                 for(j=0;j<A;j++)
//                 {
//                     str+=mat.get(i).get(j);
//                 }
//                 v.add(str);

//             }
//             ans.add(v);
//             return;
//         }
//         int j;
//         for(j=0;j<A;j++)
//         {
//             if( (colmap.containsKey(j) && colmap.get(j))
//             ||(d1map.containsKey(row-j) && d1map.get(row-j))
//             ||(d2map.containsKey(row+j) && d2map.get(row+j)) )
//             continue;
//             mat.get(row).set(j,'Q');
//             colmap.put(j,true);
//             d1map.put(row-j,true);
//             d2map.put(row+j, true);
//             nqueens(row+1, colmap, d1map, d2map, A, mat, ans);
        
//             mat.get(row).set(j,'.');
//             colmap.put(j,false);
//             d1map.put(row-j,false);
//             d2map.put(row+j, false);
//         }
//     }


//     public List<List<String>> solveNQueens(int A) {
//         List<List<String>> ans=new ArrayList<>();
//         HashMap<Integer, Boolean> colmap=new HashMap<>();
//         HashMap<Integer, Boolean> d1map=new HashMap<>();
//         HashMap<Integer, Boolean> d2map=new HashMap<>();
//         ArrayList<ArrayList<Character>> mat=new ArrayList<>();
//         //char mat[][]=new char[A][A];
//         int i,j;
//         for(i=0;i<A;i++)
//         {   
//             ArrayList<Character>in=new ArrayList<>();
//             for(j=0;j<A;j++)
//             {
//                 //mat.get(i).set(j,'.');
//                 in.add('.');
//                 //in.set(j,'.');

//             }
//             mat.add(in);
//             //mat.set(i,in);
//         }
//         nqueens(0, colmap, d1map, d2map,A, mat, ans );
//         return ans;
        
//     }
// }



class Solution {
    public void nqueens(int row, HashMap<Integer, Boolean> colmap, 
                HashMap<Integer, Boolean> d1map, HashMap<Integer, Boolean> d2map, 
                int A, char mat[][],  List<List<String>>ans )
    {
        if(row==A)
        {
            int i, j;  
            ArrayList<String> v=new ArrayList<String>();
            for(i=0;i<A;i++)
            {
                StringBuilder str=new StringBuilder();
                for(j=0;j<A;j++)
                {
                    str.append(mat[i][j]);
                }
                v.add(str.toString());
            }
            ans.add(v);
            return;
        }
        for(int j=0;j<A;j++)
        {
            if( (colmap.containsKey(j) && colmap.get(j))
            ||(d1map.containsKey(row-j) && d1map.get(row-j))
            ||(d2map.containsKey(row+j) && d2map.get(row+j)) )
            continue;
            mat[row][j]='Q';
            colmap.put(j,true);
            d1map.put(row-j,true);
            d2map.put(row+j, true);
            nqueens(row+1, colmap, d1map, d2map, A, mat, ans);
            mat[row][j]='.';
            colmap.put(j,false);
            d1map.put(row-j,false);
            d2map.put(row+j, false);
        }
    }


    public List<List<String>> solveNQueens(int A) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<Integer, Boolean> colmap=new HashMap<>();
        HashMap<Integer, Boolean> d1map=new HashMap<>();//right map
        HashMap<Integer, Boolean> d2map=new HashMap<>();//left map
        char mat[][]=new char[A][A];
        for(char[]x:mat){
            Arrays.fill(x,'.');
        }
        nqueens(0, colmap, d1map, d2map,A, mat, ans );
        return ans;
        
    }
}
