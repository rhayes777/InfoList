package farming.co.uk.infolist;

import android.view.View;
import android.widget.ImageView;

import farming.co.uk.wateraware.R;

public class InfoCell extends Cell {

    private final int imageId;

    public InfoCell(String text, int imageId) {
        super(text, R.layout.cell_info);
        if (imageId <= 0)
            this.imageId = R.drawable.white;
        else
            this.imageId = imageId;
    }

    public InfoCell(String text) {
        super(text, R.layout.cell_info);
        this.imageId = R.drawable.white;
    }

    public InfoCell(String text, int imageId, int layoutName) {
        super(text, layoutName);
        this.imageId = imageId;
    }

    @Override
    public void fillView(View view) {
        super.fillView(view);
        ((ImageView) view.findViewById(R.id.image)).setImageResource(imageId);
    }
}