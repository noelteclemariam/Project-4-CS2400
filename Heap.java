public class Heap {

    private int data[];
    int count=0;
    
    public Heap() {
            data = new int[100];
    }
    
    public int optimal_insertion(int arr[]) {
            for (int i=0; i<arr.length; i++) {
                    data[i] = arr[i];
            }
            int cnt=0;
            int s;
            for (int i=data.length/2; i>=0; i--) {
                    int j = 2 * i + 1;
                    int k = i;
                    while (j<data.length) {
                            if ((j+1)<data.length && data[j]<data[j+1]) {
                                    j++;
                            }
                            if (data[k]>=data[j])
                                    break;
                            s = data[k];
                            data[k] = data[j];
                            data[j] = s;
                            k = j;
                            j = 2*k + 1;
                            cnt++;
                    }
            }
            
            return cnt;
    }
    
    public int sequential_insertion(int arr[]) {
            int cnt=0;
            for (int i=0; i<arr.length; i++) {
                    data[i]=arr[i];
                    int j=(i-1)/2;
                    int k=i;
                    while(k!=0)
                    {
                            if(data[k]>data[j])
                            {
                                    int temp=data[k];
                                    data[k]=data[j];
                                    data[j]=temp;
                                    cnt++;
                            }
                            k=j;
                            j=(k-1)/2;
                    }
            }
            return cnt;
    }
    
    public int remove() 
{ 
            int n = data.length;
            
    int lastElement = data[n - 1]; 

    data[0] = lastElement; 

    n = n - 1; 

    heapify(n, 0); 
    return n; 
} 
    
    public void heapify(int n, int i) 
{ 
    int largest = i; 
    int l = 2 * i + 1; 
    int r = 2 * i + 2; 

    if (l < n && data[l] > data[largest]) 
        largest = l; 

    if (r < n && data[r] > data[largest]) 
        largest = r; 

    if (largest != i) { 
        int swap = data[i]; 
        data[i] = data[largest]; 
        data[largest] = swap; 
        count++;

        heapify(n, largest); 
    } 
}
    
    
    public int get(int index) {
            return data[index];
    }
}