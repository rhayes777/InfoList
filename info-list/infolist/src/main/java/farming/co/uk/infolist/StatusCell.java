package farming.co.uk.infolist;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

public class StatusCell extends Cell {

    private final int imageIdToday;
    private final int imageId72;
    private final int imageIdIcon;

    private View.OnClickListener listenerIcon, listenerToday, listener72;


    public StatusCell(String text, int imageIdToday, int imageId72, int imageIdIcon) {
        super(text, R.layout.cell_status);
        this.imageIdToday = imageIdToday;
        this.imageId72 = imageId72;
        this.imageIdIcon = imageIdIcon;
    }

    public StatusCell(String text, int imageIdToday, int imageId72, int imageIdIcon, int layoutName) {
        super(text, layoutName);
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

    private ImageView setImageForView(int imageId, int imageViewId, View view) {
        ImageView imageView = (ImageView) view.findViewById(imageViewId);
        if (imageId > 0) {
            imageView.setImageResource(imageId);
            imageView.setVisibility(View.VISIBLE);
        } else
            imageView.setVisibility(View.GONE);
        return imageView;
    }


    @Override
    public void fillView(View view) {
        super.fillView(view);
        ImageView imageToday, image72, imageIcon;

        imageToday = setImageForView(getImageIdToday(), R.id.imageToday, view);
        image72 = setImageForView(getImageId72(), R.id.image72, view);
        imageIcon = setImageForView(getImageIdIcon(), R.id.imageIcon, view);

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
