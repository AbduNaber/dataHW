public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int input_array[]) {
		super(input_array);
	}
	

	/**
	 * Sorts the array using bubble sort algorithm
	 */
    @Override
    public void sort() {
    	int i,j; // loop variables
        int flag = 0; // flag to check if any swap is done in the inner loop

			// Bubble sort algorithm
        	for(i=0; i<arr.length-1; i++) {

                flag = 0;  
                
        		for(j=0; j<arr.length-i-1; j++) {
                    comparison_counter++;
        			if(arr[j] > arr[j+1]) { // swap if the current element is greater than the next element
        				swap(j, j+1);
        				flag = 1;
                        
        			}
        		}
                // if no swap is done in the inner loop, the array is already sorted
            	if(flag == 0) {
            		break;
            	}
        	}   
    }
    
    @Override
    public void print() {
    	System.out.print("Bubble Sort\t=>\t");
    	super.print();
    }
}
