package farming.co.uk.infolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class InfoListAdapter extends BaseAdapter {

    private final Context context;
    private final LinkedHashSet<Integer> layoutIds;

    public InfoListAdapter(Context context, Section... sections) {
        this.sections = new ArrayList<>();
        this.layoutIds = new LinkedHashSet<>();
        for(Section section : Arrays.asList(sections))
            addSection(section);
        this.context = context;
        notifyDataSetChanged();
    }

    private ArrayList<Section> sections;

    public InfoListAdapter(Context context, ArrayList<String> strings) {
        this.sections = new ArrayList<>();
        this.layoutIds = new LinkedHashSet<>();
        addSection(new Section(strings));
        this.context = context;
        notifyDataSetChanged();
    }

    public void addSection(Section section) {
        sections.add(section);
        layoutIds.addAll(section.getLayoutIds());
        notifyDataSetChanged();
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
        notifyDataSetChanged();
    }

    private class Index {
        private final int section, row;

        private Index(int section, int row) {
            this.section = section;
            this.row = row;
        }

        public int getSection() {
            return section;
        }

        public int getRow() {
            return row;
        }
    }

    @Override
    public int getViewTypeCount() {
        return layoutIds.size();
    }

    @Override
    public int getItemViewType(int position) {
        int n = 0;
        int layoutId = getCell(position).getLayoutId();
        for (Integer layoutId1 : layoutIds)
            if (layoutId1 == layoutId)
                return n;
            else
                n++;
        return -1;
    }

    public Index positionToIndex(int position) {
        int total = position;
        for (int n = 0; n < sections.size(); n++) {
            int sectionSize = sections.get(n).size();
            if (total < sectionSize)
                return new Index(n, total);
            total -= sectionSize;
        }
        return null;
    }

    public Cell getCell(int position) {
        return getCell(positionToIndex(position));
    }

    public Cell getCell(Index index) {
        return sections.get(index.section).getCell(index.row);
    }

    public Section getSection(int position) {
        return sections.get(positionToIndex(position).getSection());
    }

    @Override
    public int getCount() {
        int count = 0;

        for (Section section : sections)
            count += section.size();

        return count;
    }

    @Override
    public Object getItem(int position) {
        return getCell(position);
    }

    @Override
    public long getItemId(int position) {
        return getCell(position).getLayoutId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        Cell cell = getCell(position);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(cell.getLayoutId(), parent, false);
        }

        cell.fillView(view);

        return view;
    }

}