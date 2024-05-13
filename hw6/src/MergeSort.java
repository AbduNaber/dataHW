public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) {
		super(input_array);
	}
	
	private void merge(int []input_array ,int l, int r, int mp){
        int size1 = mp-l+1;
        int size2 = r-mp;


        int [] tmp1 = new int[size1];
        int [] tmp2 = new int[size2];

        for(int i = 0; i <size1 ;i++){
            tmp1[i] = input_array[l+i];
        }

        for(int i = 0; i <size2 ;i++){
            tmp2[i] = input_array[mp+1+i];
        }

        int a =0 ;
        int b = 0;

        int m = l;
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

    private void sort(int [] input_array,int l,int r){

        if(l< r){

            int mp = r+ (r-l)/2;

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
