public class convertDate{
	public static void main(String[] args){
	String oldDate = args[0];
	converter tempDate = new converter();
	int numDate = tempDate.converter
	int converter(String oldDate){
		String day = oldDate.substring(3,5);
		String month = oldDate.substring(0,2);
		String year = oldDate.substring(6,10);
		String newDate = year + month + day;
		int numDate = Integer.parseInt(newDate);
		return numDate;
	}
	System.out.println(new converter("01/20/2012"));
}