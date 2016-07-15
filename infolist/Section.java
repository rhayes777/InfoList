package farmingonline.co.uk.wateraware.wateraware.classes.libs.infolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import farming.co.uk.wateraware.R;

public class Section {
    private final ArrayList<Cell> cells;
    private final String title;

    public Section(String title) {
        this.title = title;
        cells = new ArrayList<>();
        Cell titleCell = new Cell(title, R.layout.cell_title);
        titleCell.setTextColor(android.R.color.black);
        this.cells.add(titleCell);
    }

    public Section(String title, Cell... cells) {
        this.title = title;
        this.cells = new ArrayList<>();
        Cell titleCell = new Cell(title, R.layout.cell_title);
        titleCell.setTextColor(android.R.color.black);
        this.cells.add(titleCell);
        this.cells.addAll(Arrays.asList(cells));
    }

    public Section() {
        this.title = null;
        cells = new ArrayList<>();
    }

    public Section(Cell... cells) {
        this.title = null;
        this.cells = new ArrayList<>();
        this.cells.addAll(Arrays.asList(cells));
    }

    public Section(ArrayList<String> strings) {
        this.title = null;
        this.cells = new ArrayList<>();
        for (String string : strings)
            this.cells.add(new Cell(string));
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public void sort() {
        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell lhs, Cell rhs) {
                return lhs.getText().compareTo(rhs.getText());
            }
        });
    }

    protected Cell getCell(int n) {
        return cells.get(n);
    }

    protected String getTitle() {
        return title;
    }

    public int size() {
        return this.cells.size();
    }
}
