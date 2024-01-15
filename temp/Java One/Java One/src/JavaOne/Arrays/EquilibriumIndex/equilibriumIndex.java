package JavaOne.Arrays.EquilibriumIndex;

public class equilibriumIndex {

    public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
       
        
        int total = 0;

        for(int i = 0; i < arr.length; i++){
            total+=arr[i];
        }

        
        int lsum = 0;
        int index = 0;
        while(index<arr.length){

            int rsum = total - lsum - arr[index];
            if(lsum==rsum){
                return index;
            }else{
                lsum = lsum + arr[index];
                index++;
            }
            
        }

        return -1;
       
	}
    
    public static void main(String[] args) {

        int[] arr = {6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0};
        System.out.println("equi at index : "+arrayEquilibriumIndex(arr));

        
    }
}
