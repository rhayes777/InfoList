package farmingonline.co.uk.wateraware.wateraware.classes.libs.infolist;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import farming.co.uk.wateraware.R;
import farmingonline.co.uk.wateraware.wateraware.classes.ADAMAStyles;
import farmingonline.co.uk.wateraware.wateraware.controller.RootActivity;

public class Cell {

    private String text;
    private final int layoutId;

    private Typeface typeface;
    private int textColor;
//    private float textSize;
    private View.OnClickListener onClickListener;
    private final int textId;

    public Cell(String text) {
        this.text = text;
        this.layoutId = R.layout.cell_left_justified;
        textId = -1;
        setDefaults();
    }

    public Cell(String text, int layoutId) {
        this.text = text;
        this.layoutId = layoutId;
        textId = -1;
        setDefaults();
    }

    public Cell(String text, View.OnClickListener onClickListener) {
        this.text = text;
        this.onClickListener = onClickListener;
        this.layoutId = R.layout.cell_left_justified;
        textId = -1;
        setDefaults();
    }

    public Cell(String text, int layoutId, View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.text = text;
        this.layoutId = layoutId;
        textId = -1;
        setDefaults();
    }

    public Cell(int textId, View.OnClickListener onClickListener) {
        System.out.println("text_id SET to " + textId);
        this.textId = textId;
        this.onClickListener = onClickListener;
        this.layoutId = R.layout.cell_left_justified;
        this.text = null;
        setDefaults();
    }

    public void setDefaults() {
        ADAMAStyles adamaStyles = RootActivity.getInstance().getADAMAStyles();
        this.typeface = adamaStyles.getBrownPro();
        this.textColor = adamaStyles.getCorporateEarth();
//        this.textSize = 20;
    }

    protected int getLayoutId() {
        return layoutId;
    }

    public String getText() {
        return text;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

//    public void setTextSize(float textSize) {
//        this.textSize = textSize;
//    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public void setTextColor(int textColor) {
        this.textColor = RootActivity.getInstance().getADAMAStyles().getColor(textColor);
    }

    public void fillView(View view) {
        view.setOnClickListener(onClickListener);
        TextView textView = (TextView) view.findViewById(R.id.text);
        String text = getText();
        if (text != null)
            textView.setText(text);
        System.out.println("textId = " + textId);
        if (textId != -1)
            textView.setText(textId);

        textView.setTypeface(typeface);
        textView.setTextColor(textColor);
//        textView.setTextSize(textSize);
    }

}