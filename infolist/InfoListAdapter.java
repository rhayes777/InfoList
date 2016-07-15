package farmingonline.co.uk.wateraware.wateraware.classes.libs.infolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import farming.co.uk.wateraware.R;
import farmingonline.co.uk.wateraware.wateraware.controller.RootActivity;

public class InfoListAdapter extends BaseAdapter {

    private final Context context;

    public InfoListAdapter(Context context, Section... sections) {
        this.sections = new ArrayList<>();
        this.sections.addAll(Arrays.asList(sections));
        this.context = context;
        notifyDataSetChanged();
    }

    private ArrayList<Section> sections;

    public InfoListAdapter(RootActivity context, ArrayList<Section> sections) {
        this.context = context;
        this.sections = sections;
        notifyDataSetChanged();
    }

    public InfoListAdapter(Context context, ArrayList<String> strings) {
        this.sections = new ArrayList<>();
        sections.add(new Section(strings));
        this.context = context;
        notifyDataSetChanged();
    }

    public void addSection(Section section) {
        sections.add(section);
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
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        switch (getCell(position).getLayoutId()) {
            case R.layout.cell_title:
                return 0;
            case R.layout.cell_info:
                return 1;
            case R.layout.cell_status:
                return 2;
            case R.layout.cell_centered:
                return 3;
            case R.layout.cell_left_justified:
                return 4;
            default:
                return 0;
        }
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