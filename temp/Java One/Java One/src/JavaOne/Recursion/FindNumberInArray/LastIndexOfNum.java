package JavaOne.Recursion.FindNumberInArray;

public class LastIndexOfNum {

    public static int findLast(int[] a, int key, int si){

        //base case
        if(si == a.length -1){
            if(a[si]==key){
                return si;
            }else{
                return -1;
            }
        }

        // if key is present at si 

        if(a[si]==key){
            return si;
        }

        // do this recursively
        //for smallar workspace : as in increase si

        int findForSmall = findLast(a, key, si+1);
        int findFinal = findForSmall;

        return findFinal;


        

    }

    public static int findLastIndex(int[] a, int key){

        int[] temp = new int[a.length];

        for(int i = a.length -1,j=0; i>=0; i--,j++){
            temp[j] = a[i];
        }

        int ans = findLast(temp, key, 0);
        if(ans == -1){
            return -1;
        }else{
            return a.length - ans - 1;
        }
       

    }

    public static void main(String[] args) {
        int[] arr = {10,2,6,4,7,5,6,7,8,6};
        System.out.println(findLastIndex(arr,6));
        
    }
}
