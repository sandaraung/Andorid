package com.example.leogirl.expanlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by leogirl on 5/25/16.
 */
public class ExpandableLayoutListView extends ListView {

    private Integer position = -1;


    public ExpandableLayoutListView(Context context) {
        super(context);
        setOnScrollListener(new OnExpandableLayoutScrollListener());
    }

    public ExpandableLayoutListView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        setOnScrollListener(new OnExpandableLayoutScrollListener());
    }

    public ExpandableLayoutListView(Context context,AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        setOnScrollListener(new OnExpandableLayoutScrollListener());

    }


    @Override
    public boolean performItemClick(View view, int position, long id) {

        this.position = position;

        for(int index = 0; index < getChildCount(); ++index)
        {
            if (index != (position - getFirstVisiblePosition()))
            {
               ExpandListItem currentitem = (ExpandListItem) getChildAt(index).findViewWithTag(ExpandListItem.class.getName());

                currentitem.hide();

            }
        }

        ExpandListItem expandableLayout = (ExpandListItem)getChildAt(position - getFirstVisiblePosition()).findViewWithTag(ExpandListItem.class.getName());

        if (expandableLayout.isOpened())
            expandableLayout.hide();
        else
            expandableLayout.show();


        return super.performItemClick(view, position, id);

    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {

        if(!(l instanceof  OnExpandableLayoutScrollListener))
            throw new IllegalArgumentException("OnScrollListner must be an OnExpandableLayoutScrollListener");

        super.setOnScrollListener(l);
    }

    public class OnExpandableLayoutScrollListener implements OnScrollListener
    {
        private int scrollState = 0;

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState)
        {
            this.scrollState = scrollState;
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
        {
            if (scrollState != SCROLL_STATE_IDLE)
            {
                for (int index = 0; index < getChildCount(); ++index)
                {
                    ExpandListItem currentExpandableLayout = (ExpandListItem) getChildAt(index).findViewWithTag(ExpandListItem.class.getName());
                    if (currentExpandableLayout.isOpened() && index != (position - getFirstVisiblePosition()))
                    {
                        currentExpandableLayout.hideNow();
                    }
                    else if (!currentExpandableLayout.getCloseByUser() && !currentExpandableLayout.isOpened() && index == (position - getFirstVisiblePosition()))
                    {
                        currentExpandableLayout.showNow();
                    }
                }
            }
        }
    }
}
