学习笔记
```java
    public void bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size -1; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                int tmp = nums[j];
                if (nums[j] > nums[j+1]) {
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

   public void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for(int i = 0; i < len - 1; i++) {
            minIndex = i;
            for(int j = i + 1; j < len; j++) {
                if(arr[j] < arr[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public void insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for(int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while(preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public void shellSort(int[] arr) {
        int len = arr.length;
        for(int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for(int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while(j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
    }   
```

