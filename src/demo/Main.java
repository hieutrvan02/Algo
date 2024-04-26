package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import binarytree.TreeNode;

public class Main{

	public int removeDuplicate(int[] nums) {
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}

	public int singleNumber(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			boolean flg = true;
			for (int j = 0; j < nums.length; j++) {
				if (i != j && nums[i] == nums[j]) {
					flg = false;
					break;
				}
			}

			if (flg) {
				return nums[i];
			}
		}
		return -1;
	}

	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> mapNums = new HashMap<>();

		for (int num : nums) {
			if (mapNums.containsKey(num) && mapNums.get(num) >= 1)
				return true;
			mapNums.put(num, mapNums.getOrDefault(num, 0) + 1);
		}

		return false;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				if (nums[i] == nums[j] && Math.abs(i - j) <= k && i != j) {
					return true;
				}
			}
		}

		return false;
	}

	public int missingNumber(int[] nums) {
		int r = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == r) {
					r++;
				}
			}
		}
		return r;
	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapNums = new HashMap<>();
		Set<Integer> setNums = new HashSet();
		int i = 0;

		for (int n : nums1) {
			mapNums.put(n, mapNums.getOrDefault(n, 0) + 1);
		}
		for (Integer num : nums2) {
			if (mapNums.containsKey(num)) {
				setNums.add(num);
			}
		}
		int[] arr = new int[setNums.size()];
		for (int x : setNums)
			arr[i++] = x;
		return arr;
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapNums = new HashMap<>();
		ArrayList<Integer> listNums = new ArrayList<>();
		int i = 0;

		for (int n : nums1) {
			mapNums.put(n, mapNums.getOrDefault(n, 0) + 1);
		}
		for (Integer num : nums2) {
			if (mapNums.containsKey(num) && mapNums.get(num) > 0) {
				mapNums.put(num, mapNums.get(num) - 1);
				listNums.add(num);
			}
		}
		int[] arr = new int[listNums.size()];
		for (int x : listNums)
			arr[i++] = x;
		return arr;
	}

	public boolean halvesAreAlike(String s) {
		ArrayList<Character> listChar = new ArrayList<Character>();
		listChar.add('a');
		listChar.add('e');
		listChar.add('i');
		listChar.add('o');
		listChar.add('u');
		listChar.add('A');
		listChar.add('E');
		listChar.add('I');
		listChar.add('O');
		listChar.add('U');
		int l = s.length() / 2;
		int vowels1 = 0;
		int vowels2 = 0;
		for (int i = 0; i < l; i++) {
			if (listChar.contains(s.charAt(i))) {
				vowels1++;
			}
		}
		for (int i = l; i < s.length(); i++) {
			if (listChar.contains(s.charAt(i))) {
				vowels2++;
			}
		}
		if (vowels1 == vowels2)
			return true;
		return false;
	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> mapNums = new HashMap<>();
		for (int i : arr) {
			mapNums.put(i, mapNums.getOrDefault(i, 0) + 1);
		}
		Set<Integer> setNums = new HashSet<>();
		for (Map.Entry<Integer, Integer> entry : mapNums.entrySet()) {
			if (setNums.contains(entry.getValue()))
				return false;
			else
				setNums.add(entry.getValue());
		}
		return true;
	}

	public int[] findErrorNums(int[] nums) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int[] r = new int[2];
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			if (entry.getValue() == 2) {
				r[0] = entry.getKey();
				r[1] = numMap.containsKey(entry.getKey() + 1) ? (entry.getKey() + 1) : (entry.getKey() - 1);
			}

		}
		return r;
	}

	public int findJudge(int n, int[][] trust) {
		int[] trusting = new int[n + 1];
		int[] trusted = new int[n + 1];

		for (int i = 0; i < trust.length; i++) {
			trusting[trust[i][0]]++;
			trusted[trust[i][1]]++;
		}

		int ans = -1;

		for (int i = 1; i <= n; i++) {
			if (trusting[i] == 0 && trusted[i] == n - 1)
				ans = i;
		}

		return ans;
	}
	
	public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if(s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for(int idx = 0; idx < s.length(); idx++){
            // Compare the maps, if not equal, return false...
            if(map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            // Insert each character if string s and t into seperate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;    // Otherwise return true...
    }
	
	public int addDigits(int num) {
        int s = 0;
        do {
            s += num % 10;
            num = num / 10;
        } while (num != 0);
        if (s >= 10) return addDigits(s);
        else return s;
    }
	
	public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> m=new HashMap<>();
        String str[]=s.split(" ");
        int a = pattern.length();

        if(a!=str.length) {return false;}

        for(int i=0;i<pattern.length();i++)
        {
            char ch=pattern.charAt(i);
            if(m.containsKey(ch))
            {
                String res=m.get(ch);
                if(!res.equals(str[i]))
                {
                    return false;
                }
            }
            //check if the values are repeating ie a-->dog b-->dog should not b repeated 
            else
            {
                if(m.containsValue(str[i]))
                {
                    return false;
                }
            }

            m.put(ch,str[i]);
        }
        return true;
    }
	
	public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        return findOfleftLeaves(root, sum);
    }

    public int findOfleftLeaves(TreeNode node, int sum) {
        if (node.left == null && node.right == null) sum += node.val;
        if (node.left != null) return findOfleftLeaves(node.left, sum);
        if (node.right != null) return findOfleftLeaves(node.right, sum);
        return sum;
    }
    
    public int firstUniqChar(String s) {
    	HashMap<String,Integer> n=new HashMap<>();
    	String[] arr = s.split("");
        for (String string : arr) {
			n.put(string, n.getOrDefault(string, 0) + 1);
		}
        for (int i = 0; i < arr.length; i++) {
			if (n.get(arr[i]) == 1) return i;
		}
        return -1;
    }

	public static void main(String[] args) {
		int[] arr = { 1, 2 };
		int[] arr1 = { 2, 2 };
		String a = "hit";
		String b = "ear";
		Main m = new Main();
		System.out.println(m.sumOfLeftLeaves(null));
	}
}
