package ownGenericClass;


public class GenericMethods {

	public static void main(String[] args) {
		String []names= {"name1","name2","name3"};
		
		String elements=MyArrays.getElements(names);
		System.out.println(elements);
		
		Integer[]nums= {1,2,3,4};
		System.out.println(MyArrays.getElements(nums));
		
		System.out.println(MyArrays.getSmall(nums));
		System.out.println(MyArrays.getSmall(names));

	}

}
class MyArrays{
	
	public static <T> String getElements(T[]array) {
		return "this array have a length of "+array.length;
	}
	public static <T extends Comparable> T getSmall(T[]array) {//T is just a generic variable
		if(array==null || array.length==0) {
			return null;
		}
		
		T tt=array[0];
		for(T t:array) {
			if(tt.compareTo(t)>0) {
				tt=t;
			}
		}
		return tt;
		
	}

}