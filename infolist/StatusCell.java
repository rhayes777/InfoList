package farmingonline.co.uk.wateraware.wateraware.classes.libs.infolist;

import android.view.View;
import android.widget.ImageView;

import farming.co.uk.wateraware.R;

public class StatusCell extends Cell {

    private final int imageIdToday;
    private final int imageId72;
    private final int imageIdIcon;
    
    private View.OnClickListener listenerIcon, listenerToday, listener72; 
    

    public StatusCell(String text, int imageIdToday, int imageId72, int imageIdIcon) {
        super(text, R.layout.cell_status);
        if (imageIdToday <= 0)
            imageIdToday = R.drawable.white;
        if (imageId72 <= 0)
            imageId72 = R.drawable.white;
        if (imageIdIcon <= 0)
            imageIdIcon = R.drawable.white;
        this.imageIdToday = imageIdToday;
        this.imageId72 = imageId72;
        this.imageIdIcon = imageIdIcon;
    }

    public StatusCell(String text, int imageIdToday, int imageId72, int imageIdIcon, int layoutName) {
        super(text, layoutName);
        if (imageIdToday <= 0)
            imageIdToday = R.drawable.white;
        if (imageId72 <= 0)
            imageId72 = R.drawable.white;
        if (imageIdIcon <= 0)
            imageIdIcon = R.drawable.white;
        this.imageIdToday = imageIdToday;
        this.imageId72 = imageId72;
        this.imageIdIcon = imageIdIcon;
    }

    public int getImageIdToday() {
        return imageIdToday;
    }

    public int getImageId72() {
        return imageId72;
    }

    public int getImageIdIcon() {
        return imageIdIcon;
    }
    

    @Override
    public void fillView(View view) {
        super.fillView(view);
        ImageView imageToday, image72, imageIcon;
        imageToday = (ImageView) view.findViewById(R.id.imageToday);
        imageToday.setImageResource(getImageIdToday());
        image72 = (ImageView) view.findViewById(R.id.image72);
        image72.setImageResource(getImageId72());
        imageIcon = (ImageView) view.findViewById(R.id.imageIcon);
        imageIcon.setImageResource(getImageIdIcon());

        if (listener72 != null)
            image72.setOnClickListener(listener72);
        if (listenerToday != null)
            imageToday.setOnClickListener(listenerToday);
        if (listenerIcon != null)
            imageIcon.setOnClickListener(listenerIcon);
    }

    public void setListenerIcon(View.OnClickListener listenerIcon) {
        this.listenerIcon = listenerIcon;
    }

    public void setListenerToday(View.OnClickListener listenerToday) {
        this.listenerToday = listenerToday;
    }

    public void setListener72(View.OnClickListener listener72) {
        this.listener72 = listener72;
    }
}
