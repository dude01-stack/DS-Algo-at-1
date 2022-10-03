import java.util.Arrays;

public class QuickSortSoln {
	
	private static int partititon(int[] a, int si, int ei) {
		
		int pivotElement=a[si];
		int smallerNumCount=0;
		
		for(int i=si+1; i<=ei; i++) {
			if(a[i]<pivotElement) {
				smallerNumCount++;
			}
		}
		int pivotIndex=smallerNumCount+si;
		
		a[si]=a[smallerNumCount+si];
		a[smallerNumCount+si]=pivotElement;
		
		int i=si;
		int j=ei; 
		
		while(i<j) {
			if(a[i]<pivotElement) {
				i++;
			}
			else if(a[j]>=pivotElement) {
				j--;
			}
			else {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			
		}
		return pivotIndex;		
	}
	
	public static void quickSort(int[] a,int si,int ei) {
		
		if(si>=ei) {
			return ;
		}
		int pivotIndex=partititon(a,si,ei);
		quickSort(a, si, pivotIndex-1);
		quickSort(a, pivotIndex+1, ei);
	}

	

	public static void main(String[] args) {
		int[] a= {10,4,5,9,8,6,12,11,7,888,777,111};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}
