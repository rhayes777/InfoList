package farming.co.uk.infolist;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class Cell {

    private String text;
    private final int layoutId;

    private Typeface typeface;
    private int textColor;
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
        this.textId = textId;
        this.onClickListener = onClickListener;
        this.layoutId = R.layout.cell_left_justified;
        this.text = null;
        setDefaults();
    }

    public void setDefaults() {
        this.typeface = Typeface.create("robot", 16);
        this.textColor = android.R.color.black;
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

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void fillView(View view) {
        view.setOnClickListener(onClickListener);
        TextView textView = (TextView) view.findViewById(R.id.text);
        String text = getText();
        if (text != null)
            textView.setText(text);
        if (textId != -1)
            textView.setText(textId);

        textView.setTypeface(typeface);
        textView.setTextColor(textColor);

    }

}