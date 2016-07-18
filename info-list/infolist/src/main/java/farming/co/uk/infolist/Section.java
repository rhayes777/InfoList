package farming.co.uk.infolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Section {
    private final ArrayList<Cell> cells;
    private final String title;
    private final LinkedHashSet<Integer> layoutIds;

    public Section(String title) {
        this.title = title;
        this.layoutIds = new LinkedHashSet<>();
        cells = new ArrayList<>();
        Cell titleCell = new Cell(title, R.layout.cell_title);
        titleCell.setTextColor(android.R.color.black);
        addCell(titleCell);
    }

    public Section(String title, Cell... cells) {
        this.title = title;
        this.cells = new ArrayList<>();
        this.layoutIds = new LinkedHashSet<>();
        Cell titleCell = new Cell(title, R.layout.cell_title);
        titleCell.setTextColor(android.R.color.black);
        addCell(titleCell);
        for (Cell cell : Arrays.asList(cells))
            addCell(cell);
    }

    public Section() {
        this.title = null;
        this.layoutIds = new LinkedHashSet<>();
        cells = new ArrayList<>();
    }

    public Section(Cell... cells) {
        this.title = null;
        this.layoutIds = new LinkedHashSet<>();
        this.cells = new ArrayList<>();
        for (Cell cell : Arrays.asList(cells))
            addCell(cell);
    }

    public Section(ArrayList<String> strings) {
        this.title = null;
        this.layoutIds = new LinkedHashSet<>();
        this.cells = new ArrayList<>();
        for (String string : strings)
            addCell(new Cell(string));
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
        this.layoutIds.add(cell.getLayoutId());
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

    public Collection<Integer> getLayoutIds() {
        return layoutIds;
    }
}
