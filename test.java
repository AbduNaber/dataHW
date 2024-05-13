public class test{
    public static void main(String[] args) {
        

        int [] arr = {1,2,3,4,5,6,7,8,9};
        split(arr,0,arr.length -1,'3');

    }

    static void split(int [] arr,int l,int r,char t){
        System.out.println("f: "+ t+" l :" + l+" r: " +r);
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;
            System.out.println("m: "+m);
            // Sort first and second halves
            split(arr, l, m,'1');
            split(arr, m + 1, r,'2');
            
            System.out.println("bur");
            
            
        }
    }




}