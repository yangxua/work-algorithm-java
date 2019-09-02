 package com.xuyang.algorithm.sort;

public class SortTest {

	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length-1; j > i; j--) {
				if(arr[j] < arr[j-1]){
					swap(arr,j,j-1);
				}
			}
		}
	}
	
	public static void selectSort(int[] arr){
		int minIndex = 0;
		for (int i = 0; i < arr.length-1; i++) {
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			
			if(i != minIndex){
				swap(arr, minIndex, i);
			}
		}
	}
	
	public static void insertSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			int target = arr[i];
			
			while(j > 0 && arr[j-1] > target){
				arr[j] = arr[j-1];
				j--;
			}
			
			arr[j] = target;
		}
	}
	
	public static void quickSort(int[] arr){
		SortOfQuick(arr,0,arr.length-1);
	}
	

	private static void SortOfQuick(int[] arr, int left, int right) {
		if(left >= right){
			return;
		}
		int pos = partition(arr,left,right);
		SortOfQuick(arr,left,pos-1);
		SortOfQuick(arr,pos+1,right);
		
	}

	private static int partition(int[] arr, int left, int right) {
		int target = arr[left];
		
		while(left < right){
			while(right > left && arr[right] >= target){
				right--;
			}
			arr[left] = arr[right];
			while(right > left && arr[left] < target){
				left++;
			}
			arr[right] = arr[left];
			
		}
		
		arr[left] = target;
		
		return left;
	}
	
	public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        
        for(int i=2*start+1;i<=end; i=2*i+1) {
            //���Һ��ӵĽڵ�ֱ�Ϊ2*i+1,2*i+2
            
            //ѡ������Һ��ӽ�С���±�
            if(i < end && arr[i] < arr[i+1]) {
                i ++; 
            }
            if(temp >= arr[i]) {
                break; //�Ѿ�Ϊ�󶥶ѣ�=�����ȶ��ԡ�
            }
            arr[start] = arr[i]; //���ӽڵ�����
            start = i; //��һ��ɸѡ
        }
        
        arr[start] = temp; //������ȷ��λ��
    }
    
    
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        
        //�����󶥶�
        for(int i=(arr.length-2)/2; i>=0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }
        
        for(int i=arr.length-1; i>0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }
        
    }

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
