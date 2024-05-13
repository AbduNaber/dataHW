public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}
    /**
     * This function swaps the elements at index i and j in the array
     */
    @Override
    public void sort() {
       
  
        int  tmpi =0; // temporary index
        // Selection sort algorithm
        for(int i = 0; i< arr.length-1 ;i++){
            tmpi = i;
            for(int j= i +1;j< arr.length;j++){

                comparison_counter++;
                if(arr[j] < arr[tmpi]){ // find the minimum element in the array
                    tmpi = j;
                }


            }

            swap (i,tmpi); // swap the minimum element with the current element
            


        }
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
