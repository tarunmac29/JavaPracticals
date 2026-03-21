<%-- 
    Document   : sort
    Created on : Mar 13, 2026, 9:44:13?AM
    Author     : hp
--%>
<%@ tag body-content="empty"%>
<%@attribute name="numbers" required="true"%>

<% 
    String input = numbers;
    String[] arr= input.split(",");
    int[] nums = new int[arr.length];
    
    for(int i=0; i<arr.length;i++){
        nums[i]=Integer.parseInt(arr[i].trim());
    }
    for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]>nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
            }
        }
    }
%>

<h2>Sorted Numbers: </h2>
<h2>${numbers}</h2>