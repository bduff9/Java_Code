import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TableObject {

	public static void main(String[] args) {
		String[] when = new String[]{"1", "1", "2", "2", "3", "3"};
		String[] name = new String[]{"A", "B", "A", "C", "A", "C"};
		float[] amount = new float[]{3, 6, 5, 4, 4, 9};
		List<String> colKey = new ArrayList<String>();
		for (int i = 0; i < when.length; i++) {
			if (colKey.indexOf(when[i]) == -1) colKey.add(when[i]);
		}
		List<String> rowKey = new ArrayList<String>();
		for (int i = 0; i < name.length; i++) {
			if (rowKey.indexOf(name[i]) == -1) rowKey.add(name[i]);
		}
		List<List<Float>> graphVal = createTable(colKey.size(), rowKey.size());
		for (int i = 0; i < amount.length; i++) {
			int col = colKey.indexOf(when[i]);
			int row = rowKey.indexOf(name[i]);
			graphVal.get(col).set(row, amount[i]);
		}
		// Print resulting table
		System.out.println("   " + Arrays.toString(rowKey.toArray()));
		for (int i = 0; i < graphVal.size(); i++) {
			System.out.println(colKey.get(i) + " " + Arrays.toString(graphVal.get(i).toArray()));
		}
	}
	
	public static List<List<Float>> createTable(int cols, int rows) {
		List<List<Float>> newTable = new ArrayList<List<Float>>();
		for (int c = 0; c < cols; c++) {
			List<Float> currRow = new ArrayList<Float>();
			for (int r = 0; r < rows; r++) {
				currRow.add((float) 0);
			}
			newTable.add(currRow);
		}
		return newTable;
	}

}
