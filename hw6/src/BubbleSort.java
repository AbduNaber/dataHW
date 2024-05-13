public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int input_array[]) {
		super(input_array);
	}
	
    @Override
    public void sort() {
    	int i,j;
        int flag = 0;
        	for(i=0; i<arr.length-1; i++) {

                flag = 0;  
                
        		for(j=0; j<arr.length-i-1; j++) {
                    comparison_counter++;
        			if(arr[j] > arr[j+1]) {
        				swap(j, j+1);
        				flag = 1;
                        
        			}
        		}
                
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
