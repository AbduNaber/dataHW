public class QuickSort extends SortAlgorithm {

	public QuickSort(int input_array[]) {
		super(input_array);
	}
	
    /**
     * This function swaps the elements at index i and j in the array
     */
    private int partition(int [] input_array, int l, int r){

        
        int pivot = input_array[r];
        int i = l - 1; // index of smaller element

        // partitioning the array
        for (int j = l; j < r; j++){
            comparison_counter++;
            if (input_array[j] < pivot){
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, r);

        return i + 1;
    }

    /**
     * This function sorts the array using quick sort algorithm
     */
    private void sort(int [] input_array, int l , int r){
        
        if (l < r){ // base case

            int pivot = partition(input_array, l, r);
            sort(input_array, l, pivot - 1);
            sort(input_array, pivot + 1, r);
        }
    }
        

    @Override
    public void sort() {
        sort(arr, 0, arr.length - 1);
    }

    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();
    }
}
