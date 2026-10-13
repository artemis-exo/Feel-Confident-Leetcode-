class Solution {
    public long maxAlternatingSum(int[] nums) {
        /*
        1 ---- >>> Phele sqaure le lete hai takki -tive terms balance hoke positive mey change ho jaye aur humko waise bhi Square krna hi hai
        ------- >> sort karenge iske bad tkki smaller age ajye
        2 ---- >> Uske bad smaller terms n/2 tk arrange wali lelenge kyu ki alternating condition satisfy krne ke llye
        3 ---- >> Question mey likha bhi hai You may rearrange the elements in any order

        4 -- >> toh hum smailler walo ko ka -tive sum store kr lenge aur larger walo ka postive
        */

        for(int i=0 ; i<nums.length ;i++){  // -tive handling ke liye square
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long ans=0;
        for(int i=0; i<nums.length/2; i++){ // smaller nno process krliye koe bhi order mention hai
            ans+=nums[i];
        }
        ans=ans*-1;
        IO.println(ans);
        for(int i=nums.length/2; i<nums.length; i++){  // phir jhn se smaller khtm uske age se larger
            ans+=nums[i];
        }
          return ans;
    }
}