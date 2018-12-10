package com.example.cbsdlib.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.cbsdlib.R;
import com.example.cbsdlib.imageloader.ImageLoaderV4;

import java.util.List;
import java.util.TimerTask;

/**
 * Created by hasee on 2017/3/27.
 */

public class NinePictureLayout extends ViewGroup{
    private static final float DEFUALT_SPACING = 5f;
    private static final int MAX_COUNT = 3;

    protected Context mContext;
    private float mSpacing = DEFUALT_SPACING;
    private int mColumns;
    private int mRows;
    private int mTotalWidth;
    private int mSingleWidth;
    private boolean mIsFirst = true;
    private List<String> mUrlList =null;
    private boolean mIsShowAll = false;
    private boolean mIsNeedSavePic = false;
    private Boolean hideThree=true;
    private final String TAG="NinePictureLayout";


    public void setmIsNeedSavePic(boolean mIsNeedSavePic) {
        this.mIsNeedSavePic = mIsNeedSavePic;
    }

    public NinePictureLayout(Context context) {
        super(context);
        init(context);
    }

    public NinePictureLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridLayout);
        mSpacing = typedArray.getDimension(R.styleable.NineGridLayout_sapcing, DEFUALT_SPACING);
        typedArray.recycle();
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        if (getListSize(mUrlList) == 0) {
            setVisibility(GONE);
        }
        //// TODO: 2018/4/18 0018
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mTotalWidth = right - left;
        mSingleWidth = (int) ((mTotalWidth - mSpacing * (3 - 1)) / 3);
        if (mIsFirst) {
            notifyDataSetChanged();
            mIsFirst = false;
        }
    }

    public void setSpacing(float spacing) {
        mSpacing = spacing;
    }

    public void setUrlList(List<String> urlList) {
        if (getListSize(urlList) == 0) {
            setVisibility(GONE);
            return;
        }
        setVisibility(VISIBLE);
        mUrlList=null;
        mUrlList=urlList;
        if (!mIsFirst) {
            notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        post(new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        });
    }

    private void refresh() {
        removeAllViews();
        int size = getListSize(mUrlList);
        if (size==3){
            hideThree=false;
        }
        if (size > 0) {
            setVisibility(VISIBLE);
        } else {
            setVisibility(GONE);
        }
        if (size == 1) {
            if (mUrlList.get(0)!=null&& !TextUtils.isEmpty(mUrlList.get(0))){
                String url = mUrlList.get(0);
                ImageView imageView = createImageView(0, url);
                LayoutParams params = getLayoutParams();
                params.height = mSingleWidth;
                setLayoutParams(params);
                imageView.layout(0, 0, mSingleWidth, mSingleWidth);
                displayImage(imageView, url);
                addView(imageView);
            }
            return;
        }
        generateChildrenLayout(size);
        layoutParams();
        for (int i = 0; i < size; i++) {
            String url = mUrlList.get(i);
            ImageView imageView;
            if (!mIsShowAll) {
                if (i < MAX_COUNT - 1) {
                    imageView = createImageView(i, url);
                    layoutImageView(imageView, i, url, false);
                } else {
                    if (size <= MAX_COUNT) {
                        imageView = createImageView(i, url);
                        layoutImageView(imageView, i, url, false);
                    } else {
                        imageView = createImageView(i, url);
                        layoutImageView(imageView, i, url, true);
                        break;
                    }
                }
            } else {
                imageView = createImageView(i, url);
                layoutImageView(imageView, i, url, false);
            }
        }
    }
    private void layoutParams() {
        int singleHeight = mSingleWidth;
        LayoutParams params = getLayoutParams();
        params.height = (int) (singleHeight * mRows + mSpacing * (mRows - 1));
        setLayoutParams(params);
    }

    private ImageView createImageView(final int i, final String url) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setTagId(i);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickImage(i, url, mUrlList);
            }
        });
        return imageView;
    }

    private void layoutImageView(ImageView imageView, int i, String url, boolean showNumFlag) {
        final int singleWidth = (int) ((mTotalWidth - mSpacing * (3 - 1)) / 3);
        int singleHeight = singleWidth;
        int[] position = findPosition(i);
        int left = (int) ((singleWidth + mSpacing) * position[1]);
        int top = (int) ((singleHeight + mSpacing) * position[0]);
        int right = left + singleWidth;
        int bottom = top + singleHeight;
        imageView.layout(left, top, right, bottom);
        addView(imageView);
        if (showNumFlag) {
            int overCount = getListSize(mUrlList) - MAX_COUNT;
            if (overCount > 0) {
                float textSize = 30;
                final TextView textView = new TextView(mContext);
                textView.setText("+" + String.valueOf(overCount));
                textView.setTextColor(Color.WHITE);
                textView.setPadding(0, singleHeight / 2 - getFontHeight(textSize), 0, 0);
                textView.setTextSize(textSize);
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundColor(Color.BLACK);
                textView.getBackground().setAlpha(120);
                textView.layout(left, top, right, bottom);
                addView(textView);
            }
        }
        if (i==2&&hideThree){
            return;
        }
        displayImage(imageView, url);

    }
    private int getFontHeight(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.ascent);
    }

    private int[] findPosition(int childNum) {
        int[] position = new int[2];
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                if ((i * mColumns + j) == childNum) {
                    position[0] = i;//行
                    position[1] = j;//列
                    break;
                }
            }
        }
        return position;
    }

    private void generateChildrenLayout(int length) {
        if (length <= 3) {
            mRows = 1;
            mColumns = length;
        }else {
            mColumns = 3;
            if (mIsShowAll) {
                mRows = length / 3;
                int b = length % 3;
                if (b > 0) {
                    mRows++;
                }
            } else {
                mRows = 1;
            }
        }
    }

    private int getListSize(List<String> list) {
        if (list == null || list.size()== 0) {
            return 0;
        }
        return list.size();
    }

    protected void displayImage(ImageView imageView, String url){
        ImageLoaderV4.getInstance().displayImage(mContext, url, imageView);
    }

    protected void onClickImage(int position, String url, List<String> urlList){
        if (position==2&&hideThree){
            mIsShowAll=true;
            hideThree=false;
            refresh();
            return;
        }
        if (mIsNeedSavePic) {
//            PictureSeeActivity.start(mContext, urlList, position,mIsNeedSavePic);
        }else {
//            PictureSeeActivity.start(mContext, urlList, position);
        }
    }
    interface onClickInterface{
        void onClickImg(int position, String url, List<String> urlList);
    }
    onClickInterface onClickInterface;

    public void setOnClickInterface(NinePictureLayout.onClickInterface onClickInterface) {
        this.onClickInterface = onClickInterface;
    }
}
