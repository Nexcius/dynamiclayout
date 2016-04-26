package schibsted.com.dynamiclayout.models;

import android.content.Context;
import android.widget.ImageView;

public class SquareImage extends ImageView {

    public SquareImage(Context context) {
        super(context);
        setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
