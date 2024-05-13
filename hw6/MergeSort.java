public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) {
		super(input_array);
	}
	/**
     * This function merges the two subarrays
     */
	private void merge(int []input_array ,int l, int r, int mp){

        int size1 = mp-l+1; // size of the first subarray
        int size2 = r-mp; // size of the second subarray
 

        int [] tmp1 = new int[size1]; // temporary array for the first subarray
        int [] tmp2 = new int[size2]; // temporary array for the second subarray

        // copying the elements of the subarrays to the temporary arrays
        for(int i = 0; i <size1 ;i++){
            tmp1[i] = input_array[l+i]; 
        }

        // copying the elements of the subarrays to the temporary arrays
        for(int i = 0; i <size2 ;i++){
            tmp2[i] = input_array[mp + 1 + i];
        }

        int a =0 ; // index of the first subarray
        int b = 0; // index of the second subarray

        int m = l; // index of the merged array

        // merging the two subarrays
        while(a < size1 && b< size2){
            comparison_counter++;
            if(tmp1[a] > tmp2[b]){
                input_array[m] = tmp2[b];
                b++;
            }
            
            else if(tmp1[a] <= tmp2[b]){
                input_array[m] = tmp1[a];
                a++;
            }
            m++;
            
        }
        // copying the remaining elements of the  subarrays
        while(a< size1){
            input_array[m] = tmp1[a];
            a++;
            m++;
        }

        while(b< size2){
            input_array[m] = tmp2[b];
            b++;
            m++;
        }

    }

    /**
     * This function sorts the array using merge sort algorithm
     */
    private void sort(int [] input_array,int l,int r){

        if(l< r){

            int mp = l+ (r-l)/2; // middle point

            sort(input_array,l,mp);
            sort(input_array,mp+1,r);
    
            merge(input_array,l,r,mp);

        }
       
       
        
        
    }
    
    @Override
    public void sort() {
    	sort(arr,0,arr.length-1);
    }
    
    @Override
    public void print() {
    	System.out.print("Merge Sort\t=>\t");
    	super.print();
    }
}
