package JavaOne.Recursion.FindNumberInArray;

public class findFirstOccurence {

    public static int findI(int a[], int key, int si){

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

        int findForSmall = findI(a, key, si+1);
        int findFinal = findForSmall;

        return findFinal;

    }

    

    public static int findIndex(int a[], int key){
        
        int ans = findI(a, key, 0);
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,6};
        System.out.println(findIndex(arr,6));
    }
}
