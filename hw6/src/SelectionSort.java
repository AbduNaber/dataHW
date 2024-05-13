public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {
       
  
        int  tmpi =0;
        for(int i = 0; i< arr.length-1 ;i++){
            for(int j= i ;j< arr.length;j++){
                comparison_counter++;
                if(arr[i] > arr[j]){
                    tmpi = j;
                }


            }


           
            
            swap (i,tmpi);
            


        }
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
